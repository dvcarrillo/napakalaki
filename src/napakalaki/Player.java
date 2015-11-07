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
* Class that manages the attributes and methods of the players
*/

public class Player {
    
    static final int MAXLEVEL = 10;     // Maximum level a player can reach
    
    private String name;                // Name of the player
    private int level;                  // Current level of the player
    private boolean dead = true;        // Indicates if the player is dead
    private boolean canISteal = true;   // Indicates if the player can steal
                                        // treasures from another one
    
    /**************************************************************************/
    private Player enemy;
    private ArrayList <Treasure> hiddenTreasures;
    private ArrayList <Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;

   
    /**************************************************************************/
    
    //CONSTRUCTOR
     
    public Player(String name) {
        this.name = name;
    }
    
    // METHODS
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
    
        /*
        ...
        */
    
    }
    
    private int getCombatLevel(){
        return level;
    }
    
    private void incrementLevels( int l ){
        level = level + l;
    } 
    
    private void decrementLevels( int l ){
        level = level - l;
    } 
    
    private void setPendingBadConsequence( BadConsequence b ){ 
        pendingBadConsequence = b;
    } 
    
    private void applyPrize( Monster m ){
        /*
        ...
        ...
        */
    
    } 
    
    private void applyBadConsequence( Monster m ){
        /*
        ...
        ...
        */
    
    } 
    
    private boolean canMakeTreasureVisible( Treasure t ){
        /*
        ...
        ...
        */
    } 
    
    private int howManyVisibleTreasures( TreasureKind tKind ){
        
       return visibleTreasures.size();
    
    } 
    
    private void dieIfNoTreasures(){
        /*
        ...
        */
    
    } 
    
    public boolean isDead(){
        return dead;
    } 
    
 
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public CombatResult combat( Monster m ){
        /*
        ...
        */
    }
    
    public void makeTreasureVisible(  Treasure t ){
        /*
        ...
        .
        .
        */
    }  
    public void discardVisibleTreasure( Treasure t ){
        /*
        ...
        ...
        */
    } 
    
    public void discardHiddenTreasure( Treasure t ){
        /*
        ...
        ...
        */
    } 
    
    public boolean validState(){
    
        /*
        ...
        */
    } 

    public int getLevel() {
        return level;
    }
    
    public Treasure stealTreasure(){
        /*
        ...
        ...
        */
    } 

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure(){
        /*
        ...
        ...
        */
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        /*
        ...
        ...
        */
    }
    
    private void haveStolen(){
        /*
        ...
        ...
        */
    } 
    
    public void discardAllTreasures(){
        /*
        ...
        ...
        */
    }
    
    
    
}
