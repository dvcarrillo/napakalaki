/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import napakalaki.Napakalaki;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import napakalaki.CombatResult;
import napakalaki.Player;
import napakalaki.Treasure;
import java.util.Arrays;

public class GameTester {
  
  private static final GameTester test = new GameTester ();
  private Napakalaki game;
  private final Scanner in = new Scanner (System.in);  
  
  private GameTester () {}
  
  public static GameTester getInstance () {
    return test;
  }
  
  public void play (Napakalaki aGame, int numberOfPlayers) {
      
    Command command;
    CombatResult combatResult;
    Player currentPlayer;
    ArrayList<String> names;

    game = aGame;
    names = getPlayerNames(numberOfPlayers);
    game.initGame(names);
    
    do { // While the game is on
        
      currentPlayer = game.getCurrentPlayer();
      
      do { // Mientras el jugador se decide a conocer al monstruo
          
        System.out.println ("*******************************************************");
        System.out.println ("\n\nTurn of " + currentPlayer.toString());
        command = getCommandBeforeKnowingMonster ();
        command = processCommand (command, currentPlayer);        
        
      } while (command != Command.Exit && command != Command.ShowMonster);
      
      if (command == Command.ShowMonster)
      {
        do { // Just before the combat
          System.out.println ("*******************************************************");
          System.out.println ("\n\nTurn of " + currentPlayer.toString());
          command = getCommandBeforeFighting ();
          command = processCommand (command, currentPlayer);
        } while (command != Command.Exit && command != Command.Combat);
        
        if (command == Command.Combat) {
          combatResult = game.developCombat();
          switch (combatResult) {
            case WINGAME : 
              System.out.println ("\n\n       " + currentPlayer.getName());
              System.out.println ("\n\n ¡¡¡ Y O U  H A V E  W O N  T H E  G A M E !!!");
              break;
            case WIN :
              System.out.println ("\n\nYou have won the combat!");
              break;
            case LOSE :
              System.out.println ("\n\nYou have lost the fight");
              System.out.println ("It's time to comply the bad consequence");
              break;
          }
          if (combatResult != CombatResult.WINGAME) {
            do { // Hasta que se avance de turno 
              System.out.println ("*******************************************************");
              System.out.println ("\n\nTurn of " + currentPlayer.toString());
              if (currentPlayer.canISteal())
                command = getCommandAfterFighting();
              else 
                command = getCommandAfterFightingNoSteal();
              command = processCommand (command, currentPlayer);
            } while (command != Command.Exit && command != Command.NextTurnAllowed);
          } else {
            command = Command.Exit;
          }
        } // if (command == Command.Combat)
      } // if (command == Command.ShowMonster)
    } while (command != Command.Exit); // Mientras dure la partida
  }

  private Command getCommandAfterFighting () {
    Command commands[] = {Command.ShowMonster, 
      Command.ShowVisibleTreasure,    Command.ShowHiddenTreasure, 
      Command.DiscardVisibleTreasure, Command.DiscardHiddenTreasure, Command.DiscardAll,
      Command.MakeTreasureVisible,    Command.StealTreasure,
      Command.NextTurn, Command.Exit};
    
    return manageMenu ("Options before next turn", commands);
  }
  
  private Command getCommandAfterFightingNoSteal () {
    Command commands[] = {Command.ShowMonster, 
      Command.ShowVisibleTreasure,    Command.ShowHiddenTreasure, 
      Command.DiscardVisibleTreasure, Command.DiscardHiddenTreasure, Command.DiscardAll,
      Command.MakeTreasureVisible,
      Command.NextTurn, Command.Exit};
    
    return manageMenu ("Options before next turn", commands);
  }

  private Command getCommandBeforeFighting () {
    Command commands[] = {Command.ShowMonster, 
      Command.ShowVisibleTreasure, Command.ShowHiddenTreasure,  
      Command.Combat, Command.Exit};
    
    return manageMenu ("Options before fighting", commands);
  }
  
  private Command getCommandBeforeKnowingMonster () {
    Command commands[] = {Command.ShowMonster, 
      Command.ShowVisibleTreasure, Command.ShowHiddenTreasure, 
      Command.MakeTreasureVisible,  
      Command.Exit};
    
      return manageMenu ("Options before meeting the monster", commands);
  }
  
  private ArrayList<String> getPlayerNames (int numberOfPlayers) {
    ArrayList<String> names = new ArrayList();
    
    for (int i = 1; i <= numberOfPlayers; i++) {
      System.out.print ("Type the name of player " + i + ": ");
      names.add (in.nextLine());
    }
    return names;
  }

  private int getTreasure (int howMany) {
    boolean validInput;
    String capture;
    int option;
    
    validInput = true;
    option = Command.GoBack.menu;
    System.out.print ("\nChoose a treasure: ");
    capture = in.nextLine();
    try {
      option = Integer.valueOf(capture);
      if (option < Command.GoBack.menu || option > howMany) { // no se ha escrito un entero en el rango permitido
        validInput = false;
      }
    } catch (NumberFormatException e) { // no se ha escrito un entero
      validInput = false;
    }
    if (! validInput) {
      inputErrorMessage ();
      return -2;   // Muestra de nuevo el menu y pide otra entrada
    }
    return option;
  }
  
