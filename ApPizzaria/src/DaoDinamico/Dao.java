
package DaoDinamico;

import java.util.ArrayList;
import Objetos.*;

/**
 * @author Felipe-Isoppo
 */
public class Dao {
    
    // objetos estáticos, para que quaisquer instâncias do DAO
    // acessem os mesmos dados
    static ArrayList<Pessoa> pessoas = new ArrayList();
    static ArrayList<Staff> staffs = new ArrayList();
    static ArrayList<Cliente> clientes = new ArrayList();
    static ArrayList<Produto> cardapio= new ArrayList();
    static ArrayList<Atendimento> atendimentos= new ArrayList();
    static ArrayList<Atendimento> atendimentosAbertos= new ArrayList();
    static ArrayList<Atendimento> atendimentosEncerrado= new ArrayList();
    
    public Dao() {
        //popular o cardápio Produto(float preco, String descricao, float quantidade, String unidade)
        cardapio.add(new Produto(1, 10, "Coca Cola 2l", 20, "unid"));
        cardapio.add(new Produto(2, 5, "Coca Cola 600ml", 20, "unid"));
        cardapio.add(new Produto(3, 4, "Coca Cola lata", 20, "unid"));
        cardapio.add(new Produto(4, 15, "Pizza Marguerita Pequena", 20, "unid"));
        cardapio.add(new Produto(5, 20, "Pizza Marguerita Media", 20, "unid"));
        cardapio.add(new Produto(6, 30, "Pizza Marguerita Grande", 20, "unid"));
        cardapio.add(new Produto(7, 17, "Pizza Peperone Pequena", 20, "unid"));
        cardapio.add(new Produto(8, 23, "Pizza Peperone Media", 20, "unid"));
        cardapio.add(new Produto(9, 33, "Pizza Peperone Grande", 20, "unid"));
        cardapio.add(new Produto(10, 13, "Pizza Quatro Queijos Pequena", 20, "unid"));
        cardapio.add(new Produto(11, 18, "Pizza Quatro Queijos Media", 20, "unid"));
        cardapio.add(new Produto(12, 27, "Pizza Quatro Queijos Grande", 20, "unid"));
        
        //popular o cadastro de clientes Cliente( String nome, String cpf, String endereco, String telefone ) {
        clientes.add(new Cliente("Fabio Silva", "000.555.333-11", "Rua das Favas, 123", "99941-5510"));
        clientes.add(new Cliente("Aldo Jose", "100.666.333-12", "Rua das Flores, 001", "99941-4420"));
        clientes.add(new Cliente("Joana", "200.777.333-13", "Rua das Antas, 70", "99941-3330"));
        clientes.add(new Cliente("Maria", "300.888.333-14", "Rua das Abelhas, 12", "99941-2240"));
        clientes.add(new Cliente("Felipe", "051.940.435-11", "Rua Otto, 317", "99641-8081"));
        
        //popular o cadastro de funcionarios Staff( String nome, String cpf, String endereco, String telefone, String Funcao ) {
        staffs.add(new Staff("Fabio Silva", "000.555.333-11", "Rua das Favas, 123", "99941-5510", "Atendente"));
        
        //public void MontaPessoas() {
        for(int i=0; i<staffs.size();i++) {
        pessoas.add(staffs.get(i));}
        for(int i=0; i<clientes.size();i++) {
        pessoas.add(clientes.get(i));}
    }
    
    /**
    // manipulação de pessoas
    //public ArrayList<Pessoa> retornarPessoas() {
    public void MontaPessoas() {
        for(int i=0; i<staffs.size();i++) {
        pessoas.add(staffs.get(i));}
        for(int i=0; i<clientes.size();i++) {
        pessoas.add(clientes.get(i));}
        
        //return pessoas;
    }
    */
    public void SalvaAtendimento(Atendimento p) {
        this.atendimentos.add(p);
    }
    
    public ArrayList<Atendimento> getAtendimentos() {
         return atendimentos;
    }
    
    public ArrayList<Atendimento> getAtendimentosAbertos() {
        ArrayList<Atendimento> abertos = new ArrayList();
        for (Atendimento aten : atendimentos){
            if(aten.getStatusAtendimento().equals("Fechado")){
            } else {
                abertos.add(aten);
            }
        }
        this.atendimentosAbertos = abertos;
         return abertos;
    }
    
