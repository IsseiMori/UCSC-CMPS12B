//-----------------------------------------------------------------------------
//Issei Mori
//1612406
//Make File2 of reversed File1
//FileReverse.java
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

class FileReverse{
   public static void main(String[] args) throws IOException{

      if(args.length < 2){
         System.out.println("Usage: java –jar FileReverse.jar <input file> <output file>");
         System.exit(1);
      }

      Scanner in = new Scanner(new File(args[0]));
      PrintWriter out = new PrintWriter(new FileWriter(args[1]));

      while(in.hasNextLine() ){
         String line = in.nextLine().trim() + " ";
         String[] tokens = line.split("\\s+");

         for(String token:tokens){
            out.println(stringReverse(token));
         }
      }

      in.close();
      out.close();
   }

   public static String stringReverse(String s){
      String reversed = "";
      for(int i = s.length(); i > 0; i--){
         reversed += s.substring(i-1,i);
      }
      return reversed;
   }
}