  private void inputErrorMessage () {
    System.out.println ("\n\nERROR:\n\nWrong selection, try again.\n\n");    
  }
  
  private void manageDiscardTreasures (boolean visible, Player aPlayer) {
    int howMany;
    int option;
    
    do { // Se descartan tesoros hasta que se vuelve al menú anterior
      if (visible) {
        howMany = showTreasures ("Choose visible treasures to discard", aPlayer.getVisibleTreasures(), true);
      } else {
        howMany = showTreasures ("Choose hidden treasures to discard", aPlayer.getHiddenTreasures(), true);
      }
      option = getTreasure (howMany);
      if (option > Command.GoBack.menu) {
        if (visible) {
          game.discardVisibleTreasures(new ArrayList (Arrays.asList(aPlayer.getVisibleTreasures().get(option))));
        } else {
          game.discardHiddenTreasures(new ArrayList (Arrays.asList(aPlayer.getHiddenTreasures().get(option))));
        }
      }
    } while (option != Command.GoBack.menu);  
  }
  
  private void manageMakeTreasureVisible (Player aPlayer) {
    int howMany;
    int option;
    
    do { // Se hacen tesoros visibles hasta que se vuelve al menú anterior
      howMany = showTreasures ("Choose treasures to try to make them visible", aPlayer.getHiddenTreasures(), true);
      option = getTreasure (howMany);
      if (option > Command.GoBack.menu) {
        aPlayer.makeTreasureVisible (aPlayer.getHiddenTreasures().get(option));
      }
    } while (option != Command.GoBack.menu);
  }
  
  private Command manageMenu (String message, Command[] menu) {
    HashMap <Integer, Command> menuCheck = new HashMap(); // Para comprobar que se hace una selección válida
    boolean validInput;
    String capture;
    int option;
    
    for (Command c : menu) {
      menuCheck.put (c.menu, c);
    }
    do { // Hasta que se hace una selección válida
      validInput = true;
      option = Command.GoBack.menu;
      System.out.println ("\n\n-------------------------------------------------------");
      System.out.println ("**** " + message + " ****\n");
      for (Command c : menu) { // se muestran las opciones del menú
        System.out.println (String.format ("%2d",c.menu) + " : " + c.text);
      } 
      System.out.print ("\nChoose an option: ");
      capture = in.nextLine();
      try {
        option = Integer.valueOf(capture);
        if (! menuCheck.containsKey(option)) { // No es un entero entre los válidos
          validInput = false;
        }
      } catch (NumberFormatException e) { // No se ha introducido un entero
        validInput = false;
      }
      if (!validInput) {
        inputErrorMessage ();
      }
    } while (! validInput);
    return (menuCheck.get (option));    
  }
  
  private Command processCommand (Command command, Player aPlayer) {
    Treasure aTreasure;
    
    switch (command) {
      case Exit :
        break;
      case Combat :
        break;
      case ShowMonster : 
        System.out.println ("\n------------------------------------------------------- ");
        System.out.println ("The current monster is:\n\n" + game.getCurrentMonster().toString());
        break;
      case ShowVisibleTreasure :
        showTreasures ("This is your visible treasures list", aPlayer.getVisibleTreasures(), false);
        break;
      case ShowHiddenTreasure :
        showTreasures ("This is your hidden treasures list", aPlayer.getHiddenTreasures(), false);
        break;
      case MakeTreasureVisible :
        manageMakeTreasureVisible (aPlayer);
        break;
      case DiscardVisibleTreasure :
        manageDiscardTreasures (true, aPlayer);
        break;
      case DiscardHiddenTreasure :
        manageDiscardTreasures (false, aPlayer);
        break;
      case DiscardAll :
        aPlayer.discardAllTreasures ();
        break;
      case StealTreasure :
        aTreasure = aPlayer.stealTreasure ();
        if (aTreasure == null)
          System.out.println ("\n\nYou could not steal anything \n\n");
        else
          System.out.println ("\n\nYou have stolen this treasure: \n" + aTreasure.toString());
        break;
      case NextTurn :
        if (! game.nextTurn ()) {
          System.out.println ("\n\nERROR:\n");
          System.out.println ("You do not satisfy the required conditions before the next turn.");
          System.out.println ("Either you have more than 4 hidden trasures");
          System.out.println ("or you must carry out a bad consequence ");
        } else {
          command = Command.NextTurnAllowed;
        }
        break;
    }
    return command;
  }
  
  private int showTreasures (String message, ArrayList <Treasure> treasures, boolean menu) {
    int optionMenu = Command.GoBack.menu;

    System.out.println ("\n-------------------------------------------------------");
    System.out.println (message + "\n");
    if (menu)
      System.out.println ("\n" + Command.GoBack.menu + " : " + Command.GoBack.text);
    
    for (Treasure t : treasures) {
      optionMenu++;
      System.out.println ("\n" + (menu ? optionMenu + ":" : "") + t.toString());
    }
    return optionMenu;
  }
}
