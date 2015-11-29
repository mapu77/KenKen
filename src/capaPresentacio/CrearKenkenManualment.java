/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

/**
 *
 * @author Oriolcapo
 */
public class CrearKenkenManualment extends javax.swing.JPanel {

    /**
     * Creates new form CrearKenkenManualment
     */
    public CrearKenkenManualment() {
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
        jLabel1 = new javax.swing.JLabel();
        BoxDificultat = new javax.swing.JComboBox<>();
        PreviewLabel = new javax.swing.JLabel();
        PreviewPanel = new javax.swing.JLabel();
        CreateSave = new javax.swing.JButton();
        CreatePlay = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Kenken manually", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setLayout(new java.awt.CardLayout());

        jLabel1.setText("Select difficulty");

        BoxDificultat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        BoxDificultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxDificultatActionPerformed(evt);
            }
        });

        PreviewLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PreviewLabel.setText("Preview:");

        PreviewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(BoxDificultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviewLabel))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoxDificultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CreateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreatePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PreviewLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void BoxDificultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxDificultatActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BoxDificultatActionPerformed

    private void CreateSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateSaveActionPerformed

    private void CreatePlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePlayActionPerformed
        // TODO add your handling code here:
        PlayKenKen pk = new PlayKenKen();
        setVisible(false);
    }//GEN-LAST:event_CreatePlayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxDificultat;
    private javax.swing.JButton CreatePlay;
    private javax.swing.JButton CreateSave;
    private javax.swing.JLabel PreviewLabel;
    private javax.swing.JLabel PreviewPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
