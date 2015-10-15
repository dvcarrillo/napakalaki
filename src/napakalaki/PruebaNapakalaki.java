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
        // TODO code application logic here
         ArrayList<Monster> monstruos = new ArrayList();
        
        /**********************************************************************/
        
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles"
                + " y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /**********************************************************************/
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta"
                +" y te dejan caer en mitad del vuelo. Descarta 1 mano visible"
                +" y 1 mano oculta",0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, 
        badConsequence, prize));
        
        /**********************************************************************/
        
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra"
                + "oculta", 0, 1, 1 );
        prize = new Prize(2,1);
        
    }
    
}
