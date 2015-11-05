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
    
    private String name;            // Name of the treasure 
    private int bonus;              // Bonus that the treasure can give
    
    /**************************************************************************/
    private TreasureKind type;
    
    //CONSTRUCTOR

    public Treasure(String name, int bonus, TreasureKind type) {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
    }
    
    
}
