package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.dao.PessoaDAO;
import model.entidades.Pessoa;

public class Popup {

    JFrame frame = new JFrame("Popup");

    JLabel user = new JLabel("USUARIO: ");
    JTextField login = new JTextField();

    JLabel password = new JLabel("SENHA: ");
    JPasswordField senha2 = new JPasswordField();

    JLabel validacao = new JLabel("");

    public static void main(String st[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Popup mypopup = new Popup();
                mypopup.load();
            }
        });
    }

    public void load() {

        JButton b1 = new JButton("CADASTRAR");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { //INCLUIR DADOS NO SQL CAMINHO PARA SQL
                //sql.add(user);	
                //sql.add(senha)
                Pessoa pessoa = new Pessoa(login.getText(), senha2.getText());
                PessoaDAO pessoaDao = new PessoaDAO();

                try {
                    
                    String nome = login.getText();
                    String senha = senha2.getText();

                    if (!(nome.equals("")) && !(senha.equals(""))) {

                        pessoaDao.cadastrarPessoa(pessoa);

                        validacao.setText("Cadastro realizado!");

                    } else {

                        validacao.setText("Cadastro não realizado");

                    }

                    login.setText("");
                    senha2.setText("");

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });

        JButton b2 = new JButton("VOLTAR");
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                //Login mylogin = new Login();
                //mylogin.load();
            }
        });

        senha2.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) { //add+ entrada com ENTER
                b1.doClick(13);
            }
        });
        // Laytout 
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(270, 150));
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);

        Container c = frame.getContentPane();

        c.setLayout(null);

        user.setBounds(50, 20, 110, 20);
        user.setBackground(Color.GRAY);
        user.setForeground(Color.white);
        c.add(user);

        login.setBounds(110, 20, 110, 20);
        login.setBackground(Color.GRAY);
        login.setForeground(Color.white);
        c.add(login);

        password.setBounds(60, 50, 110, 20);
        password.setBackground(Color.GRAY);
        password.setForeground(Color.white);
        c.add(password);

        senha2.setBounds(110, 50, 110, 20);
        senha2.setBackground(Color.GRAY);
        senha2.setForeground(Color.white);
        c.add(senha2);

        validacao.setBounds(70, 80, 110, 20);
        validacao.setBackground(Color.GRAY);
        validacao.setForeground(Color.white);
        c.add(validacao);

        b1.setBounds(140, 110, 110, 20);
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.white);
        c.add(b1);

        b2.setBounds(20, 110, 110, 20);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.white);
        c.add(b2);
    }
}
