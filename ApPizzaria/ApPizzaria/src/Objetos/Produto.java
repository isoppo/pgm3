/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 * @author Felipe-Isoppo
 */
public class Produto extends Oferta {
    
    //private int quantidade;
    private String unidade;
    
    //public int getQuantidade() { return quantidade; }
    //public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
    
    // construtor
    public Produto(int item, float preco, String descricao, int q , String u ) {
        super( item, preco, descricao, q );  unidade = u;  }
       //super( item, preco, descricao ); quantidade = q; unidade = u;  }
    
    public Produto(int item, float preco, String descricao, String u ) {
        //public Produto(int item, float preco, String descricao,int qtda, int q , String u ) {
        super( item, preco, descricao);  unidade = u;  }
       //super( item, preco, descricao, qtda ); quantidade = q; unidade = u;  }
    
    public Produto(Produto p ) {
        //super( p.getItem(), p.getPreco(), p.getDescricao(), p.getQtda() ); quantidade = p.getQuantidade(); unidade = p.getUnidade();
       super( p.getItem(), p.getPreco(), p.getDescricao(), p.getQtda() );  unidade = p.getUnidade();  }
}