
package Objetos;

/**
 * @author Felipe-Isoppo
 */
//public class Staff extends Pessoa {
public class Staff extends Cliente {
    
    private String endereco;
    private String telefone;
    private String funcao;
   
    //public String getEndereco() { return endereco; }
    //public void setEndereco(String e) {endereco = e; }
    //public String getTelefone() { return telefone; }
    //public void setTelefone(String t) {telefone = t; }
    public String getFuncao() { return funcao; }
    public void setFuncao(String f) {funcao = f; }
    
    // construtor
    //public Staff( String nome, String cpf, String e, String t , String f) {
    //    super( nome, cpf ); endereco = e; telefone = t; funcao = f; }
    
    public Staff( String nome, String cpf, String endereco, String telefone , String f) {
        super( nome, cpf, endereco, telefone); funcao = f; }
   
}
