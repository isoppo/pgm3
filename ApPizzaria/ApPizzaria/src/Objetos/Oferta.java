
package Objetos;

/**
 * @author Felipe-Isoppo
 */

public abstract class Oferta {
    
    private int item;
    private int quantidade;
    private float preco;
    private String descricao;
   
    
    public int getItem() { return item; }
    public void setItem(int item) { this.item = item; }
    public int getQtda() { return quantidade; }
    public void setQtda(int qtda) { this.quantidade = qtda; }
    public float getPreco() { return preco; }
    public void setPreco(float preco) { this.preco = preco; }
    public String getDescricao() { return descricao; }
    public void setcpf(String descricao) { this.descricao = descricao; }
    
   
    // construtor
    public Oferta(int i, float p, String d ) {
        this.item = i; this.preco = p; this.descricao = d; this.quantidade =1; }
    public Oferta(int i, float p, String d, int q ) {
        this.item = i; this.preco = p; this.descricao = d; this.quantidade =q; }
}