    public ArrayList<Atendimento> getAtendimentosEncerrado() {
        ArrayList<Atendimento> fechado = new ArrayList();
        for (Atendimento aten : atendimentos){
            if(aten.getStatusAtendimento().equals("Fechado")){
            fechado.add(aten);
            }
        }
        this.atendimentosEncerrado = fechado;
         return fechado;
    }
    
    
    public void SalvaPessoa(Pessoa p) {
        String cpf = p.getcpf();
        String cpfNum = cpf.replace("-", "").replace(".", "");
        cpf = (cpfNum.substring(0, 3) +"." + cpfNum.substring(3, 6) +"." + cpfNum.substring(6, 9) +"-"+ cpfNum.substring(9, 11));
        p.setcpf(cpf);
     //  cadastra pessoa
        if (!existePessoaPorCPF(cpf)) {
            // adicionar a nova pessoa
            adicionarPessoa(p);
        } else { // atualiza cadastro da pessoa
            atualizarPessoa(p);
            
        }
    }
    
        
    
    public void adicionarPessoa(Pessoa p) {
        pessoas.add(p);
    }

    /**
    public Pessoa retornarPessoaAcessoAbsoluto(int i) {
        return pessoas.get(i);
    }

    public int retornarQuantidadeDePessoas() {
        return pessoas.size();
    }**/
    
    public Cliente buscarPessoaPorCPF(String cpf) {
        
        String cpfPesssaNum;      
        for (Pessoa p : pessoas) {
            cpfPesssaNum = p.getcpf().replace("-", "").replace(".", "");;
            if (p.getcpf().equals(cpf)) {
                return (Cliente)p;
            } else {
                if ( cpfPesssaNum.equals(cpf) ){
                    return (Cliente)p;
                }
            }
        }
        return new Cliente("Nao Encontrado", cpf, "","");
    }
    
    public Staff buscarStaffPorCPF(String cpf) {
        String cpfPesssaNum;      
        for (Pessoa p : staffs) {
            cpfPesssaNum = p.getcpf().replace("-", "").replace(".", "");;
            if (p.getcpf().equals(cpf)) {
                return (Staff)p;
            } else {
                if ( cpfPesssaNum.equals(cpf) ){
                    return (Staff)p;
                }
            }
        }
        return new Staff("Nao Encontrado", cpf, "","","");
    }
    
    public boolean existePessoaPorNome(String nomeProcurado) {
        // busca a pessoa pelo nome
        for (Pessoa p : pessoas) {
            if (p.getNome().equals(nomeProcurado)) {
                return true;
            }
        }
        // não achou? retorna falso
        return false;
    }
        
    public boolean existePessoaPorCPF(String cpf) {
        // busca a pessoa pelo nome
        for (Pessoa p : pessoas) {
            if (p.getcpf().equals(cpf)) {
                return true;
            }
        }
        // não achou? retorna falso
        return false;
    }
    
    public void atualizarPessoa(Pessoa p) {
        // sinaliza que será feita uma busca
        int ondeMudar = -1;
        // busca a pessoa pelo nome
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getcpf().equals(p.getcpf())) {
                ondeMudar = i;
                break;
            }
        }
        // se achou a pessoa pra mudar
        if (ondeMudar >= 0) {
            pessoas.set(ondeMudar, p);
            
            
        }
    }
    
    public ArrayList<Produto> retornarCardapio() {
        return cardapio;
    }
    
    public Produto buscarProduto(String produto) {
        for (Produto p : cardapio) {
            if (p.getDescricao().equals(produto)) {
                return p;
            }
        }
        return new Produto(0, 0, "nao encontrado", 0 , "u" );
    }
    
    public void retiraItemDoEstoque(int item, int quantidade) {
        Produto p = new Produto(cardapio.get(item));
        p.setQuantidade(p.getQuantidade() - (float)quantidade);
        cardapio.add(item, p);

    }
    
    public ArrayList<Oferta> removeItemPedido(int item, ArrayList<Oferta> p) {
        ArrayList<Oferta> pedido = new ArrayList();
        for (int i=0; i<item; i++){
        Produto prod = new Produto((Produto)p.get(i));
        pedido.add(prod);
        }
        for (int i=item+1; i<p.size(); i++){
        Produto prod = new Produto((Produto)p.get(i));
        prod.setItem(i);
        pedido.add(prod);
        }
        return pedido;
    }
    
}
