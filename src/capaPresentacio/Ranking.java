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
public class Ranking extends javax.swing.JPanel {

    /**
     * Creates new form Ranking2
     */
    public Ranking() {
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
        rankingLabel = new javax.swing.JLabel();
        GrankingLabel = new javax.swing.JLabel();
        GrankingPanel = new javax.swing.JPanel();
        PrankingButton = new javax.swing.JButton();
        TrankingButton = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        rankingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rankingLabel.setText("RANKING");
        rankingLabel.setAlignmentX(250.0F);
        rankingLabel.setAlignmentY(300.0F);

        GrankingLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GrankingLabel.setText("General Ranking:");

        GrankingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout GrankingPanelLayout = new javax.swing.GroupLayout(GrankingPanel);
        GrankingPanel.setLayout(GrankingPanelLayout);
        GrankingPanelLayout.setHorizontalGroup(
            GrankingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        GrankingPanelLayout.setVerticalGroup(
            GrankingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        PrankingButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PrankingButton.setText("Personal Ranking");
        PrankingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrankingButtonActionPerformed(evt);
            }
        });

        TrankingButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TrankingButton.setText("Ranking by Type");
        TrankingButton.setActionCommand("");
        TrankingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrankingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(rankingLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GrankingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(GrankingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(PrankingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TrankingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(rankingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrankingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrankingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrankingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TrankingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void PrankingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrankingButtonActionPerformed
        // TODO add your handling code here:
        removeAll();
        repaint();
        revalidate();
        //afegint JPanel
        add(new PersonalR());
        repaint();
        revalidate();
    }//GEN-LAST:event_PrankingButtonActionPerformed

    private void TrankingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrankingButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TrankingButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GrankingLabel;
    private javax.swing.JPanel GrankingPanel;
    private javax.swing.JButton PrankingButton;
    private javax.swing.JButton TrankingButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel rankingLabel;
    // End of variables declaration//GEN-END:variables
}
