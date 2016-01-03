/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

public enum Command {
  Exit (0, "Exit game"),
  GoBack (-1, "Previous menu"), 
  Combat (69, "¡¡ F I G H T !!"),
  ShowMonster         (10, "Show monster"), 
  ShowVisibleTreasure (11, "Show visible treasures"), 
  ShowHiddenTreasure  (12, "Show hidden treasures"), 
  DiscardVisibleTreasure (21, "Discard a visible treasure"), 
  DiscardHiddenTreasure  (22, "Discard a hidden treasure"), 
  DiscardAll             (23, "Discard ALL treasures"),
  MakeTreasureVisible    (31, "Equip a treasure"), 
  StealTreasure    (32, "Steal a treasure"),
  NextTurn         (1, "Next turn"),
  NextTurnAllowed  (2, "Next turn allowed");
  
  public final int menu;
  public final String text;
  
  private Command (int aValue, String aText) {
    this.menu = aValue;
    this.text = aText;
  }
}
