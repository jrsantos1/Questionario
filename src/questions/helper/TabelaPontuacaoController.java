/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questions.helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.entidades.Pontuacao;
import questions.TabelaPontuacao;

/**
 *
 * @author Jhonatan
 */
public class TabelaPontuacaoController {
    
    TabelaPontuacao tbPontuacao;
    
    public TabelaPontuacaoController(TabelaPontuacao tbPontuacao) {
        this.tbPontuacao = tbPontuacao;
    }
    
    public void preencherTabela(ArrayList<Pontuacao> pontuacao){
    
        DefaultTableModel tabela = (DefaultTableModel) tbPontuacao.getTbPontuadores().getModel();
        tabela.setNumRows(0);
        
        int posicao = 1; 
        
        for(Pontuacao pontuacoes : pontuacao){
            tabela.addRow(new Object[]{
            pontuacoes.getNome(),
            pontuacoes.getPontuacao(),
            posicao
            });
            
            posicao++;
        }
        
    }
}
