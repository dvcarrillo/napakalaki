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
 * @author davidvargascarrillo
 */
public class SpecificBadConsequence extends BadConsequence
{ 
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public SpecificBadConsequence (String txt, int lvls,
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden)
    {
        super(txt,lvls);
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures ()
    {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures ()
    {
        return specificHiddenTreasures;
    }
    
    /**************************************************************************/
    // SUBSTRACT METHODS
    
    @Override
    public void substractVisibleTreasure (Treasure t)
    {
        TreasureKind trk = t.getType();
        specificVisibleTreasures.remove(trk);
    }
    
    @Override
    public void substractHiddenTreasure (Treasure t)
    {
        TreasureKind trk = t.getType();
        specificHiddenTreasures.remove(trk);
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
        
        if ((specificHiddenTreasures.isEmpty()) && 
                (specificVisibleTreasures.isEmpty()))
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
        BadConsequence speBadCon;
        
        // FOR VISIBLE TREASURES
        ArrayList<Treasure> copiaV = new ArrayList(v);
        ArrayList<TreasureKind> newSpecificVisible = new ArrayList();

        for (TreasureKind tk : specificVisibleTreasures)
        {
            int i = 0;
            boolean found = false;

            while ((i < copiaV.size()) && !(found))
            {
                if (copiaV.get(i).getType() == tk)
                {
                    found = true;
                    newSpecificVisible.add(tk);
                    copiaV.remove(i);
                }

                i++;
            }
        }

        // FOR HIDDEN TREASURES
        ArrayList<Treasure> copiaH = new ArrayList(h);
        ArrayList<TreasureKind> newSpecificHidden = new ArrayList();

        for (TreasureKind tk : specificHiddenTreasures)
        {
            int i = 0;
            boolean found = false;

            while ((i < copiaH.size()) && !(found))
            {
                if (copiaH.get(i).getType() == tk)
                {
                    found = true;
                    newSpecificHidden.add(tk);
                    copiaH.remove(i);
                }

                i++;
            }
        }

        speBadCon = new SpecificBadConsequence(this.text,this.levels,
                newSpecificVisible,newSpecificHidden);
        
        return speBadCon;
    }
    
    /**************************************************************************/
    // TO STRING METHOD
    
    @Override
    public String toString()
    {
        String toRet = super.toString();
        
        if (!specificVisibleTreasures.isEmpty())
        {
            toRet += "\nVisible tr. to lose: ";

            for (int i = 0; i < specificVisibleTreasures.size(); i++)
                toRet += specificVisibleTreasures.get(i) + " ";
        }

        if (!specificHiddenTreasures.isEmpty())
        {
            toRet += "\nHidden tr. to lose: ";

            for (int i = 0; i < specificHiddenTreasures.size(); i++)
                toRet += specificHiddenTreasures.get(i) + " ";
        }
        
        return toRet;
    }
}
