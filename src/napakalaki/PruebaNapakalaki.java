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
        ArrayList<Monster> monstruos = new ArrayList();
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        /**********************************************************************/
        //Byakhees de bonanza:
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
        //Chibithulhu:
        tVisible.add(TreasureKind.HELMET);
        badConsequence = new BadConsequence("Embobados con el lindo" +
                "primigenio te descartas de tu casco" +
                "visible", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        tVisible.clear();
        tHidden.clear();
        
        /**********************************************************************/
        //El sopor de Dunwich:
        tVisible.add(TreasureKind.SHOES);
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso."
                + " Pierdes el calzado visible", 0, tVisible, tHidden );
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster ("El sopor de Dunwich", 2, badConsequence, 
                prize));
        
        tVisible.clear();
        tHidden.clear();
        
        /**********************************************************************/
        //Ángeles de la noche ibicenca:
        tVisible.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.ONEHAND);
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta"
                + " y te dejan caer en mitad delvuelo. Descarta 1 mano visible"
                + " y 1 mano oculta", 0, tVisible, tHidden);
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14,
                badConsequence, prize));
        
        tVisible.clear();
        tHidden.clear();
        
        /**********************************************************************/
        //El gorrón en el umbral:
        //Para que pierda la totalidad de tesoros visibles, le he asignado 
        //un numero relativamente grande
        badConsequence = new BadConsequence("Pierdes todos tus tesoros "
                + "visibles", 0, 10, 0);
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence,
                prize));
        
        /**********************************************************************/
        //H.P nchcraft:
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0,
                tVisible, tHidden);
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("H.P nchcraft", 6, badConsequence, prize));
        
        tVisible.clear();
        
        /**********************************************************************/
        //Bichgooth:
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        tVisible.clear();
        
        /**********************************************************************/
        //El rey de rosa:
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles.", 5, 3, 0);
        prize = new Prize(4, 2);
        
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /**********************************************************************/
        //La que redacta en las tinieblas:
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2"
                + " niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, 
                badConsequence, prize));
        
        /**********************************************************************/
        //Los hondos:
        badConsequence = new BadConsequence("Estos monstruos resultan bastante"
                + " superficiales y te aburren mortalmente. Estas muerto", 
                true);
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        /**********************************************************************/
        //Semillas Cthulhu:
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros "
                + "ocultos.", 2, 0, 2);
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        /**********************************************************************/
        //Dameargo:
        tVisible.add(TreasureKind.ONEHAND);
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes "
                + "una mano visible.", 0, tVisible, tHidden);
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        tVisible.clear();
        
        /**********************************************************************/
        //Pollipólipo volante:
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 "
                + "niveles.", 3, 0, 0);
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, 
                prize));
        
        /**********************************************************************/
        //YskhtihyssgGoth:
        badConsequence = new BadConsequence("No le hace gracia que pronuncien"
                + " mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("YskhtihyssgGoth", 12, badConsequence, prize));
        
        /**********************************************************************/
       //Familia feliz:
        badConsequence = new BadConsequence("La familia te atrapa. Estás "
                + "muerto.", true);
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        /**********************************************************************/
    }
    
}
