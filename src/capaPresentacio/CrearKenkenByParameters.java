/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import java.awt.Color;
import java.awt.image.ColorModel;
import javax.swing.JComboBox;

/**
 *
 * @author Oriolcapo
 */
public class CrearKenkenByParameters extends javax.swing.JPanel {

    private String dif;
    private String user;
    private javax.swing.JFrame parent;
    /**
     * Creates new form Create_Kenken_ByParameters
     */
    public CrearKenkenByParameters(String user, javax.swing.JFrame pare) {
        parent = pare;
        initComponents();
        this.user = user;
        dif = "-";
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Boto_Suma = new javax.swing.JButton();
        Boto_Resta = new javax.swing.JButton();
        Boto_Mult = new javax.swing.JButton();
        Boto_Div = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CreateSave = new javax.swing.JButton();
        CreatePlay = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 500));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Kenken By Parameters", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 500));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Select difficulty");

        jLabel3.setText("Minimum number of fixed numbers");

        jTextField2.setMaximumSize(new java.awt.Dimension(6, 20));

        jLabel2.setText("Select the operands");

        Boto_Suma.setBackground(java.awt.Color.gray);
        Boto_Suma.setText("+");
        Boto_Suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_SumaActionPerformed(evt);
            }
        });

        Boto_Resta.setBackground(java.awt.Color.white);
        Boto_Resta.setText("-");
        Boto_Resta.setToolTipText("");
        Boto_Resta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_RestaActionPerformed(evt);
            }
        });

        Boto_Mult.setBackground(java.awt.Color.white);
        Boto_Mult.setText("x");
        Boto_Mult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_MultActionPerformed(evt);
            }
        });

        Boto_Div.setBackground(java.awt.Color.white);
        Boto_Div.setText("/");
        Boto_Div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_DivActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Preview:");

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setMaximumSize(new java.awt.Dimension(350, 350));
        jLabel5.setMinimumSize(new java.awt.Dimension(350, 350));
        jLabel5.setPreferredSize(new java.awt.Dimension(350, 350));

        CreateSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CreateSave.setText("Create&Save");
        CreateSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreateSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSaveActionPerformed(evt);
            }
        });

        CreatePlay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CreatePlay.setText("Create&Play");
        CreatePlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreatePlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Boto_Mult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Boto_Suma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boto_Resta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boto_Div, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boto_Suma)
                            .addComponent(Boto_Resta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boto_Mult)
                            .addComponent(Boto_Div))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        add(jPanel1, "card2");
        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void Boto_DivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boto_DivActionPerformed
        // TODO add your handling code here:
        Color c = Boto_Div.getBackground();
        if (c == Color.white) {
            Boto_Div.setBackground(Color.gray);
        }
        else Boto_Div.setBackground(Color.white);
    }//GEN-LAST:event_Boto_DivActionPerformed

    private void Boto_MultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boto_MultActionPerformed
        // TODO add your handling code here:
        Color c = Boto_Mult.getBackground();
        if (c == Color.white) {
            Boto_Mult.setBackground(Color.gray);
        }
        else Boto_Mult.setBackground(Color.white);
    }//GEN-LAST:event_Boto_MultActionPerformed

    private void Boto_RestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boto_RestaActionPerformed
        // TODO add your handling code here:
        Color c = Boto_Resta.getBackground();
        if (c == Color.white) {
            Boto_Resta.setBackground(Color.gray);
        }
        else Boto_Resta.setBackground(Color.white);

    }//GEN-LAST:event_Boto_RestaActionPerformed

    private void Boto_SumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boto_SumaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Boto_SumaActionPerformed

    private void CreateSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateSaveActionPerformed

    private void CreatePlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePlayActionPerformed
        // TODO add your handling code here:
        int d;
        if (dif.substring(0,1).equals("-")) d = 2;
        else d = Integer.parseInt(dif.substring(0,1));
        PlayKenKen pk = new PlayKenKen(d,user,parent);
        parent.dispose();
        setVisible(false);
    }//GEN-LAST:event_CreatePlayActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        JComboBox a = (JComboBox)evt.getSource();
        dif = (String)a.getSelectedItem();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boto_Div;
    private javax.swing.JButton Boto_Mult;
    private javax.swing.JButton Boto_Resta;
    private javax.swing.JButton Boto_Suma;
    private javax.swing.JButton CreatePlay;
    private javax.swing.JButton CreateSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}