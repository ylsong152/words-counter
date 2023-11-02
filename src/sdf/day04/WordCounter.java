package sdf.day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;

public class WordCounter {

   public static void main(String[] args) throws Exception {
      // Open the file
      FileReader fr = new FileReader(args[0]);
      BufferedReader br = new BufferedReader(fr);

      long count = br.lines()
         .map(line -> line.trim().replaceAll("[^\\sa-zA-Z0-9]", ""))
         .filter(line -> !line.isEmpty())
         .map(line -> line.split(" "))
         .flatMap(words -> Stream.of(words))
         .count();
            
      System.out.println(count);

      br.close();
      
   }   
}