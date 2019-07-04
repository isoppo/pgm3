
package InterfaceDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Felipe-Isoppo
 */
//Faz o acesso a dados binarios para o DaoEstatico
public class DaoAF  implements Serializable{
    
    public String caminhoArquivo;
    public HashMap dados = new HashMap();;
    
    public DaoAF() { super();}
    
    //Construtor
    DaoAF( String caminhoArquivo){
        this.caminhoArquivo = caminhoArquivo;
        //this.dados = dados;
    }
    
    
    // método auxiliar: carregar dados do disco
    HashMap carregarDadosDoDisco() {
        dados.clear();
        try {
            // ler o arquivo
            FileInputStream fis = new FileInputStream(caminhoArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // converter o conteúdo lido no objeto dados
            dados = (HashMap) ois.readObject();
            
            // captura de diversos tipos de erros possíveis    
        } catch (FileNotFoundException fex) {
            fex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException cex) {
            cex.printStackTrace();
        } catch(Exception ex){
           ex.printStackTrace(); 
        } 
        // retornar :-)
        return dados;
    }
    
    
    // método auxiliar para gravar dados no disco
    void salvarDadosNoDisco(HashMap dados) {
        this.dados = dados;
        try {
            // prepara ponteiro de gravação
            FileOutputStream fos = new FileOutputStream(caminhoArquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // grava dados
            oos.writeObject(this.dados);
            // fecha o arquivo e efetiva a gravação
            oos.close();
            // tratamento de possível erro de I/O
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
