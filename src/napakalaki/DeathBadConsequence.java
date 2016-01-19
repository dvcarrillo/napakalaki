/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import static napakalaki.BadConsequence.MAXTREASURES;

/**
 *
 * @author davidvargascarrillo
 */
public class DeathBadConsequence extends NumericBadConsequence
{
    // To represent a "Bad Consequence" that causes death
    private boolean death;
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public DeathBadConsequence (String txt , boolean dth)
    {
        super(txt, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
        death = dth;
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    /*
    Returns if the bad consequence is empty
    */
    @Override
    public boolean isEmpty ()
    {
        return false;
    }
    
    /**************************************************************************/
    // TO STRING METHOD
    
    @Override
    public String toString()
    {
        String toRet = "You are dead\nDiscard all your treasures";
        
        return toRet;
    }
    
}
