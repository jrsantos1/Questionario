package questions;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import login.FimDeJogo;
import menu.Menu;
import modelo.dao.PessoaDAO;
import modelo.dao.QuestoesDAO;
import modelo.entidades.Pessoa;
import modelo.entidades.Pontuacao;
import modelo.entidades.Questao;
@SuppressWarnings("serial")
public class EndGame {
	
	private static Pontuacao pontuacao;
	private static Pessoa pessoa;
	private static JFrame frame = new JFrame();
	
	public EndGame(Pontuacao pontuacao, Pessoa pessoa) {
		
		this.pontuacao = pontuacao;
		this.pessoa = pessoa;
		
		// criando e dimensionando o frame
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(new Dimension(700, 700));
	    frame.getContentPane().setBackground(Color.BLACK);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setUndecorated(true);
	    frame.setVisible(true);
	    
	    // texto exibido na frame
	    
	    JTextArea pgnt = new JTextArea("Parabéns " + pessoa.getNome() + ", você fez " + pontuacao.getPontuacao() + " Pontos!!");
		  Container c = frame.getContentPane();
		  c.setLayout(null);
		  
		  pgnt.setBounds(130,  150,  500, 20);
		    pgnt.setBackground(Color.black);
		    pgnt.setForeground(Color.white);
		    pgnt.setLineWrap(true);
		    pgnt.setEditable(false);
		    c.add(pgnt);
		    
		    
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
	        b1.addActionListener(new ActionListener(){
	        	

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
				}
	        });
		    
		    b1.setBounds(550, 640, 110, 20);
		    b1.setBackground(Color.black);
		    b1.setForeground(Color.white);
		    c.add(b1);
		    
		    b2.setBounds(50, 640, 100, 20);
		    b2.setBackground(Color.black);
		    b2.setForeground(Color.white);
		    c.add(b2);
				  
		System.out.println("Parabéns " + pessoa.getNome() + ", você fez " + pontuacao.getPontuacao() + " Pontos!!");
		
	}
	    
		
	}
	
	/*
	 * public static EndGame getPontuacao() {
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
