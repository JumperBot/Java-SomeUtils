package SomeUtils.Clock;

public class Alarm{
  //For demo only!
  public static void main(String[]a){
    Alarm alarm=new Alarm();
    //Alarm 5 seconds later.
    alarm.alarmAfter(5, Alarm.seconds, new Alarm.AlarmWatcher(){
      public void isRinging(boolean ringing){
        System.out.print("Ringing? "+ringing+"\r");
        if(ringing)
          System.out.println();
      }
    });
  }
  //The actual class!
  long start=System.nanoTime();
  public final static int millis=0;
  public final static int seconds=1;
  public final static int nanos=2;
  public void start(){
    start=System.nanoTime();
  }
  private long getTimeElapsed(){
    return System.nanoTime()-start;
  }
  private long getTimeElapsed(final int unit){
    final long timeElapsed=System.nanoTime()-start;
    return (long)(
      (unit==millis)?timeElapsed/1000000:
     (unit==seconds)?(timeElapsed/1000000000):
      timeElapsed
    );
  }
  //Watcher is private.
  AlarmWatcher watcher;
  public void alarmAfter(final long duration, final int unit, final AlarmWatcher watcher){
    start();
    new Thread(new Runnable(){
      @Override
      public void run(){
        final long endAt=start+duration;
        while(getTimeElapsed(unit)+start<endAt){
          watcher.isRinging(false);
        }
        watcher.isRinging(true);
      }
    }).start();
  }
  public interface AlarmWatcher{
    public void isRinging(boolean ringing);
  }
}