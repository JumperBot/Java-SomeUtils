package SomeUtils.Clock;

public class Stopwatch{
  //For demo only!
  public static void main(String[]a){
    Stopwatch stopwatch=new Stopwatch();
    stopwatch.start();
    try{
      java.lang.Thread.sleep(1000);
    }catch(Exception e){}
    System.out.println("Time elapsed in nanoseconds: "+stopwatch.getTimeElapsed());
    System.out.println("Time elapsed in milliseconds: "+stopwatch.getTimeElapsed(Stopwatch.millis));
    System.out.println("Time elapsed in seconds: "+stopwatch.getTimeElapsed(Stopwatch.seconds));
  }
  //The actual class!
  //Stopwatch
  long start=System.nanoTime();
  public final static int millis=0;
  public final static int seconds=1;
  public final static int nanos=2;
  public void start(){
    start=System.nanoTime();
  }
  public long getTimeElapsed(){
    return System.nanoTime()-start;
  }
  public long getTimeElapsed(final int unit){
    final long timeElapsed=System.nanoTime()-start;
    return (long)(
      (unit==millis)?timeElapsed/1000000:
     (unit==seconds)?(timeElapsed/1000000000):
      timeElapsed
    );
  }
}