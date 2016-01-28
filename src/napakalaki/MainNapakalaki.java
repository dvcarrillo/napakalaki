/*
 * Copyright (C) 2016 davidvargascarrillo
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
