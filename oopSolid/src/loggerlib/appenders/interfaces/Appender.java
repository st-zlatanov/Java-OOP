package loggerlib.appenders.interfaces;

import loggerlib.enumerations.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
}
