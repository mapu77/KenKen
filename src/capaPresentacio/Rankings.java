/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import com.sun.glass.events.KeyEvent;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author Jan
 */
public class Rankings extends javax.swing.JPanel {

    private CtrlPresentacio CP;
    private javax.swing.JFrame parent;
    /**
     * Creates new form Rankings
     */
    public Rankings(CtrlPresentacio CP) {
        initComponents();
        this.CP = CP;
        nJocs.setText(Integer.toString(CP.jocsRG()));
        nPartides.setText(Integer.toString(CP.partidesRG()));
        nUsuaris.setText(Integer.toString(CP.usuarisRG()));
        popular.setText(CP.popularRG());
    }
    
    public Rankings(CtrlPresentacio CP, int index, javax.swing.JFrame p) {
        initComponents();
        this.parent = p;
        this.CP = CP;
        nJocs.setText(Integer.toString(CP.jocsRG()));
        nPartides.setText(Integer.toString(CP.partidesRG()));
        nUsuaris.setText(Integer.toString(CP.usuarisRG()));
        popular.setText(CP.popularRG());
        tabMenu2.setSelectedIndex(index);
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
        tabMenu2 = new javax.swing.JTabbedPane();
        generalR = new javax.swing.JPanel();
        jocsLabel = new javax.swing.JLabel();
        nJocs = new javax.swing.JLabel();
        partidesLabel = new javax.swing.JLabel();
        nPartides = new javax.swing.JLabel();
        usuarisLabel = new javax.swing.JLabel();
        nUsuaris = new javax.swing.JLabel();
        popularLabel = new javax.swing.JLabel();
        popular = new javax.swing.JLabel();
        PersonalR = new javax.swing.JPanel();
        user_label = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        jResoltsLabel = new javax.swing.JLabel();
        jResolts = new javax.swing.JLabel();
        avgpistesLabel = new javax.swing.JLabel();
        avgpistes = new javax.swing.JLabel();
        timesLabel = new javax.swing.JLabel();
        threeLabel = new javax.swing.JLabel();
        fourLabel = new javax.swing.JLabel();
        fiveLabel = new javax.swing.JLabel();
        sixLabel = new javax.swing.JLabel();
        sevenLabel = new javax.swing.JLabel();
        eightLabel = new javax.swing.JLabel();
        nineLabel = new javax.swing.JLabel();
        ninetime = new javax.swing.JLabel();
        eighttime = new javax.swing.JLabel();
        seventime = new javax.swing.JLabel();
        sixtime = new javax.swing.JLabel();
        fivetime = new javax.swing.JLabel();
        fourtime = new javax.swing.JLabel();
        threetime = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRes = new javax.swing.JTable();
        select_diff1 = new javax.swing.JLabel();
        dificultat1 = new javax.swing.JComboBox<>();
        entrades1 = new javax.swing.JComboBox<>();
        select_entries1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ranking", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tabMenu2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tabMenu2.setPreferredSize(new java.awt.Dimension(575, 465));

        jocsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jocsLabel.setText("Total KenKens:");

        nJocs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        partidesLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        partidesLabel.setText("Played games:");

        nPartides.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        usuarisLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarisLabel.setText("Total users:");

        nUsuaris.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        popularLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        popularLabel.setText("Most popular KenKen:");

        popular.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout generalRLayout = new javax.swing.GroupLayout(generalR);
        generalR.setLayout(generalRLayout);
        generalRLayout.setHorizontalGroup(
            generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalRLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jocsLabel)
                    .addComponent(partidesLabel)
                    .addComponent(usuarisLabel)
                    .addComponent(popularLabel))
                .addGap(35, 35, 35)
                .addGroup(generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(popular, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nPartides, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nJocs, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        generalRLayout.setVerticalGroup(
            generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalRLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jocsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nJocs, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nPartides, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partidesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nUsuaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuarisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(generalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(popularLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(popular, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        tabMenu2.addTab("General Ranking", generalR);

        user_label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        user_label.setText("Username");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameFieldKeyPressed(evt);
            }
        });

        findButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        jResoltsLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jResoltsLabel.setText("KenKens solved:");

        jResolts.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jResolts.setText("-");

        avgpistesLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        avgpistesLabel.setText("Average hints:");

        avgpistes.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        avgpistes.setText("-");

        timesLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        timesLabel.setText("Best times:");

        threeLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        threeLabel.setText("3x3:");

        fourLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fourLabel.setText("4x4:");

        fiveLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fiveLabel.setText("5x5:");

        sixLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        sixLabel.setText("6x6:");

        sevenLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        sevenLabel.setText("7x7:");

        eightLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        eightLabel.setText("8x8:");

        nineLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        nineLabel.setText("9x9:");

        ninetime.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ninetime.setText("-");

        eighttime.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        eighttime.setText("-");

        seventime.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        seventime.setText("-");

        sixtime.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        sixtime.setText("-");

        fivetime.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fivetime.setText("-");

        fourtime.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fourtime.setText("-");

        threetime.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        threetime.setText("-");

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PersonalRLayout = new javax.swing.GroupLayout(PersonalR);
        PersonalR.setLayout(PersonalRLayout);
        PersonalRLayout.setHorizontalGroup(
            PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalRLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PersonalRLayout.createSequentialGroup()
                        .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(threeLabel)
                            .addComponent(timesLabel)
                            .addComponent(fourLabel)
                            .addComponent(fiveLabel)
                            .addComponent(sixLabel)
                            .addComponent(sevenLabel)
                            .addComponent(eightLabel)
                            .addComponent(nineLabel))
                        .addGap(18, 18, 18)
                        .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(threetime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fourtime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fivetime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sixtime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seventime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eighttime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ninetime, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PersonalRLayout.createSequentialGroup()
                        .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avgpistesLabel)
                            .addComponent(jResoltsLabel))
                        .addGap(18, 18, 18)
                        .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jResolts, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avgpistes, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PersonalRLayout.createSequentialGroup()
                        .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(user_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        PersonalRLayout.setVerticalGroup(
            PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalRLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jResoltsLabel)
                    .addComponent(jResolts))
                .addGap(18, 18, 18)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avgpistesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avgpistes))
                .addGap(18, 18, 18)
                .addComponent(timesLabel)
                .addGap(18, 18, 18)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threeLabel)
                    .addComponent(threetime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fourLabel)
                    .addComponent(fourtime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fivetime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixtime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sevenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eighttime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ninetime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabMenu2.addTab("Personal Ranking", PersonalR);

        tableRes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Position", "User", "Time", "KenKen ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRes);
        if (tableRes.getColumnModel().getColumnCount() > 0) {
            tableRes.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableRes.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        select_diff1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        select_diff1.setText("Select difficulty");

        dificultat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));
        dificultat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dificultat1ActionPerformed(evt);
            }
        });
        dificultat1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dificultat1KeyPressed(evt);
            }
        });

        entrades1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "5", "10", "15", "20" }));
        entrades1.setMinimumSize(new java.awt.Dimension(47, 22));
        entrades1.setPreferredSize(new java.awt.Dimension(47, 22));
        entrades1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrades1ActionPerformed(evt);
            }
        });
        entrades1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entrades1KeyPressed(evt);
            }
        });

        select_entries1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        select_entries1.setText("Select number of entries");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(select_diff1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dificultat1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(select_entries1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entrades1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_entries1)
                    .addComponent(entrades1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dificultat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_diff1))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tabMenu2.addTab("Ranking by Type", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tabMenu2.getAccessibleContext().setAccessibleName("General");

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            findButton.doClick();
    }//GEN-LAST:event_usernameFieldKeyPressed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        String user = usernameField.getText();
        if (CP.existeixUsuari(user)) {
            if (CP.obtenirResoltsRP(user) == 0) {
                buidaAll();
                jResolts.setText("0");
                errorLabel.setText("<html>No games played by this user</html>");
            }
            else {
                obtenirAll(user);
                errorLabel.setText("");
            }
        }
        else {
            buidaAll();
            errorLabel.setText("<html>Username incorrect</html>");
        }
    }//GEN-LAST:event_findButtonActionPerformed

    private void dificultat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dificultat1ActionPerformed
        // TODO add your handling code here:
        obtenirR();
    }//GEN-LAST:event_dificultat1ActionPerformed

    private void entrades1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrades1ActionPerformed
        // TODO add your handling code here:
        obtenirR();
    }//GEN-LAST:event_entrades1ActionPerformed

    private void entrades1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entrades1KeyPressed

    }//GEN-LAST:event_entrades1KeyPressed

    private void dificultat1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dificultat1KeyPressed

    }//GEN-LAST:event_dificultat1KeyPressed

    private void obtenirAll (String user) {
        DecimalFormat decimals = new DecimalFormat("0.00");
        int h, m, s;
        long time;
        jResolts.setText(Integer.toString(CP.obtenirResoltsRP(user)));
        avgpistes.setText(decimals.format(CP.obtenirPistesRP(user)));
        time = (long)CP.obtenirTempsRP(user, "3x3");
        h = (int)time/3600; m = (int)(time%3600)/60; s = (int)(time%3600)%60;
        threetime.setText((h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s));
        time = (long)CP.obtenirTempsRP(user, "4x4");
        h = (int)time/3600; m = (int)(time%3600)/60; s = (int)(time%3600)%60;
        fourtime.setText((h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s));
        time = (long)CP.obtenirTempsRP(user, "5x5");
        h = (int)time/3600; m = (int)(time%3600)/60; s = (int)(time%3600)%60;
        fivetime.setText((h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s));
        time = (long)CP.obtenirTempsRP(user, "6x6");
        h = (int)time/3600; m = (int)(time%3600)/60; s = (int)(time%3600)%60;
        sixtime.setText((h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s));
        time = (long)CP.obtenirTempsRP(user, "7x7");
        h = (int)time/3600; m = (int)(time%3600)/60; s = (int)(time%3600)%60;
        seventime.setText((h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s));
        time = (long)CP.obtenirTempsRP(user, "8x8");
        h = (int)time/3600; m = (int)(time%3600)/60; s = (int)(time%3600)%60;
        eighttime.setText((h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s));
        time = (long)CP.obtenirTempsRP(user, "9x9");
        h = (int)time/3600; m = (int)(time%3600)/60; s = (int)(time%3600)%60;
        ninetime.setText((h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s));
    }
    
    private void buidaAll() {
        jResolts.setText("-");
        avgpistes.setText("-");
        threetime.setText("-");
        fourtime.setText("-");
        fivetime.setText("-");
        sixtime.setText("-");
        seventime.setText("-");
        eighttime.setText("-");
        ninetime.setText("-");
    }
    
    private void obtenirR () {
        String entr = entrades1.getItemAt(entrades1.getSelectedIndex());
        String dif = dificultat1.getItemAt(dificultat1.getSelectedIndex());
        DecimalFormat dec = new DecimalFormat("0.0000");
        String [] cols = {"Position","User","Time","KenKen ID"};
        DefaultTableModel table = new DefaultTableModel(null,cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        if (!entr.equals("-") && !dif.equals("-")) {
            for (int i = 1; i <= Integer.parseInt(entr); i++) {
                String user = CP.obtenirUserRT(dif, Integer.parseInt(entr), (i-1));
                long time = (long)CP.obtenirTimeRT(dif, Integer.parseInt(entr), (i-1));
                int h = (int)time/3600; int m = (int)(time%3600)/60; int s = (int)(time%3600)%60;
                String t = (h<10? ("0"+h):h) +":"+ (m<10? ("0"+m):m) +":"+ (s<10? ("0"+s):s);
                String id = CP.obtenirIdRT(dif, Integer.parseInt(entr), (i-1));
                if (user ==null) {
                    String [] row = {Integer.toString(i)+".-",user,null,id};
                    table.addRow(row);
                }
                else {
                    String [] rowwt = {Integer.toString(i)+".-",user,t,id};
                    table.addRow(rowwt);
                }
            }
        }
        tableRes.setModel(table);
        TableColumn columna = tableRes.getColumn("Position");
        columna.setPreferredWidth(10);
        columna = tableRes.getColumn("KenKen ID");
        columna.setPreferredWidth(10);
        tableRes.setRowHeight(27);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PersonalR;
    private javax.swing.JLabel avgpistes;
    private javax.swing.JLabel avgpistesLabel;
    private javax.swing.JComboBox<String> dificultat1;
    private javax.swing.JLabel eightLabel;
    private javax.swing.JLabel eighttime;
    private javax.swing.JComboBox<String> entrades1;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton findButton;
    private javax.swing.JLabel fiveLabel;
    private javax.swing.JLabel fivetime;
    private javax.swing.JLabel fourLabel;
    private javax.swing.JLabel fourtime;
    private javax.swing.JPanel generalR;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jResolts;
    private javax.swing.JLabel jResoltsLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jocsLabel;
    private javax.swing.JLabel nJocs;
    private javax.swing.JLabel nPartides;
    private javax.swing.JLabel nUsuaris;
    private javax.swing.JLabel nineLabel;
    private javax.swing.JLabel ninetime;
    private javax.swing.JLabel partidesLabel;
    private javax.swing.JLabel popular;
    private javax.swing.JLabel popularLabel;
    private javax.swing.JLabel select_diff1;
    private javax.swing.JLabel select_entries1;
    private javax.swing.JLabel sevenLabel;
    private javax.swing.JLabel seventime;
    private javax.swing.JLabel sixLabel;
    private javax.swing.JLabel sixtime;
    private javax.swing.JTabbedPane tabMenu2;
    private javax.swing.JTable tableRes;
    private javax.swing.JLabel threeLabel;
    private javax.swing.JLabel threetime;
    private javax.swing.JLabel timesLabel;
    private javax.swing.JLabel user_label;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usuarisLabel;
    // End of variables declaration//GEN-END:variables
}
