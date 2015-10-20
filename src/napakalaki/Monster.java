/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Alicia Vílchez, David Vargas
 */

/*
* This class manages the cards of type Monster and its attributes
*/

public class Monster {

    private final String name;              // Name of the monstar
    private final int combatLevel;          // Combat level of the monster
    private final BadConsequence bc;        // Linked bad consequence
    private final Prize pz;                 // Linked prize

    /**************************************************************************/
    // CONSTRUCTOR

    public Monster(String nm, int cl, BadConsequence badco, Prize prz) 
    {
        name = nm;
        combatLevel = cl;
        bc = badco;
        pz = prz;
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

    /**************************************************************************/
    
    @Override
    public String toString() {
        return "Monster{" + "name=" + name + ", combatLevel=" + combatLevel
        + ", bc=" + bc + ", pz=" + pz + '}';
    }
}
