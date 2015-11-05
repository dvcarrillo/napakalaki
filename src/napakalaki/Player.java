/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author davidvargascarrillo
 */

/*
* Class that manages the attributes and methods of the players
*/

public class Player {
    
    static final int MAXLEVEL = 10;     // Maximum level a player can reach
    
    private String name;                // Name of the player
    private int level;                  // Current level of the player
    private boolean dead = true;        // Indicates if the player is dead
    private boolean canISteal = true;   // Indicates if the player can steal
                                        // treasures from another one
    
    /**************************************************************************/
    private Player enemy;
    private ArrayList <Treasure> hiddenTreasures;
    private ArrayList <Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;

   
    /**************************************************************************/
    
    //CONSTRUCTOR
    
     public Player(String name, int level, Player enemy, 
             ArrayList<Treasure> hiddenTreasures, 
             ArrayList<Treasure> visibleTreasures, 
             BadConsequence pendingBadConsequence) {
        
        this.name = name;
        this.level = level;
        this.enemy = enemy;
        this.hiddenTreasures = hiddenTreasures;
        this.visibleTreasures = visibleTreasures;
        this.pendingBadConsequence = pendingBadConsequence;
    }
    
    
}
