/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author David Vargas
 * ETSIIT, University of Granada
 */

/*
* MAIN CLASS
*/

public class MainNapakalaki { 
    
    public static void main (String [] args) {
        // Manages the course of the game
        Napakalaki game = Napakalaki.getInstance();
        
        // Manages the main window
        NapakalakiView napakalakiView = new NapakalakiView();
        
        // Creates the instance of the graphic dice
        Dice.createInstance(napakalakiView);
        
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = 
                new PlayerNamesCapture (napakalakiView,true);
        names = namesCapture.getNames();
        
        game.initGame(names);
        
        // Links the model to the view
        napakalakiView.setNapakalaki(game);
        
        // Shows the window of the application
        napakalakiView.setVisible(true);
    }
    
}
