package SomeUtils.Timer;

public class Timer{
  //For demo only!
  public static void main(String[]a){
    Timer timer=new Timer();
    timer.start();
    try{
      java.lang.Thread.sleep(1000);
    }catch(Exception e){}
    System.out.println("Time elapsed in nanoseconds: "+timer.getTimeElapsed());
    System.out.println("Time elapsed in milliseconds: "+timer.getTimeElapsed(timer.millis));
    System.out.println("Time elapsed in seconds: "+timer.getTimeElapsed(timer.seconds));
  }
  //The actual class!
  long start=System.nanoTime();
  public final int millis=0;
  public final int seconds=1;
  public final int nanos=2;
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
     (unit==seconds)?(timeElapsed/1000000)/1000:
      timeElapsed
    );
  }
}