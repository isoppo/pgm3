
package Objetos;
/**
 * @author Felipe-Isoppo
 */

public abstract class Pessoa {
    
    private String nome;
    private String cpf;
    

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getcpf() { return cpf; }
    public void setcpf(String cpf) { this.cpf = cpf; }
    
    // construtor
    public Pessoa(String n, String c ) {
        nome = n; cpf = c;  }
    
}