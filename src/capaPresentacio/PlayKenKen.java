/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Dificultat.Dificultat;
import capaDomini.Utils.CtrlPartida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.Timer;

/**
 *
 * @author Oriol Capo, Eduard Maura, Jordi Pont i Jan Teruel
 */
public class PlayKenKen extends javax.swing.JFrame {
    
    private static int h=0, m=0, s=0;
    private Timer t;
    private CtrlPresentacio CP;
    private CtrlPartida CPartida;
    private String user;
    private javax.swing.JFrame parent;
    ArrayList<ArrayList<Integer> > mat;
    static public ImageIcon imageResume;
    static public ImageIcon imagePause;
    private boolean notpaused;
    
    URL resume = PlayKenKen.class.getResource("./img/ResumeButton.png");
    URL pause = PlayKenKen.class.getResource("./img/PauseButton.png");
    int N, X, Y, BZ;
    String d;
    
    public PlayKenKen(String user, CtrlPresentacio CP, javax.swing.JFrame pare) {
        this.parent = pare;
        this.user = user;
        this.CP = CP;
        CPartida = CP.crearPartida(user);
        this.d = CPartida.getStringDificultat();
        this.N = CPartida.getIntDificultat();
        init();
    }
    
    public PlayKenKen(String d, String user, CtrlPresentacio CP, javax.swing.JFrame pare) {
        this.d = d;
        this.N = Dificultat.toInt(d);
        this.CP = CP;
        parent = pare;
        this.user = user;
        CPartida = CP.crearPartida(user,d);
        init();
    }
    
    public PlayKenKen(String d, String user, CtrlPresentacio CP, String id, javax.swing.JFrame pare) {
        this.d = d;
        this.N = Dificultat.toInt(d);
        this.CP = CP;
        parent = pare;
        this.user = user;
        CPartida = CP.crearPartida(user,d, id);
        init();
    }
    
