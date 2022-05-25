package questions;

import javax.swing.*;
import java.awt.*;

public class Scores extends JFrame {
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraDeRolagem;

    Object [][] dados = {
            {"Ana monteiro", "12", "ana@gmail.com"},
            {"Carlos", "14", "carlos@hotmail.com"},
            {"Bianca", "14", "bianca@bianca.com"}};

    String [] colunas = {"Nome", "Idade", "E-mail"};

    public Scores(){
        super ("Contatos");
    }

    public void exibir(){

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        barraDeRolagem = new JScrollPane(tabela);
        painelFundo.add(barraDeRolagem);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 120);
        setVisible(true);
    }

   /* public static void main(String[] args){
        Scores scores = new Scores();
        scores.show();
    }*/


}
