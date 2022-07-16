package SomeUtils.PreciseFloat;

public class PreciseFloat{
  //Just a demo.
  public static void main(String[]a){
    final PreciseFloat decimal=new PreciseFloat(1.8);
    final long start=System.currentTimeMillis();
    System.out.println("1.8 + 2.2 = "+decimal.add(2.2));
    System.out.println(System.currentTimeMillis()-start);
    System.out.println("1.8 - 2.2 = "+decimal.sub(2.2));
    System.out.println("1.8 * 2.1 = "+decimal.mul(2.1));
  }
  //The class itself
  final int[] floater;
  public PreciseFloat(final String in){
    if(!in.contains(".")){
      floater=new int[]{
        Integer.parseInt(in),
        0
      };
      return;
    }
    final String[] splitted=in.split("\\.", 2);
    floater=new int[]{
      Integer.parseInt(splitted[0]),
      Integer.parseInt(splitted[1])
    };
  }
  public PreciseFloat(final int in){
    floater=new int[]{
      in, 0
    };
  }
  public PreciseFloat(final double in){
    floater=splitter(in);
  }
  public PreciseFloat(final float in){
    floater=splitter(Double.parseDouble(String.valueOf(in)));
  }
  private int[] splitter(final double in){
    final String temp=String.valueOf(in);
    if(!temp.contains("."))
      return new int[]{
        Integer.parseInt(temp),
        0
      };
    final String[] splitted=temp.split("\\.", 2);
    return new int[]{
      Integer.parseInt(splitted[0]),
      Integer.parseInt(splitted[1])
    };
  }
  private int getDigits(final int in1, final int in2){
    final int[] sizes={
      String.valueOf(in1).length(),
      String.valueOf(in2).length()
    };
    return (sizes[0]>sizes[1])?sizes[1]:sizes[0];
  }
  public PreciseFloat add(final double in){
    if(in==0)
      return new PreciseFloat(
        new StringBuilder(String.valueOf(floater[0]))
          .append(".").append(floater[1])
        .toString()
      );
    else if(floater[0]==0&&floater[1]==0)
      return new PreciseFloat(in);
    final int[] splitted=splitter(in);
    final int[] results={
      floater[0]+splitted[0],
      floater[1]+splitted[1],
    };
    final int finalSize=getDigits(floater[1], splitted[1]);
    final String decimal=String.valueOf(results[1]);
    if(decimal.length()>finalSize){
      results[0]+=Integer.parseInt(decimal.substring(0, 1));
      results[1]=Integer.parseInt(decimal.substring(1));
    }
    return new PreciseFloat(
      new StringBuilder(String.valueOf(results[0]))
        .append(".")
        .append(String.valueOf(results[1]))
        .toString()
    );
  }
  public PreciseFloat sub(final double in){
    return subtract(in);
  }
  public PreciseFloat subtract(final double in){
    if(in==0)
      return new PreciseFloat(
        new StringBuilder(String.valueOf(floater[0]))
          .append(".")
          .append(String.valueOf(floater[1]))
          .toString()
      );
    else if(floater[0]==0&&floater[1]==0)
      return new PreciseFloat("-"+in);
    final int[] splitted=splitter(in);
    final int[] results={
      floater[0]-splitted[0],
      floater[1]-splitted[1],
    };
    final int finalSize=getDigits(floater[1], splitted[1]);
    final String decimal=String.valueOf(results[1]);
    if(decimal.length()>finalSize){
      results[0]-=Integer.parseInt(decimal.substring(0, 1));
      results[1]=Integer.parseInt(decimal.substring(1));
    }
    return new PreciseFloat(
      new StringBuilder(String.valueOf(results[0]))
        .append(".")
        .append(String.valueOf(results[1]))
        .toString()
    );
  }
  private char[] reverseArr(final char[] in){
    final char[] out=new char[in.length];
    int j=in.length;
    for(int i=0;i<in.length;i++){
      out[j-1]=in[i];
      j-=1;
    }
    return out;
  }
  //O(n²) lol
  public PreciseFloat mul(final double in){
    return multiply(in);
  }
  public PreciseFloat multiply(final double in){
    if(in==0||(floater[0]==0&&floater[1]==0))
      return new PreciseFloat(0);
    final String inDecimal=String.valueOf(splitter(in)[1]);
    final String inTemp=(in+"").replace(".", "");
    final String baseTemp=floater[0]+""+floater[1];
    final int[] sizes={
      inTemp.length(),
      baseTemp.length()
    };
    final char[] arrTemp;
    final long arrTemp2;
    if(sizes[0]>sizes[1]){
      arrTemp=reverseArr(baseTemp.toCharArray());
      arrTemp2=Long.parseLong(inTemp);
    }else{
      arrTemp=reverseArr(inTemp.toCharArray());
      arrTemp2=Long.parseLong(baseTemp);
    }
    final long[] output={0, 0};
    long place=1;
    final int decLength=inDecimal.length()+String.valueOf(floater[1]).length();
    for(int i=0;i<arrTemp.length;i++){
      final char c=arrTemp[i];
      final long res=(Byte.parseByte(c+"")*arrTemp2)*place;
      final String resTemp=String.valueOf(res);
      if(resTemp.length()>decLength){
        output[0]+=Integer.parseInt(resTemp.substring(0, resTemp.length()-decLength));
        output[1]+=Integer.parseInt(resTemp.substring(resTemp.length()-decLength));
      }else
        output[1]+=res;
      place*=10;
    }
    return new PreciseFloat(
      new StringBuilder(String.valueOf(output[0]))
        .append(".")
        .append(String.valueOf(output[1]))
        .toString()
    );
  }
  public double getValue(){
    return Double.parseDouble(
      new StringBuilder(String.valueOf(floater[0]))
        .append(".")
        .append(String.valueOf(floater[1]))
        .toString()
    );
  }
  @Override
  public String toString(){
    return new StringBuilder(String.valueOf(floater[0]))
      .append(".").append(String.valueOf(floater[1]))
    .toString();
  }
}