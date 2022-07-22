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

import java.util.ArrayList;

public class Stopwatch{
  //For demo only!
  public static void main(String[]a){
    final Stopwatch stopwatch=new Stopwatch();
    stopwatch.start();
    try{
      java.lang.Thread.sleep(1000);
    }catch(Exception e){}
    stopwatch.split();
    System.out.println("Time elapsed in nanoseconds: "+stopwatch.getTimeElapsed());
    System.out.println("Time elapsed in milliseconds: "+stopwatch.getTimeElapsed(Stopwatch.millis));
    System.out.println("Time elapsed in seconds: "+stopwatch.getTimeElapsed(Stopwatch.seconds));
    try{
      java.lang.Thread.sleep(1000);
    }catch(Exception e){}
    stopwatch.split();
    final long[][] laps=stopwatch.getLaps();
    for(long[] lap:laps){
      System.out.println(java.util.Arrays.toString(lap));
    }
  }
  //The actual class!
  long start=System.nanoTime();
  public final static int millis=0;
  public final static int seconds=1;
  public final static int nanos=2;
  public void start(){
    start=System.nanoTime();
  }
  public long getTimeElapsed(){
    return getTimeElapsed(nanos);
  }
  public long getTimeElapsed(final int unit){
    final long timeElapsed=System.nanoTime()-start;
    return (long)(
      (unit==millis)?timeElapsed/1000000:
     (unit==seconds)?(timeElapsed/1000000000):
      timeElapsed
    );
  }
  public void lap(){
    split();
  }
  final ArrayList<long[]> laps=new ArrayList<>();
  long lastSplit=-1;
  public void split(){
    final long elapsed=getTimeElapsed();
    if(lastSplit==-1)
      lastSplit=elapsed;
    else
      lastSplit=elapsed-lastSplit;
    laps.add(new long[]{lastSplit, elapsed});
    lastSplit=elapsed;
  }
  public long[][] getLaps(){
    final int lapSize=laps.size();
    final long[][] lapsArr=new long[lapSize][3];
    for(int i=0;i<lapSize;i++){
      final long[] curLap=laps.get(i);
      lapsArr[i][0]=i;
      lapsArr[i][1]=curLap[0];
      lapsArr[i][2]=curLap[1];
    }
    return lapsArr;
  }
}