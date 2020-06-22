package loggerlib.appenders;

import loggerlib.appenders.interfaces.Appender;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
    }

    protected AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.setReportLevel(reportLevel);
    }

    protected String format(String date, ReportLevel reportLevel, String message){
        return this.layout.format(date, reportLevel,message);

    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
}
