package questions;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;

import menu.Menu;
import model.dao.PontuacaoDAO;
import model.entidades.Pessoa;
import model.entidades.Pontuacao;

@SuppressWarnings("serial")
public class EndGame {

    private Pontuacao pontuacao;
    private Pessoa pessoa;
    private JFrame frame = new JFrame();
    private JTextArea finalMessage;

    public EndGame(Pontuacao pontuacao, Pessoa pessoa) {

        this.pontuacao = pontuacao;
        this.pessoa = pessoa;

    }

    public void run() throws SQLException {

        PontuacaoDAO pontuacaoDao = new PontuacaoDAO();
        pontuacaoDao.adicionaPontuacao(pontuacao);

        // criando e dimensionando o frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(700, 700));
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);

        // texto exibido na frame
        finalMessage = new JTextArea("Parabéns " + pessoa.getNome() + ", você fez " + pontuacao.getPontuacao() + " Pontos!!");
        Container c = frame.getContentPane();
        c.setLayout(null);

        finalMessage.setBounds(130, 150, 500, 20);
        finalMessage.setBackground(Color.black);
        finalMessage.setForeground(Color.white);
        finalMessage.setLineWrap(true);
        finalMessage.setEditable(false);
        c.add(finalMessage);

        JButton b2 = new JButton("Jogar Novamente");
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu mymenu = new Menu(pessoa);
                mymenu.load();
            }
        });

        JButton b1 = new JButton("Finalizar");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

        b1.setBounds(550, 640, 110, 20);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        c.add(b1);

        b2.setBounds(50, 640, 150, 20);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        c.add(b2);

        System.out.println("Parabéns " + " seu id é " + pessoa.getId() + " " + pessoa.getNome() + ", você fez " + pontuacao.getPontuacao() + " Pontos!!");
    }

}
