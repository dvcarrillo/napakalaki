/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;    // For creating random numbers

/**
 *
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
 */

/*
* This singleton class works as a dice, returning random numbers between 1 and 6
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
    
    /**************************************************************************/
    // Gives a random number between 1 and 6
    
    public int nextNumber ()
    {
        Random r = new Random();
        return (r.nextInt(6) + 1);
    }
    
}
