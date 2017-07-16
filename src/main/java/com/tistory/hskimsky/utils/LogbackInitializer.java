package com.tistory.hskimsky.utils;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Haneul, Kim
 */
public class LogbackInitializer implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(LogbackInitializer.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.setProperty("PID", SystemUtils.getPid());

        try {
            LoggerContext loggerContext = (LoggerContext) StaticLoggerBinder.getSingleton().getLoggerFactory();
            loggerContext.reset();
            new ContextInitializer(loggerContext).configureByResource(this.getClass().getResource("/logback.xml"));
        } catch (JoranException e) {
            e.printStackTrace();
        }

        // http://patorjk.com/software/taag
        logger.info("\n" +
                "___________.__                                       _____                .__  __               .__                \n" +
                "\\_   _____/|__| ____ _____    ____   ____  ____     /     \\   ____   ____ |__|/  |_  ___________|__| ____    ____  \n" +
                " |    __)  |  |/    \\\\__  \\  /    \\_/ ___\\/ __ \\   /  \\ /  \\ /  _ \\ /    \\|  \\   __\\/  _ \\_  __ \\  |/    \\  / ___\\ \n" +
                " |     \\   |  |   |  \\/ __ \\|   |  \\  \\__\\  ___/  /    Y    (  <_> )   |  \\  ||  | (  <_> )  | \\/  |   |  \\/ /_/  >\n" +
                " \\___  /   |__|___|  (____  /___|  /\\___  >___  > \\____|__  /\\____/|___|  /__||__|  \\____/|__|  |__|___|  /\\___  / \n" +
                "     \\/            \\/     \\/     \\/     \\/    \\/          \\/            \\/                              \\//_____/  ");
        logger.info("============================================================");
        logger.info(" Now starting ..... PID: " + SystemUtils.getPid());
        logger.info("============================================================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ContextSelector selector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
        LoggerContext loggerContext = selector.getLoggerContext();
        String loggerContextName = loggerContext.getName();
        LoggerContext context = selector.detachLoggerContext(loggerContextName);
        context.reset();
    }
}
