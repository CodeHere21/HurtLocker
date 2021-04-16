import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception, NoClassDefFoundError{
        String input = (new Main()).readRawDataToString().toLowerCase();
        System.out.println(input);
        JerksonParser jerksonParser = new JerksonParser(input);
      String[] output= jerksonParser.getIndividualLines(input);
       for(String s:output){
          String jsonString=jerksonParser.convertStringToJsonString(s); //"{ \"name\" : \"Black\", \"type\" : \"BMW\",\"price\" : \"Black\", \"expiration\" : \"BMW\" }"; //
           Product p=jerksonParser.jsonStringToObject(jsonString);
           System.out.println(p.getName());

       }
    }
}
