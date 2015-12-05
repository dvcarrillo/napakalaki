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
 * ETSIIT, University of Granada
 */

public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        //////////////////////// THIS IS PAST CODE /////////////////////////////
        
        ////////////////////////////////////////////////////////////////////////
        // TESTS OF THE CREATED CLASSES
        ////////////////////////////////////////////////////////////////////////
        /*
        
        String texto = "Soy una prueba";
        int niveles = 10;
        int visibles = 6;
        int ocultos = 4;
        
        BadConsequence malrollo = new BadConsequence(texto,niveles,visibles,
        ocultos);
        
        System.out.println("****************************************");
        System.out.println("// BEGIN OF TESTS //");
        System.out.println("****************************************");
        System.out.println();
        
        System.out.println("Prueba de la clase BadConsequence:");
        System.out.println(malrollo.toString());
        
        int tesoros = 2;
        int nivel = 3;
        
        Prize premio = new Prize(tesoros,nivel);
        System.out.println("Prueba de la clase Prize:");
        System.out.println(premio.toString());
        
        String nombre = "Cortijo";
        int nivelcombate = 100;
        
        Monster monstruo = new Monster (nombre, nivelcombate, malrollo, premio);
        System.out.println("Prueba de la clase Monster:");
        System.out.println(monstruo.toString());
        
        System.out.println();
        System.out.println("****************************************");
        System.out.println("// END OF TESTS //");
        System.out.println("****************************************");
        
        ////////////////////////////////////////////////////////////////////////
        // CONSULTATIONS OVER THE MONSTERS ARRAY
        ////////////////////////////////////////////////////////////////////////
        /*
        
        // With combat level >10
        
        System.out.println();
        System.out.println("Monsters with a level greater than 10:");
        
        for (Monster unMonstruo : monstruos)
            if (unMonstruo.getCombatLevel() > 10)
                System.out.println(unMonstruo.getName());
        
        // With a bad consequence that only causes losing levels
        
        System.out.println();
        System.out.println("Monsters with a bad consequence that only causes "
                + "losing levels:");
                
        for (Monster unMonstruo : monstruos)
        {
            BadConsequence thisBadCon = unMonstruo.getBadConsequence();
            
            if (thisBadCon.getNVisibleTreasures() == 0)
                if (thisBadCon.getNHiddenTreasures() == 0)
                    if (thisBadCon.getLevels() > 0)
                        System.out.println(unMonstruo.getName());
        }
        
        // With a prize that levels up more than 1 level
        
        System.out.println();
        System.out.println("With a prize that levels up more than 1 level:");
        
        for (Monster unMonstruo : monstruos)
        {
            Prize thisPrize = unMonstruo.getPrize();
            if(thisPrize.getLevel() > 1)
                System.out.println(unMonstruo.getName());
        
        }
        
        // Whose bad consequence causes the loss of certain treasures,
        // whether they are visible or hidden
        
        System.out.println();
        System.out.println("Whose bad consequence causes the loss of certain "
                + "treasures, whether they are visible or hidden:");
        
        for (Monster unMonstruo : monstruos)
        {
           BadConsequence thisBadCon = unMonstruo.getBadConsequence();
           if(thisBadCon.getSpecificVisibleTreasures().size() > 0 || 
              thisBadCon.getSpecificHiddenTreasures().size() > 0)
               System.out.println(unMonstruo.getName());
        }
        
        System.out.println();
        System.out.println("////////// TESTS //////////");
        
        for (Monster unMonstruo : monstruos)
        {
            BadConsequence thisBadCon = unMonstruo.getBadConsequence();
            
            System.out.println(unMonstruo.getName());
            System.out.println(thisBadCon.toString());
        }
        
        */
    }
    
}
