package SomeUtils.DynamicArray;

public class DynamicArray<T>{
  //Just a demo.
  public static void main(String[]a)throws Exception{
    // Could be DynamicArray<Object> ... =new DynamicArray<>();
    DynamicArray<String> dynamics=new DynamicArray<String>();
    dynamics.set(5, "This is the fifth slot!");
    dynamics.set(3, "This is the lower slot...");
    dynamics.set(0, "Con: Some slots are null of type <T>");
    dynamics.set(12, "But atleast we have this in the repo.");
    System.out.println(
      java.util.Arrays.toString(dynamics.getArray())
    );
    System.out.println("But this is how it really looks like:");
    System.out.println(
      java.util.Arrays.toString(dynamics.getRealArray())
    );
    //Can throw ArrayIndexOutOfBoundsException if not used "properly".
    System.out.println(dynamics.get(10));
    dynamics=new DynamicArray<String>(
      new String[]{"Hello?", "Is", "It", "..."}
    );
    System.out.println(
      java.util.Arrays.toString(dynamics.getArray())
    );
    System.out.println("But this is how it really looks like:");
    System.out.println(
      java.util.Arrays.toString(dynamics.getRealArray())
    );
    System.out.println("Pre initialized arrays are not automatically expanded until the #get() method is called.");
  }
  //The class itself
  //It's an empty array, we're not affecting any data at all.
  @SuppressWarnings("unchecked")
  T[] underlyingArr=(T[])new Object[0];
  int size=0;
  int actualSize=0;
  public DynamicArray(){}
  public DynamicArray(final T[] newArr){
    underlyingArr=newArr;
    actualSize=newArr.length;
    size=newArr.length;
  }
  public void set(final int ind, final T value){
    if(actualSize<ind+1){
      //It's an empty array, we're not affecting any data at all.
      @SuppressWarnings("unchecked")
      final T[] duplicate=(T[])new Object[ind+10];
      System.arraycopy(
        underlyingArr, 0, duplicate, 0, actualSize
      );
      actualSize=ind+10;
      underlyingArr=duplicate;
    }
    if(size<ind+1)
      size=ind+1;
    underlyingArr[ind]=value;
  }
  public T get(final int ind)throws ArrayIndexOutOfBoundsException{
    if(ind>size-1)
      throw new ArrayIndexOutOfBoundsException(
        new StringBuilder("Index ")
          .append(String.valueOf(ind))
          .append(" out of bounds for length ")
          .append(size)
        .toString()
      );
    return underlyingArr[ind];
  }
  public T[] toArray(){
    return getArray();
  }
  public T[] getArray(){
    @SuppressWarnings("unchecked")
    final T[] returnMe=(T[])new Object[size];
    System.arraycopy(underlyingArr, 0, returnMe, 0, size);
    return returnMe;
  }
  public T[] getRealArray(){
    final int l=underlyingArr.length;
    @SuppressWarnings("unchecked")
    final T[] copyOf=(T[])new Object[l];
    System.arraycopy(underlyingArr, 0, copyOf, 0, l);
    return underlyingArr;
  }
}