package menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import login.Login;
import modelo.entidades.Pessoa;
import questions.Quest01;
public class Menu {
	
	static Pessoa pessoa;
	
	public Menu(Pessoa pessoa){
		this.pessoa = pessoa;
	}

    JFrame  frame = new JFrame();
    
    ImageIcon gif = new ImageIcon(getClass().getResource("pixel-jeff-matrix-s.gif"));
	JLabel picture = new JLabel(gif);

    public static void main(String st[]) {
    	
    	Pessoa pessoa1 = pessoa;
    	
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
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
    			Quest01 myquest01 = new Quest01(pessoa);
                myquest01.load();
                
    		}
    	});
        
        JButton b2 = new JButton("HANKED");
        
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
}