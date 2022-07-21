package SomeUtils.Pattern;

import java.util.regex.Pattern;

public class PatternMaker{
  //Just a demo.
  public static void main(String[]a){
    final PatternMaker maker=new PatternMaker();
    final String sample="blah blach  blah ...";
    //Translates into:
    //Match string "bla" and any character that occurs atleast once before a whitespace.
    //After that, remember the match and see if it matches the string atleast once.
    //Lastly, check if there are any more characters that occurs atleast once.
    final Pattern pattern=maker.add("bla")
                               .any()
                               .atleastOnce()
                               .whitespace()
                               .captureRecent()
                               .atleast(1)
                               .any()
                               .atleastOnce()
                               .compile();
    System.out.println("This is what the pattern looks like:");
    System.out.println(pattern.toString());
    System.out.println("Does it matches our sample string: "+sample+" ?");
    System.out.println((pattern.matcher(sample).matches())?"Yes it does!":"Nope, it doesn't.");
    System.out.println("This is what it looks like if we replace any match with just the letter 'e':");
    System.out.println(pattern.matcher(sample).replaceAll("e"));
  }
  //The class itself.
  final StringBuilder builder=new StringBuilder();
  public PatternMaker(){}
  public PatternMaker(final String in){
    builder.append(in);
  }
  public PatternMaker(final Pattern in){
    builder.append(in.toString());
  }
  public PatternMaker add(final String in){
    builder.append(in);
    return this;
  }
  public PatternMaker anyOf(final String in){
    builder.append("[").append(in).append("]");
    return this;
  }
  public PatternMaker notAnyOf(final String in){
    builder.append("[^").append(in).append("]");
    return this;
  }
  public PatternMaker rangeOf(final char in, final char in2){
    builder.append(Character.toString(in))
           .append("-")
           .append(Character.toString(in2));
    return this;
  }
  public PatternMaker or(final String in){
    builder.append("|").append(in);
    return this;
  }
  public PatternMaker any(){
    builder.append(".");
    return this;
  }
  public PatternMaker beginsWith(final String in){
    builder.append("^").append(in);
    return this;
  }
  public PatternMaker endsWith(final String in){
    builder.append(in).append("$");
    return this;
  }
  public PatternMaker anyNumber(){
    builder.append("\\d");
    return this;
  }
  public PatternMaker whitespace(){
    builder.append("\\s");
    return this;
  }
  public PatternMaker wordBoundary(){
    builder.append("\\b");
    return this;
  }
  public PatternMaker unicode(final String in){
    if(in.startsWith("\\u"))
      builder.append(Character.toString(
        (char)Integer.parseInt(in.substring(2), 16)
      ));
    else
      builder.append(Character.toString(
        (char)Integer.parseInt(in, 16)
      ));
    return this;
  }
  public PatternMaker once(){
    builder.append("{1}");
    return this;
  }
  public PatternMaker noneOrMore(){
    builder.append("*");
    return this;
  }
  public PatternMaker onceOrNone(){
    builder.append("?");
    return this;
  }
  public PatternMaker atleastOnce(){
    builder.append("+");
    return this;
  }
  public PatternMaker occurOnly(final int in){
    builder.append("{").append(String.valueOf(in)).append("}");
    return this;
  }
  public PatternMaker atleast(final int in){
    builder.append("{").append(String.valueOf(in)).append(",}");
    return this;
  }
  public PatternMaker atleastRange(final int from, final int to){
    builder.append("{")
           .append(String.valueOf(from))
           .append(",")
           .append(String.valueOf(to))
           .append("}");
    return this;
  }
  public PatternMaker captureRecent(){
    builder.insert(0, "(").append(")");
    return this;
  }

  /**From Pattern.java
    *Go to their website for more details:
    *https://hg.openjdk.java.net/jdk8u/jdk8u/jdk/file/tip...
    *.../src/share/classes/java/util/regex/Pattern.java
  **/
  public static final int UNIX_LINES=0x01;
  public static final int CASE_INSENSITIVE=0x02;
  public static final int COMMENTS=0x04;
  public static final int MULTILINE=0x08;
  public static final int LITERAL=0x10;
  public static final int DOTALL=0x20;
  public static final int CANON_EQ=0x80;
  public static final int UNICODE_CHARACTER_CLASS=0x100;

  public Pattern compile(){
    return Pattern.compile(builder.toString());
  }
  public Pattern compile(final int in){
    return Pattern.compile(builder.toString(), in);
  }
  @Override
  public String toString(){
    return builder.toString();
  }
}