/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Dificultat.Dificultat;
import capaDomini.Utils.CtrlJoc;
import capaDomini.Utils.CtrlPartida;
import java.awt.Color;
import java.awt.Component;
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
    
    private int h,m,s;
    private Timer t;
    private final CtrlPresentacio CP;
    private CtrlPartida CPartida;
    private final CtrlJoc CJ;
    private final String user;
    private final javax.swing.JFrame parent;
    ArrayList<ArrayList<Integer> > mat;
    private int cont;
    private Color c = new Color(0,200,0);
    boolean finished = false;
    private static ImageIcon imageResume;
    private static ImageIcon imagePause;
    private boolean solved = false;
  
    
    URL resume = PlayKenKen.class.getResource("./img/ResumeButton.png");
    URL pause = PlayKenKen.class.getResource("./img/PauseButton.png");
    
    int N, X, Y, BZ;
    String d;
    
    /**
     * Crea la vista per jugar a una partida guardada
     * 
     * @param user Usuari
     * @param CP Controlador de Presentació
     * @param CJ Controlador de Joc
     * @param pare Vista pare
     */
    public PlayKenKen(String user, CtrlPresentacio CP, CtrlJoc CJ, javax.swing.JFrame pare) {
        this.parent = pare;
        this.user = user;
        this.CP = CP;
        this.CJ = CJ;
        CPartida = CP.crearPartida(user);
        this.d = CPartida.getStringDificultat();
        this.N = CPartida.getIntDificultat();
        this.cont = CPartida.getNPistes();
        long time = CPartida.getTime();
        h = (int)time/3600;
        time = time%3600;
        m = (int)time/60;
        time = time%60;
        s = (int)time;
        init();
    }
    
    /** 
     * Crea la vista per jugar una KenKen aleatori
     * @param d
     * @param user
     * @param CP
     * @param CJ
     * @param pare 
     */
    public PlayKenKen(String d, String user, CtrlPresentacio CP,CtrlJoc CJ, javax.swing.JFrame pare) {
        this.d = d;
        this.N = Dificultat.toInt(d);
        this.CP = CP;
        this.CJ = CJ;
        parent = pare;
        this.user = user;
        this.cont = 0;
        CPartida = CP.crearPartida(user,d);
        h = m = s = 0;
        init();
    }
    
    /**
     * Crea la vista per jugar a un KenKen emmagatzemat a la BD
     * @param d Dificultat del KenKen
     * @param user Usuari registrat
     * @param CP Controlador Partida
     * @param id Identificador del Joc
     * @param CJ Controlador del Joc
     * @param pare Vista pare
     */
    public PlayKenKen(String d, String user, CtrlPresentacio CP, String id, CtrlJoc CJ,javax.swing.JFrame pare) {
        this.d = d;
        this.N = Dificultat.toInt(d);
        this.CP = CP;
        this.CJ = CJ;
        parent = pare;
        this.user = user;
        this.cont = 0;
        CPartida = CP.crearPartida(user,d, id);
        h = m = s = 0;
        init();
    }
    
    Runnable rp = new Runnable() {
        @Override
        public void run() {
            CPartida.clonarTauler();
            CPartida.resoldrePerPista();
            HintButton.setEnabled(true);
        }
    };
    Thread th;
    
    private void init() {
        initComponents();
        hours.setText(h<10? "0"+String.valueOf(h):String.valueOf(h));
        minutes.setText(m<10? "0"+String.valueOf(m):String.valueOf(m));
        seconds.setText(s<10? "0"+String.valueOf(s):String.valueOf(s));
        t=new Timer(1000, new startChrono());
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
        HintButton.setEnabled(false);
        if (CPartida.resolem()) {
            th = new Thread(rp);
            th.start();
        }
        else HintButton.setEnabled(true);
        solveButton.setEnabled(true);
    }
    
    private void InicialitzaBotons() {
        int ancho = 65;
        //____
        int NN = N/2;
        if (N%2 != 0) ++NN;
        int midaB = NN*ancho;
        int k = (Botons.getHeight()-midaB)/2;
        //____
        int j = 0;
        for (int i=0; i<N+1; i++) {
            JButton b = new JButton();
            Botons.add(b);
            if (i%2 == 0) b.setBounds(0,k+(i-j)*ancho, ancho, ancho);
            else b.setBounds(ancho,k+((i-1)-j)*ancho, ancho, ancho);
            if (i%2 != 0) ++j;
            b.setVisible(true);
            b.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            if (i==N) {
                b.setText("Supr");
                b.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
            }
            else {
                b.setText(Integer.toString(i+1));
            }
            //___________________
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (X != -1) {
                        JLabel j = (JLabel) Tauler.getComponentAt(X,Y);
                        if (!j.getBackground().equals(c)) {
                            if (b.getText().equals("Supr")) {
                                CPartida.borrar(Y/BZ,X/BZ);
                                j.setText("");
                            }
                            else {
                                finished = CPartida.setValor(Y/BZ,X/BZ,Integer.parseInt(b.getText()));
                                j.setText(b.getText());
                            }
                            if (finished) {
                                t.stop();
                                if (CPartida.correct()){
                                    long time = h*3600+m*60+s;
                                    CPartida.setcurrentTime(time);
                                    CPartida.saveToRank();
                                    Object[] opciones = {"Play again", "Play another KenKen", "Exit"};
                                    int eleccion = JOptionPane.showOptionDialog(rootPane,
                                            "You have solved this KenKen successfully\n"
                                          + "Your time: "+(h<10?"0"+h:h)+":"+(m<10?"0"+m:m)+":"+(s<10? "0"+s:s)+"\n"
                                          + "What do you want to do next?",
                                        "Congratulations!",
                                        JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
                                        null,opciones,opciones[2]);
                                    if (eleccion == JOptionPane.YES_OPTION) 
                                        ResetButton.doClick();
                                    else {
                                        PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
                                        dispose();
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(parent,
                                            "We are sorry\n"
                                          + "It seems your solution is not correct\n"
                                          + "Keep trying!", 
                                        "Wrong", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                    t.start();
                                }
                            }
                        }
                    }
                }
            });
            //__________________
        }
    }
    
    private void InicialitzaTauler() {
        ArrayList<Boolean> Regions = new ArrayList<>();
        for (int i=0; i<CPartida.getNRegio();++i) Regions.add(false);
        
        mat = new ArrayList< >();
        for (int i=0; i<N; i++) {
            mat.add(new ArrayList<>());
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
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (X != -1) {
                            JLabel j = (JLabel) Tauler.getComponentAt(X,Y);
                            if (!j.getBackground().equals(c)) {
                                j.setBackground(Color.white);
                            }
                            canviaColorRegio(X,Y,false);
                        }
                        X = b.getX();
                        Y = b.getY();
                        if (!b.getBackground().equals(c)) {
                            canviaColorRegio(X,Y,true);
                            b.setBackground(Color.ORANGE);
                        }
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
                    if (b) {
                        if (!(label.getBackground().equals(c))) label.setBackground(Color.LIGHT_GRAY);
                    }
                    else {
                        if (!(label.getBackground().equals(c))) {
                            label.setBackground(Color.white);
                        }
                    }
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
        solveButton = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PLAY");
        setMinimumSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel1.setMaximumSize(new java.awt.Dimension(509, 506));

        Tauler.setMaximumSize(new java.awt.Dimension(505, 502));
        Tauler.setMinimumSize(new java.awt.Dimension(505, 502));

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

        UndoButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        UndoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/UndoButton.png"))); // NOI18N
        UndoButton.setText("UNDO");
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UndoButton);
        UndoButton.setBounds(30, 40, 130, 60);

        HintButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        HintButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/HintButton.png"))); // NOI18N
        HintButton.setText("HINT");
        HintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HintButtonActionPerformed(evt);
            }
        });
        getContentPane().add(HintButton);
        HintButton.setBounds(30, 120, 130, 60);

        ResetButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/ResetButton.png"))); // NOI18N
        ResetButton.setText("RESET");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ResetButton);
        ResetButton.setBounds(30, 200, 130, 60);

        PauseButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        PauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/PauseButton.png"))); // NOI18N
        PauseButton.setText("PAUSE");
        PauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PauseButton);
        PauseButton.setBounds(30, 280, 130, 60);

        SaveButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/SaveButtonn.png"))); // NOI18N
        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton);
        SaveButton.setBounds(30, 360, 130, 60);

        BotoExit.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
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

        solveButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        solveButton.setText("Solve");
        solveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BotonsLayout = new javax.swing.GroupLayout(Botons);
        Botons.setLayout(BotonsLayout);
        BotonsLayout.setHorizontalGroup(
            BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonsLayout.createSequentialGroup()
                .addGroup(BotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonsLayout.createSequentialGroup()
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
                        .addComponent(seconds))
                    .addComponent(solveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                .addComponent(solveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(Botons);
        Botons.setBounds(710, 40, 160, 510);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaPresentacio/img/background-gran.jpeg"))); // NOI18N
        backgroundLabel.setMaximumSize(new java.awt.Dimension(1000, 800));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(1000, 800));
        backgroundLabel.setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1000, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents
               
    private void BotoExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoExitActionPerformed
        if (!solved) {
            t.stop(); 
            II=0;
            Object[] opciones = {"Save", "Exit", "Cancel"};
            int eleccion = JOptionPane.showOptionDialog(rootPane,
                    "Do you want to save the game?",
                    "Confirmation Message",
                    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,opciones,"Save");
            if (eleccion == JOptionPane.YES_OPTION) {
                SaveButton.doClick();
                PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
                dispose();
            }
            else if (eleccion == JOptionPane.NO_OPTION) {
                PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
                dispose();
            }
            t.start();
        }
        else {
            PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
            dispose();
        }
    }//GEN-LAST:event_BotoExitActionPerformed

    int II = 0;
    
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        t.stop();
        hours.setText("00"); h=0;
        minutes.setText("00"); m=0;
        seconds.setText("00"); s=0;
        II=0;
        HintButton.setEnabled(true);
        CPartida.reset();
        for (int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                JLabel x = (JLabel) Tauler.getComponentAt(i*BZ,j*BZ);
                x.setText(""); 
                x.setBackground(Color.white);
            }
        }
        cont = 0;
        t.restart();
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void PauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseButtonActionPerformed
        // TODO add your handling code here:
        if(II==0){
            t.stop();
            II=1;
            PauseButton.setText("CONTINUE");
            PauseButton.setIcon(imageResume);
            for (Component c : Botons.getComponents()) {
                   c.setEnabled(false);
               }
            UndoButton.setEnabled(false);
            HintButton.setEnabled(false);
            ResetButton.setEnabled(false);
        }else{
            t.start();
            II=0;
            PauseButton.setText("PAUSE");
            PauseButton.setIcon(imagePause);
            for (Component c : Botons.getComponents()) {
                    c.setEnabled(true);
                }
            UndoButton.setEnabled(true);
            HintButton.setEnabled(true);
            ResetButton.setEnabled(true);
        }
    }//GEN-LAST:event_PauseButtonActionPerformed

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoButtonActionPerformed
        int i = CPartida.undoX();
        int j = CPartida.undoY();
        if (i == -1 || j == -1) {
            JOptionPane.showMessageDialog(this,
                    "You can not undo more", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            int val = CPartida.undoN(); // fa el "pop" a CtrlPartida
            JLabel d = (JLabel) Tauler.getComponentAt(j*BZ, i*BZ);
            if (d.getBackground().equals(c)) {
                UndoButtonActionPerformed(evt);
            }
            else {
                JLabel b = (JLabel) Tauler.getComponentAt(j*BZ, i*BZ);
                if (val == -1) b.setText("");
                else b.setText(String.valueOf(val));
            }
        }
    }//GEN-LAST:event_UndoButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!solved) {
            t.stop(); 
            II=0;
            Object[] opciones = {"Save", "Exit", "Cancel"};
            int eleccion = JOptionPane.showOptionDialog(rootPane,
                    "Do you want to save the game?",
                    "Confirmation Message",
                    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,opciones,"Save");
            if (eleccion == JOptionPane.YES_OPTION) {
                SaveButton.doClick();
                PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
                dispose();
            }
            else if (eleccion == JOptionPane.NO_OPTION) {
                PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
                dispose();
            }
            t.start();
        }
        else {
            PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing
    
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if (CJ.existeixPartidaGuardada(user)) {
            Object[] opciones = {"Yes", "No"};
            int eleccion = JOptionPane.showOptionDialog(rootPane,
                "You already have a game saved\n"
                        +"Do you want to overwrite it?",
                "Confirmation Message",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,"Yes");
            if (eleccion == JOptionPane.YES_OPTION) {
                long time = h*3600+m*60+s;
                CPartida.setcurrentTime(time);
                CPartida.saveState();
                JOptionPane.showMessageDialog(parent,
                        "Your game has been saved successfully" , 
                        "Confirmation Message", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            long time = h*3600+m*60+s;
            CPartida.setcurrentTime(time);
            CPartida.saveState();
            JOptionPane.showMessageDialog(parent,
                        "Your game has been saved successfully" , 
                        "Confirmation Message", 
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void HintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HintButtonActionPerformed
        if (cont < N-2) {
            finished = CPartida.getPista();
            int x = CPartida.getPistaX();
            int y = CPartida.getPistaY();
            int val = CPartida.getPistaN();
            JLabel b = (JLabel) Tauler.getComponentAt(y*BZ, x*BZ);
            b.setText(String.valueOf(val));
            b.setBackground(new Color(0,200,0));
            ++cont;
            if (cont == N-2) HintButton.setEnabled(false);
            if (finished) {
                t.stop();
                if (CPartida.correct()){
                    long time = h*3600+m*60+s;
                    CPartida.setcurrentTime(time);
                    CPartida.saveToRank();
                    Object[] opciones = {"Play again", "Play another KenKen", "Exit"};
                    int eleccion = JOptionPane.showOptionDialog(rootPane,
                            "You have solved this KenKen successfully\n"
                          + "Your time: "+(h<10?"0"+h:h)+":"+(m<10?"0"+m:m)+":"+(s<10? "0"+s:s)+"\n"
                          + "What do you want to do next?",
                        "Congratulations!",
                        JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
                        null,opciones,opciones[2]);
                    if (eleccion == JOptionPane.YES_OPTION) 
                        ResetButton.doClick();
                    else {
                        PantallaPrincipal P = new PantallaPrincipal(user,CP,parent);
                        dispose();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(parent,
                            "We are sorry\n"
                          + "It seems your solution is not correct\n"
                          + "Keep trying!", 
                        "Wrong", 
                        JOptionPane.ERROR_MESSAGE);
                    t.start();
                }
            }
        }
    }//GEN-LAST:event_HintButtonActionPerformed

    private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveButtonActionPerformed
        t.stop();
        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                int val = CPartida.getValorSolved(i,j);
                JLabel l = (JLabel)Tauler.getComponentAt(j*BZ,i*BZ);
                l.setText(String.valueOf(val));
            }
        }
        for (Component c : Botons.getComponents()) {
            c.setEnabled(false);
        }
        UndoButton.setEnabled(false);
        HintButton.setEnabled(false);
        PauseButton.setEnabled(false);
        ResetButton.setEnabled(false);
        SaveButton.setEnabled(false);
        hours.setText("00");
        minutes.setText("00");
        seconds.setText("00");
        solved = true;
    }//GEN-LAST:event_solveButtonActionPerformed
    
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
    private javax.swing.JButton solveButton;
    // End of variables declaration//GEN-END:variables
}
