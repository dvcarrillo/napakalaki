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
    
    /*
    Applies a prize to the player after winning a combat
    */
    private void applyPrize (Monster m)
    {
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        
        if (nTreasures > 0)
        {
            CardDealer dealer = CardDealer.getInstance();
            
            for (int i = 0; i < nTreasures; i++)
            {
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    /*
    Applies a bad consequence to the player after losing a combat
    */
    private void applyBadConsequence (Monster m)
    {
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        
        decrementLevels(nLevels);
        
        BadConsequence pendingBad = 
                badConsequence.adjustToFitTreasureLists (visibleTreasures, 
                        hiddenTreasures);
        
        setPendingBadConsequence(pendingBad);
    } 
    
    /*
    Returns 'true' if the player is allowed to make the trasure t visible,
    assuming it was hidden before
    */
    private boolean canMakeTreasureVisible (Treasure t)
    {
        boolean ret = true;
        TreasureKind type = t.getType();
        
        // SPECIAL CASE 1: t is ONEHAND treasure
        // If there's a BOTHHANDS treasure in visibleTreasures, t won't be able
        // to be added. In another case, the method will check if they are up to
        // 2 treasures in visibleTreasures
        if (type == TreasureKind.ONEHAND)
        {
            if ((howManyVisibleTreasures(TreasureKind.BOTHHANDS) > 0) || 
                    (howManyVisibleTreasures(TreasureKind.ONEHAND) > 1))
                ret = false;
        }
        
        // SPECIAL CASE 2: t is BOTHHANDS treasure
        // There can't be a BOTHHANDS treasure if there's already a ONEHAND
        // treasure on visibleTreasures
        else if (type == TreasureKind.BOTHHANDS)
        {
            if ((howManyVisibleTreasures(TreasureKind.BOTHHANDS) > 0) ||
                    (howManyVisibleTreasures(TreasureKind.ONEHAND) > 0))
                ret = false;
        }
        
        // OTHER CASES: t won't be able to be added if there's a treasure
        // of the same type in visibleTreasures
        else
        {
            if (howManyVisibleTreasures(type) > 0)
                ret = false;
        }
        
        return ret;
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

    /*
    Returns a random treasure and deletes it from hiddenTreasures array.
    To use when the a player is going to steal a enemy's card
    */
    private Treasure giveMeATreasure ()
    {
        Random r = new Random();
        int posTreasure = r.nextInt(hiddenTreasures.size());
        
        Treasure returnTreasure = hiddenTreasures.get(posTreasure);
        hiddenTreasures.remove(posTreasure);
        
        return returnTreasure;
    }
    
    public CombatResult combat (Monster m)
    {
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        
        CombatResult combatResult;
        
        // The player wins 
        if (myLevel > monsterLevel)
        {
            applyPrize(m);
            
            if (level > MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            else
                combatResult = CombatResult.WIN;
        }
        
        // The players loses
        else
        {
            applyBadConsequence(m);
            combatResult = CombatResult.LOSE;
        }
        
        return combatResult;
    }
    
    public void makeTreasureVisible (Treasure t)
    {
        // ...
    }
    
    /*
    Methods that erase a treasure from the visible or hidden array of treasures,
    and applies the pending bad consequence (if any). Then, if the player has no
    treasures, dies
    */
    
    public void discardVisibleTreasure (Treasure t)
    {
        boolean remove = visibleTreasures.remove(t);
        
        if ((pendingBadConsequence != null) &&
                (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasure(t);
        
        dieIfNoTreasures();
    } 
    
    public void discardHiddenTreasure (Treasure t)
    {
        hiddenTreasures.remove(t);
        
        if ((pendingBadConsequence != null) &&
                (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasure(t);
        
        dieIfNoTreasures();
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
    
    public void initTreasures()
    {
        // ...
    }
}
