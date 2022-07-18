package SomeUtils.Pattern;

public class PatternFinder{
  //Just a demo
  public static void main(String[]a){
    final PatternFinder finder=new PatternFinder("He had three simple rules by which he lived. The first was to never eat blue food. There was nothing in nature that was edible that was blue. People often asked about blueberries, but everyone knows those are actually purple. He understood it was one of the stranger rules to live by, but it had served him well thus far in the 50+ years of his life.");
    System.out.println("Find the occurence for... nothing:");
    for(String[] s:finder.findAll(0).getArray()){
      System.out.println(java.util.Arrays.toString(s));
    }
    System.out.println("Find the occurence for everything:");
    for(String[] s:finder.findAll(finder.getInput().length()).getArray()){
      System.out.println(java.util.Arrays.toString(s));
    }
    System.out.println("Find the occurence for each character:");
    for(String[] s:finder.findAll(1).getArray()){
      System.out.println(java.util.Arrays.toString(s));
    }
    System.out.println("~substring of length 4:");
    for(String[] s:finder.findAll(4).getArray()){
      System.out.println(java.util.Arrays.toString(s));
    }
    System.out.println("~character but without those that only shows up once:");
    for(String[] s:finder.findAll(1).removeOnes().getArray()){
      System.out.println(java.util.Arrays.toString(s));
    }
    System.out.println("~substring of length 4 but without those that only shows up once:");
    for(String[] s:finder.findAll(4).removeOnes().getArray()){
      System.out.println(java.util.Arrays.toString(s));
    }
  }
  //The class itself
  final String input;
  String[][] output;
  public PatternFinder(final String in){
    input=in;
  }
  public PatternFinder findAll(final int size){
    if(size==input.length()){
      output=new String[][]{{input, "1"}};
      return this;
    }
    if(size<1){
      //Not going to thow an Exception, for now.
      //Decode "Infinity" using `Double.parseDouble("Infinity");`
      output=new String[][]{{"", "Infinity"}};
      return this;
    }
    //Optimized for 1 char situation.
    //More or less, O(n²).
    if(size==1){
      final int[] num=new int[input.length()];
      //StringBuilder doesn't make sense in this context.
      String builder="";
      String temp=input;
      int ind=0;
      while(temp.length()!=0){
        final String temp2=temp.replace(temp.substring(0, 1), "");
        num[ind]=temp.length()-temp2.length();
        builder+=temp.substring(0, 1);
        temp=temp2;
        ind++;
      }
      final char[] arr=builder.toCharArray();
      final String[][] result=new String[arr.length][2];
      for(int i=0;i<result.length;i++){
        result[i][0]=Character.toString(arr[i]);
        result[i][1]=String.valueOf(num[i]);
      }
      output=result;
      return this;
    }
    //More or less, O(n³). Don't blame me for that.
    final int[] num=new int[input.length()];
    final String[] builder=new String[input.length()];
    int ind=0;
    for(int i=0;i+size<input.length();i++){
      final String substring=input.substring(i, i+size);
      for(int j=0;j<builder.length;j++){
        if(builder[j]!=null&&(
            builder[j].equals(substring)||builder[j]==substring
          )
        )
          break;
        if(j==builder.length-1){
          num[ind]=(int)((input.length()-input.replace(
            substring, ""
          ).length())/size);
          builder[ind]=substring;
          ind++;
          break;
        }
      }
    }
    final String[][] result=new String[ind][2];
    for(int i=0;i<result.length;i++){
      result[i][0]=builder[i];
      result[i][1]=String.valueOf(num[i]);
    }
    output=result;
    return this;
  }
  public PatternFinder removeOnes(){
    final StringBuilder builder=new StringBuilder();
    for(int i=0;i<output.length;i++){
      final String s=output[i][1];
      if(s.equals("1")||s=="1")
        builder.append(String.valueOf(i)+",");
    }
    builder.delete(builder.length()-1, builder.length()-1);
    final String[] removeMe=builder.toString().split(",");
    if(removeMe.length==output.length){
      output=new String[0][2];
      return this;
    }
    final String[][] out=new String[output.length-removeMe.length][2];
    int ind=0;
    int ind2=0;
    for(int i=0;i<output.length;i++){
      if(Integer.parseInt(removeMe[ind])==i)
        ind++;
      else{
        out[ind2][0]=output[i][0];
        out[ind2][1]=output[i][1];
        ind2++;
      }
    }
    output=out;
    return this;
  }
  public String getInput(){
    return input;
  }
  public String[][] toArray(){
    return getArray();
  }
  public String[][] getArray(){
    return output;
  }
}