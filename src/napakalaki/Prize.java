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

/**
 *
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
 */

/*
* Class for managing the "prize", which is the benefits that may give a
* monster when the player fights against it and wins.
* "Prize" includes obtaining an increment of the level and new treasures.
*/

public class Prize {
    
    private int treasures;            // Bonus of treasures given by the prize
    private int level;                // Bonus of levels given by the prize
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public Prize (int trs, int lvl)
    {
        treasures=trs;
        level=lvl;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public int getTreasures ()
    {
        return treasures;
    }
    
    public int getLevels ()
    {
        return level;
    }

    /**************************************************************************/
    // TO STRING METHOD
    // Returns the current state of the object
    
    @Override
    public String toString()
    {
        return ("Levels you gain: " + level +
                "\nNum. of treasures you gain: " + treasures);
    }
}