    private void init() {
        t=new Timer(1000, new startChrono());
        initComponents();
        setVisible(true);
       
        InicialitzaTauler();
        InicialitzaBotons();
        X = -1;
        Y = -1;
        t.start();
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim = new Dimension(tool.getScreenSize());
        int height = (int) dim.getHeight();
        int width = (int) dim.getWidth();
        imageResume = new javax.swing.ImageIcon(resume);
        imagePause = new javax.swing.ImageIcon(pause);
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
            b.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
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
        ArrayList<Boolean> Regions = new ArrayList<Boolean>();
        for (int i=0; i<CPartida.getNRegio();++i) Regions.add(false);
        
        mat = new ArrayList<ArrayList<Integer> >();
        for (int i=0; i<N; i++) {
            mat.add(new ArrayList<Integer>());
            for (int j=0; j<N; ++j) {
                    mat.get(i).add(CPartida.nRegio(i,j));
            }
        }  
        int alt = Tauler.getHeight();
        int bSize = alt/N;
        BZ = bSize;
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
                b.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, N>6 ? 30-N : 30));
                if (CPartida.getValor(i,j) != -1) {
                    b.setText(String.valueOf(CPartida.getValor(i,j)));
                }
                else {
                    b.setText("");
                }
                //-------
                if (! Regions.get(CPartida.nRegio(i, j))) {
                    Regions.set(CPartida.nRegio(i,j),true);
                    String a = Integer.toString(CPartida.getRegioIJResult(i,j));
                    String a1 = CPartida.getRegioIJOperation(i, j);
                    if (a1.equals("*")) a1 = "x";
                    else if (a1.equals("/")) a1 = "÷";
                    a += " " + a1;
                    JLabel opres = new JLabel(a);
                    b.add(opres);
                    opres.setBounds(5, 0, bSize/2, bSize/2);
                    opres.setVisible(true);
                    int tamLletra = 20-N;
                    opres.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, tamLletra));
                }
                //-------
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
            u+=3;
            if (Me != mat.get(i+1).get(j)) d+=2;
            if (j>0 && j<n) {
                if (Me != mat.get(i).get(j+1)) r+=2;
                if (Me != mat.get(i).get(j-1)) l+=2;
            }
        }
        else if (i == n) {
            d+=3;
            if (Me != mat.get(i-1).get(j)) u+=2;
            if (j>0 && j<n) {
                if (Me != mat.get(i).get(j+1)) r+=2;
                if (Me != mat.get(i).get(j-1)) l+=2;
            }
        }
        if (j == 0) {
            l+=3;
            if (Me != mat.get(i).get(j+1)) r+=2;
            if (i>0 && i<n) {
                if (Me != mat.get(i+1).get(j)) d+=2;
                if (Me != mat.get(i-1).get(j)) u+=2;
            }
        }
        if (j == n) {
            r+=3;
            if (Me != mat.get(i).get(j-1)) l+=2;
            if (i>0 && i<n) {
                if (Me != mat.get(i+1).get(j)) d+=2;
                if (Me != mat.get(i-1).get(j)) u+=2;
            }
        }
        if (i!=0 && i!=n && j!=0 && j!=n) {
            if (Me != mat.get(i+1).get(j)) d+=2;
            if (Me != mat.get(i-1).get(j)) u+=2;
            if (Me != mat.get(i).get(j+1)) r+=2;
            if (Me != mat.get(i).get(j-1)) l+=2;
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
        UndoButton = new javax.swing.JButton();
        HintButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        PauseButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        BotoExit = new javax.swing.JButton();
        Botons = new javax.swing.JPanel();
        seconds = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        hours = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        punts1 = new javax.swing.JLabel();
        punts2 = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
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

        UndoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/UndoButton.png"))); // NOI18N
        UndoButton.setText("UNDO");
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UndoButton);
        UndoButton.setBounds(30, 40, 130, 60);

        HintButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/HintButton.png"))); // NOI18N
        HintButton.setText("HINT");
        getContentPane().add(HintButton);
        HintButton.setBounds(30, 120, 130, 60);

        ResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/ResetButton.png"))); // NOI18N
        ResetButton.setText("RESET");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ResetButton);
        ResetButton.setBounds(30, 200, 130, 60);

        PauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/PauseButton.png"))); // NOI18N
        PauseButton.setText("PAUSE");
        PauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PauseButton);
        PauseButton.setBounds(30, 280, 130, 60);

        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/SaveButtonn.png"))); // NOI18N
        SaveButton.setText("SAVE");
        getContentPane().add(SaveButton);
        SaveButton.setBounds(30, 360, 130, 60);

        BotoExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/ExitButton.png"))); // NOI18N
        BotoExit.setText("EXIT");
        BotoExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoExitActionPerformed(evt);
            }
        });
        getContentPane().add(BotoExit);
        BotoExit.setBounds(30, 446, 130, 100);

        Botons.setOpaque(false);

        seconds.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        seconds.setForeground(new java.awt.Color(255, 255, 255));
        seconds.setText("00");

        minutes.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        minutes.setForeground(new java.awt.Color(255, 255, 255));
        minutes.setText("00");

        hours.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        hours.setForeground(new java.awt.Color(255, 255, 255));
        hours.setText("00");

        TimeLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimeLabel.setText("Time:");

        punts1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        punts1.setForeground(new java.awt.Color(255, 255, 255));
        punts1.setText(":");

        punts2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        punts2.setForeground(new java.awt.Color(255, 255, 255));
        punts2.setText(":");

        javax.swing.GroupLayout BotonsLayout = new javax.swing.GroupLayout(Botons);
        Botons.setLayout(BotonsLayout);
        BotonsLayout.setHorizontalGroup(
            BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonsLayout.createSequentialGroup()
                .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hours)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(punts1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minutes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(punts2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seconds)
                .addGap(89, 89, 89))
        );
        BotonsLayout.setVerticalGroup(
            BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonsLayout.createSequentialGroup()
                .addGroup(BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimeLabel)
                    .addComponent(hours)
                    .addComponent(minutes)
                    .addComponent(seconds)
                    .addComponent(punts1)
                    .addComponent(punts2))
                .addGap(0, 478, Short.MAX_VALUE))
        );

        getContentPane().add(Botons);
        Botons.setBounds(710, 40, 160, 500);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/background-gran.jpeg"))); // NOI18N
        backgroundLabel.setMaximumSize(new java.awt.Dimension(1000, 800));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(1000, 800));
        backgroundLabel.setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1000, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BotoExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoExitActionPerformed
        // TODO add your handling code here:
        t.stop();
        hours.setText("00"); h=0;
        minutes.setText("00"); m=0;
        seconds.setText("00"); s=0;
        II=0;
        Object[] opciones = {"Save", "Exit"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,
                "Do you want to save the game?",
                "Confirmation Message",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,"Save");
        if (eleccion == JOptionPane.YES_OPTION) {
            SaveButton.doClick();
        }
        PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
        dispose();
    }//GEN-LAST:event_BotoExitActionPerformed

    int II = 0;
    
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        t.stop();
        hours.setText("00"); h=0;
        minutes.setText("00"); m=0;
        seconds.setText("00"); s=0;
        II=0;
        t.restart();
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void PauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseButtonActionPerformed
        // TODO add your handling code here:
        if(II==0){
            t.stop();
            II=1;
            PauseButton.setText("CONTINUE");
            PauseButton.setIcon(imageResume);
        }else{
            t.start();
            II=0;
            PauseButton.setText("PAUSE");
            PauseButton.setIcon(imagePause);
        }
    }//GEN-LAST:event_PauseButtonActionPerformed

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoButtonActionPerformed
        
    }//GEN-LAST:event_UndoButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        t.stop();
        hours.setText("00"); h=0;
        minutes.setText("00"); m=0;
        seconds.setText("00"); s=0;
        II=0;
        Object[] opciones = {"Save", "Exit"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,
                "Do you want to save the game?",
                "Confirmation Message",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,"Save");
        if (eleccion == JOptionPane.YES_OPTION) {
            SaveButton.doClick();
        }
        PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
        dispose();
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoExit;
    private javax.swing.JPanel Botons;
    private javax.swing.JButton HintButton;
    private javax.swing.JButton PauseButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPanel Tauler;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JButton UndoButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel hours;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minutes;
    private javax.swing.JLabel punts1;
    private javax.swing.JLabel punts2;
    private javax.swing.JLabel seconds;
    // End of variables declaration//GEN-END:variables
}
