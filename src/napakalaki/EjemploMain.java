/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import Test.GameTester;
import java.util.Scanner;

/**
 *
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
 */

public class EjemploMain {
    
    public static void showHelp()
    {
        System.out.println();
        System.out.println("////////////////// NAPAKALAKI HELP ///////////////////////");
        System.out.println();
        System.out.println("Napakalaki is a card game based on one of the most popular");
        System.out.println("card games. This game is about gaining levels by obtaining");
        System.out.println("treasures that increase them.");
        System.out.println();
        System.out.println("When the game begins, every player will have 1, 2 or 3 ");
        System.out.println("treasures to equip (make them visible), and with the level");
        System.out.println("that they gain, they will have to fight against monsters.");
        System.out.println("If the monster is defeated, the player will obtain a prize");
        System.out.println("consisting in more treasures and a level gaining.");
        System.out.println("Otherwise, the player will suffer a 'bad consequence', ");
        System.out.println("which is a loss of levels and treasures.");
        System.out.println();
        System.out.println("The first player to reach the (player) level 10 wins.");
        System.out.println();
        System.out.println("For more help, see:");
        System.out.println("https://github.com/dvcarrillo/napakalaki/tree/master/doc");
        System.out.println();
        System.out.println("////////////// END OF NAPAKALAKI HELP //////////////////");
        System.out.println();
    }

    public static void main(String[] args) {
      
      // Maximum number of players that can play the game (adjust them according
      // to the number of avaliable cards and treasures)
      final int MAXPLAYERS = 4;
      
      System.out.println ("**********************************************************");
      System.out.println ("*                    - NAPAKALAKI -                      *");
      System.out.println ("*             BY DAVID VARGAS, ALICIA VILCHEZ            *");
      System.out.println ("*                         2015                           *");
      System.out.println ("*                                                        *");
      System.out.println ("*              http://github.com/dvcarrillo              *");
      System.out.println ("**********************************************************");
      System.out.println ("v0.5-beta");
      System.out.println ();
      System.out.println ();
      
      Napakalaki game = Napakalaki.getInstance();
      GameTester test = GameTester.getInstance();
      
      // Indicating the number of players or the need of help
      Scanner capt = new Scanner(System.in);
      int input;
      
      do {
        System.out.print("Type the amount of players or press 0 for help: ");
        input = capt.nextInt();
        
        if (input == 0)
            showHelp();
        if (input == 1)
            System.out.println("There must be at least 2 players");
        if (input > MAXPLAYERS)
            System.out.println("There cannot be more than " + MAXPLAYERS + 
                    " players");
      } while ((input < 2) || (input > MAXPLAYERS));
      
      System.out.println();
      
      // The game begins with the desired players
      test.play(game, input);
    }
}
