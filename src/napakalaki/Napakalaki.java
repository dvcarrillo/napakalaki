/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author davidvargascarrillo
 */

/*
* INTRODUCIR EXPLICACIÓN DE LA CLASE!!!
*/

// This class is a singleton: it means that there can only be one instance

public class Napakalaki {
    /**************************************************************************/
    // Code for making this class a singleton
    
    private static final Napakalaki instance = new Napakalaki();
    
    // The private constructor ensures that this class will not be instanciable
    // from other classes
    private Napakalaki() { }
    
    public static Napakalaki getInstance() {
        return instance;
    }
    
    /**************************************************************************/
    // PRIVATE METHODS OF THE CLASS
    
    private void initPlayers (String names)
    {
        // ...
    }
    
    private Player nextPlayer ()
    {
        // return <Player> p;
        return null;
    }
    
    private boolean nextTurnAllowed()
    {
        // ...
        return false;
    }
    
    private void setEnemies()
    {
        // ...
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public Player getCurrentPlayer ()
    {
        // return <Player> p;
        return null;
    }
    
    public Monster getCurrentMonster ()
    {
        // return <Monster> m;
        return null;
    }
    
    /**************************************************************************/
    // METHODS FOR DISCARDING TREASURES
    
    public void discardVisibleTreasures (ArrayList <Treasure> treasures)
    {
        // ...
    }
    
    public void discardHiddenTreasures (ArrayList <Treasure> treasures)
    {
        // ...
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    public CombatResult developCombat ()
    {
        // return <CombatResult> res;
        return null;
    }
    
    public void makeTreasuresVisible (ArrayList <Treasure> treasures)
    {
        // ...
    }
    
    public void initGame (String players)
    {
        // ...
    }
    
    public boolean nextTurn ()
    {
        // ...
        return false;
    }
    
    public boolean endOfGame (CombatResult result)
    {
        // ...
        return false;
    }
    
}
