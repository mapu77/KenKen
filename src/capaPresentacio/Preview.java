/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Oriolcapo
 */
public class Preview extends javax.swing.JPanel {

    /**
     * Creates new form Preview
     */
    private int[][] mat;
    private ArrayList<String> ops;
    private int N, BZ;
    
    public Preview() {
        initComponents();
    }
    
    public Preview(int[][] mat, ArrayList<String> ops, Rectangle r) {
        initComponents();
        this.setBounds(r);
        Tauler.setBounds(r);
        this.mat = mat;
        this.ops = ops;
        this.N = mat.length;
        initMatriu();
        setVisible(true);
    }

    private void initMatriu() {
        int alt = getHeight();
        int bSize = alt/N;
        BZ = bSize;
        ArrayList<Boolean> reg = new ArrayList<>();
        for (int i=0; i<ops.size(); i++) reg.add(false);
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                JLabel b = new JLabel();
                Tauler.add(b);
                b.setBounds(j*bSize, i*bSize, bSize, bSize);
                b.setOpaque(true);                
                b.setBackground(Color.white);
                b.setVisible(true);
                if (!reg.get(mat[i][j])) {
                    reg.set(mat[i][j], true);
                    JLabel lab = new JLabel(ops.get(mat[i][j]));
                    b.add(lab);
                    lab.setBounds(5, 0, BZ/2, BZ/2);
                }
            }
        }
        mat = transposaMat(mat);
        setBorders();
    }
    
    private int[][] transposaMat (int[][] mat) {
        int[][] mat2 = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                mat2[j][i] = mat[i][j];
            }
        }
        return mat2;
    }
    
    private void setBorders() {
        int n = N-1;
        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                int Me = mat[i][j];
                int u=1,d=1,l=1,r=1;

                if (i == 0) {
                    u+=2;
                    if (Me != mat[i+1][j]) d+=1;
                    if (j>0 && j<n) {
                        if (Me != mat[i][j+1]) r+=1;
                        if (Me != mat[i][j-1]) l+=1;
                    }
                }
                else if (i == n) {
                    d+=2;
                    if (Me != mat[i-1][j]) u+=1;
                    if (j>0 && j<n) {
                        if (Me != mat[i][j+1]) r+=1;
                        if (Me != mat[i][j-1]) l+=1;
                    }
                }
                if (j == 0) {
                    l+=2;
                    if (Me != mat[i][j+1]) r+=1;
                    if (i>0 && i<n) {
                        if (Me != mat[i+1][j]) d+=1;
                        if (Me != mat[i-1][j]) u+=1;
                    }
                }
                if (j == n) {
                    r+=2;
                    if (Me != mat[i][j-1]) l+=1;
                    if (i>0 && i<n) {
                        if (Me != mat[i+1][j]) d+=1;
                        if (Me != mat[i-1][j]) u+=1;
                    }
                }
                if (i!=0 && i!=n && j!=0 && j!=n) {
                    if (Me != mat[i+1][j]) d+=1;
                    if (Me != mat[i-1][j]) u+=1;
                    if (Me != mat[i][j+1]) r+=1;
                    if (Me != mat[i][j-1]) l+=1;
                }
                JLabel label = (JLabel) Tauler.getComponentAt(i*BZ,j*BZ);
                label.setBorder(BorderFactory.createMatteBorder(l,u,r,d,Color.black));
                
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

        Tauler = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(350, 350));
        setMinimumSize(new java.awt.Dimension(350, 350));
        setPreferredSize(new java.awt.Dimension(350, 350));
        setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout TaulerLayout = new javax.swing.GroupLayout(Tauler);
        Tauler.setLayout(TaulerLayout);
        TaulerLayout.setHorizontalGroup(
            TaulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        TaulerLayout.setVerticalGroup(
            TaulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        add(Tauler, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tauler;
    // End of variables declaration//GEN-END:variables
}
