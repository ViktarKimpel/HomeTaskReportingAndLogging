import reporting.MyLogger;



public class LogDemo {
    public static void main(String[] args) {


        MyLogger.info("Info message");
        MyLogger.log("Log message");
        MyLogger.error("error message!!!");
        try {
            throw new RuntimeException("broken code");
        } catch (Exception e){
            MyLogger.error("Beda!", e);
        }

    }
}
