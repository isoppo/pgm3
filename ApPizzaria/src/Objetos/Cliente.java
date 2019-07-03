
package Objetos;

/**
 * @author Felipe-Isoppo
 */
public class Cliente extends Pessoa {
    
    private String endereco;
    private String telefone;
   
    public String getEndereco() { return endereco; }
    public void setEndereco(String e) {endereco = e; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String t) {telefone = t; }
    
    // construtor
    public Cliente( String nome, String cpf, String e, String t ) {
        super( nome, cpf ); endereco = e; telefone = t; }
    
    public Cliente(){
        super( "", "" ); endereco = ""; telefone = "";
    }
   
}
