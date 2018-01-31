//-----------------------------------------------------------------------------
//Issei Mori
//1612406
//Make File2 of reversed File1
//FileReverse.java
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

class TrimTest{
   public static void main(String[] args){

      String line = " aa   aaaa aaaaa ";

      String trimed = line.trim() + "a";

      String[] tokens = line.split("\\s+");

      for(String token:tokens){
         System.out.println(token);
      }

   }
}
