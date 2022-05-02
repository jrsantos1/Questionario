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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import login.FimDeJogo;
import menu.Menu;
import modelo.dao.QuestoesDAO;
import modelo.entidades.Pessoa;
import modelo.entidades.Pontuacao;
import modelo.entidades.Questao;
@SuppressWarnings("serial")
public class Quest01 extends JFrame{
	
	JFrame  frame = new JFrame();
	
    
    
    int indexQuestion = 0;
    
    private static Pessoa pessoa;
    
    public Quest01(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public static void main(String st[]) {
    	
        SwingUtilities.invokeLater( new Runnable(){
            public void run(){
                Quest01 myquest01 = new Quest01(pessoa);
                myquest01.load();
            }
        });
    }
    
    public void load() {
    	
    	Pontuacao pontucao = new Pontuacao(pessoa.getId(), 0);
    	
    	ArrayList<Questao> questoes = new QuestoesDAO().getQuestoes();
    	
    	ButtonGroup grp = new ButtonGroup();
    	

       // JLabel inform = new JLabel("teste");
    	
        JLabel q1 = new JLabel(questoes.get(indexQuestion).getTitulo());
    	JRadioButton r1 = new JRadioButton(questoes.get(indexQuestion).getAlternativa01()); //Resposta Correta
    	r1.setActionCommand(questoes.get(indexQuestion).getAlternativa01());
        JRadioButton r2 = new JRadioButton(questoes.get(indexQuestion).getAlternativa02());
        r2.setActionCommand(questoes.get(indexQuestion).getAlternativa02());
        JRadioButton r3 = new JRadioButton(questoes.get(indexQuestion).getAlternativa03());
        r3.setActionCommand(questoes.get(indexQuestion).getAlternativa03());                        
        JRadioButton r4 = new JRadioButton(questoes.get(indexQuestion).getAlternativa04());
        r4.setActionCommand(questoes.get(indexQuestion).getAlternativa04());
        
        JButton b1 = new JButton("CONFIRMAR");
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				
				String opcaoDoUsuario = "";
				
				if(true) {
					
					if(r1.isSelected()) {
						opcaoDoUsuario = r1.getText();
					}else if(r2.isSelected()){
						opcaoDoUsuario = r2.getText();
					}else if(r3.isSelected()){
						opcaoDoUsuario = r3.getText();
					}else if(r4.isSelected()){
						opcaoDoUsuario = r4.getText();
					}else {
						System.out.println("Nenhum opção selecionada");
					}
					
					if(opcaoDoUsuario.equalsIgnoreCase(questoes.get(indexQuestion).getAlternativaCorreta())){
						pontucao.setPontuacao(pontucao.getPontuacao() + 10);
        			}
        	
					
					System.out.println("A opção do usuário é: " + opcaoDoUsuario);
					
					
					if(!(indexQuestion > 3)) {
						
						indexQuestion = indexQuestion + 1;
						
						r1.setText(questoes.get(indexQuestion).getAlternativa01());		
						r2.setText(questoes.get(indexQuestion).getAlternativa02());	
						r3.setText(questoes.get(indexQuestion).getAlternativa03());	
						r4.setText(questoes.get(indexQuestion).getAlternativa04());	
						q1.setText(questoes.get(indexQuestion).getTitulo());
						
					}else {
						System.out.println("Sua pontuação final é: " + pontucao.getPontuacao());
						frame.dispose();
						FimDeJogo fim = new FimDeJogo();
						fim.exibeMensagem();
					}															
														
				}
				
				System.out.println(indexQuestion);
				
				
				/*
				 * if( grp.getSelection() != null ){ JOptionPane.showMessageDialog(
				 * Quest01.this, grp.getSelection().getActionCommand()); }else{
				 * JOptionPane.showMessageDialog( Quest01.this, "Selecione uma opÃ§Ã£o!"); }
				 */			
			}
		});
        
    	JButton b2 = new JButton("VOLTAR");
        b2.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			Menu mymenu = new Menu(pessoa);
                mymenu.load();    							
    		}
    	});
    	

    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(new Dimension(700, 700));
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setUndecorated(true);
    frame.setVisible(true);
   
    ArrayList<JRadioButton> lista = new ArrayList<JRadioButton>(); //Misturar alternativas
	lista.add(r1); //Resposta correta
	lista.add(r2);
	lista.add(r3);
	lista.add(r4);
	
	Collections.shuffle(lista);

	grp.add(lista.get(0));
    grp.add(lista.get(1));
    grp.add(lista.get(2));
    grp.add(lista.get(3));
    //grp.add(q1);
    
    Container c = frame.getContentPane();
    
    c.setLayout(null);
    
    q1.setBounds(130, 150, 500, 20);
    q1.setVerticalAlignment(SwingConstants.CENTER);
    q1.setBackground(Color.black);
    q1.setForeground(Color.white);
    c.add(q1);
    
    lista.get(0).setBounds(130, 250, 200, 20);
    lista.get(0).setBackground(Color.black);
    lista.get(0).setForeground(Color.white);
    c.add(lista.get(0));
    
    lista.get(1).setBounds(130, 280, 200, 20);
    lista.get(1).setBackground(Color.black);
    lista.get(1).setForeground(Color.white);
    c.add(lista.get(1));
    
    lista.get(2).setBounds(130, 310, 200, 20);
    lista.get(2).setBackground(Color.black);
    lista.get(2).setForeground(Color.white);
    c.add(lista.get(2));
    
    lista.get(3).setBounds(130, 340, 200, 20);
    lista.get(3).setBackground(Color.black);
    lista.get(3).setForeground(Color.white);
    c.add(lista.get(3));
    
    b1.setBounds(550, 640, 110, 20);
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    c.add(b1);
    
    b2.setBounds(50, 640, 100, 20);
    b2.setBackground(Color.black);
    b2.setForeground(Color.white);
    c.add(b2);
    
   
    }
}