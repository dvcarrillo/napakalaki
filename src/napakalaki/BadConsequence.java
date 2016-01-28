/*
 * Copyright (C) 2016 davidvargascarrillo
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
}
