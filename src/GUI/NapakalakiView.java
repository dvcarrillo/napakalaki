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

package GUI;

import napakalaki.CombatResult;
import napakalaki.Monster;
import napakalaki.Napakalaki;
import napakalaki.Player;

/**
 *
 * @author David Vargas
 * ETSIIT, University of Granada
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
        setLocationRelativeTo(null);
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
        
        playerView.setNapakalakiModel(napakalakiModel);
        
        nextTurnButton.setEnabled(false);
        combatButton.setEnabled(false);
        nextTurnButton.setEnabled(false);
        
        playerView.ChangeStealButton(false);
        
        repaint();
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
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

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
        
        GeneralDialog resultDialog = new GeneralDialog(this, true);
        
        if (combatResult == CombatResult.WIN)
            resultDialog.setGeneralDialog("You have won the combat!", "Combat won", 'i');
        else if (combatResult == CombatResult.LOSE)
            resultDialog.setGeneralDialog("You have lost the combat.\nIt is time to comply the bad consequence.", "Combat lost", 'i');
        else if (combatResult == CombatResult.LOSEANDCONVERT)
            resultDialog.setGeneralDialog("You have been converted to CULTIST player!", "Cultist player", 'i');
        else if (combatResult == CombatResult.WINGAME)
        {
            resultDialog.setGeneralDialog("Congratulations, " + currentPlayer.getName() + ". You have won the game!", "Victory", 'w');
            resultDialog.setVisible(true);
            
            GeneralDialog creditsDialog = new GeneralDialog(this,true);
            creditsDialog.setGeneralDialog(
                    "Napakalaki Game v1.0\n\n" +
                    "Coded with <3 by David Vargas and Alicia Vílchez.\n" +
                    "GUI designed by David Vargas.\n" +
                    "Part of the BSc in Computer Science at the University of Granada.\n\n" +
                    "We hope you have enjoyed our game!\n" +
                    "More information at http://github.com/dvcarrillo"
                    , "Napakalaki Credits", 'i');
            
            creditsDialog.setVisible(true); 
            System.exit(0);
        }
        
        resultDialog.setVisible(true);
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView.ChangeStealButton(true);
        nextTurnButton.setEnabled(true);
        combatButton.setEnabled(false);
    }//GEN-LAST:event_combatButtonActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        if (!napakalakiModel.nextTurn())
        {
            GeneralDialog resultDialog = new GeneralDialog(this, false);
            resultDialog.setGeneralDialog("You do not satisfy the required conditions to pass to the next turn. "
            + "Either you have more than 4 hidden treasures or you must carry out a bad consequence. ",
            "Error", 'e');
            resultDialog.setVisible(true);
        }
        else
        {
            playerView.setPlayer(napakalakiModel.getCurrentPlayer());
            monsterView.setMonster(napakalakiModel.getCurrentMonster());
            meetMonsterButton.setEnabled(true);
            nextTurnButton.setEnabled(false);
            playerView.ChangeStealButton(false);
        }
    }//GEN-LAST:event_nextTurnButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JButton meetMonsterButton;
    private GUI.MonsterView monsterView;
    private javax.swing.JButton nextTurnButton;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables
}
