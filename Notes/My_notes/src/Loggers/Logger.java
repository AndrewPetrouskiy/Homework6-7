package Loggers;

public class Logger implements Logable{
    @Override
    public void showLog(String message) {
        System.out.println(message);
    }
}
