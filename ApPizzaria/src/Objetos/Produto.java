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
    
    private float quantidade;
    private String unidade;
    
    public float getQuantidade() { return quantidade; }
    public void setQuantidade(float quantidade) { this.quantidade = quantidade; }
    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
    
    // construtor
    public Produto(int item, float preco, String descricao, float q , String u ) {
       super( item, preco, descricao ); quantidade = q; unidade = u;  }
    
    public Produto(Produto p ) {
       super( p.getItem(), p.getPreco(), p.getDescricao() ); quantidade = p.getQuantidade(); unidade = p.getUnidade();  }
    
}