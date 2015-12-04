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

        createPanel = new javax.swing.JPanel();
        tabMenu = new javax.swing.JTabbedPane();
        manualPanel = new javax.swing.JPanel();
        diffLabel = new javax.swing.JLabel();
        BoxDificultat = new javax.swing.JComboBox<>();
        CreateSave1 = new javax.swing.JButton();
        CreatePlay1 = new javax.swing.JButton();
        PreviewPanel = new javax.swing.JLabel();
        PreviewLabel = new javax.swing.JLabel();
        EditButton = new javax.swing.JButton();
        paramPanel = new javax.swing.JPanel();
        difLabel = new javax.swing.JLabel();
        difBox = new javax.swing.JComboBox<>();
        fixedLabel = new javax.swing.JLabel();
        operandLabel = new javax.swing.JLabel();
        Boto_Suma = new javax.swing.JButton();
        Boto_Resta = new javax.swing.JButton();
        Boto_Mult = new javax.swing.JButton();
        Boto_Div = new javax.swing.JButton();
        previewLabel = new javax.swing.JLabel();
        CreateSave = new javax.swing.JButton();
        CreatePlay = new javax.swing.JButton();
        PreviewPanel1 = new javax.swing.JLabel();
        fixedFField = new javax.swing.JFormattedTextField();

        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(598, 496));
        setLayout(new java.awt.CardLayout());

        createPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create KenKen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        createPanel.setPreferredSize(new java.awt.Dimension(598, 496));

        tabMenu.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tabMenu.setPreferredSize(new java.awt.Dimension(575, 465));

        diffLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        diffLabel.setText("Select difficulty");

        BoxDificultat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        BoxDificultat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        BoxDificultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxDificultatActionPerformed(evt);
            }
        });

        CreateSave1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        CreateSave1.setText("Create&Save");
        CreateSave1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreateSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSave1ActionPerformed(evt);
            }
        });

        CreatePlay1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        CreatePlay1.setText("Create&Play");
        CreatePlay1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreatePlay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePlay1ActionPerformed(evt);
            }
        });

        PreviewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PreviewPanel.setMaximumSize(new java.awt.Dimension(350, 350));
        PreviewPanel.setMinimumSize(new java.awt.Dimension(350, 350));
        PreviewPanel.setPreferredSize(new java.awt.Dimension(350, 350));

        PreviewLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        PreviewLabel.setText("Preview:");

        EditButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        EditButton.setText("Edit");
        EditButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manualPanelLayout = new javax.swing.GroupLayout(manualPanel);
        manualPanel.setLayout(manualPanelLayout);
        manualPanelLayout.setHorizontalGroup(
            manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manualPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BoxDificultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diffLabel)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviewLabel))
                .addContainerGap())
        );
        manualPanelLayout.setVerticalGroup(
            manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manualPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diffLabel)
                    .addComponent(PreviewLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(manualPanelLayout.createSequentialGroup()
                        .addComponent(BoxDificultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CreateSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CreatePlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tabMenu.addTab("Manually", manualPanel);

        difLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        difLabel.setText("Select difficulty");

        difBox.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        difBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        difBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                difBoxActionPerformed(evt);
            }
        });

        fixedLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fixedLabel.setText("<html>Minimum number<br>of fixed numbers</html>");

        operandLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        operandLabel.setText("Select the operands");

        Boto_Suma.setBackground(java.awt.Color.gray);
        Boto_Suma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Suma.setText("+");
        Boto_Suma.setMaximumSize(new java.awt.Dimension(30, 30));
        Boto_Suma.setMinimumSize(new java.awt.Dimension(30, 30));
        Boto_Suma.setPreferredSize(new java.awt.Dimension(40, 35));
        Boto_Suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_SumaActionPerformed(evt);
            }
        });

        Boto_Resta.setBackground(java.awt.Color.white);
        Boto_Resta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Resta.setText("-");
        Boto_Resta.setToolTipText("");
        Boto_Resta.setMaximumSize(new java.awt.Dimension(30, 30));
        Boto_Resta.setMinimumSize(new java.awt.Dimension(30, 30));
        Boto_Resta.setPreferredSize(new java.awt.Dimension(40, 35));
        Boto_Resta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_RestaActionPerformed(evt);
            }
        });

        Boto_Mult.setBackground(java.awt.Color.white);
        Boto_Mult.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Mult.setText("x");
        Boto_Mult.setMaximumSize(new java.awt.Dimension(30, 30));
        Boto_Mult.setMinimumSize(new java.awt.Dimension(30, 30));
        Boto_Mult.setPreferredSize(new java.awt.Dimension(40, 35));
        Boto_Mult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_MultActionPerformed(evt);
            }
        });

        Boto_Div.setBackground(java.awt.Color.white);
        Boto_Div.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Boto_Div.setText("/");
        Boto_Div.setMaximumSize(new java.awt.Dimension(30, 30));
        Boto_Div.setMinimumSize(new java.awt.Dimension(30, 30));
        Boto_Div.setPreferredSize(new java.awt.Dimension(40, 35));
        Boto_Div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boto_DivActionPerformed(evt);
            }
        });

        previewLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        previewLabel.setText("Preview:");

        CreateSave.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        CreateSave.setText("Create&Save");
        CreateSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreateSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSaveActionPerformed(evt);
            }
        });

        CreatePlay.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        CreatePlay.setText("Create&Play");
        CreatePlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CreatePlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePlayActionPerformed(evt);
            }
        });

        PreviewPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PreviewPanel1.setMaximumSize(new java.awt.Dimension(350, 350));
        PreviewPanel1.setMinimumSize(new java.awt.Dimension(350, 350));
        PreviewPanel1.setPreferredSize(new java.awt.Dimension(350, 350));

        fixedFField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        fixedFField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fixedFField.setMaximumSize(new java.awt.Dimension(50, 27));
        fixedFField.setMinimumSize(new java.awt.Dimension(50, 27));
        fixedFField.setPreferredSize(new java.awt.Dimension(50, 27));
        fixedFField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedFFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paramPanelLayout = new javax.swing.GroupLayout(paramPanel);
        paramPanel.setLayout(paramPanelLayout);
        paramPanelLayout.setHorizontalGroup(
            paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paramPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fixedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(difLabel)
                    .addComponent(operandLabel)
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Boto_Suma, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(Boto_Mult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Boto_Div, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(Boto_Resta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(difBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fixedFField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreviewPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previewLabel))
                .addContainerGap())
        );
        paramPanelLayout.setVerticalGroup(
            paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paramPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(difLabel)
                    .addComponent(previewLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addComponent(difBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fixedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixedFField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(operandLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boto_Suma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boto_Resta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boto_Mult, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boto_Div, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PreviewPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tabMenu.addTab("By Parameters", paramPanel);

        javax.swing.GroupLayout createPanelLayout = new javax.swing.GroupLayout(createPanel);
        createPanel.setLayout(createPanelLayout);
        createPanelLayout.setHorizontalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        createPanelLayout.setVerticalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addComponent(tabMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        tabMenu.getAccessibleContext().setAccessibleName("");

        add(createPanel, "card2");
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

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditButtonActionPerformed

    private void fixedFFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedFFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fixedFFieldActionPerformed


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
    private javax.swing.JButton EditButton;
    private javax.swing.JLabel PreviewLabel;
    private javax.swing.JLabel PreviewPanel;
    private javax.swing.JLabel PreviewPanel1;
    private javax.swing.JPanel createPanel;
    private javax.swing.JComboBox<String> difBox;
    private javax.swing.JLabel difLabel;
    private javax.swing.JLabel diffLabel;
    private javax.swing.JFormattedTextField fixedFField;
    private javax.swing.JLabel fixedLabel;
    private javax.swing.JPanel manualPanel;
    private javax.swing.JLabel operandLabel;
    private javax.swing.JPanel paramPanel;
    private javax.swing.JLabel previewLabel;
    private javax.swing.JTabbedPane tabMenu;
    // End of variables declaration//GEN-END:variables
}
