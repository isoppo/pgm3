                                                                                   
package Objetos;

/**
 * @author Felipe-Isoppo
 */
public class Cliente  {
    
    private String endereco;
    private String telefone;
    
    private String nome;
    private String cpf;
    

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getcpf() { return cpf; }
    public void setcpf(String cpf) { this.cpf = cpf; }
   
    public String getEndereco() { return endereco; }
    public void setEndereco(String e) {endereco = e; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String t) {telefone = t; }
    
    // construtor
    public Cliente( String nome, String cpf, String e, String t ) {
        this.nome = nome; this.cpf = cpf ; endereco = e; telefone = t; }
    
    public Cliente(){
        this.nome = ""; this.cpf = "" ; this.endereco = ""; this.telefone = "";
    }
   
}
