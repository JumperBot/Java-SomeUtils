import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import java.lang.Process;
import java.lang.Runtime;
import java.lang.StringBuilder;

import java.nio.MappedByteBuffer;

import java.nio.channels.FileChannel;

import java.nio.charset.Charset;

import java.util.Scanner;

import java.util.regex.Pattern;

class DirectoryMaintainer{
  public static void main(String[]a)throws Exception{
    final StringBuilder builder=new StringBuilder();
    final File file=new File("CONTRIBUTING.md");
    try(final FileChannel channel=new FileInputStream(file).getChannel()){
      final MappedByteBuffer buffer=channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
      String in=Charset.forName("UTF-8").decode(buffer).toString();
      builder.append(in.substring(0, in.indexOf("```shell")+8)).append("\n");
      in=in.substring(in.indexOf("```shell")+8);
      in=in.substring(in.indexOf("```"));
      final Process proc=Runtime.getRuntime().exec("tree -a -I .git "+System.getProperty("user.dir")+"/..");
      try{
        proc.waitFor();
      }catch(Exception e){}
      try(final Scanner outputReader=new Scanner(new InputStreamReader(proc.getInputStream()))){
        final Pattern dirHeader=Pattern.compile("^/.*");
        while(outputReader.hasNext()){
          final String line=dirHeader.matcher(outputReader.nextLine()).replaceAll("");
          if(!line.isEmpty()&&outputReader.hasNext())
            builder.append("     ").append(line+"\n");
        }
      }
      builder.append(in);
    }
    file.delete();
    file.createNewFile();
    try(final FileWriter writer=new FileWriter(file)){
      writer.write(builder.toString());
    }
  }
}