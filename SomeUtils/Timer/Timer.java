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
    System.out.println("----------\n");
    timer.setWatcher(new Timer.TimerWatcher(){
      public void hasStopped(boolean stopped){
        System.out.print("Timer stopped: "+stopped+" | ");
      }
      public void timeElapsed(long nano, long millis, long seconds){
        System.out.print("Time elapsed in nanoseconds: "+nano+" | ");
        System.out.print("Time elapsed in milliseconds: "+millis+" | ");
        System.out.print("Time elapsed in seconds: "+seconds+" | ");
      }
      public void timeLeft(long timeLeft){
        System.out.print("Time left: "+timeLeft+"\r");
      }
    });
    //Block the thread for 5 seconds!
    timer.stopAfter(5, timer.seconds);
    //So that our watcher won't go to waste.
    System.out.println();
  }
  //The actual class!
  //Stopwatch
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
     (unit==seconds)?(timeElapsed/1000000000):
      timeElapsed
    );
  }
  //Timer
  //watcher is private.
  TimerWatcher watcher;
  public void stopAfter(final long duration, final int unit){
    //No need to call #start() before #stopAfter().
    start();
    final long endAt=start+duration;
    while(getTimeElapsed(unit)+start<endAt){
      watcher.hasStopped(false);
      watcher.timeElapsed(
        getTimeElapsed(nanos),
        getTimeElapsed(millis),
        getTimeElapsed(seconds)
      );
      watcher.timeLeft(
        endAt-(getTimeElapsed(unit)+start)
      );
    }
    watcher.hasStopped(true);
    watcher.timeElapsed(
      getTimeElapsed(nanos),
      getTimeElapsed(millis),
      getTimeElapsed(seconds)
    );
    watcher.timeLeft(
      0
    );
  }
  public void setWatcher(final TimerWatcher watcher){
    this.watcher=watcher;
  }
  public interface TimerWatcher{
    public void hasStopped(boolean stopped);
    public void timeElapsed(long nano, long millis, long seconds);
    //Returns time left using certain "unit" given.
    public void timeLeft(long timeLeft);
  }
}