/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author David Vargas, Alicia Vílchez
 */

/*
* Class for managing the "bad consequence", which is the damages that causes a
* monster when the player fights against it and loses.
* "Bad consequence" includes losing a number of levels and treasures.
*/

public abstract class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    protected String text;            // What does a Bad Consequence says
    protected int levels;             // The number of levels to lose
    
    /**************************************************************************/
    // BASIC CONSTRUCTOR
    
    public BadConsequence (String txt, int lvls)
    {
        text = txt;
        levels = lvls;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public String getText ()
    {
        return text;
    }
    
    public int getLevels ()
    {
        return levels;
    }
    
    /**************************************************************************/
    // SUBSTRACT METHODS
    
    public abstract void substractVisibleTreasure (Treasure t);
    public abstract void substractHiddenTreasure (Treasure t);
    
    /**************************************************************************/
    // OTHER METHODS
    
    // Checks if the bad consequence is empty
    public abstract boolean isEmpty ();
    
    /*
    Returns a new object of bad consequence adjusted to the possibilities of the
    player, as the he sometimes won't be able to discard all the treasures that
    bad consequence indicates
    */
    public abstract BadConsequence adjustToFitTreasureLists
        (ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    /**************************************************************************/
    // TO STRING METHOD
    
    @Override
    public String toString()
    {
        String toRet = text;
        toRet += "\nLevels you lose: " + levels;
        
        return toRet;
    }
}
