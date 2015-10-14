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
* Class for managing the "prize", which is the benefits that may give a
* monster when the player fights against it and wins.
* "Prize" includes obtaining an increment of the level and new treasures.
*/

public class Prize {
    
    private int treasures;
    private int level;
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public Prize (int trs, int lvl)
    {
        treasures=trs;
        level=lvl;
    }
    
    /**************************************************************************/
    // SET METHODS
    
    public void setTreasures (int tre)
    {
        treasures=tre;
    }
    
    public void setLevel (int lvl)
    {
        level=lvl;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public int getTreasures ()
    {
        return treasures;
    }
    
    public int getLevel ()
    {
        return level;
    }
    
}
