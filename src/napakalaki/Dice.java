/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author David Vargas Carrillo Alicia Vílchez
 */

/*
* INTRODUCIR EXPLICACIÓN DE LA CLASE!!!
*/

// This class is a singleton: it means that there can only be one instance

public class Dice {
    /**************************************************************************/
    // Code for making this class a singleton
    
    private static final Dice instance = new Dice();
    
    // The private constructor ensures that this class will not be instanciable
    // from other classes
    private Dice() { }
    
    public static Dice getInstance() {
        return instance;
    }
    /**************************************************************************/
    
}
