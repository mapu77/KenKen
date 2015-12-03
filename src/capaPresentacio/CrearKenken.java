/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComboBox;

/**
 *
 * @author Oriolcapo
 */
public class CrearKenken extends javax.swing.JPanel {

    private String user;
    private javax.swing.JFrame parent;
    private String dif;
    /**
     * Creates new form Crear_Kenken
     */
    public CrearKenken() {
        initComponents();
    }
    
    public CrearKenken(String u, javax.swing.JFrame p) {
        super();
        parent = p;
        user = u;
        dif = "-";
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        manualPanel = new javax.swing.JPanel();
        diffLabel = new javax.swing.JLabel();
        BoxDificultat = new javax.swing.JComboBox<>();
        CreateSave1 = new javax.swing.JButton();
        CreatePlay1 = new javax.swing.JButton();
        PreviewPanel = new javax.swing.JLabel();
        PreviewLabel = new javax.swing.JLabel();
        paramPanel = new javax.swing.JPanel();
        difLabel = new javax.swing.JLabel();
        difBox = new javax.swing.JComboBox<>();
        fixedLabel = new javax.swing.JLabel();
        fixedField = new javax.swing.JTextField();
        operandLabel = new javax.swing.JLabel();
        Boto_Suma = new javax.swing.JButton();
        Boto_Resta = new javax.swing.JButton();
        Boto_Mult = new javax.swing.JButton();
        Boto_Div = new javax.swing.JButton();
        previewLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CreateSave = new javax.swing.JButton();
        CreatePlay = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(598, 496));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create KenKen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setPreferredSize(new java.awt.Dimension(598, 496));

        diffLabel.setText("Select difficulty");

        BoxDificultat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        BoxDificultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxDificultatActionPerformed(evt);
            }
        });

        CreateSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CreateSave1.setText("Create&Save");
        CreateSave1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreateSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSave1ActionPerformed(evt);
            }
        });

        CreatePlay1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CreatePlay1.setText("Create&Play");
        CreatePlay1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreatePlay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePlay1ActionPerformed(evt);
            }
        });

        PreviewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PreviewLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PreviewLabel.setText("Preview:");

        javax.swing.GroupLayout manualPanelLayout = new javax.swing.GroupLayout(manualPanel);
        manualPanel.setLayout(manualPanelLayout);
        manualPanelLayout.setHorizontalGroup(
            manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manualPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diffLabel)
                    .addComponent(BoxDificultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreviewLabel)
                    .addComponent(PreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        manualPanelLayout.setVerticalGroup(
            manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manualPanelLayout.createSequentialGroup()
                .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manualPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diffLabel)
                            .addComponent(PreviewLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxDificultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addComponent(CreateSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreatePlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(manualPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(PreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manually", manualPanel);

        difLabel.setText("Select difficulty");

        difBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        difBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                difBoxActionPerformed(evt);
            }
        });

        fixedLabel.setText("Minimum number of fixed numbers");

        fixedField.setMaximumSize(new java.awt.Dimension(6, 20));

        operandLabel.setText("Select the operands");

        Boto_Suma.setBackground(java.awt.Color.gray);
        Boto_Suma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Suma.setText("+");
        Boto_Suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_SumaActionPerformed(evt);
            }
        });

        Boto_Resta.setBackground(java.awt.Color.white);
        Boto_Resta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Resta.setText("-");
        Boto_Resta.setToolTipText("");
        Boto_Resta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_RestaActionPerformed(evt);
            }
        });

        Boto_Mult.setBackground(java.awt.Color.white);
        Boto_Mult.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Mult.setText("x");
        Boto_Mult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_MultActionPerformed(evt);
            }
        });

        Boto_Div.setBackground(java.awt.Color.white);
        Boto_Div.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Div.setText("/");
        Boto_Div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_DivActionPerformed(evt);
            }
        });

        previewLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        previewLabel.setText("Preview:");

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

        javax.swing.GroupLayout paramPanelLayout = new javax.swing.GroupLayout(paramPanel);
        paramPanel.setLayout(paramPanelLayout);
        paramPanelLayout.setHorizontalGroup(
            paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paramPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fixedLabel)
                    .addComponent(difLabel)
                    .addComponent(difBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fixedField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operandLabel)
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Boto_Mult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Boto_Suma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boto_Resta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boto_Div, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewLabel)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        paramPanelLayout.setVerticalGroup(
            paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paramPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(previewLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addComponent(difLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(difBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(fixedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(operandLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boto_Suma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boto_Resta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boto_Mult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boto_Div, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("By Parameters", paramPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void BoxDificultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxDificultatActionPerformed
        // TODO add your handling code here:
        JComboBox a = (JComboBox)evt.getSource();
        dif = (String)a.getSelectedItem();
    }//GEN-LAST:event_BoxDificultatActionPerformed

    private void CreateSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateSave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateSave1ActionPerformed

    private void CreatePlay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePlay1ActionPerformed
        // TODO add your handling code here:
        int d;
        if (dif.substring(0,1).equals("-")) d = 2;
        else d = Integer.parseInt(dif.substring(0,1));
        PlayKenKen pk = new PlayKenKen(d,user,parent);
        parent.dispose();
        setVisible(false);
    }//GEN-LAST:event_CreatePlay1ActionPerformed

    private void CreatePlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePlayActionPerformed
        // TODO add your handling code here:
        int d;
        if (dif.substring(0,1).equals("-")) d = 2;
        else d = Integer.parseInt(dif.substring(0,1));
        PlayKenKen pk = new PlayKenKen(d,user,parent);
        parent.dispose();
        setVisible(false);
    }//GEN-LAST:event_CreatePlayActionPerformed

    private void CreateSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateSaveActionPerformed

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

    private void difBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_difBoxActionPerformed
        // TODO add your handling code here:
        JComboBox a = (JComboBox)evt.getSource();
        dif = (String)a.getSelectedItem();
    }//GEN-LAST:event_difBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boto_Div;
    private javax.swing.JButton Boto_Mult;
    private javax.swing.JButton Boto_Resta;
    private javax.swing.JButton Boto_Suma;
    private javax.swing.JComboBox<String> BoxDificultat;
    private javax.swing.JButton CreatePlay;
    private javax.swing.JButton CreatePlay1;
    private javax.swing.JButton CreateSave;
    private javax.swing.JButton CreateSave1;
    private javax.swing.JLabel PreviewLabel;
    private javax.swing.JLabel PreviewPanel;
    private javax.swing.JComboBox<String> difBox;
    private javax.swing.JLabel difLabel;
    private javax.swing.JLabel diffLabel;
    private javax.swing.JTextField fixedField;
    private javax.swing.JLabel fixedLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel manualPanel;
    private javax.swing.JLabel operandLabel;
    private javax.swing.JPanel paramPanel;
    private javax.swing.JLabel previewLabel;
    // End of variables declaration//GEN-END:variables
}
