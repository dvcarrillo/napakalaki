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
* This class manages the cards of type Monster and their attributes
*/

public class Monster {

    private String name;              // Name of the monster
    private int combatLevel;          // Combat level of the monster
    
    private BadConsequence bc;        // Linked bad consequence
    private Prize pz;                 // Linked prize
    
    // Indicates the increment or decrement of level when it fights against a 
    // cultist player
    private int levelChangeAgainstCultistPlayer;

    /**************************************************************************/
    // CONSTRUCTORS

    public Monster(String nm, int cl, BadConsequence badco, Prize prz) 
    {
        name = nm;
        combatLevel = cl;
        bc = badco;
        pz = prz;
        levelChangeAgainstCultistPlayer = 0;
    }
    
    // For monsters that modify their level against a cultist player
    public Monster(String nm, int cl, BadConsequence badco, Prize prz, int lC) 
    {
        name = nm;
        combatLevel = cl;
        bc = badco;
        pz = prz;
        levelChangeAgainstCultistPlayer = lC;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public String getName ()
    {
        return name;
    }

    public int getCombatLevel ()
    {
        return combatLevel;
    }

    public  BadConsequence getBadConsequence ()
    {
        return bc;
    }

    public Prize getPrize ()
    {
        return pz;
    }
    
    public int getLevelsGained ()
    {
        return pz.getLevels();
    }
    
    public int getTreasuresGained ()
    {
        return pz.getTreasures();
    }
    
    public int getCombatLevelAgainstCultistPlayer ()
    {
        return (combatLevel + levelChangeAgainstCultistPlayer);
    }

    /**************************************************************************/
    // TOSTRING METHOD
    // Returns the current state of the object
    
    @Override
    public String toString()
    {
        String toRet = "Name: " + name + "\nCombat level: " + combatLevel;
        
        if (levelChangeAgainstCultistPlayer != 0)
            toRet = "\nLevel change against cultist players: " +
                    levelChangeAgainstCultistPlayer;
        
        toRet += "\n\nBAD CONSEQUENCE:\n" + bc.toString();
        toRet += "\n\nPRIZE:\n" + pz.toString();
        
        return toRet;
    }
}
