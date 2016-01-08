/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Collections;    // For shuffle function

/**
 *
 * @author David Vargas, Alicia Vílchez
 * ETSIIT, University of Granada
 */

/*
* Class that manages the decks of cards
*/

// This class is a singleton: it means that there can only be one instance

public class CardDealer {
    
    // Arrays for the treasures (used and unused)
    private ArrayList <Treasure> unusedTreasures = new ArrayList();
    private ArrayList <Treasure> usedTreasures = new ArrayList();
    
    // Arrays for the monsters (used and unused)
    private ArrayList <Monster> usedMonsters = new ArrayList();
    private ArrayList <Monster> unusedMonsters = new ArrayList();
    
    // Array for the unused cultists (a cultist card cannot be given back)
    private ArrayList <Cultist> unusedCultists = new ArrayList();
    
    /**************************************************************************/
    // Code for making this class a singleton
    
    private static final CardDealer instance = new CardDealer();
    
    // The private constructor ensures that this class will not be instanciable
    // from other classes
    private CardDealer() { }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    /**************************************************************************/
    // PRIVATE METHODS
    
    private void shuffleTreasures ()
    {
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters ()
    {
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultists ()
    {
        Collections.shuffle(unusedCultists);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // DEFINITION OF THE TREASURES 
    ////////////////////////////////////////////////////////////////////////////

    private void initTreasureCardDeck ()
    {
        /**********************************************************************/
        // Si, mi amo!
        unusedTreasures.add(new Treasure("Si, mi amo!", 4,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Botas de investigacion
        unusedTreasures.add(new Treasure("Botas de investigacion", 3,
                TreasureKind.SHOES));
        
        /**********************************************************************/
        // Capucha de Cthulhu
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // A prueba de babas
        unusedTreasures.add(new Treasure("A prueba de babas", 2, 
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Botas de lluvia acida
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Casco minero
        unusedTreasures.add(new Treasure("Casco minero", 2,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Ametralladora Thompson
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Camiseta de la UGR
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1,
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Clavo de rail ferroviario
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Cuchillo de sushi arcano
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Fez alopodo
        unusedTreasures.add(new Treasure("Fez alopodo", 3,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Hacha prehistorica
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2,
                TreasureKind.ONEHAND));
         
        /**********************************************************************/
        // El aparato del Pr. Tesla
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4,
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Gaita
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Insecticida
        unusedTreasures.add(new Treasure("Insecticida", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Escopeta de 3 cañones
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Garabato mistico
        unusedTreasures.add(new Treasure("Garabato mistico", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // La rebeca metalica
        unusedTreasures.add(new Treasure("La rebeca metalica", 2,
                TreasureKind.ARMOR));
        /**********************************************************************/
        //Lanzallamas
        unusedTreasures.add(new Treasure("Lanzallamas", 4,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Necrocomicon
        unusedTreasures.add(new Treasure("Necrocomicon", 1,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Necronomicon
        unusedTreasures.add(new Treasure("Necronomicon", 5,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Linterna a 2 manos
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Necrognomicon
        unusedTreasures.add(new Treasure("Necrognomicon", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Necrotelecom
        unusedTreasures.add(new Treasure("Necrotelecom", 2,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Mazo de los antiguos
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Necroplayboycon
        unusedTreasures.add(new Treasure("Necroplayboycon", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Porra preternatural
        unusedTreasures.add(new Treasure("Porra preternatural", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Shogulador
        unusedTreasures.add(new Treasure("Shogulador", 1,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Varita de atizamiento
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Tentaculo de pega
        unusedTreasures.add(new Treasure("Tentaculo de pega", 2,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Zapato deja-amigos
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1,
                TreasureKind.SHOES));
        
        // Shuffle the added treasures
        shuffleTreasures();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // DEFINITION OF THE MONSTERS
    ////////////////////////////////////////////////////////////////////////////
    
    private void initMonsterCardDeck ()
    {
        // Array which will store the monsters
        ArrayList<Monster> monstruos = new ArrayList();
        
        // Array which will store the visible and hidden treasures
        // that the player can obtain by killing a monster 
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        /**********************************************************************/
        // 3 Byakhees de bonanza
        
        tVisible.add(TreasureKind.ARMOR);
        tHidden.add(TreasureKind.ARMOR);
        
        BadConsequence badConsequence = new SpecificBadConsequence 
        ("Pierdes tu armadura visible y otra oculta", 0, tVisible, tHidden);
        
        Prize prize = new Prize(2, 1);
        
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, 
                prize));
        
        tVisible = new ArrayList();
        tHidden = new ArrayList();
        
        /**********************************************************************/
        // Chibithulhu
        
        tVisible.add(TreasureKind.HELMET);
        
        badConsequence = new SpecificBadConsequence ("Embobados con el lindo" +
                "primigenio te descartas de tu casco visible", 0, tVisible, 
                tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // El sopor de Dunwich
        
        tVisible.add(TreasureKind.SHOES);
        
        badConsequence = new SpecificBadConsequence ("El primordial bostezo" 
                + " contagioso. Pierdes el calzado visible", 0, tVisible, 
                tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster ("El sopor de Dunwich", 2, badConsequence, 
                prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Ángeles de la noche ibicenca
        
        tVisible.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.ONEHAND);
        
        badConsequence = new SpecificBadConsequence ("Te atrapan para llevarte"
                + " de fiesta y te dejan caer en mitad del vuelo. Descarta 1"
                + " mano visible y 1 mano oculta", 0, tVisible, tHidden);
        
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14,
                badConsequence, prize));
        
        tVisible = new ArrayList();
        tHidden = new ArrayList();
        
        /**********************************************************************/
        // El gorrón en el umbral
        //
        // We have assigned a large amount of visible treasures to lose in
        // order to make the player lose all of them
        
        badConsequence = new NumericBadConsequence ("Pierdes todos tus tesoros "
                + "visibles", 0, 10, 0);
        
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence,
                prize));
        
        /**********************************************************************/
        // H.P Munchcraft
        
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new SpecificBadConsequence ("Pierdes la armadura"
                + " visible", 0, tVisible, tHidden);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("H.P Munchcraft", 6, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Bichgooth
        
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new SpecificBadConsequence ("Sientes bichos bajo la"
                + " ropa. Descarta la armadura visible", 0, tVisible, tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // El rey de rosa
        
        badConsequence = new NumericBadConsequence ("Pierdes 5 niveles y 3 "
                + "tesoros visibles.", 5, 3, 0);
        
        prize = new Prize(4, 2);
        
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /**********************************************************************/
        // La que redacta en las tinieblas
        
        badConsequence = new NumericBadConsequence ("Toses los pulmones y"
                + " pierdes 2 niveles", 2, 0, 0);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, 
                badConsequence, prize));
        
        /**********************************************************************/
        // Los hondos
        
        badConsequence = new DeathBadConsequence ("Estos monstruos resultan"
                + " bastante superficiales y te aburren mortalmente."
                + " Estás muerto", true);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        /**********************************************************************/
        // Semillas Cthulhu
        
        badConsequence = new NumericBadConsequence ("Pierdes 2 niveles y 2"
                + " tesoros ocultos", 2, 0, 2);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Dameargo
        
        tVisible.add(TreasureKind.ONEHAND);
        
        badConsequence = new SpecificBadConsequence ("Te intentas escaquear."
                + " Pierdes una mano visible", 0, tVisible, tHidden);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Pollipólipo volante
        
        badConsequence = new NumericBadConsequence ("Da mucho asquito. Pierdes"
                + " 3 niveles", 3, 0, 0);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Yskhtihyssg-Goth
        
        badConsequence = new DeathBadConsequence ("No le hace gracia que"
                + " pronuncien mal su nombre. Estas muerto", true);
        
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Familia feliz
        
        badConsequence = new DeathBadConsequence ("La familia te atrapa. Estás "
                + "muerto", true);
        
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        /**********************************************************************/
        // Roboggoth
        
        tVisible.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new SpecificBadConsequence ("La quinta directiva te"
                + " obliga a perder 2 niveles y un tesoro 2 manos visible", 
                2, tVisible, tHidden);
        
        prize = new Prize (2, 1);
        
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // El espia
        
        tVisible.add(TreasureKind.HELMET);
        
        badConsequence = new SpecificBadConsequence ("Te asusta en la noche."
                + " Pierdes un casco visible", 0, tVisible, tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // El Lenguas
        
        badConsequence = new NumericBadConsequence ("Menudo susto te llevas."
                + " Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        /**********************************************************************/
        // Bicéfalo
        
        tHidden = new ArrayList();
        tVisible.add(TreasureKind.ONEHAND);
        tVisible.add(TreasureKind.ONEHAND);
        tVisible.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new SpecificBadConsequence ("Te faltan manos para"
                + " tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de"
                + " las manos", 3, tVisible, tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        ////////////////////////////////////////////////////////////////////////
        // MONSTERS WITH MODIFICATIONS FOR SECTARIAN PLAYERS
        
        /**********************************************************************/
        // El mal indecible impronunciable
        
        tVisible.add(TreasureKind.ONEHAND);
        
        badConsequence = new SpecificBadConsequence ("Pierdes una mano visible",
                0, tVisible, tHidden);
        
        prize = new Prize (3, 1);
        
        monstruos.add(new Monster("El mal indecible impronunciable", 10,
                badConsequence, prize, -2));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Testigos Oculares
        
        badConsequence = new NumericBadConsequence ("Pierdes tus tesoros"
                + " visibles. Jajaja", 0, 10, 0);
        
        prize = new Prize (2, 1);
        
        monstruos.add(new Monster("Testigos Oculares", 6, badConsequence,
                prize, 2));
        
        /**********************************************************************/
        // El gran cthulhu
        
        badConsequence = new DeathBadConsequence ("Hoy no es tu dia de suerte. " 
                + "Mueres", true);
        
        prize = new Prize (2, 5);
        
        monstruos.add(new Monster("El gran cthulhu", 20,
                badConsequence, prize, 4));
        
        /**********************************************************************/
        // Serpiente politico
        
        badConsequence = new NumericBadConsequence ("Tu gobierno te recorta 2"
                + " niveles", 2, 0, 0);
        
        prize = new Prize (2, 1);
        
        monstruos.add(new Monster("Serpiente politico", 8, badConsequence,
                prize, -2));
        
        /**********************************************************************/
        // Felpuggoth
        
        tVisible.add(TreasureKind.ARMOR);
        tVisible.add(TreasureKind.HELMET);
        tHidden.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new SpecificBadConsequence ("Pierdes tu casco y tu"
                + " armadura visible. Pierdes tus manos ocultas", 0, tVisible,
                tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Felpuggoth", 2, badConsequence, prize, +5));
        
        tVisible = new ArrayList();
        tHidden = new ArrayList();
        
        /**********************************************************************/
        // Shoggoth
        
        badConsequence = new NumericBadConsequence ("Pierdes 2 niveles.", 2, 
                0, 0);
        
        prize = new Prize (4, 2);
        
        monstruos.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        /**********************************************************************/
        // Lolitagooth
        
        badConsequence = new NumericBadConsequence ("Pintalabios negro."
                + " Pierdes 2 niveles", 2, 0, 0);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Lolitagooth", 2, badConsequence, prize, +3));
        
        
        // Assigns the filled array of monsters to the unused monsters array
        unusedMonsters = monstruos;
        
        // Shuffle the added monsters
        shuffleMonsters();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // DEFINITION OF THE CULTISTS
    ////////////////////////////////////////////////////////////////////////////
    
    private void initCultistCardDeck ()
    {
        /**********************************************************************/
        // Sectario (1)
        unusedCultists.add(new Cultist("Sectario", 1));
        
        /**********************************************************************/
        // Sectario (2)
        unusedCultists.add(new Cultist("Sectario", 2));
        
        /**********************************************************************/
        // Sectario (3)
        unusedCultists.add(new Cultist("Sectario", 1));
        
        /**********************************************************************/
        // Sectario (4)
        unusedCultists.add(new Cultist("Sectario", 2));
        
        /**********************************************************************/
        // Sectario (5)
        unusedCultists.add(new Cultist("Sectario", 1));
        
        /**********************************************************************/
        // Sectario (6)
        unusedCultists.add(new Cultist("Sectario", 1));
        
        // Shuffle the added cultists
        shuffleCultists();
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    public void initCards()
    {
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
    }
    
    // Returns the next treasure of the unused treasures card deck
    // If it was empty, it would shuffle the used ones and introduce them again
    // into the unused ones
    
    public Treasure nextTreasure ()
    {
        // Checks if the unused_treasures array is empty and, if so, shuffle 
        // the used ones and introduce them again into the unused ones
        
        if(unusedTreasures.isEmpty())
        {
            unusedTreasures = usedTreasures;
            usedTreasures = new ArrayList();
            shuffleTreasures();
        }
        
        Treasure trs = unusedTreasures.get(0);
        unusedTreasures.remove(trs);
        
        return trs;     
    }
    
    // Returns the next monster of the unused monsters card deck
    // If it was empty, it would shuffle the used ones and introduce them again
    // into the unused ones
    
    public Monster nextMonster ()
    {
        // Checks if the unused_monsters array is empty and, if so, shuffle 
        // the used ones and introduce them again into the unused ones
        
        if(unusedMonsters.isEmpty())
        {
            unusedMonsters = usedMonsters;
            usedMonsters = new ArrayList();
            shuffleMonsters();    
        }
        
        Monster mst = unusedMonsters.get(0);
        unusedMonsters.remove(mst);
        
        return mst;
    }
    
    // Returns the next cultist of the unused cultists card deck
    
    public Cultist nextCultist ()
    {
        Cultist clt = unusedCultists.get(0);
        unusedCultists.remove(clt);
        
        return clt;
    }
    
    public void giveTreasureBack (Treasure t)
    {
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack (Monster m)
    {
        usedMonsters.add(m);
    }
    
}
