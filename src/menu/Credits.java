package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.entidades.Pessoa;

public class Credits {
	
	static Pessoa pessoa;
	
	JFrame  framecred = new JFrame();
    
    ImageIcon gif = new ImageIcon(getClass().getResource("ezgif.com-gif-maker.gif"));
	JLabel picture = new JLabel(gif);
	
    JLabel cred = new JLabel("<html><center>DESENVOLVEDORES<br>"
    		+ "<br><br>MATHEUS LOPES TRINDADE<br>"
    		+ "<br><br>JHONATA<br>"
    		+ "<br><br>GUSTAVO<br>"
    		+ "<br><br>MURILO<br>"
    		+ "<br><br>JOÃO");
    

    public Credits(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public static void main(String st[]) {
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
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