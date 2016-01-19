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
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
 */

/*
* Class that manages the attributes and methods of the cultist players
*/

public class CultistPlayer extends Player {
    
    // Saves the total number of cultist players in the game
    private static int totalCultistPlayers = 0;
    
    Cultist myCultistCard;               // Cultist card assigned to this player
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public CultistPlayer (Player p, Cultist c)
    {
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public static int getTotalCultistPlayers ()
    {
        return totalCultistPlayers;
    }
    
    /*
    This overriden method returns the combat level of the cultist player, which
    is the result of increasing in a 20% the original combat level, adding the
    level given by its cultist card and multiplicating by the total number of 
    cultist players in the game
    */
    @Override
    public int getCombatLevel ()
    {
        double toRet = super.getCombatLevel() * 1.2;
        toRet += myCultistCard.getGainedLevels();
        toRet *= totalCultistPlayers;
        
        return ((int) toRet);
    }
    
    /*
    This overriden method returns the combat level of the monster the cultist 
    player is fighting against
    */
    @Override
    protected int getOpponentLevel (Monster m)
    {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    /*
    This player cannot be converted back to standard player
    */
    @Override
    protected boolean shouldConvert ()
    {
        return false;
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    /*
    Returns a random treasure and deletes it from visibleTreasures array.
    To use when the a player is going to steal a enemy's card
    */
    @Override
    public Treasure giveMeATreasure ()
    {
        Random r = new Random();
        ArrayList<Treasure> visible = super.getVisibleTreasures();
        int posTreasure = r.nextInt(visible.size());
        
        Treasure rTreasure = visible.get(posTreasure);
        visible.remove(posTreasure);
        
        return rTreasure;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure ()
    {
        ArrayList<Treasure> visible = super.getVisibleTreasures();
        boolean result = !(visible.isEmpty());
        return result;
    }
    
    /**************************************************************************/
    // TO STRING METHOD
    
    @Override
    public String toString()
    {
        String toRet = super.toString();
        toRet += "\n\nThis is a CULTIST PLAYER.\n";
        
        return toRet;
    }
}
