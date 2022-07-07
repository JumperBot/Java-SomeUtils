package SomeUtils.DynamicArray;

import java.lang.Object;

public class DynamicArray<T>{
  //Just a demo.
  public static void main(String[]a){
    // Could be DynamicArray<Object> ... =new DynamicArray<>();
    DynamicArray<String> dynamics=new DynamicArray<String>();
    dynamics.set(5, "This is the fifth slot!");
    dynamics.set(3, "This is the lower slot...");
    dynamics.set(0, "Con: Some slots are null of type <T>");
    dynamics.set(12, "But atleast we have this in the repo.");
    System.out.println(
      java.util.Arrays.toString(dynamics.getArray())
    );
    //Can throw ArrayIndexOutOfBounds if not used "properly".
    System.out.println(dynamics.get(10));
    dynamics=new DynamicArray<String>(
      new String[]{"Hello?", "Is", "It", "..."}
    );
    System.out.println(
      java.util.Arrays.toString(dynamics.getArray())
    );
  }
  //Would rather use a List<> to be honest.
  //The class itself
  public DynamicArray(){}
  public DynamicArray(final T[] newArr){
    underlyingArr=newArr;
  }
  //T is an Object, don't mind it too much.
  //Also, it's an empty array, we're not affecting any data at all.
  @SuppressWarnings("unchecked")
  T[] underlyingArr=(T[])new Object[0];
  public void set(final int ind, final T value){
    if(underlyingArr.length<ind+1){
      //It's an empty array, we're not affecting any data at all.
      @SuppressWarnings("unchecked")
      final T[] duplicate=(T[])new Object[ind+1];
      System.arraycopy(
        underlyingArr, 0, duplicate, 0, underlyingArr.length
      );
      underlyingArr=duplicate;
    }
    underlyingArr[ind]=value;
  }
  public T get(final int ind){
    return underlyingArr[ind];
  }
  public T[] getArray(){
    return underlyingArr;
  }
}