/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package questions;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import menu.Menu;
import model.dao.PontuacaoDAO;
import model.entidades.Pessoa;
import model.entidades.Pontuacao;

/**
 *
 * @author Jhonatan
 */
public class EndGame2 extends javax.swing.JFrame {

    static Pontuacao pontuacao;
    static Pessoa pessoa;
    private JFrame frame = new JFrame();
    private JTextArea finalMessage;

    public EndGame2(Pontuacao pontuacao, Pessoa pessoa) {
        this.pontuacao = pontuacao;
        this.pessoa = pessoa;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setResizable(false);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbFimDeJogo = new javax.swing.JLabel();
        lbPontuacaoFinal = new javax.swing.JLabel();
        btnFinalizarJogo = new javax.swing.JButton();
        btnJogarNovamente = new javax.swing.JButton();

        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        lbFimDeJogo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbFimDeJogo.setForeground(new java.awt.Color(0, 255, 51));
        lbFimDeJogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFimDeJogo.setText("Fim de Jogo");

        lbPontuacaoFinal.setBackground(new java.awt.Color(255, 255, 255));
        lbPontuacaoFinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPontuacaoFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnFinalizarJogo.setBackground(new java.awt.Color(0, 0, 0));
        btnFinalizarJogo.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarJogo.setText("Sair");
        btnFinalizarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarJogoActionPerformed(evt);
            }
        });

        btnJogarNovamente.setBackground(new java.awt.Color(0, 0, 0));
        btnJogarNovamente.setForeground(new java.awt.Color(255, 255, 255));
        btnJogarNovamente.setText("Menu");
        btnJogarNovamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarNovamenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbFimDeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPontuacaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnJogarNovamente, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(lbFimDeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(lbPontuacaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJogarNovamente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarJogoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnFinalizarJogoActionPerformed

    private void btnJogarNovamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarNovamenteActionPerformed
        // TODO add your handling code here:
        dispose();
        Menu mymenu = new Menu(pessoa);
        mymenu.load();
    }//GEN-LAST:event_btnJogarNovamenteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EndGame2 endGame;
                endGame = new EndGame2(pontuacao, pessoa);
                try {
                    endGame.load();
                } catch (SQLException ex) {
                    Logger.getLogger(EndGame2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void load() throws SQLException {
        setVisible(true);
        lbPontuacaoFinal.setText("Parabéns, " + pessoa.getNome() + "!! Você fez " + pontuacao.getPontuacao() + " Pontos!!");
        PontuacaoDAO pontuacaoDao = new PontuacaoDAO();
        pontuacaoDao.adicionaPontuacao(pontuacao);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarJogo;
    private javax.swing.JButton btnJogarNovamente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lbFimDeJogo;
    private javax.swing.JLabel lbPontuacaoFinal;
    // End of variables declaration//GEN-END:variables

}
