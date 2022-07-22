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

package SomeUtils.ProgressBar;

public class ProgressBar{
  //Demo, can be removed if you want to!
  public static void main(String[]a){
    final ProgressBar progress=new ProgressBar(100);
    progress.printBar();
    for(int i=0;i<100;i++){
      progress.addValue();
      progress.printBar();
      try{
        java.lang.Thread.sleep(100);
      }catch(Exception e){}
    }
  }
  //The actual class, don't remove! (Please)
  final int[] values={0, 0};
  public ProgressBar(){
    //SUFFER
  }
  public ProgressBar(final int maxVal){
    values[0]=0;
    values[1]=maxVal;
  }
  public ProgressBar(final int minVal, final int maxVal){
    values[0]=minVal;
    values[1]=maxVal;
  }
  public int getValue(){
    return values[0];
  }
  public int getMaxValue(){
    return values[1];
  }
  public int[] getValues(){
    return new int[]{values[0], values[1]};
  }
  public void setValue(final int newValue){
    values[0]=newValue;
  }
  public void addValue(){
    values[0]++;
  }
  public void deductValue(){
    values[0]--;
  }
  final String emptyBar="                    ";
  final String  fullBar="====================";
  public void printBar(){
    //Percentage need not to be very accurate.
    //Ternary statement didn't worked, don't know why.
    final int percentage=(int)(
      (values[0]>=values[1])?100:
      (values[0]*100)/values[1]
    );
    final int barShown=(int)(percentage/5);
    System.out.print(
      new StringBuilder("[")
                .append(percentage)
                .append("%][")
                .append( fullBar.substring(0, barShown))
                .append(emptyBar.substring(barShown))
                .append("][")
                .append(values[0])
                .append("/")
                .append(values[1])
                .append("]\r")
      .toString()
    );
    if(percentage==100)
      System.out.println();
  }
}