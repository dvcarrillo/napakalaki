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

public class CardDealer {
    
    // Arrays for the treasures (used and unused)
    private ArrayList <Treasure> unusedTreasures;
    private ArrayList <Treasure> usedTreasures;
    
    // Arrays for the monsters (used and unused)
    private ArrayList <Monster> usedMonsters;
    private ArrayList <Monster> unusedMonsters;
    
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
    
    ////////////////////////////////////////////////////////////////////////
    // DEFINITION OF THE CARDS 
    ////////////////////////////////////////////////////////////////////////

    private void initTreasureCardDeck ()
    {
        /**********************************************************************/
        // Si, mi amo!
        unusedTreasures.add(new Treasure("Si, mi amo!", 4,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Botas de investigacion
        unusedTreasures.add(new Treasure("Botas de investigacion", 3,
                TreasureKind.SHOES));
        
        /**********************************************************************/
        // Capucha de Cthulhu
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // A prueba de babas
        unusedTreasures.add(new Treasure("A prueba de babas", 2, 
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Botas de lluvia acida
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Casco minero
        unusedTreasures.add(new Treasure("Casco minero", 2,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Ametralladora Thompson
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Camiseta de la UGR
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1,
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Clavo de rail ferroviario
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3,
                TreasureKind.ONEHAND));
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
