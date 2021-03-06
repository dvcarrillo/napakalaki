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

import napakalaki.BadConsequence;

/**
 *
 * @author David Vargas
 * ETSIIT, University of Granada
 */

public class PendingBadConsequenceView extends javax.swing.JPanel {
    
    BadConsequence pendingBadModel;
    
    /*
    Sets the view of the Pending Bad Consequence
    Hides it if it is empty
    */
    public void setPendingBadConsequenceView (BadConsequence b)
    {
        pendingBadModel = b;
        
        if (b != null)
        {
            if (b.isEmpty())
                text.setText(" ");
            else
                text.setText(pendingBadModel.toString());
        }
        else
            text.setText(" ");
        
        repaint();
    }
    
    /**
     * Creates new form PendingBadConsequenceView
     */
    public PendingBadConsequenceView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBorder(null);

        text.setEditable(false);
        text.setBackground(new java.awt.Color(0, 0, 0));
        text.setColumns(20);
        text.setForeground(new java.awt.Color(51, 204, 255));
        text.setLineWrap(true);
        text.setRows(2);
        text.setText("text\n");
        text.setWrapStyleWord(true);
        text.setBorder(null);
        jScrollPane1.setViewportView(text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
