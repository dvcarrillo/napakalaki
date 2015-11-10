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
    private boolean dead = true;        // Indicates if the player is dead
    private boolean canISteal = true;   // Indicates if the player can steal
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
    }
    
    /**************************************************************************/
    // GET METHODS
    
    private int getCombatLevel ()
    {
        return level;
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
    
    public int getLevel () 
    {
        return level;
    }
    
    /**************************************************************************/
    // SET METHODS
    
    private void setPendingBadConsequence (BadConsequence b)
    { 
        this.pendingBadConsequence = b;
    }
    
    public void setEnemy (Player enemy)
    {
        this.enemy = enemy;
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    private boolean canYouGiveMeATreasure ()
    {
        // ...
        return true;
    }
    
    private void haveStolen ()
    {
        // ...
    } 
    
    private void bringToLife ()
    {
        // ...
    }
    
    private void incrementLevels (int i)
    {
        level = level + i;
    } 
    
    private void decrementLevels (int i)
    {
        level = level - i;
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
        // ...
        return 0;
    } 
    
    private void dieIfNoTreasures ()
    {
        // ...
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
    
    public boolean validState ()
    {
        // ...
        return true;
    }
    
    public Treasure stealTreasure ()
    {
        // ...
        return null;
    }
    
    public boolean canISteal ()
    {
        return canISteal;
    }
    
    public void discardAllTreasures()
    {
        // ...
    }
}
