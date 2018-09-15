import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import reporting.MyLogger;

public class LogLevelDemo {

    public static void main (String[] args ) {
        Logger logger = Logger.getLogger(MyLogger.class);
        logger.setLevel(Level.INFO);
// Logger.getLogger(LogLevelDemo.class).info("qwe");
        logger.debug("Some trash info");
        logger.debug("Some trash info");
        logger.debug("Some trash info");
        logger.debug("Some trash info");
        logger.debug("Some trash info");

        logger.error("Very important message");
    }
}