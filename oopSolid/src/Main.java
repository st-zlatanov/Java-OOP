import loggerlib.appenders.ConsoleAppender;
import loggerlib.appenders.FileAppender;
import loggerlib.appenders.interfaces.Appender;
import loggerlib.customFiles.LogFile;
import loggerlib.customFiles.interfaces.File;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layouts.SimpleLayout;
import loggerlib.layouts.interfaces.Layout;
import loggerlib.loggers.MessageLogger;
import loggerlib.loggers.interfaces.Logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");


    }
}
