package SomeUtils.ProgressBar;

import java.lang.StringBuilder;

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
    return values;
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