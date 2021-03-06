/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Utils.CtrlJoc;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;


/**
 *
 * @author Oriolcapo
 */
public class KenkenBBDD extends javax.swing.JPanel {

    private String user;
    private javax.swing.JFrame parent;
    private CtrlPresentacio CP;
    private CtrlJoc CJ;
    /**
     * Creates new form KenkenBBDD2
     */
    public KenkenBBDD(String u, javax.swing.JFrame pare, CtrlPresentacio CP, CtrlJoc CJ) {
        initComponents();
        parent = pare;
        user = u;
        this.CP = CP;
        this.CJ = CJ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        diffLabel = new javax.swing.JLabel();
        BoxDiff = new javax.swing.JComboBox<>();
        selectLabel = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        previewLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        idList = new javax.swing.JList<>();
        prevPanel = new javax.swing.JPanel();
        prevPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kenken from Database", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setMaximumSize(new java.awt.Dimension(576, 474));
        jPanel1.setMinimumSize(new java.awt.Dimension(576, 474));

        diffLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        diffLabel.setText("Select difficulty");

        BoxDiff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        BoxDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxDiffActionPerformed(evt);
            }
        });
        BoxDiff.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                BoxDiffPropertyChange(evt);
            }
        });

        selectLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        selectLabel.setText("Select Kenken");

        playButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        playButton.setText("Play!");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        previewLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        previewLabel.setText("KenKen Preview");

        idList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                idListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(idList);

        prevPanel.setMaximumSize(new java.awt.Dimension(326, 336));
        prevPanel.setMinimumSize(new java.awt.Dimension(326, 336));
        prevPanel.setPreferredSize(new java.awt.Dimension(326, 336));
        prevPanel.setLayout(new java.awt.CardLayout());

        prevPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout prevPanel1Layout = new javax.swing.GroupLayout(prevPanel1);
        prevPanel1.setLayout(prevPanel1Layout);
        prevPanel1Layout.setHorizontalGroup(
            prevPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        prevPanel1Layout.setVerticalGroup(
            prevPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        prevPanel.add(prevPanel1, "card2");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BoxDiff, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectLabel)
                            .addComponent(playButton, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(diffLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prevPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previewLabel))
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(diffLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BoxDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectLabel)
                    .addComponent(previewLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prevPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        String d = String.valueOf(BoxDiff.getSelectedItem());
        if (d.equals("-")) jLabel1.setText("You must select a difficulty");
        else {
            int id = idList.getSelectedIndex() + 1;
            PlayKenKen pk = new PlayKenKen(d,user,CP,Integer.toString(id),CJ,parent);
            parent.dispose();
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void BoxDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxDiffActionPerformed
        // TODO add your handling code here:
        idList.removeAll();
        String dif = String.valueOf(BoxDiff.getSelectedItem());
        DefaultListModel list = new DefaultListModel();
        if (!dif.equals("-")) {
            String s = CP.obtenirIdJoc(dif);
            String []vs = s.split(".txt");
            int cont = 0;
            while (cont < vs.length) {
                int i = 0;
                while (i < vs.length && !(vs[i].equals(Integer.toString((cont+1))))) {
                    ++i;
                }
                list.addElement("KenKen " +(cont+1));
                ++cont;
            }
            list.remove(list.getSize()-1);            
        }
        idList.setModel(list);
        idList.setSelectedIndex(0);
    }//GEN-LAST:event_BoxDiffActionPerformed

    private void BoxDiffPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_BoxDiffPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxDiffPropertyChange

    private void idListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_idListValueChanged
        // TODO add your handling code here:
        String id = idList.getSelectedValue();
        if  (id != null) {
            id = id.substring(7);
            String dif = String.valueOf(BoxDiff.getSelectedItem());
            ArrayList<String> vOps = new ArrayList<>();
            int[][] mat = CP.taulerBBDD(id, dif, vOps);
            prevPanel.removeAll();
            prevPanel.repaint();
            prevPanel.revalidate();
            prevPanel.add(new Preview(mat,vOps,prevPanel.getBounds()));
            prevPanel.repaint();
            prevPanel.revalidate(); 
        }
    }//GEN-LAST:event_idListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxDiff;
    private javax.swing.JLabel diffLabel;
    private javax.swing.JList<String> idList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton playButton;
    private javax.swing.JPanel prevPanel;
    private javax.swing.JPanel prevPanel1;
    private javax.swing.JLabel previewLabel;
    private javax.swing.JLabel selectLabel;
    // End of variables declaration//GEN-END:variables
}
