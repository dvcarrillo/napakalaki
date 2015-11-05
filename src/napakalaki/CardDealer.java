/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author davidvargascarrillo
 */

/*
* INTRODUCIR EXPLICACIÓN DE LA CLASE!!!
*/

// This class is a singleton: it means that there can only be one instance

public class CardDealer {
    
    /**************************************************************************/
    // Code for making this class a singleton
    
    private static final CardDealer instance = new CardDealer();
    
    // The private constructor ensures that this class will not be instanciable
    // from other classes
    private CardDealer() { }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    /**************************************************************************/
    // PRIVATE METHODS
    
    private void initTreasureCardDeck ()
    {
        // ...
    }
    
    private void initMonsterCardDeck ()
    {
        // ...
    }
    
    private void shuffleTreasures ()
    {
        // ...
    }
    
    private void shuffleMonsters ()
    {
        // ... 
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    public void initCards()
    {
        // ...
    }
    
    public Treasure nextTreasure ()
    {
        // return <Treasure> t;
        return null;
    }
    
    public Monster nextMonster ()
    {
        // return <Monster> m;
        return null;
    }
    
    public void giveTreasureBack (Treasure t)
    {
        // ...
    }
    
    public void giveMonsterBack (Monster m)
    {
        // ...
    }
    
}
