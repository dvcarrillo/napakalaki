/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
    
    
}
