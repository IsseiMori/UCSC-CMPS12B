//-----------------------------------------------------------------------------
//Issei Mori
//1612406
//Make a copy of a file
//FileCopy.java
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

class FileCopy{
   public static void main(String[] args) throws IOException{
      if(args.length < 2) {
         System.out.println("Usage: java –jar FileCopy.jar <input file> <output file>");
         System.exit(1);
      }

      Scanner in = new Scanner(new File(args[0]));
      PrintWriter out = new PrintWriter(new File(args[1]) );

      while( in.hasNextLine() ){
         String line = in.nextLine();
         out.println(line);
      }

      in.close();
      out.close();
   }

}