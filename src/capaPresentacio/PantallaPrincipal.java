package capaPresentacio;

import capaDomini.Utils.CtrlJoc;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Oriolcapo
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private final CtrlJoc CJ;
    private final String user;
    private final javax.swing.JFrame parent;
    private final CtrlPresentacio CP;
    
    /**
     * Creates new form Pantalla Principal
     * 
     * @param user Usuari logejat
     * @param CP Controlador de Presentació
     * @param pare Formulari pare
     */
    public PantallaPrincipal(String user, CtrlPresentacio CP, javax.swing.JFrame pare) {
        System.out.println("Mostrant pantalla principal");
        initComponents();
        parent = pare;
        this.user = user;
        this.CP = CP;
        CJ = new CtrlJoc();
        setVisible(true);
        
        // Centrem la finestra al monitor
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim = new Dimension(tool.getScreenSize());
        int height = (int) dim.getHeight();
        int width = (int) dim.getWidth();
        setLocation(width/2 - getWidth()/2, height/2 - getHeight()/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        welcomeToKenken1 = new capaPresentacio.WelcomeToKenken();
        jButton_GestorUsuari = new javax.swing.JButton();
        jButton_CrearKenken = new javax.swing.JButton();
        jButton_JugarKenKen = new javax.swing.JButton();
        jButton_ConsultarRanking = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        userGuideItem = new javax.swing.JMenuItem();
        exitItemMenu = new javax.swing.JMenuItem();
        options = new javax.swing.JMenu();
        userMngrItem = new javax.swing.JMenuItem();
        submenuCreateKenKen = new javax.swing.JMenu();
        manItem = new javax.swing.JMenuItem();
        parItem = new javax.swing.JMenuItem();
        submenuPlayKenKen = new javax.swing.JMenu();
        resumeItem = new javax.swing.JMenuItem();
        selectItem = new javax.swing.JMenuItem();
        randomItem = new javax.swing.JMenuItem();
        submenuRanking = new javax.swing.JMenu();
        generalItem = new javax.swing.JMenuItem();
        personalItem = new javax.swing.JMenuItem();
        typeRanking = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("KenKen");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        menuPanel.setMaximumSize(new java.awt.Dimension(598, 496));
        menuPanel.setMinimumSize(new java.awt.Dimension(598, 496));
        menuPanel.setPreferredSize(new java.awt.Dimension(598, 496));
        menuPanel.setLayout(new java.awt.CardLayout());

        welcomeToKenken1.setMaximumSize(new java.awt.Dimension(603, 501));
        welcomeToKenken1.setMinimumSize(new java.awt.Dimension(603, 501));
        menuPanel.add(welcomeToKenken1, "card2");

        getContentPane().add(menuPanel);
        menuPanel.setBounds(190, 34, 600, 496);

        jButton_GestorUsuari.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_GestorUsuari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/UserManagerButton.png"))); // NOI18N
        jButton_GestorUsuari.setText("<html>User <br> \nSettings\n</html>");
        jButton_GestorUsuari.setToolTipText("");
        jButton_GestorUsuari.setMaximumSize(new java.awt.Dimension(164, 110));
        jButton_GestorUsuari.setMinimumSize(new java.awt.Dimension(164, 110));
        jButton_GestorUsuari.setPreferredSize(new java.awt.Dimension(164, 110));
        jButton_GestorUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GestorUsuariActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GestorUsuari);
        jButton_GestorUsuari.setBounds(14, 34, 166, 110);

        jButton_CrearKenken.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_CrearKenken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/CreateButton1.png"))); // NOI18N
        jButton_CrearKenken.setText("<html>Create<br>\n KenKen\n</html>");
        jButton_CrearKenken.setMaximumSize(new java.awt.Dimension(164, 110));
        jButton_CrearKenken.setMinimumSize(new java.awt.Dimension(164, 110));
        jButton_CrearKenken.setPreferredSize(new java.awt.Dimension(164, 110));
        jButton_CrearKenken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearKenkenActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_CrearKenken);
        jButton_CrearKenken.setBounds(14, 162, 166, 108);

        jButton_JugarKenKen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_JugarKenKen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/playButton1.png"))); // NOI18N
        jButton_JugarKenKen.setText("<html>Play<br>\nKenKen\n</html>");
        jButton_JugarKenKen.setMaximumSize(new java.awt.Dimension(164, 110));
        jButton_JugarKenKen.setMinimumSize(new java.awt.Dimension(164, 110));
        jButton_JugarKenKen.setPreferredSize(new java.awt.Dimension(164, 110));
        jButton_JugarKenKen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_JugarKenKenActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_JugarKenKen);
        jButton_JugarKenKen.setBounds(14, 294, 166, 109);

        jButton_ConsultarRanking.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_ConsultarRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/RankingButton1.png"))); // NOI18N
        jButton_ConsultarRanking.setText("Ranking");
        jButton_ConsultarRanking.setMaximumSize(new java.awt.Dimension(164, 110));
        jButton_ConsultarRanking.setMinimumSize(new java.awt.Dimension(164, 110));
        jButton_ConsultarRanking.setPreferredSize(new java.awt.Dimension(164, 110));
        jButton_ConsultarRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConsultarRankingActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ConsultarRanking);
        jButton_ConsultarRanking.setBounds(14, 421, 166, 109);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/background.jpeg"))); // NOI18N
        backgroundLabel.setPreferredSize(new java.awt.Dimension(800, 580));
        backgroundLabel.setRequestFocusEnabled(false);
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 800, 575);

        file.setText("File");

        userGuideItem.setText("User Guide");
        userGuideItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userGuideItemActionPerformed(evt);
            }
        });
        file.add(userGuideItem);

        exitItemMenu.setText("Exit");
        exitItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemMenuActionPerformed(evt);
            }
        });
        file.add(exitItemMenu);

        Menu.add(file);

        options.setText("Options");

        userMngrItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/UserManagerIcon.png"))); // NOI18N
        userMngrItem.setText("User Manager");
        userMngrItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userMngrItem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        userMngrItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMngrItemActionPerformed(evt);
            }
        });
        options.add(userMngrItem);

        submenuCreateKenKen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/CreateIcon.png"))); // NOI18N
        submenuCreateKenKen.setText("Create KenKen");
        submenuCreateKenKen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        submenuCreateKenKen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        manItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/ManuallyIcon.png"))); // NOI18N
        manItem.setText("Manually");
        manItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manItemActionPerformed(evt);
            }
        });
        submenuCreateKenKen.add(manItem);

        parItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/ParametersIcon.png"))); // NOI18N
        parItem.setText("By Parameters");
        parItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parItemActionPerformed(evt);
            }
        });
        submenuCreateKenKen.add(parItem);

        options.add(submenuCreateKenKen);

        submenuPlayKenKen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/playIcon.png"))); // NOI18N
        submenuPlayKenKen.setText("Play KenKen");
        submenuPlayKenKen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        submenuPlayKenKen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        resumeItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/ResumeIcon.png"))); // NOI18N
        resumeItem.setText("Resume saved game...");
        resumeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeItemActionPerformed(evt);
            }
        });
        submenuPlayKenKen.add(resumeItem);

        selectItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/DBIcon.png"))); // NOI18N
        selectItem.setText("Select a KenKen");
        selectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectItemActionPerformed(evt);
            }
        });
        submenuPlayKenKen.add(selectItem);

        randomItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/RandomIcon.png"))); // NOI18N
        randomItem.setText("Random KenKen");
        randomItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomItemActionPerformed(evt);
            }
        });
        submenuPlayKenKen.add(randomItem);

        options.add(submenuPlayKenKen);

        submenuRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/RankingIcon.png"))); // NOI18N
        submenuRanking.setText("Ranking");
        submenuRanking.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        submenuRanking.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        generalItem.setText("General Ranking");
        generalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalItemActionPerformed(evt);
            }
        });
        submenuRanking.add(generalItem);

        personalItem.setText("Personal Ranking");
        personalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalItemActionPerformed(evt);
            }
        });
        submenuRanking.add(personalItem);

        typeRanking.setText("By Type Ranking");
        typeRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeRankingActionPerformed(evt);
            }
        });
        submenuRanking.add(typeRanking);

        options.add(submenuRanking);

        Menu.add(options);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GestorUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GestorUsuariActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new GestioUsuari(user,CP));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_jButton_GestorUsuariActionPerformed

    private void jButton_CrearKenkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearKenkenActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new CrearKenken(user,this, 0, CP, CJ));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_jButton_CrearKenkenActionPerformed

    private void jButton_JugarKenKenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_JugarKenKenActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new JugarKenken(user,CP,CJ,this));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_jButton_JugarKenKenActionPerformed

    private void jButton_ConsultarRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConsultarRankingActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new Rankings(CP));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_jButton_ConsultarRankingActionPerformed

    private void exitItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemMenuActionPerformed
        Object[] opciones = {"Accept", "Cancel"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,
                "Do you want to logout?",
                "Confirmation Message",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,opciones[0]);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.out.println("Tancant pantalla principal");
            PantallaInici P = new PantallaInici(CP);
            dispose();
        }
    }//GEN-LAST:event_exitItemMenuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Object[] opciones = {"Accept", "Cancel"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,
                "Do you want to logout?",
                "Confirmation Message",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,opciones[0]);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.out.println("Tancant pantalla principal");
            PantallaInici P = new PantallaInici(CP);
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void manItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manItemActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new CrearKenken(user,this,0,CP,CJ));
        menuPanel.repaint();
        menuPanel.revalidate();        
    }//GEN-LAST:event_manItemActionPerformed

    private void resumeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeItemActionPerformed
        if (CJ.existeixPartidaGuardada(user)) {
            PlayKenKen pk = new PlayKenKen(user,CP,CJ,parent);
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "You haven't saved any game", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_resumeItemActionPerformed

    private void userMngrItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMngrItemActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new GestioUsuari(user,CP));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_userMngrItemActionPerformed

    private void generalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalItemActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new Rankings(CP,0,this));
        menuPanel.repaint();
        menuPanel.revalidate(); 
    }//GEN-LAST:event_generalItemActionPerformed

    private void parItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parItemActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new CrearKenken(user,this,1,CP,CJ));
        menuPanel.repaint();
        menuPanel.revalidate(); 
    }//GEN-LAST:event_parItemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void selectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectItemActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new KenkenBBDD(user,this,CP,CJ));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_selectItemActionPerformed

    private void randomItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomItemActionPerformed
        SelectSize pk = new SelectSize(user,CP,CJ,this);
        pk.setVisible(true);
    }//GEN-LAST:event_randomItemActionPerformed

    private void personalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalItemActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new Rankings(CP,1,this));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_personalItemActionPerformed

    private void typeRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeRankingActionPerformed
        menuPanel.removeAll();
        menuPanel.repaint();
        menuPanel.revalidate();
        menuPanel.add(new Rankings(CP,2,this));
        menuPanel.repaint();
        menuPanel.revalidate();
    }//GEN-LAST:event_typeRankingActionPerformed

    private void userGuideItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userGuideItemActionPerformed
        Desktop d = Desktop.getDesktop();
        try {
            d.open(new File("ManualdeJoc.pdf"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                      "No user guide found\n"
                    + "Please contact with the developers", 
                      "Error", 
                      JOptionPane.ERROR_MESSAGE);  
            
        }    }//GEN-LAST:event_userGuideItemActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JMenuItem exitItemMenu;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem generalItem;
    private javax.swing.JButton jButton_ConsultarRanking;
    private javax.swing.JButton jButton_CrearKenken;
    private javax.swing.JButton jButton_GestorUsuari;
    private javax.swing.JButton jButton_JugarKenKen;
    private javax.swing.JMenuItem manItem;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JMenu options;
    private javax.swing.JMenuItem parItem;
    private javax.swing.JMenuItem personalItem;
    private javax.swing.JMenuItem randomItem;
    private javax.swing.JMenuItem resumeItem;
    private javax.swing.JMenuItem selectItem;
    private javax.swing.JMenu submenuCreateKenKen;
    private javax.swing.JMenu submenuPlayKenKen;
    private javax.swing.JMenu submenuRanking;
    private javax.swing.JMenuItem typeRanking;
    private javax.swing.JMenuItem userGuideItem;
    private javax.swing.JMenuItem userMngrItem;
    private capaPresentacio.WelcomeToKenken welcomeToKenken1;
    // End of variables declaration//GEN-END:variables
}
