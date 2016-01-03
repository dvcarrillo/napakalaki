/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
 */

/*
This enum specifies all the possible results in a fight:
    * WINGAME: the player wins the previous combat and reaches the level 10
    * WIN: the player wins the previous combat
    * LOSE: the player loses the previous combat
    * LOSEANDCONVERT: the player loses the previous combat and gets the number 1
      when throwing again the dice, so he has to convert to cultist
*/
public enum CombatResult {
    WINGAME, WIN, LOSE, LOSEANDCONVERT
}
