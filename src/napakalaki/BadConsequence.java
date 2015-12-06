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

public class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    private String text;            // What does a Bad Consequence says
    
    private int levels;             // The number of levels to lose
    private int nVisibleTreasures;  // Number of visible treasures to lose
    private int nHiddenTreasures;   // Number of hidden treasures to lose
    
    private boolean death;          // To represent a "Bad Consequence" of
                                    // type "death"
    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    /**************************************************************************/
    // CONSTRUCTORS
    
    public BadConsequence (String txt, int lvls, int nVisible, int nHidden)
    {
        text = txt;
        levels = lvls;
        
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
        
        //specificVisibleTreasures = new ArrayList();
        //specificHiddenTreasures = new ArrayList();
        death = false;
    }
    
    // To use for monsters which cause death
    public BadConsequence (String txt, boolean dth)
    {
        text = txt;
        levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
        //specificVisibleTreasures = new ArrayList();
        //specificHiddenTreasures = new ArrayList();
        death = true;
    }
    
    public BadConsequence (String txt, int lvls,
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden)
    {
        text = txt;
        levels = lvls;
        //specificVisibleTreasures = new ArrayList(tVisible);
        //specificHiddenTreasures = new ArrayList(tHidden);
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
        nVisibleTreasures = tVisible.size();
        nHiddenTreasures = tHidden.size();
        death = false;
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
    
    public int getNVisibleTreasures ()
    {
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures ()
    {
        return nHiddenTreasures;
    }
    
    public boolean getDeath ()
    {
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures ()
    {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures ()
    {
        return specificHiddenTreasures;
    }
    
    // ¡REVISAR!
    // Tener en cuenta: nVisibleTreasures y nHiddenTreasures toman valores
    // distintos de 0 en TODOS LOS CASOS EXCEPTO en el que la condición
    // death es verdadera (lo que causa la muerte en el jugador)
    
    public boolean isEmpty ()
    {
        boolean result = false;
        
        if (!death) {
            if ((nVisibleTreasures == 0) && (nHiddenTreasures == 0))
                result = true;
        }
        
        return result;
    }
    
    /**************************************************************************/
    // SUBSTRACT METHODS
    
    public void substractVisibleTreasure (Treasure t)
    {
        TreasureKind trk = t.getType();
        
        // CASE 1: The specificVisibleTreasures array is empty but there is a 
        // number greater than 0 on nVisibleTreasures
        // SOLUTION: decrement in an unit nVisibleTreasures

        if(specificVisibleTreasures.isEmpty() && nVisibleTreasures > 0)
            nVisibleTreasures--;

        // CASE 2: The specific_visible_treasures array is not empty.
        // SOLUTION: The method will look for the specified treasure in the 
        // array, and if it finds it, it will delete it. In another case, 
        // nothing will happen.
        
        else
        { 
            specificVisibleTreasures.remove(trk);
            nVisibleTreasures--;
        }
    }
    
    public void substractHiddenTreasure (Treasure t)
    {
        TreasureKind trk = t.getType();
        
        // CASE 1: The specificHiddenTreasures array is empty but there is a 
        // number greater than 0 on n_hidden_treasures
        // SOLUTION: decrement in an unit nHiddenTreasures
    
        if(specificHiddenTreasures.isEmpty() && nHiddenTreasures > 0)
            nHiddenTreasures--;
        
        // CASE 2: The specificHiddenTreasures array is not empty.
        // SOLUTION: The method will look for the specified treasure in the 
        // array, and if it finds it, it will delete it. In another case,
        // nothing will happen
        
        else
        { 
            specificHiddenTreasures.remove(trk);
            nHiddenTreasures--;
        }
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    /*
    Returns a new object of bad consequence adjusted to the possibilities of the
    player, as the he sometimes won't be able to discard all the treasures that
    bad consequence indicates
    */
    public BadConsequence adjustToFitTreasureLists (ArrayList<Treasure> v,
            ArrayList<Treasure> h)
    {
        BadConsequence badCon;
        
        // CASE 1:
        // The Bad Consequence DOES NOT remove any SPECIFIC TREASURE. That
        // means that nVisibleTreasures AND nHiddenTreasures attributes will
        // have some particular value while their specific arrays will be empty
        if ((specificVisibleTreasures.isEmpty()) &&
                (specificHiddenTreasures.isEmpty()))
        {
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
            
            badCon = new BadConsequence(this.text, this.levels, 
                    newNVisibleTreasures, newNHiddenTreasures);
        }
        
        // CASE 2:
        // The Bad Consequence's specific arrays ARE NOT empty. That means that
        // there will be neccesary to adjust the arrays to the possibilities
        // of the player
        
        /* 
        ******************* OLD VERSION OF THIS METOD **************************
        else
        {
            // FOR VISIBLE TREASURES
            ArrayList<TreasureKind> newSpecificVisible = new ArrayList();
            int newOneHandNum = 0;
            int theOneHandNum = 0;
            
            for (Treasure aTreasure : v)
            {
                TreasureKind aType = aTreasure.getType();

                if (aType == TreasureKind.ONEHAND)
                    newOneHandNum++;
                else
                {
                    for (TreasureKind visTreasure : specificVisibleTreasures)
                    {
                        if (visTreasure == TreasureKind.ONEHAND)
                            theOneHandNum++;
                        else if ((aType == visTreasure) && 
                                !(newSpecificVisible.contains(aType)))
                            newSpecificVisible.add(aType);
                    }
                }
            }
            
            // Adjustment of ONEHAND treasures
            int diffOneHand = theOneHandNum - newOneHandNum;
            
            switch (diffOneHand)
            {
                case 1:
                    for (int i = 0; i < 2; i++)
                        newSpecificVisible.add(TreasureKind.ONEHAND);
                    break;
                    
                case 0:
                    newSpecificVisible.add(TreasureKind.ONEHAND);
                    break;
            }
            
            
            // FOR HIDDEN TREASURES
            ArrayList<TreasureKind> newSpecificHidden = new ArrayList();
            newOneHandNum = 0;
            theOneHandNum = 0;
            
            for (Treasure aTreasure : h)
            {
                TreasureKind aType = aTreasure.getType();

                if (aType == TreasureKind.ONEHAND)
                    newOneHandNum++;
                else
                {
                    for (TreasureKind hidTreasure : specificHiddenTreasures)
                    {
                        if (hidTreasure == TreasureKind.ONEHAND)
                            theOneHandNum++;
                        else if ((aType == hidTreasure) && 
                                !(newSpecificHidden.contains(aType)))
                            newSpecificHidden.add(aType);
                    }
                }
            }
            
            // Adjustment of ONEHAND treasures
            diffOneHand = theOneHandNum - newOneHandNum;
            
            switch (diffOneHand)
            {
                case 1:
                    for (int i = 0; i < 2; i++)
                        newSpecificHidden.add(TreasureKind.ONEHAND);
                    break;
                    
                case 0:
                    newSpecificHidden.add(TreasureKind.ONEHAND);
                    break;
            }
            
            badCon = new BadConsequence(this.text, this.levels,
                    newSpecificVisible, newSpecificHidden);
        }
        ***********************************************************************/
        
        else
        {
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
            ArrayList <Treasure> copiaH = new ArrayList(h);
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
            
            badCon = new BadConsequence(this.text,this.levels,
                    newSpecificVisible,newSpecificHidden);
        }
        
        return badCon;
    }
    
    /**************************************************************************/
    // TO STRING METHOD
    
    @Override
    public String toString()
    {
        String toRet = text;
    
        /* Usuallyy indicated on the text of bad consequence
        if (getDeath())
        {
            toRet += "\nThis monster causes the death";
        }
        */
        if (!getDeath())
        {
            toRet += "\nLevels you lose: " + levels;
            
            if (!specificVisibleTreasures.isEmpty())
            {
                toRet += "\nVisible treasures you lose: ";
            
                for (int i = 0; i < specificVisibleTreasures.size(); i++)
                    toRet += specificVisibleTreasures.get(i) + " ";
            }
            
            if (!specificHiddenTreasures.isEmpty())
            {
                toRet += "\nHidden treasures you lose: ";
            
                for (int i = 0; i < specificHiddenTreasures.size(); i++)
                    toRet += specificHiddenTreasures.get(i) + " ";
            }
            
            if ((specificHiddenTreasures.isEmpty()) &&
                    (specificVisibleTreasures.isEmpty()))
            {
                toRet +=
                "\nNum. of visible treasures you lose: " + nVisibleTreasures
                + "\nNum. ofHidden treasures you lose: " + nHiddenTreasures;
            }
        }
        
        return toRet;
    }
}
