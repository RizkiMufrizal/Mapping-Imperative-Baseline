package org.rizki.mufrizal.baseline.helper;

import lombok.extern.log4j.Log4j2;

import java.io.PrintWriter;
import java.io.StringWriter;

@Log4j2
public class LoggingHelper {

    public static void Log(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        log.error("Exception {}", e.getMessage());
        log.error("Exception {}", stringWriter);
    }

}