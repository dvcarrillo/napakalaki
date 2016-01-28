/*
 * Copyright (C) 2016 davidvargascarrillo
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package napakalaki;

import GUI.Dice;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
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
    
    protected Player enemy;                         // Main rival of this player
    private ArrayList <Treasure> visibleTreasures;  // Array of vis. treasures
    private ArrayList <Treasure> hiddenTreasures;   // Array of hid. tresures
    private BadConsequence pendingBadConsequence;

    /**************************************************************************/
    // CONSTRUCTORS
    
    // Receives a name and initializes the player with the default parameters
    public Player(String name)
    {
        this.name = name;
        level = 1;
        dead = true;
        canISteal = true;
        
        visibleTreasures = new ArrayList();
        hiddenTreasures = new ArrayList();
    }
    
    // Copies a player from another one
    // In the moment of the copy, the original player MUST have completed its 
    // bad consequence
    public Player (Player p)
    {
        if (p.validState()) {
            this.name = p.getName();
            this.level = p.getLevels();
            this.dead = p.isDead();
            this.canISteal = p.canISteal();

            this.enemy = p.enemy;
            this.visibleTreasures = p.getVisibleTreasures();
            this.hiddenTreasures = p.getHiddenTreasures();
            this.setPendingBadConsequence(null);
        }
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public int getCombatLevel ()
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
    
    /*
    Needed by the GUI
    */
    
    public BadConsequence getPendingBadConsequence ()
    {
        return pendingBadConsequence;
    }
    
    public Player getEnemy ()
    {
        return enemy;
    }
    
    /*
    Returns the combat level of the monster the player is fighting against
    */
    protected int getOpponentLevel (Monster m)
    {
        return m.getCombatLevel();
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
    
    protected boolean canYouGiveMeATreasure ()
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
        
        if (level < 1)
            level = 1;
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
    
    /*
    Counts the number of treasures of the specified type in the visible
    treasures array
    */
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
    protected Treasure giveMeATreasure ()
    {
        Random r = new Random();
        int posTreasure = r.nextInt(hiddenTreasures.size());
        
        Treasure rTreasure = hiddenTreasures.get(posTreasure);
        hiddenTreasures.remove(posTreasure);
        
        return rTreasure;
    }
    
    /*
    To use in the development of a combat, called from Napakalaki class. Returns
    the result of the combat
    */
    public CombatResult combat (Monster m)
    {
        int myLevel = getCombatLevel();
        int monsterLevel = getOpponentLevel(m);
        
        CombatResult combatResult;
        
        // Player wins 
        if (myLevel > monsterLevel)
        {
            applyPrize(m);
            
            if (level > MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            else
                combatResult = CombatResult.WIN;
        }
        
        // Player loses
        else
        {
            applyBadConsequence(m);
            
            // Checks if the player has to convert to cultist
            if (shouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;
            else
                combatResult = CombatResult.LOSE;
        }
        
        return combatResult;
    }
    
    /*
    Moves the desired treasure from the hidden treasures array to the visible
    one, if the player is able to do so
    */
    public void makeTreasureVisible (Treasure t)
    {
        boolean canI = canMakeTreasureVisible(t);
        
        if (canI)
        {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    /*
    Methods that erase a treasure from the visible or hidden array of treasures,
    and applies the pending bad consequence (if any). Then, if the player has no
    treasures, dies
    */
    public void discardVisibleTreasure (Treasure t)
    {
        visibleTreasures.remove(t);
        
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
        
        if ((hiddenTreasures.size() <= 4) && ((pendingBadConsequence == null) ||
                (pendingBadConsequence.isEmpty())))
            result = true;
        
        return result;
    }
    
    /*
    Checks if the player is able to steal a treasure from its enemy and if his
    enemy can provide it. If so, the enemy gives a treasure from its hidden
    array of treasures. The player that has stolen a treasure IS NOT ABLE to do
    it again
    */
    public Treasure stealTreasure ()
    {
        // Checks if this player is able to steal a treasure
        boolean canI = canISteal();
        
        // Treasure to return.
        // This object will be null when, for any reason, the player is not able
        // to steal a treasure from his enemy
        Treasure ret;
        
        if (canI)
        {
            // Checks if the enemy can provide the player a treasure
            boolean canYou = enemy.canYouGiveMeATreasure();
            
            if (canYou)
            {
                // A random treasure from the enemy is added to the hidden ones
                // of the player
                Treasure treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                
                // Sets canISteal to false
                haveStolen();
                
                // As the enemy can provide a treasure, there is a treasure to
                // return
                ret = treasure;
            }
            else ret = null;
            
        }
        else ret = null;
        
        return ret;
    }
    
    /*
    True if the player is able to steal a treasure from its enemy, and false
    when the player has already stolen a treasure
    */
    public boolean canISteal ()
    {
        return canISteal;
    }
    
    /*
    The player discards all his visible and hidden treasures, verifying that
    the pending bad consequence is applied by adding the discardVisibleTreasure
    and discardHiddenTreasure methods
    */
    public void discardAllTreasures()
    {
        // It is neccessary to make copies before of both arrays to iterate
        // over them
        ArrayList<Treasure> visTreasures = new ArrayList(visibleTreasures);
        ArrayList<Treasure> hidTreasures = new ArrayList(hiddenTreasures);
                
        for (int i = 0; i < visTreasures.size(); i++)
        {
            Treasure treasure = visTreasures.get(i);
            discardVisibleTreasure(treasure);
        }
        
        for (int i = 0; i < hidTreasures.size(); i++)
        {
            Treasure treasure = hidTreasures.get(i);
            discardHiddenTreasure(treasure);
        }
    }
    
    /*
    Provide treasures for a player in his first turn or for one that has run out
    of treasures to make him keep playing. The number of treasures that he 
    obtains is conditioned by the value he gets throwing the dice, so:
        - if (dice == 1), steals ONE treasure
        - if (1 < dice < 6), steals TWO treasures
        - if (dice == 6), steals THREE treasures
    */
    public void initTreasures()
    {
        // Instance of CardDealer singleton
        CardDealer dealer = CardDealer.getInstance();
        
        // Instance of Dice singleton
        Dice dice = Dice.getInstance();
        
        // Brings to life this player
        bringToLife();
        
        // Adds a first treasure
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
 
        // Depending on the number, the method will add more treasures or not
        int number = dice.nextNumber("Turn of " + name + ".", "Throw the dice" +
                " to get some treasures.");
        
        if (number > 1)
        {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if (number == 6)
        {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    /*
    RELATED TO THE CULTIST PLAYERS
    Throws the dice and, if the result is 1, makes able the conversion to
    cultist player
    */
    protected boolean shouldConvert ()
    {
        boolean toRet = false;
        
        Dice dice = Dice.getInstance();
        int randnum = dice.nextNumber("You have lost the fight.", "If you " +
                "get a 1, you will be converted to CULTIST player.");
        
        if (randnum == 1)
            toRet = true;
        
        return toRet;
    }
    
    /**************************************************************************/
    // TO STRING METHOD
    
    @Override
    public String toString()
    {
        return name;
    }
}
