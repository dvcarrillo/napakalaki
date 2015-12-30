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
* Class that manages the attributes and methods of the cultist players
*/

public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0;
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public CultistPlayer (Player p, Cultist c)
    {
        // ...
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public static int getTotalCultistPlayers ()
    {
        // ...
        return 0;
    }
    
    @Override
    protected int getCombatLevel ()
    {
        // ...
        return 0;
    }
    
    @Override
    protected boolean shouldConvert ()
    {
        // ...
        return false;
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    public Treasure giveMeATreasure ()
    {
        // ...
        return null;
    }
    
    public boolean canYouGiveMeATreasure ()
    {
        // ...
        return false;
    }
}
