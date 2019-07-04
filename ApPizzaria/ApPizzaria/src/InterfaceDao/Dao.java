
package InterfaceDao;

import Objetos.*;
import java.util.ArrayList;

/**
 * @author Felipe-Isoppo
 */
public interface Dao  {
    
    public void SalvaCaixa(Caixa a);
    
    public Caixa ExtratoCaixa();
    
    public void SalvaAtendimento(Atendimento p);
    
    public void SubstituiAtendimento(Atendimento p );
    
    public Atendimento getAtendimento(String id);
    
    public ArrayList<Atendimento> getAtendimentos();
    
    public ArrayList<Atendimento> getAtendimentosAbertos();
    
    public ArrayList<Atendimento> getAtendimentosEncerrado();
    
    public void removeAtendimento(String item);
    
    public void MontaListaPessoa();
    
    public String formataCPF(String cpf);
    
    public void SalvaStaff(Staff p);
    
    public void SalvaPessoa(Cliente p);
    
    public void adicionarPessoa(Cliente p);
    
    public Cliente buscarPessoaPorCPF(String cpf);
    
    public Staff buscarStaffPorCPF(String cpf);
    
    public boolean existePessoaPorCPF(String cpf);
    
    public void atualizarPessoa(Cliente p);
    
    public ArrayList<Produto> retornarCardapio();
    
    public Produto buscarProduto(String produto);
    
    public void retiraItemDoEstoque(int item, int quantidade);
    
    public ArrayList<Oferta> removeItemPedido(int item, ArrayList<Oferta> p);
}
