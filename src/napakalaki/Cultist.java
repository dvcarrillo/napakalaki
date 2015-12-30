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
* Class that manages each card of the cultist card deck
*/

public class Cultist {
    
    private String name;                // Name of the cultist player
    private int gainedLevels;           // Number the gained levels thanks to
                                        // being cultist player
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public Cultist (String name, int gainedLevels)
    {
        // ...
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public int getGainedLevels()
    {
        return gainedLevels;
    }
    
}
