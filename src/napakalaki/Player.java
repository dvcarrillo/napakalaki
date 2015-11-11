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
    
    // Parameters of THIS player
    private String name;                // Name of the player
    private int level;                  // Current level of the player
    private boolean dead;               // Indicates if the player is dead
    private boolean canISteal;          // Indicates if the player can steal
                                        // treasures from another one
    
    private Player enemy;                           // Main rival of this player
    private ArrayList <Treasure> visibleTreasures;  // Array of vis. treasures
    private ArrayList <Treasure> hiddenTreasures;   // Array of hid. tresures
    private BadConsequence pendingBadConsequence;

    /**************************************************************************/
    // CONSTRUCTOR
    
    public Player(String name)
    {
        this.name = name;
        dead = true;
        canISteal = true;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    private int getCombatLevel ()
    {
        int result = level;
        
        for (Treasure a_treasure : visibleTreasures)
            result += a_treasure.getBonus();
        
        return result;
    }
    
    public String getName()
    {
        return name;
    }
    
    public boolean isDead ()
    {
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures ()
    {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures ()
    {
        return visibleTreasures;
    }
    
    public int getLevels () 
    {
        return level;
    }
    
    /**************************************************************************/
    // SET METHODS
    
    private void setPendingBadConsequence (BadConsequence b)
    { 
        this.pendingBadConsequence = b;
    }
    
    public void setEnemy (Player a_enemy)
    {
        this.enemy = a_enemy;
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    private boolean canYouGiveMeATreasure ()
    {
        boolean result = !(hiddenTreasures.isEmpty());
        return result;
    }
    
    // To execute after this player stoles a treasure
    private void haveStolen ()
    {
        canISteal = false;
    } 
    
    private void bringToLife ()
    {
        dead = false;
    }
    
    private void incrementLevels (int i)
    {
        level += i;
    } 
    
    private void decrementLevels (int i)
    {
        level -= i;
    } 
    
    private void applyPrize (Monster m)
    {
        // ...
    } 
    
    private void applyBadConsequence (Monster m)
    {
        // ...
    } 
    
    private boolean canMakeTreasureVisible (Treasure t)
    {
        // ...
        return true;
    } 
    
    private int howManyVisibleTreasures (TreasureKind tKind)
    {    
        int count = 0;
        
        for (Treasure a_treasure : visibleTreasures)
        {
            if (a_treasure.getType() == tKind)
                count++;
        }
        
        return count;
    } 
   
    private void dieIfNoTreasures ()
    {
        if ((visibleTreasures.isEmpty()) && (hiddenTreasures.isEmpty()))
        {
            dead = true;
        }
    }

    private Treasure giveMeATreasure ()
    {
        // ...
        return null;
    }
    
    public CombatResult combat (Monster m)
    {
        // ...
        return null;
    }
    
    public void makeTreasureVisible (Treasure t)
    {
        // ...
    }
    
    public void discardVisibleTreasure (Treasure t)
    {
        // ...
    } 
    
    public void discardHiddenTreasure (Treasure t)
    {
        // ...
    } 
    
    /* 
    * Returns true when the player has not any bad consequence to do and has
    * not more than 4 treasures too. Returns false in another case.
    */
    public boolean validState ()
    {
        boolean result = false;
        
        if ((hiddenTreasures.size() <= 4) && (pendingBadConsequence.isEmpty()))
            result = true;
        
        return result;
    }
    
    public Treasure stealTreasure ()
    {
        // ...
        return null;
    }
    
    // True if the player is able to steal a treasure from its enemy
    public boolean canISteal ()
    {
        return canISteal;
    }
    
    public void discardAllTreasures()
    {
        // ...
    }
}
