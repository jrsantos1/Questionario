package questions;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import menu.Menu;
import model.dao.PerguntaDAO;
import model.entidades.Pessoa;
import model.entidades.Pontuacao;
import model.entidades.Pergunta;
@SuppressWarnings("serial")
public class Game extends JFrame{
	
	JFrame frame = new JFrame();
    int indexQuestion = 0;
    private static Pessoa pessoa;
    
    public Game(Pessoa pessoa) {
		this.pessoa = pessoa;
        
	}

	public static void main(String st[]) {
    	
        SwingUtilities.invokeLater( new Runnable(){
            public void run(){
                Game myquest01 = new Game(pessoa);
                try {
                    myquest01.load();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void load() throws SQLException {
    	
    	Pontuacao pontucao = new Pontuacao(pessoa.getId(), 0);
    	
    	ArrayList<Pergunta> questoes = new PerguntaDAO().getQuestoes();
    	
    	ButtonGroup grp = new ButtonGroup();
    	

       // JLabel inform = new JLabel("teste");
    	JTextArea pgnt = new JTextArea(questoes.get(indexQuestion).getTitulo());
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
					
					
					if(!(indexQuestion >= 8)) {
						
						indexQuestion = indexQuestion + 1;
						
						r1.setText(questoes.get(indexQuestion).getAlternativa01());		
						r2.setText(questoes.get(indexQuestion).getAlternativa02());	
						r3.setText(questoes.get(indexQuestion).getAlternativa03());	
						r4.setText(questoes.get(indexQuestion).getAlternativa04());	
						pgnt.setText(questoes.get(indexQuestion).getTitulo());
						
					}else {
						System.out.println("Sua pontuação final é: " + pontucao.getPontuacao());
						System.out.println("O número de questoes é: " + questoes.size());
						frame.dispose();
                        EndGame finish = new EndGame(pontucao, pessoa);
                        try {
                            finish.run();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }


                    }
														
				}
				
				System.out.println(indexQuestion);
				
				
				/*
				 * if( grp.getSelection() != null ){ JOptionPane.showMessageDialog(
				 * Quest01.this, grp.getSelection().getActionCommand()); }else{
				 * JOptionPane.showMessageDialog( Quest01.this, "Selecione uma opção!"); }
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
    
    pgnt.setBounds(130,  150,  500, 20);
    pgnt.setBackground(Color.black);
    pgnt.setForeground(Color.white);
    pgnt.setLineWrap(true);
    pgnt.setEditable(false);
    c.add(pgnt);
    
    
    q1.setBounds(130, 150, 500, 20);
    q1.setVerticalAlignment(SwingConstants.CENTER);
    q1.setBackground(Color.black);
    q1.setForeground(Color.white);
    //c.add(q1);
    
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