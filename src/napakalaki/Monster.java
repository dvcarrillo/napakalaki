/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author ali_a_000
 */
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize pz;

   
    
  
/******************************************************/
// Constructor

public Monster(String name, int combatLevel, BadConsequence bc, Prize pz) 
{
    this.name = name;
    this.combatLevel = combatLevel;
    this.bc = bc;
    this.pz = pz;
}
    
/***********************************************************************************/

// Get methods
    
    public String getName()
    {
        return name;
    }
    
    public int getCombatLevel()
    {
        return combatLevel;
    }
    
    public  BadConsequence getBadConsequence()
    {
        return bc;
    
    }
    
    public Prize getPrize()
    {
        return pz;
    
    }

    public String toString() {
        return "Monster{" + "name=" + name + ", combatLevel=" + combatLevel + ", bc=" + bc + ", pz=" + pz + '}';
    }
       
            
    
}
