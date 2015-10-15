/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Alicia Vílchez Ceballos
 */

/*
* Class for managing the "bad consequence", which is the damages that causes a
* monster when the player fights against it and loses.
* "Bad consequence" includes losing a number of levels and treasures.
*/

public class BadConsequence {
    
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
        text=txt;
        levels=lvls;
        nVisibleTreasures=nVisible;
        nHiddenTreasures=nHidden;
    }
    
    public BadConsequence (String txt, boolean dth)
    {
        text=txt;
        death=dth;
    }
    
    public BadConsequence (String txt, int lvls,
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden)
    {
        text=txt;
        levels=lvls;
        specificVisibleTreasures=tVisible;
        specificHiddenTreasures=tHidden;
    }
    
    /**************************************************************************/
    // SET METHODS
    
    public void setText (String txt)
    {
        text=txt;
    }
    
    public void setLevels (int lvls)
    {
        levels=lvls;
    }
    
    public void setNHiddenTreasures (int n_hidden_tr)
    {
        nHiddenTreasures=n_hidden_tr;
    }
    
    public void setNVisibleTreasures (int n_visible_tr)
    {
        nVisibleTreasures=n_visible_tr;
    }
    
    public void setDeath (boolean dth)
    {
        death=dth;
    }
    
    public void setSpecificHiddenTreasures (ArrayList<TreasureKind> spe_hid_tre)
    {
        specificHiddenTreasures=spe_hid_tre;
    }
    
    public void setSpecificVisibleTreasures(ArrayList<TreasureKind> spe_vis_tre)
    {
        specificVisibleTreasures=spe_vis_tre;
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
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures()
    {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddentreasures()
    {
        return specificHiddenTreasures;
    }
    /////////////////////////

    public String toString() {
        return "BadConsequence{" + "text=" + text + ", levels=" + levels + ", nVisibleTreasures=" + nVisibleTreasures + ", nHiddenTreasures=" + nHiddenTreasures + ", death=" + death + ", specificVisibleTreasures=" + specificVisibleTreasures + ", specificHiddenTreasures=" + specificHiddenTreasures + '}';
    }
}
