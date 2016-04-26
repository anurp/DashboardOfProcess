import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StraceTry{

static final Pattern linePattern = Pattern.compile("([0-9]+)\\s+([\\d]+:[\\d]+:[\\d]+\\.[\\d]+)\\s+(\\w+)\\((.*)\\)\\s+=\\s+(\\-?[0-9]+).*");

 
 public static void main(String[] args) {

 String TEMP_FILE_PATH="strace-output.txt";
    
try
{
BufferedReader traceReader = new BufferedReader(new FileReader("strace-output.txt"));

String line;
                           while((line = traceReader.readLine())!= null) {
                            parseEvent(line);
                           } 
traceReader.close();
}
catch(Exception e){
         e.printStackTrace();
      }
} 
public static void parseEvent(String line) {


String pid,time,syscall,args,retVal;

        
            Matcher stracelineMatcher = linePattern.matcher(line);
 
            boolean success = true;

            if (stracelineMatcher.find()) {
                pid = stracelineMatcher.group(1);
                time = stracelineMatcher.group(2);
                syscall = stracelineMatcher.group(3);
                args = stracelineMatcher.group(4);
                retVal = stracelineMatcher.group(5);
System.out.println(pid+" "+time+" "+syscall+" "+args+" "+retVal);
 }


    }
   

}
