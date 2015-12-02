
package napakalaki;

import Test.GameTester;

public class EjemploMain {

    public static void main(String[] args) {
      
      System.out.println ("**************************************************");
      System.out.println ("*                NAPAKALAKI GAME                 *");
      System.out.println ("*         BY DAVID VARGAS, ALICIA VILCHEZ        *");
      System.out.println ("*                     2015                       *");
      System.out.println ("*                                                *");
      System.out.println ("*             github.com/dvcarrillo              *");
      System.out.println ("**************************************************");
      System.out.println ();
      System.out.println ();
      
      Napakalaki game = Napakalaki.getInstance();
      GameTester test = GameTester.getInstance();
      
      // Poner el numero de jugadores con el que se quiera probar
      test.play(game, 2);
    }
}
