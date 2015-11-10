/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author davidvargascarrillo
 */

/*
* This class manages the cards of type Treasure and their attributes
*/

public class Treasure {
    
    TreasureKind type;              // Type of the treasure
    
    private String name;            // Name of the treasure 
    private int bonus;              // Bonus that the treasure can give
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public Treasure(String n, int bonus, TreasureKind t)
    {
        this.name = n;
        this.bonus = bonus;
        this.type = t;
    }

    public TreasureKind getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public int getBonus()
    {
        return bonus;
    }
    
}
