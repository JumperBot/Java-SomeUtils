import java.math.BigDecimal;

class Main{
  public static void main(String[] a){
    final long start=System.currentTimeMillis();
    final BigDecimal big=new BigDecimal(1.8);
    System.out.println(big.add(new BigDecimal(2.2)));
    System.out.println(System.currentTimeMillis()-start);
  }
}