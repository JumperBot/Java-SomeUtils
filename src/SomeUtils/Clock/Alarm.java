/**------------------------------------------------------------------------------
  MIT License

  Copyright (c) 2022 JumperBot_

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
*-----------------------------------------------------------------------------**/

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