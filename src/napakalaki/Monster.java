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
        {
            toRet += "\nLevel change against cultist players: " +
                    levelChangeAgainstCultistPlayer;
        }
        
        toRet += "\n\nBAD CONSEQUENCE:\n" + bc.toString();
        toRet += "\n\nPRIZE:\n" + pz.toString();
        
        return toRet;
    }
}
