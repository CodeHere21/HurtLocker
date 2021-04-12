import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JerksonParser {
   private String outputData;

   public JerksonParser() throws Exception { this.outputData = (new Main()).readRawDataToString(); }

   public String getOutputData() { return outputData;}

   public String changeNaMeToName(){
      Pattern pattern = Pattern.compile("Name",Pattern.CASE_INSENSITIVE);
      Matcher matcher1 = pattern.matcher(outputData);
      boolean matchFound = matcher1.find();
      String newOutput = outputData;

      if(matchFound){
         newOutput = matcher1.replaceAll("name");
      }

      return newOutput;
   }
}
