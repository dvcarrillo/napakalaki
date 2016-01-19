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
* This class represents the bad consequence that only causes a "numeric loss" of
* treasures
*/

public class NumericBadConsequence extends BadConsequence
{
    private int nVisibleTreasures;  // Number of visible treasures to lose
    private int nHiddenTreasures;   // Number of hidden treasures to lose
 
    /**************************************************************************/
    // CONSTRUCTOR
    
    public NumericBadConsequence (String txt, int lvls, int nVisible, 
            int nHidden)
    {
        super(txt,lvls);
        
        if (nVisible > MAXTREASURES)
        {
            nVisibleTreasures = MAXTREASURES;
        }
        else
        {
            nVisibleTreasures = nVisible;
        }
        
        if (nHidden > MAXTREASURES)
        {
            nHiddenTreasures = MAXTREASURES;
        }
        else
        {
            nHiddenTreasures = nHidden;
        }
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public int getNVisibleTreasures ()
    {
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures ()
    {
        return nHiddenTreasures;
    }
    
    /**************************************************************************/
    // SUBSTRACT METHODS
    
    @Override
    public void substractVisibleTreasure (Treasure t)
    {
        if (nVisibleTreasures > 0)
            nVisibleTreasures--;
    }
    
    @Override
    public void substractHiddenTreasure (Treasure t)
    {
        if (nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    /*
    Returns if the bad consequence is empty
    */
    @Override
    public boolean isEmpty ()
    {
        boolean res = false;
        
        if ((nVisibleTreasures == 0) && (nHiddenTreasures == 0))
            res = true;
        
        return res;
    }
    
    /*
    Returns a new object of bad consequence adjusted to the possibilities of the
    player, as the he sometimes won't be able to discard all the treasures that
    bad consequence indicates
    */
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,
            ArrayList<Treasure> h)
    {
        BadConsequence numBadCon;
        
        int newNVisibleTreasures = nVisibleTreasures;
        int newNHiddenTreasures = nHiddenTreasures;

        if (newNVisibleTreasures > v.size())
        {
            newNVisibleTreasures = v.size();
        }

        if (newNHiddenTreasures > h.size())
        {
            newNHiddenTreasures = h.size();
        }

        numBadCon = new NumericBadConsequence(this.text, this.levels, 
                newNVisibleTreasures, newNHiddenTreasures);
        
        return numBadCon;
    }
    
    /**************************************************************************/
    // TO STRING METHOD
    
    @Override
    public String toString()
    {
        String toRet = super.toString();
        
        toRet += "Visible tr. to lose: " + nVisibleTreasures 
                + "\nHidden tr. to lose: " + nHiddenTreasures;
        
        return toRet;
    }
}
