package sdf.day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class WordCounter {

   public static void main(String[] args) throws Exception {
      // Open the file
      FileReader fr = new FileReader(args[0]);
      BufferedReader br = new BufferedReader(fr);

      Optional <Integer> opt = br.lines()
         .map(line -> line.trim().replaceAll("[^\\sa-zA-Z0-9]", ""))
         .filter(line -> !line.isEmpty())
         .map(line -> line.split(" ").length)
         .reduce((acc, next) -> acc + next);
            

      if (opt.isPresent()) {
         int count = opt.get();
         System.out.printf("Word Count: %d\n", count);
      } else {
         System.out.println("No result");
      }

      br.close();
      
   }   
}