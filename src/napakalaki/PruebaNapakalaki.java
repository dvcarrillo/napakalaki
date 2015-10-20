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
        
        ////////////////////////////////////////////////////////////////////////
        // TESTS OF THE CREATED CLASSES
        ////////////////////////////////////////////////////////////////////////
        
        String texto = "Soy una prueba";
        int niveles = 10;
        int visibles = 6;
        int ocultos = 4;
        
        BadConsequence malrollo = new BadConsequence(texto,niveles,visibles,
        ocultos);
        
        System.out.println("****************************************");
        System.out.println("// TESTS //");
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
        // DEFINITION OF THE MONSTERS 
        ////////////////////////////////////////////////////////////////////////
        
        // Array which will store the monsters
        ArrayList<Monster> monstruos = new ArrayList();
        
        // Array which will store the visible and hidden treasures
        // that the player can obtain by killing a monster 
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        /**********************************************************************/
        // Byakhees de bonanza
        
        tVisible.add(TreasureKind.ARMOR);
        tHidden.add(TreasureKind.ARMOR);
        
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura"
                + " visible y otra oculta", 0, tVisible, tHidden);
        
        Prize prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Byakhees de bonanza", 8, badConsequence, 
                prize));
        
        tVisible.clear();
        tHidden.clear();
        
        /**********************************************************************/
        // Chibithulhu
        
        tVisible.add(TreasureKind.HELMET);
        
        badConsequence = new BadConsequence("Embobados con el lindo" +
                "primigenio te descartas de tu casco " +
                "visible", 0, tVisible, tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        tVisible.clear();
        tHidden.clear();
        
        /**********************************************************************/
        // El sopor de Dunwich
        
        tVisible.add(TreasureKind.SHOES);
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso."
                + " Pierdes el calzado visible", 0, tVisible, tHidden );
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster ("El sopor de Dunwich", 2, badConsequence, 
                prize));
        
        tVisible.clear();
        tHidden.clear();
        
        /**********************************************************************/
        // Ángeles de la noche ibicenca
        
        tVisible.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.ONEHAND);
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta"
                + " y te dejan caer en mitad del vuelo. Descarta 1 mano visible"
                + " y 1 mano oculta", 0, tVisible, tHidden);
        
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14,
                badConsequence, prize));
        
        tVisible.clear();
        tHidden.clear();
        
        /**********************************************************************/
        // El gorrón en el umbral
        //
        // We have assigned a large amount of visible treasures to lose in
        // order to make the player lose all of them
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros "
                + "visibles", 0, 20, 0);
        
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence,
                prize));
        
        /**********************************************************************/
        // H.P Munchcraft
        
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0,
                tVisible, tHidden);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("H.P Munchcraft", 6, badConsequence, prize));
        
        tVisible.clear();
        
        /**********************************************************************/
        // Bichgooth
        
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible", 0, tVisible, tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        tVisible.clear();
        
        /**********************************************************************/
        // El rey de rosa
        
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles.", 5, 3, 0);
        
        prize = new Prize(4, 2);
        
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /**********************************************************************/
        // La que redacta en las tinieblas
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2"
                + " niveles", 2, 0, 0);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, 
                badConsequence, prize));
        
        /**********************************************************************/
        // Los hondos
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante"
                + " superficiales y te aburren mortalmente. Estás muerto", 
                true);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        /**********************************************************************/
        // Semillas Cthulhu
        
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros "
                + "ocultos", 2, 0, 2);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Dameargo
        
        tVisible.add(TreasureKind.ONEHAND);
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes "
                + "una mano visible", 0, tVisible, tHidden);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        tVisible.clear();
        
        /**********************************************************************/
        // Pollipólipo volante
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 "
                + "niveles", 3, 0, 0);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Yskhtihyssg-Goth
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien"
                + " mal su nombre. Estás muerto", true);
        
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Familia feliz
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás "
                + "muerto", true);
        
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        /**********************************************************************/
        // Roboggoth
        
        tVisible.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new BadConsequence ("La quinta directiva te obliga "
                + "a perder 2 niveles y un tesoro 2 manos visible", 2, tVisible,
                tHidden);
        
        prize = new Prize (2, 1);
        
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        tVisible.clear();
        
        /**********************************************************************/
        // El espia
        
        tVisible.add(TreasureKind.HELMET);
        
        badConsequence = new BadConsequence ("Te asusta en la noche. Pierdes"
                + " un casco visible", 0, tVisible, tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
        
        tVisible.clear();
        
        /**********************************************************************/
        // El Lenguas
        
        badConsequence = new BadConsequence ("Menudo susto te llevas. Pierdes "
                + "2 niveles y 5 tesoros visibles", 2, 5, 0);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        /**********************************************************************/
        // Bicéfalo
        
        tVisible.add(TreasureKind.ONEHAND);
        tVisible.add(TreasureKind.ONEHAND);
        tVisible.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new BadConsequence ("Te faltan manos para tanta"
                + " cabeza. Pierdes 3 niveles y tus tesoros visibles de "
                + "las manos", 3, tVisible, tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        ////////////////////////////////////////////////////////////////////////
        // CONSULTATIONS OVER THE MONSTERS ARRAY
        ////////////////////////////////////////////////////////////////////////
        
        // With combat level >10
        
        System.out.println("Monsters with a level greater than 10:");
        
        for (Monster unMonstruo : monstruos)
            if (unMonstruo.getCombatLevel() > 10)
                System.out.println(unMonstruo.getName());
        
        // With a bad consequence that only causes losing levels
        
        System.out.println("Monsters with a bad consequence that only causes "
                + "losing levels:");
                
        for (Monster unMonstruo : monstruos)
        {
            BadConsequence thisBadCon = unMonstruo.getBadConsequence();
            
            if (thisBadCon.getNVisibleTreasures() == 0)
                if (thisBadCon.getNHiddenTreasures() == 0)
                    System.out.println(unMonstruo.getName());
        }
        
        // With a prize that levels up more than 1 level
        // ...
        
        
        // Whose bad consequence causes the loss of certain treasures,
        // whether they are visible or hidden
        //
        // WHICH TREASURES!???? <----
        // ...
        
    }
    
}
