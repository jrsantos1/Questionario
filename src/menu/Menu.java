package menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import login.Login;
import model.entidades.Pessoa;
import questions.Game2;
import questions.Scores;
import questions.TabelaPontuacao;

public class Menu {

    static Pessoa pessoa;

    public Menu(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    JFrame frame = new JFrame();

    ImageIcon gif = new ImageIcon(getClass().getResource("../contents/pixel-jeff-matrix-s.gif"));
    JLabel picture = new JLabel(gif);

    public static void main(String[] args) {

        Pessoa pessoa1 = pessoa;

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Menu mymenu = new Menu(pessoa);
                mymenu.load();
            }
        });

    }

    public void load() {

        JButton b1 = new JButton("JOGAR");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Game2 myquest01 = new Game2(pessoa);
                try {
                    myquest01.load();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        JButton b2 = new JButton("RANKING");
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    //Scores score = new Scores();
                    //score.exibir();
                    TabelaPontuacao tbPontuacao = new TabelaPontuacao(pessoa);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        JButton b3 = new JButton("CR�DITOS");
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Credits mycred = new Credits(pessoa);
                mycred.load();

            }
        });

        JButton b4 = new JButton("VOLTAR");
        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { //add+ encerrar app
                frame.dispose();
                Login mylogin = new Login();
                mylogin.load();

            }
        });

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(700, 700));
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);

        Container c = frame.getContentPane();

        c.setLayout(null); //vamos fazer a gestão manualmente

        b1.setBounds(300, 550, 100, 20); //dimensoes e posicionamento do botão (os dois primeiros valores indicam a posicao absoluta do botao)
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        c.add(b1);

        b2.setBounds(300, 580, 100, 20); //dimensoes e posicionamento do botão (os dois primeiros valores indicam a posicao absoluta do botao)
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        c.add(b2);

        b3.setBounds(300, 610, 100, 20);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        c.add(b3);

        b4.setBounds(300, 640, 100, 20);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        c.add(b4);

        picture.setBounds(0, 0, 720, 980);
        picture.setLocation(-20, -240);
        c.add(picture);
    }

    public static class Credits {

        static Pessoa pessoa;

        JFrame framecred = new JFrame();

        ImageIcon gif = new ImageIcon(getClass().getResource("../contents/ezgif.com-gif-maker.gif"));
        JLabel picture = new JLabel(gif);

        JLabel cred = new JLabel("<html><center>DESENVOLVEDORES<br>"
                + "<br><br>MATHEUS LOPES TRINDADE<br>"
                + "<br><br>JHONATAN RIBEIRO DOS SANTOS<br>"
                + "<br><br>MURILO LIMA DOS SANTOS<br>"
                + "<br><br>JO�O PEDRO ARAUJO");

        public Credits(Pessoa pessoa) {
            this.pessoa = pessoa;
        }

        public static void main(String st[]) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Credits mycred = new Credits(pessoa);
                    mycred.load();
                }
            });

        }

        public void load() {

            JButton b4 = new JButton("VOLTAR");
            b4.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) { //add+ encerrar app
                    framecred.dispose();
                    Menu mymenu = new Menu(pessoa);
                    mymenu.load();

                }
            });

            framecred.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            framecred.setSize(new Dimension(700, 700));
            framecred.getContentPane().setBackground(Color.BLACK);
            framecred.setLocationRelativeTo(null);
            framecred.setResizable(false);
            framecred.setUndecorated(true);
            framecred.setVisible(true);

            Container c = framecred.getContentPane();

            c.setLayout(null); //vamos fazer a gestão manualmente

            cred.setBounds(265, 50, 200, 400); //dimensoes e posicionamento do botão (os dois primeiros valores indicam a posicao absoluta do botao)
            cred.setVerticalAlignment(SwingConstants.CENTER);
            cred.setForeground(Color.white);
            c.add(cred);

            b4.setBounds(300, 640, 100, 20);
            b4.setBackground(Color.black);
            b4.setForeground(Color.white);
            c.add(b4);

            picture.setBounds(0, 0, 800, 800);
            picture.setLocation(-50, -50);
            c.add(picture);
        }
    }
}
