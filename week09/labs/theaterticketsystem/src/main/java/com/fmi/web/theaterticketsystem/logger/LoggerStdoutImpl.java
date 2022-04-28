package com.fmi.web.theaterticketsystem.logger;

import com.fmi.web.theaterticketsystem.config.AppConfig;
import com.fmi.web.theaterticketsystem.vo.LoggerLevel;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class LoggerStdoutImpl implements Logger {
    private final LoggerLevel loggerLevel;

    public LoggerStdoutImpl(final AppConfig appConfig) {
        loggerLevel = LoggerLevel.valueOf(appConfig.getLogger().getLevel());
    }
//
//    @PostConstruct
//    void onConstruct() {
//        loggerLevel = LoggerLevel.valueOf(this.appConfig.getLogger().getLevel());
//    }

    @Override
    public void info(final Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.INFO.getCode()) >= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void debug(final Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.DEBUG.getCode()) >= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void trace(final Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.TRACE.getCode()) >= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void error(final Object toLog) {
        System.out.println(toLog);
    }
}
