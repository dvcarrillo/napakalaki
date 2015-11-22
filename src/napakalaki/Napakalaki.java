/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author davidvargascarrillo
 */

/*
* Class that manages the correct development of the game
*/

// This class is a singleton: it means that there can only be one instance

public class Napakalaki {
    
    // Stores the person who is currently playing
    private Player currentPlayer;
    
    // Stores the total of the players playing the game
    private ArrayList<Player> players = new ArrayList();
    
    // Stores the monster which is currently fighting against the player
    Monster currentMonster;
    
    CardDealer dealer;
    
    /**************************************************************************/
    // Code for making this class a singleton
    
    private static final Napakalaki instance = new Napakalaki();
    
    // The private constructor ensures that this class will not be instanciable
    // from other classes
    private Napakalaki() { }
    
    public static Napakalaki getInstance() {
        return instance;
    }
    
    /**************************************************************************/
    // PRIVATE METHODS OF THE CLASS
    
    /*
    Initializes the 'players' array, adding as many players as they are
    on the 'names' string, which contains the names of the players
    */
    private void initPlayers (ArrayList<String> names)
    {
        for (String a_name : names)
        {
            Player a_player = new Player (a_name);
            players.add(a_player);
        }
    }
    
    /*
    Decides who is the next player to play.
    First, it calculates the index of the next player in the array of players
    Then, if this is the first move, it generates a random number between
    0 and the number of players minus 1
    */
    private Player nextPlayer ()
    {
        int posToReturn;
        
        if (currentPlayer == null)
        {
            Random r = new Random();
            posToReturn = r.nextInt(players.size());
        }
        else
        {
            int count = 0;
            
            while (currentPlayer != players.get(count))
                count++;
            
            posToReturn = count++;
            
            if (posToReturn == players.size())
                posToReturn = 0;
        }
        
        return(players.get(posToReturn));
    }
    
    /*
    Checks if the current player fulfills the rules of the game to end up
    its turn making use of the 'validState' method of the Player class
    */
    private boolean nextTurnAllowed()
    {
        return (currentPlayer.validState());
    }
    
    /*
    Assignation of enemies between the players. This method has been made to
    use with n players
    */
    private void setEnemies()
    {   
        Random r = new Random();
        
        // Assigns a random position of the list to the enemy attribute of 
        // another player
        for (int i = 0; i < players.size(); i++)
        {
            int randomPos = r.nextInt(players.size() + 1);
            
            while (i == randomPos)
                randomPos = r.nextInt(players.size() + 1);
            
            players.get(i).setEnemy(players.get(randomPos));
        }
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public Player getCurrentPlayer ()
    {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster ()
    {
        return currentMonster;
    }
    
    /**************************************************************************/
    // METHODS FOR DISCARDING TREASURES
    
    public void discardVisibleTreasures (ArrayList <Treasure> treasures)
    {
        // ...
    }
    
    public void discardHiddenTreasures (ArrayList <Treasure> treasures)
    {
        // ...
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    public CombatResult developCombat ()
    {
        // return <CombatResult> res;
        return null;
    }
    
    public void makeTreasuresVisible (ArrayList <Treasure> treasures)
    {
        // ...
    }
    
    public void initGame (String players)
    {
        // ...
    }
    
    public boolean nextTurn ()
    {
        // ...
        return false;
    }
    
    /*
    Returns 'true' if the result paratemer is WINGAME
    */
    public boolean endOfGame (CombatResult result)
    {
        boolean ret_result = false;
        
        if (result == CombatResult.WINGAME)
            ret_result = true;
        
        return ret_result;
    }
    
}
