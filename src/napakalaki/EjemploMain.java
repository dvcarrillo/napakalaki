/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import Test.GameTester;
import java.util.Scanner;

public class EjemploMain {
    
    public static void showHelp()
    {
        System.out.println("Showing help...");
    }

    public static void main(String[] args) {
      
      System.out.println ("**********************************************************");
      System.out.println ("*                    - NAPAKALAKI -                      *");
      System.out.println ("*             BY DAVID VARGAS, ALICIA VILCHEZ            *");
      System.out.println ("*                         2015                           *");
      System.out.println ("*                                                        *");
      System.out.println ("*              http://github.com/dvcarrillo              *");
      System.out.println ("**********************************************************");
      System.out.println ("version 0.1 beta");
      System.out.println ();
      System.out.println ();
      
      Napakalaki game = Napakalaki.getInstance();
      GameTester test = GameTester.getInstance();
      
      Scanner capt = new Scanner(System.in);
      int input;
      
      do {
        System.out.print("Type the number of players or press 0 for help: ");
        input = capt.nextInt();
        
        if (input == 0)
            showHelp();
      } while ((input < 2) || (input > 5));
      
      System.out.println();
      
      // Poner el numero de jugadores con el que se quiera probar
      test.play(game, input);
    }
}
