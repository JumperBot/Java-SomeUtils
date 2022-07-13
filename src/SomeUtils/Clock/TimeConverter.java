package SomeUtils.Clock;

public class TimeConverter{
  //Just a demo.
  public static void main(String[]a){

  }
  //The actual class itself!
  public final static byte millis=0;
  public final static byte seconds=1;
  public final static byte nanos=2;
  public final static byte mins=3;
  public final static byte hours=4;
  public final static byte days=5;
  public final static byte weeks=6;
  public final static byte months=7; //30day month rule.
  public final static byte years=8;
  public final static byte century=9;
  public final static byte millennium=10; //kiloannum
  public final static byte eon=11; //1 trillion years a.k.a. aeon
  final byte from;
  final long toConvert;
  private TimeConverter(final long convertMe, final byte f){
    toConvert=convertMe;
    from=f;
  }
  private TimeConverter(final long convertMe){
    toConvert=convertMe;
    from=-1;
  }
  public TimeConverter from(final byte f){
    return new TimeConverter(toConvert, f)
  }
  public double to(final byte t){
    
  }
  private double toSeconds(){
    //else if meaningless here.
    if(from==seconds)
      return toConvert;
    if(from==millis)
      return toConvert/1000;
    if(from==nanos)
      return toConvert/1000000000;
    if(from==mins)
      return toConvert*60;
    if(from==hours)
      return toConvert*3600;
    if(from==days)
      return toConvert*86400;
    if(from==weeks)
      return toConvert*604800;
    if(from==months)
      return toConvert*2592000;
    if(from==years)
      return toConvert*31557600;
    if(from==century)
      return toConvert*3155760000;
    if(from==millennium)
      return toConvert*31557600000;
    if(from==eon)
      return toConvert*31557600000000000;
  }
}