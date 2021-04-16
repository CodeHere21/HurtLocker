import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JerksonParser {
   private String outputData;
   private ArrayList<String> output = new ArrayList<String>();

   public JerksonParser(String outputData) {
      this.outputData = outputData;
   }

   public String getOutputData() {
      return outputData;
   }

   public String[] getIndividualLines(String input){
     Pattern pattern = Pattern.compile("##");
     String[] result = pattern.split(input);
     return result;
   }

   public String  convertStringToJsonString (String productLine){
       Pattern patternSemicolon = Pattern.compile("[;^%@!*]");
       Matcher matcherSemicolon = patternSemicolon.matcher(productLine);
       String jsonString=productLine;
       jsonString= matcherSemicolon.replaceAll("\", \"");

       Pattern patternColon = Pattern.compile(":");
       Matcher matcherColon = patternColon.matcher(jsonString);
       jsonString= matcherColon.replaceAll("\": \"");
       return "{\"" + jsonString + "\"}";

   }



   public Product jsonStringToObject (String productLine) throws JsonProcessingException {
       ObjectMapper objectMapper = new ObjectMapper();
       Product newProduct = objectMapper.readValue(productLine, Product.class);

       return newProduct;
   }

   }
//   public  String changeHamletToLeon(){
//      Pattern pattern =Pattern.compile("[hH][aA][mM][lL][eE][tT]");
//      Matcher matcher=pattern.matcher(hamletData);
//      boolean matchFound = matcher.find();
//      String newPoem=hamletData;
//
//      if(matchFound){
//         newPoem = matcher.replaceAll("Leon");
//      }
//
//      return newPoem;