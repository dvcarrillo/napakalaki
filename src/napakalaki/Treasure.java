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
* This class manages the cards of type Treasure and their attributes
*/

public class Treasure {
    
    private TreasureKind type;      // Type of the treasure
    
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
    
    /**************************************************************************/
    // GET METHODS
    
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
    
    /**************************************************************************/
    // TO STRING
    
    @Override
    public String toString()
    {
        return ("\nName: " + name + "\nBonus: " + bonus + "\nType: " + type);
    }
    
}
