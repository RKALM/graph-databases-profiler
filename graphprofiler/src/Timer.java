import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Oscar
 */
public class Timer {
    private long startTime, stopTime;
    private final NumberFormat formatter = new DecimalFormat("#0.000000000");

    public void startTimer(){
        startTime = System.nanoTime();
    }

    public void stopTimer(){
        stopTime = System.nanoTime();
    }

    public String toString(){
        return formatter.format((stopTime - startTime) / 1000000000d);
    }
    public long getTime(){
        return stopTime-startTime;
    }
}