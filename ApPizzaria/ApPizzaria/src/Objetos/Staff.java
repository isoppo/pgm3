
package Objetos;

/**
 * @author Felipe-Isoppo
 */

public class Staff extends Cliente {
    
    private String funcao;
   
    public String getFuncao() { return funcao; }
    public void setFuncao(String f) {funcao = f; }
    
    
    public Staff( String nome, String cpf, String endereco, String telefone , String f) {
        super( nome, cpf, endereco, telefone); funcao = f; }
    
    public Staff( ) {
        super( "", "", "", ""); funcao = ""; }
    
    public Staff( String x ) {
        super( "", "", "", ""); funcao = x; }
}
