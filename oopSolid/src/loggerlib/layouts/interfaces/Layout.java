package loggerlib.layouts.interfaces;

import loggerlib.enumerations.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}
