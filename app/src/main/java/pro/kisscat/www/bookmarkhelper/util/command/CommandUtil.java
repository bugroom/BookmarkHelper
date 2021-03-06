package pro.kisscat.www.bookmarkhelper.util.command;

/**
 * Created with Android Studio.
 * Project:BookmarkHelper
 * User:ChengLiang
 * Mail:stevenchengmask@gmail.com
 * Date:2016/11/16
 * Time:8:54
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import pro.kisscat.www.bookmarkhelper.entry.command.CommandResult;
import pro.kisscat.www.bookmarkhelper.util.json.JsonUtil;
import pro.kisscat.www.bookmarkhelper.util.log.LogHelper;
import pro.kisscat.www.bookmarkhelper.util.random.RandomUtil;

public class CommandUtil {
    private static final String COMMAND_SU = "su";
    private static final String COMMAND_EXIT = "exit\n";
    private static final String COMMAND_LINE_END = "\n";

    @Getter
    public CommandResult commandResult = null;

    private long getWaitForExecuteTime(boolean isLongCommand) {
        int base = 40;
        int Float = 20;
        LogHelper.v("isLongCommand:" + isLongCommand);
        if (isLongCommand) {
            base = 3 * base;
            Float = 3 * Float;
        }
        return base + RandomUtil.nextInt(Float);//随机睡眠40~60毫秒，等待io流线程读取，实测低于10时会出现io流没读完整的问题
    }

    public void executeCommand(String[] commands, boolean isLongCommand) {
        executeCommand(COMMAND_SU, commands, isLongCommand);
    }

    private void executeCommand(String excuteUser, String[] commands, boolean isLongCommand) {
        int result = -1;
        if (commands == null || commands.length == 0) {
            commandResult = new CommandResult(result);
            return;
        }
        List<String> stdoutList = new ArrayList<>();
        List<String> erroroutList = new ArrayList<>();
        String commandStr = Arrays.toString(commands);
        LogHelper.v("commands is:" + commandStr);
        Process process = null;
        DataOutputStream os = null;
        InputStream is = null;
        InputStream es = null;
        Thread stdoutThread = null;
        Thread erroroutThread = null;
        try {
            process = Runtime.getRuntime().exec(excuteUser);
            os = new DataOutputStream(process.getOutputStream());
            for (String command : commands) {
                if (command == null || command.isEmpty()) {
                    continue;
                }
                os.write(command.getBytes());
                os.writeBytes(COMMAND_LINE_END);
                os.flush();
            }
            os.writeBytes(COMMAND_EXIT);
            os.flush();
            os.close();
            is = process.getInputStream();
            es = process.getErrorStream();
            stdoutThread = new IOThread(is, stdoutList).start();
            erroroutThread = new IOThread(es, erroroutList).start();
            LogHelper.v("waitFor start.");
            result = process.waitFor();
            LogHelper.v("waitFor end.");
            long sleep = getWaitForExecuteTime(isLongCommand);
            LogHelper.v("sleep:" + sleep);
            Thread.sleep(sleep);
            LogHelper.v("result is:" + result + ",successMsg is:" + JsonUtil.toJson(stdoutList) + ",errorMsg is:" + JsonUtil.toJson(erroroutList), false);
        } catch (IOException e) {
            LogHelper.e("IOException:Root cmd 执行失败,commands:" + commandStr + ",exception:" + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            LogHelper.e("InterruptedException:Root cmd 执行失败,commands:" + commandStr + ",exception:" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (stdoutThread != null && stdoutThread.isAlive()) {//主线程等待的时间超出后，io线程还是在运行，可能出现了阻塞问题，强制关闭
                IOThread.needExitNow();
                stdoutThread.interrupt();
            }
            if (erroroutThread != null && erroroutThread.isAlive()) {//主线程等待的时间超出后，io线程还是在运行，可能出现了阻塞问题，强制关闭
                IOThread.needExitNow();
                erroroutThread.interrupt();
            }
            if (os != null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    LogHelper.e("os.close(),IOException:Root 资源释放失败,commands:" + commandStr + ",exception:" + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LogHelper.e("is.close(),IOException:Root 资源释放失败,commands:" + commandStr + ",exception:" + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (es != null) {
                try {
                    es.close();
                } catch (IOException e) {
                    LogHelper.e("es.close(),IOException:Root 资源释放失败,commands:" + commandStr + ",exception:" + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (process != null) {
                process.destroy();
            }
        }
        commandResult = new CommandResult(result, stdoutList, erroroutList);
        LogHelper.v("commandResult is :" + JsonUtil.toJson(commandResult), false);
    }
}
