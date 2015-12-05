/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
 */

/*
* Class for managing the "prize", which is the benefits that may give a
* monster when the player fights against it and wins.
* "Prize" includes obtaining an increment of the level and new treasures.
*/

public class Prize {
    
    private int treasures;            // Bonus of treasures given by the prize
    private int level;                // Bonus of levels given by the prize
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public Prize (int trs, int lvl)
    {
        treasures=trs;
        level=lvl;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public int getTreasures ()
    {
        return treasures;
    }
    
    public int getLevels ()
    {
        return level;
    }

    /**************************************************************************/
    // TO STRING METHOD
    // Returns the current state of the object
    
    @Override
    public String toString()
    {
        return ("Levels you gain: " + level +
                "\nNum. of treasures you gain: " + treasures);
    }
}
