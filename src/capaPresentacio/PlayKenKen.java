/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.Timer;

/**
 *
 * @author Oriolcapo
 */
public class PlayKenKen extends javax.swing.JFrame {
    
    private static int h=0, m=0, s=0;
    private Timer t;
    ArrayList<ArrayList<Integer> > mat;
    Scanner sn = new Scanner(System.in);
    int N, X, Y, BZ;
    
    public PlayKenKen(int N) {
        this.N = N;
        t=new Timer(1000, new startChrono());
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        InicialitzaTauler();
        InicialitzaBotons();
        Botons.setVisible(true);
        X = -1;
        Y = -1;
        t.start();
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim = new Dimension(tool.getScreenSize());
        int height = (int) dim.getHeight();
        int width = (int) dim.getWidth();
        setLocation(width/2 - getWidth()/2, height/2 - getHeight()/2);
    }
    
    private void InicialitzaBotons() {
        int ancho = Botons.getWidth()/2;
        //____
        int NN = N/2;
        if (N%2 != 0) ++NN;
        int midaB = NN*ancho;
        int k = (Botons.getHeight()-midaB)/2;
        //____
        int j = 0;
        for (int i=0; i<N; i++) {
            JButton b = new JButton();
            Botons.add(b);
            if (i%2 == 0) b.setBounds(0,k+(i-j)*ancho, ancho, ancho);
            else b.setBounds(ancho,k+((i-1)-j)*ancho, ancho, ancho);
            if (i%2 != 0) ++j;
            b.setVisible(true);
            b.setFont(new Font("Comic Sants", Font.PLAIN, 30));
            b.setText(Integer.toString(i+1));
            //___________________
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (X != -1) {
                        JLabel j = (JLabel) Tauler.getComponentAt(X,Y);
                        j.setText(b.getText());
                    }
                }
            });
            //__________________
        }
    }
    
    private void InicialitzaTauler() {
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
        BZ = bSize;
        count=1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                JLabel b = new JLabel();
                Tauler.add(b);
                b.setBounds(j*bSize, i*bSize, bSize, bSize);
                MatteBorder border = creaMarge(i,j);
                b.setBorder(border);
                b.setVisible(true);
                b.setHorizontalAlignment(SwingConstants.CENTER);
                b.setVerticalAlignment(SwingConstants.CENTER);
                b.setOpaque(true);                
                b.setBackground(Color.white);
                b.setFont(new Font("Comic Sants", Font.PLAIN, 30));
                b.setText("");
                //____________
                b.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (X != -1) {
                            JLabel j = (JLabel) Tauler.getComponentAt(X,Y);
                            j.setBackground(Color.white);canviaColorRegio(X,Y,false);
                        }
                        X = b.getX();
                        Y = b.getY();
                        canviaColorRegio(X,Y,true);
                        b.setBackground(Color.ORANGE);
                    }
                });
                //_____________
            }
            count+=2;
        }
    }
    
    private void canviaColorRegio(int Y, int X, Boolean b) {
        int val = mat.get(X/BZ).get(Y/BZ);
        for (int i=0; i<BZ*N; i+=BZ) {
            for (int j=0; j<BZ*N; j+=BZ) {
                if (mat.get(i/BZ).get(j/BZ) == val) {
                    JLabel label = (JLabel) Tauler.getComponentAt(j,i);
                    if (b) label.setBackground(Color.LIGHT_GRAY);
                    else label.setBackground(Color.white);
                }
            }
        }
    }
    
    public MatteBorder creaMarge (int i, int j) {
        int n = mat.size()-1;
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
    
    private class startChrono implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (s<59){
                s++;
                String sec= (s<10?"0":"")+s;
                seconds.setText(""+sec);
            }else{
                s=0;
                seconds.setText("00");
                if(m<59){
                    m++;
                    String min= (m<10?"0":"")+m;
                    minutes.setText(""+min);
                }else{
                    m=0;
                    minutes.setText("00");
                    h++;
                    String hr= (h<10?"0":"")+h;
                    hours.setText(""+hr);
                }
                
                    
            }
        }
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
        Tauler = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        PauseButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        BotoExit = new javax.swing.JButton();
        Botons = new javax.swing.JPanel();
        TimeLabel = new javax.swing.JLabel();
        hours = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        seconds = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 650));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setPreferredSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 650));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        javax.swing.GroupLayout TaulerLayout = new javax.swing.GroupLayout(Tauler);
        Tauler.setLayout(TaulerLayout);
        TaulerLayout.setHorizontalGroup(
            TaulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        TaulerLayout.setVerticalGroup(
            TaulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Tauler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tauler, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(180, 40, 509, 506);

        jButton1.setText("UNDO");
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 40, 110, 60);

        jButton2.setText("HINT");
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 120, 110, 60);

        ResetButton.setText("RESET");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ResetButton);
        ResetButton.setBounds(30, 200, 110, 60);

        PauseButton.setText("PAUSE");
        PauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PauseButton);
        PauseButton.setBounds(30, 280, 110, 60);

        jButton5.setText("SAVE");
        getContentPane().add(jButton5);
        jButton5.setBounds(30, 360, 110, 60);

        BotoExit.setText("EXIT");
        BotoExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoExitActionPerformed(evt);
            }
        });
        getContentPane().add(BotoExit);
        BotoExit.setBounds(30, 446, 110, 100);

        Botons.setOpaque(false);

        javax.swing.GroupLayout BotonsLayout = new javax.swing.GroupLayout(Botons);
        Botons.setLayout(BotonsLayout);
        BotonsLayout.setHorizontalGroup(
            BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        BotonsLayout.setVerticalGroup(
            BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(Botons);
        Botons.setBounds(710, 40, 160, 500);

        TimeLabel.setText("Time:");
        getContentPane().add(TimeLabel);
        TimeLabel.setBounds(586, 10, 40, 14);

        hours.setText("00");
        getContentPane().add(hours);
        hours.setBounds(630, 10, 20, 14);

        minutes.setText("00");
        getContentPane().add(minutes);
        minutes.setBounds(650, 10, 20, 14);

        seconds.setText("00");
        getContentPane().add(seconds);
        seconds.setBounds(670, 10, 20, 14);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/background-gran.jpeg"))); // NOI18N
        backgroundLabel.setMaximumSize(new java.awt.Dimension(1000, 800));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(1000, 800));
        backgroundLabel.setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1000, 730);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BotoExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoExitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_BotoExitActionPerformed

    int II = 0;
    
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        t.stop();
        hours.setText("00"); h=0;
        minutes.setText("00"); m=0;
        seconds.setText("00"); s=0;
        II=0;
        PauseButton.setText("START");
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void PauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseButtonActionPerformed
        // TODO add your handling code here:
        if(II==0){
            if (PauseButton.getText().equals("START")) {
                t.start();
                II=0;
                PauseButton.setText("PAUSE");
            }
            else {
                t.stop();
                II=1;
                PauseButton.setText("CONTINUE");
            }
        }else{
            t.start();
            II=0;
            PauseButton.setText("PAUSE");
        }
    }//GEN-LAST:event_PauseButtonActionPerformed
    
/*    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayKenKen(9).setVisible(true);
            }
        });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoExit;
    private javax.swing.JPanel Botons;
    private javax.swing.JButton PauseButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JPanel Tauler;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel hours;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minutes;
    private javax.swing.JLabel seconds;
    // End of variables declaration//GEN-END:variables
}
