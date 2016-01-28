/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;
import napakalaki.CombatResult;
import napakalaki.Monster;
import napakalaki.Napakalaki;
import napakalaki.Player;

/**
 *
 * @author davidvargascarrillo
 */
public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;             // Manages the game
    private Player currentPlayer;                   // Player which is playing
    private Monster currentMonster;                 // Monster in combat
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        this.setTitle("Napakalaki Game");
        initComponents();
    }
    
    /*
    Set method for the object of Napakalaki class
    */
    public void setNapakalaki (Napakalaki aGame)
    {
        napakalakiModel = aGame;
        
        currentPlayer = aGame.getCurrentPlayer();
        playerView.setPlayer(currentPlayer);
        
        currentMonster = aGame.getCurrentMonster();
        monsterView.setMonster(currentMonster);
        monsterView.HideMonster();
        
        playerView.setNapakalakiModel(napakalakiModel);
        
        nextTurnButton.setEnabled(false);
        combatButton.setEnabled(false);
        
        repaint();
    }
    
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        meetMonsterButton = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        monsterView = new GUI.MonsterView();
        playerView = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        meetMonsterButton.setText("Discover");
        meetMonsterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterButtonActionPerformed(evt);
            }
        });

        combatButton.setText("Fight");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        nextTurnButton.setText("Next Turn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(meetMonsterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nextTurnButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(monsterView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(meetMonsterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextTurnButton)))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetMonsterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterButtonActionPerformed
        monsterView.ShowMonster();
        combatButton.setEnabled(true);
        meetMonsterButton.setEnabled(false);
        playerView.ChangeMakeVisibleButton(false);
    }//GEN-LAST:event_meetMonsterButtonActionPerformed

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        CombatResult combatResult = napakalakiModel.developCombat();
        
        if (combatResult == CombatResult.WIN)
            infoBox("You have won the combat!", "Combat won");
        else if (combatResult == CombatResult.LOSE)
            infoBox("You have lost the combat. Time to comply the bad Consequence.", "Combat lost");
        else if (combatResult == CombatResult.LOSEANDCONVERT)
            infoBox("You have lost the combat, but you have been converted to CULTIST player!", "Combat lost");
        else
        {
            infoBox(currentPlayer.getName() + " is the WINNER!", "Congratulations");
            System.exit(0);
        }
        
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView.ChangeStealButton(true);
        nextTurnButton.setEnabled(true);
        combatButton.setEnabled(false);
    }//GEN-LAST:event_combatButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JButton meetMonsterButton;
    private GUI.MonsterView monsterView;
    private javax.swing.JButton nextTurnButton;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables
}
