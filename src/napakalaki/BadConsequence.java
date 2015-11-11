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
    
    // class method
    final int MAXTREASURES = 10;
    
    /**************************************************************************/
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
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
        death = false;
    }
    
    // To use for monsters which cause death
    public BadConsequence (String txt, boolean dth)
    {
        text = txt;
        levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
        death = true;
    }
    
    public BadConsequence (String txt, int lvls,
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden)
    {
        text = txt;
        levels = lvls;
        specificVisibleTreasures = new ArrayList(tVisible);
        specificHiddenTreasures = new ArrayList(tHidden);
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
        specificVisibleTreasures.remove(t);
    }
    
    public void substractHiddenTreasure (Treasure t)
    {
        specificHiddenTreasures.remove(t);
    }
    
    /**************************************************************************/
    
    public BadConsequence adjustToFitTreasureLists (ArrayList<Treasure> v,
            ArrayList<Treasure> h)
    {
        // ...
        
        // return <BadConsequence> bc;
        return null;
    }
    
    /**************************************************************************/
    // TOSTRING
    
    @Override
    public String toString() {
        return "BadConsequence{" + "text=" + text + ", levels=" + levels
        + ", nVisibleTreasures=" + nVisibleTreasures + ", nHiddenTreasures="
        + nHiddenTreasures + ", death=" + death + ", specificVisibleTreasures="
        + specificVisibleTreasures + ", specificHiddenTreasures="
        + specificHiddenTreasures + '}';
    }
    
}
