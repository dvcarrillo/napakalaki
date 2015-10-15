/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author David Vargas, Alicia Vílchez
 */

public class Monster {

    private final String name;
    private final int combatLevel;
    private final BadConsequence bc;
    private final Prize pz;

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
