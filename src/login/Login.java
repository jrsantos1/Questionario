package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import menu.Menu;
import model.dao.PessoaDAO;
import model.entidades.Pessoa;

public class Login {

    JFrame frame = new JFrame("MENU");

    ImageIcon gif = new ImageIcon(getClass().getResource("../contents/pixel-jeff-matrix-s.gif"));
    JLabel picture = new JLabel(gif);

    JLabel validacao = new JLabel("");

    JLabel user = new JLabel("USUARIO: ");

    JTextField login = new JTextField();

    JLabel senha1 = new JLabel("SENHA: ");

    JPasswordField senha2 = new JPasswordField();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login mylogin = new Login();
                mylogin.load();
            }
        });

    }

    public void load() {

        JButton b1 = new JButton("ENTRAR");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Pessoa pessoa = new Pessoa(login.getText(), senha2.getText());
                PessoaDAO pessoaDao = new PessoaDAO();
                pessoa.setId(pessoaDao.retornaId(pessoa));

                try {
                    if (pessoaDao.validaLogin(pessoa)) {

                        frame.dispose();
                        Menu mymenu = new Menu(pessoa);
                        mymenu.load();

                    } else {
                        validacao.setText("USUARIO E/OU SENHA INVÃ�LIDOS");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("CADASTRAR");
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { //add+ encerrar app
                Popup mypopup = new Popup();
                mypopup.load();
            }
        });

        JButton b3 = new JButton("SAIR");
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { //add+ encerrar app
                System.exit(0);

            }
        });
        
        senha2.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) { //add+ entrada com ENTER
                b1.doClick(13);
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

        c.setLayout(null); //vamos fazer a gestÃ£o manualmente

        validacao.setBounds(255, 520, 200, 20); //dimensoes e posicionamento do botÃ£o (os dois primeiros valores indicam a posicao absoluta do botao)
        validacao.setBackground(Color.black);
        validacao.setForeground(Color.RED);
        c.add(validacao);

        user.setBounds(235, 550, 110, 20); //dimensoes e posicionamento do botÃ£o (os dois primeiros valores indicam a posicao absoluta do botao)
        user.setBackground(Color.black);
        user.setForeground(Color.white);
        c.add(user);

        login.setBounds(295, 550, 110, 20); //dimensoes e posicionamento do botÃ£o (os dois primeiros valores indicam a posicao absoluta do botao)
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        c.add(login);

        senha1.setBounds(245, 580, 110, 20); //dimensoes e posicionamento do botÃ£o (os dois primeiros valores indicam a posicao absoluta do botao)
        senha1.setBackground(Color.black);
        senha1.setForeground(Color.white);
        c.add(senha1);

        senha2.setBounds(295, 580, 110, 20); //dimensoes e posicionamento do botÃ£o (os dois primeiros valores indicam a posicao absoluta do botao)
        senha2.setBackground(Color.black);
        senha2.setForeground(Color.white);
        c.add(senha2);

        b1.setBounds(295, 610, 110, 20);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        c.add(b1);

        b2.setBounds(295, 640, 110, 20);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        c.add(b2);

        b3.setBounds(295, 670, 110, 20);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        c.add(b3);

        picture.setBounds(0, 0, 720, 980);
        picture.setLocation(-20, -240);
        c.add(picture);
    }
}
