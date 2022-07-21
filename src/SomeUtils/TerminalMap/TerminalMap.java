package SomeUtils.TerminalMap;

public class TerminalMap{
  //Just a demo.
  public static void main(String[]a){
    final TerminalMap map=new TerminalMap(5, 5);
    for(int i=0;i<5;i++){
      System.out.println(java.util.Arrays.toString(map.getRow(i)));
    }
    System.out.println("-----vs-----");
    map.printMap();
    System.out.println("-----vs-----");
    map.printMap(true);
    System.out.println("-----vs-----");
    map.printMap(true, true);
    System.out.println("Moving 'occupied' to coords {2, 4}");
    map.set(2, 2, TerminalMap.empty);
    map.set(2, 4, TerminalMap.occupied);
    map.printMap(true, true);
    System.out.println("Creating new map...");
    try{
      map.setMap(new char[][]{
        {TerminalMap.empty, TerminalMap.occupied, TerminalMap.empty},
        {TerminalMap.empty, TerminalMap.empty   , TerminalMap.empty},
        {TerminalMap.empty, TerminalMap.occupied, TerminalMap.empty}
      });
    }catch(Exception e){
      System.out.println(e.toString());
    }
    map.printMap(true, false);
    System.out.println("Creating a new uneven map...");
    try{
      map.setMap(new char[][]{
        {TerminalMap.empty, TerminalMap.empty},
        {TerminalMap.empty, TerminalMap.empty   , TerminalMap.empty},
        {TerminalMap.empty, TerminalMap.occupied, TerminalMap.empty}
      });
    }catch(Exception e){
      System.out.println(e.toString());
    }
  }
  //The class itself.
  public static final char fullBlock='\u2588'; //█
  public static final char midFullBlock='\u2586'; //▆
  public static final char empty='\u2591'; //░
  public static final char occupied='\u2593'; //▓
  char[][] map;
  public TerminalMap(){
    map=makeEmptyMap(3, 3);
  }
  public TerminalMap(final int width, final int height){
    map=makeEmptyMap(width, height);
  }
  public TerminalMap(final char[][] newMap)throws Exception{
    map=newMap;
    //Not falling for that.
    if(map.length!=0){
      final int width=map[0].length;
      for(char[] c:map){
        if(c.length!=width)
          throw new Exception("The new map has unequal width or length.");
      }
    }
  }
  //Creating new objects are expensive!
  public void setMap(final char[][] newMap)throws Exception{
    map=newMap;
    //Not falling for that.
    if(map.length!=0){
      final int width=map[0].length;
      for(char[] c:map){
        if(c.length!=width)
          throw new Exception("The new map has unequal width or length.");
      }
    }
  }
  public void set(final int x, final int y, final char in){
    map[y][x]=in;
  }
  public char get(final int x, final int y){
    return map[y][x];
  }
  //Row = horizontal
  public char[] getRow(final int y){
    return map[y];
  }
  //Column = vertical
  public char[] getColumn(final int x){
    final char[] temp=new char[map.length];
    for(int i=0;i<map.length;i++){
      temp[i]=map[i][x];
    }
    return temp;
  }
  public char[][] getMap(){
    final char[][] copyOf=new char[map.length][map[0].length];
    System.arraycopy(map, 0, copyOf, 0, map.length);
    return copyOf;
  }
  public void printMap(){
    printMap(false, false);
  }
  public void printMap(final boolean useBorders){
    printMap(useBorders, false);
  }
  public void printMap(final boolean useBorders, final boolean useThinnerBorders){
    final int boardWidth;
    if(useBorders){
      boardWidth=(map[0].length*2)+1;
      printTopBorder(boardWidth, useThinnerBorders);
    }else
      boardWidth=map[0].length;
    for(char[] c:map){
      if(useBorders){
        for(int i=0;i<boardWidth;i++){
          if(i%2==0||i==0)
            if(useThinnerBorders)
              System.out.print(midFullBlock);
            else
              System.out.print(fullBlock);
          else
            System.out.print(c[(int)(i/2)]);
        }
        System.out.print("\n");
        printTopBorder(boardWidth, useThinnerBorders);
      }
      else{
        for(int i=0;i<boardWidth;i++){
          System.out.print(c[i]);
        }
        System.out.print("\n");
      }
    }
  }
  private void printTopBorder(final int boardWidth, final boolean useThinnerBorders){
    if(useThinnerBorders)
      for(int i=0;i<boardWidth;i++){
        System.out.print(midFullBlock);
      }
    else
      for(int i=0;i<boardWidth;i++){
        System.out.print(fullBlock);
      }
    System.out.print("\n");
  }
  private char[][] makeEmptyMap(final int width, final int height){
    final char[][] temp=new char[height][width];
    for(char[] c:temp){
      for(int i=0;i<width;i++){
        c[i]=empty;
      }
    }
    temp[roundUp(height/2)][roundUp(width/2)]=occupied;
    return temp;
  }
  //Stop me from importing java.lang.Math .
  //Doesn't have to be anywhere near too accurate.
  private int roundUp(final double roundMe){
    final String temp=String.valueOf(roundMe);
    final int decimalPoint=temp.indexOf(".");
    if(decimalPoint==-1)
      return (int)roundMe;
    final String decimals=temp.substring(decimalPoint+1, decimalPoint+2);
    if(Integer.parseInt(decimals)>=5)
      return ((int)roundMe)+1;
    return (int)roundMe;
  }
}