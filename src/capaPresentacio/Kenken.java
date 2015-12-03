/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

/**
 *
 * @author Oriolcapo
 */
public class Kenken extends javax.swing.JFrame {

    /**
     * Creates new form Kenken
     */
    
    ArrayList<ArrayList<Integer> > mat;
    Scanner sn = new Scanner(System.in);
    int N, X, Y;
    
    public Kenken() {
        initComponents();
        X = -1;
        Y = -1;
        InicialitzaTauler();
        InicialitzaBotons();
        Botons.setVisible(false);
        setVisible(true);
    }
    
    private void InicialitzaBotons() {
        int ancho = Botons.getWidth();
        int alto = Botons.getHeight()/N;
        for (int i=0; i<N; ++i) {
            JButton b = new JButton();
            Botons.add(b);
            b.setBounds(0, i*alto, ancho, alto);
            b.setVisible(true);
            b.setFont(new Font("Comic Sants", Font.PLAIN, 30));
            b.setText(Integer.toString(i+1));
            //___________________
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (X != -1) {
                        Component j = Tauler.getComponentAt(X,Y);
                        j.setForeground(Color.black);
                    }
                }
            });
            //__________________
        }
    }
    
    private void InicialitzaTauler() {
        N = sn.nextInt();
        int count = 0;
        mat = new ArrayList<ArrayList<Integer> >();
        for (int i=0; i<N; i++) {
            mat.add(new ArrayList<Integer>());
            for (int j=0; j<N; ++j) {
                if (j < 2) {
                    mat.get(i).add(count);
                }
                else {
                    mat.get(i).add(count+1);
                }
            }
            count+=2;
        }   
        
        int alt = Tauler.getHeight();
        int bSize = alt/N;
        count=1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                //JButton b = new JButton();
                JLabel b = new JLabel();
                Tauler.add(b);
                b.setBounds(j*bSize, i*bSize, bSize, bSize);
                MatteBorder border = creaMarge(i,j);
                b.setBorder(border);
                b.setVisible(true);
                b.setHorizontalAlignment(SwingConstants.CENTER);
                b.setVerticalAlignment(SwingConstants.CENTER);
                b.setFont(new Font("Comic Sants", Font.PLAIN, 30));
                b.setText("");
                //____________
                b.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int a;
                        if (b.getText().equals("")) a = 0;
                        else a = Integer.parseInt(b.getText());
                        if (a < N) b.setText(Integer.toString(a+1));
                        else b.setText("1");
                        X = b.getX();
                        Y = b.getY();
                        //b.setText("");
                    }
                });
                //_____________
            }
            count+=2;
        }        
    }
    
    public MatteBorder creaMarge (int i, int j) {
        int n = mat.size()-1;
        int Up, Down, Left, Right;
        int Me = mat.get(i).get(j);        
        int u=1,d=1,l=1,r=1;

        if (i == 0) {
            u+=2;
            if (Me != mat.get(i+1).get(j)) d+=1;
            if (j>0 && j<n) {
                if (Me != mat.get(i).get(j+1)) r+=1;
                if (Me != mat.get(i).get(j-1)) l+=1;
            }
        }
        else if (i == n) {
            d+=2;
            if (Me != mat.get(i-1).get(j)) u+=1;
            if (j>0 && j<n) {
                if (Me != mat.get(i).get(j+1)) r+=1;
                if (Me != mat.get(i).get(j-1)) l+=1;
            }
        }
        if (j == 0) {
            l+=2;
            if (Me != mat.get(i).get(j+1)) r+=1;
            if (i>0 && i<n) {
                if (Me != mat.get(i+1).get(j)) d+=1;
                if (Me != mat.get(i-1).get(j)) u+=1;
            }
        }
        if (j == n) {
            r+=2;
            if (Me != mat.get(i).get(j-1)) l+=1;
            if (i>0 && i<n) {
                if (Me != mat.get(i+1).get(j)) d+=1;
                if (Me != mat.get(i-1).get(j)) u+=1;
            }
        }
        if (i!=0 && i!=n && j!=0 && j!=n) {
            if (Me != mat.get(i+1).get(j)) d+=1;
            if (Me != mat.get(i-1).get(j)) u+=1;
            if (Me != mat.get(i).get(j+1)) r+=1;
            if (Me != mat.get(i).get(j-1)) l+=1;
        }
        return BorderFactory.createMatteBorder(u,l,d,r,Color.black);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        Tauler = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        Botons = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 650));
        getContentPane().setLayout(new java.awt.CardLayout());

        Panel.setMaximumSize(new java.awt.Dimension(800, 600));
        Panel.setMinimumSize(new java.awt.Dimension(800, 600));
        Panel.setPreferredSize(new java.awt.Dimension(800, 600));

        Tauler.setMaximumSize(new java.awt.Dimension(650, 600));
        Tauler.setMinimumSize(new java.awt.Dimension(650, 600));
        Tauler.setName(""); // NOI18N
        Tauler.setPreferredSize(new java.awt.Dimension(650, 600));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setText("label1");
        label1.setVisible(false);

        javax.swing.GroupLayout TaulerLayout = new javax.swing.GroupLayout(Tauler);
        Tauler.setLayout(TaulerLayout);
        TaulerLayout.setHorizontalGroup(
            TaulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaulerLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );
        TaulerLayout.setVerticalGroup(
            TaulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaulerLayout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        Botons.setMaximumSize(new java.awt.Dimension(150, 500));
        Botons.setMinimumSize(new java.awt.Dimension(150, 500));
        Botons.setPreferredSize(new java.awt.Dimension(150, 500));

        javax.swing.GroupLayout BotonsLayout = new javax.swing.GroupLayout(Botons);
        Botons.setLayout(BotonsLayout);
        BotonsLayout.setHorizontalGroup(
            BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BotonsLayout.setVerticalGroup(
            BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(Tauler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Botons, javax.swing.GroupLayout.PREFERRED_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tauler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Botons, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Panel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kenken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kenken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kenken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kenken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kenken().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Botons;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Tauler;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
