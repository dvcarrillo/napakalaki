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

public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // TEST OF THE CRATED CLASSES
        
        String texto = "Soy una prueba";
        int niveles = 10;
        int visibles = 6;
        int ocultos = 4;
        
        BadConsequence malrollo = new BadConsequence(texto,niveles,visibles,
        ocultos);
        
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
        
    }
    
}
