
package InterfaceDao;

import Objetos.*;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Felipe-Isoppo
 */
public class DaoEstatico implements Dao {
    
    //DaoAF(String caminhoArquivo)
    DaoAF AF; 
    // configuração específica do DAO dump binário:
    String caminhoArquivo = "/Users/Felipe-Isoppo/Documents/Curso/dados.bin";
    
    String caminhoArquivoCaixa = "/Users/Felipe-Isoppo/Documents/Curso/caixa.bin";
    // variáveis para uso *** interno e temporário *** do DAO
    HashMap dados = new HashMap();
    // objetos estáticos, para que quaisquer instâncias do DAO acessem os mesmos dados
    static ArrayList<Cliente> pessoas = new ArrayList();
    static ArrayList<Staff> staffs = new ArrayList();
    static ArrayList<Cliente> clientes = new ArrayList();
    static ArrayList<Produto> cardapio= new ArrayList();
    static ArrayList<Atendimento> atendimentos= new ArrayList();
    static ArrayList<Atendimento> atendimentosAbertos= new ArrayList();
    static ArrayList<Atendimento> atendimentosEncerrado= new ArrayList();
    private Caixa caixa;
    private Servico entrega;

    public void EscreveDadosHashMap(){
        dados.clear();
        //inclui dados no objeto HashMap
        //dados.put("Pessoa", pessoas);
        dados.put("staff", staffs);
        dados.put("cliente", clientes);
        dados.put("produto", cardapio);
        dados.put("atendimento", atendimentos);
    }
    
    public void LeDadosHashMap(HashMap tmp){
        // retorna dados
        //pessoas = (ArrayList<Pessoa>) tmp.get("Pessoa");
        staffs = (ArrayList<Staff>) tmp.get("staff");
        clientes = (ArrayList<Cliente>) tmp.get("cliente");
        cardapio = (ArrayList<Produto>) tmp.get("produto");
        atendimentos = (ArrayList<Atendimento>) tmp.get("atendimento");
    }
    
    public void SalvaDadosEmArquivo(){
        //fazer um copia dos objetos no objeto "dados"
        EscreveDadosHashMap();
        //salva dados no arquivo
        AF.salvarDadosNoDisco(dados);
    }
    
    // inicialização do DAO: popular cadastros, se o arquivo não existir
    public DaoEstatico() {
        AF = new DaoAF(caminhoArquivo);
        Path path = Paths.get(caminhoArquivo);
        if (!Files.exists(path)) {
            popularDados();
            //fazer um copia dos objetos no objeto "dados"
            EscreveDadosHashMap();
            
            //salva dados no arquivo
            AF.salvarDadosNoDisco(dados);
        }else{
            //carreda os dados do arquivo para o objeto "dados"
            dados=AF.carregarDadosDoDisco();
            
            //atribui os dados à cada objeto statico contido no objeto "dados"
            LeDadosHashMap(dados);
        }
         
    }
    
    void popularDados() {
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
        entrega = new Servico(0, 8, "Entrega");
        
        //popular o cadastro de clientes Cliente( String nome, String cpf, String endereco, String telefone ) {
        clientes.add(new Cliente("Fabio Silva", "000.555.333-11", "Rua das Favas, 123", "99941-5510"));
        clientes.add(new Cliente("Aldo Jose", "100.666.333-12", "Rua das Flores, 001", "99941-4420"));
        clientes.add(new Cliente("Joana", "200.777.333-13", "Rua das Antas, 70", "99941-3330"));
        clientes.add(new Cliente("Maria", "300.888.333-14", "Rua das Abelhas, 12", "99941-2240"));
        clientes.add(new Cliente("Felipe", "051.940.435-11", "Rua Otto, 317", "99641-8081"));
        
        //popular o cadastro de funcionarios Staff( String nome, String cpf, String endereco, String telefone, String Funcao ) {
        staffs.add(new Staff("Fabio Silva", "000.555.333-11", "Rua das Favas, 123", "99941-5510", "Atendente"));
        
        MontaListaPessoa();
    }
    
    
    
    public void MontaListaPessoa(){
        pessoas.clear();
        for(int i=0; i<staffs.size();i++) {
        pessoas.add(staffs.get(i));}
        for(int i=0; i<clientes.size();i++) {
        pessoas.add(clientes.get(i));}
    }
  
    public void SalvaCaixa(Caixa a){
        this.caixa = a;
        DaoAF AFCaixa = new DaoAF(caminhoArquivoCaixa);
        HashMap dadosCaixa = new HashMap();
        dadosCaixa.put("Caixa", a);
        AFCaixa.salvarDadosNoDisco(dadosCaixa);
    }
    
    public Caixa ExtratoCaixa(){
        return this.caixa;
    }
    
    public void SalvaAtendimento(Atendimento p) {
        boolean atendimentoJaExiste = false;
        for (Atendimento atend : atendimentos){
            if (p.getidAtendimento().equals(atend.getidAtendimento()))
            atendimentoJaExiste = true;
        }
        if (!atendimentoJaExiste){
            this.atendimentos.add(p);
        }else{
            SubstituiAtendimento(p);
        }
        
        //salva dados no arquivo
        SalvaDadosEmArquivo();
    }
    
    public void SubstituiAtendimento(Atendimento p ) {
        String item = p.getidAtendimento();
        //remove o atendimento (conforme o id passado por parametro) da lista de atendimentos
        ArrayList<Atendimento> atendimentosTemp = new ArrayList();
        for (Atendimento aten : atendimentos){
            if(aten.getidAtendimento().equals(item)){
                atendimentosTemp.add(p);
            } else {
                atendimentosTemp.add(aten);
            }
        }
        this.atendimentos = atendimentosTemp;
        
        //atualiza a lista de atendimentos abertos
        ArrayList<Atendimento> abertos = new ArrayList();
        for (Atendimento aten : atendimentos){
            if(aten.getStatusAtendimento().equals("Fechado")){
            } else {
                abertos.add(aten);
            }
        }
        this.atendimentosAbertos = abertos; 
        
        //salva dados no arquivo
        SalvaDadosEmArquivo();
    }
    
    public Atendimento getAtendimento(String id) {
        Atendimento x= new Atendimento();
        for (Atendimento atend : atendimentos){
            if(atend.getidAtendimento().equals(id)){
            x= atend;
            }
        } 
        return x;
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
    
    public void removeAtendimento(String item) {
        
        //remove o atendimento (conforme o id passado por parametro) da lista de atendimentos
        ArrayList<Atendimento> atendimentosTemp = new ArrayList();
        for (Atendimento aten : atendimentos){
            if(aten.getidAtendimento().equals(item)){
            } else {
                atendimentosTemp.add(aten);
            }
        }
        this.atendimentos = atendimentosTemp;
        
        //atualiza a lista de atendimentos abertos
        ArrayList<Atendimento> abertos = new ArrayList();
        for (Atendimento aten : atendimentos){
            if(aten.getStatusAtendimento().equals("Fechado")){
            } else {
                abertos.add(aten);
            }
        }
        this.atendimentosAbertos = abertos; 
        
        //salva dados no arquivo
        SalvaDadosEmArquivo();
    }
    
    
    
    public String formataCPF(String cpf){
        String cpfNum = cpf.replace("-", "").replace(".", "");
        if (cpf.length()>10){
            cpf = (cpfNum.substring(0, 3) +"." + cpfNum.substring(3, 6) +"." + cpfNum.substring(6, 9) +"-"+ cpfNum.substring(9, 11));}
        return cpf;
    }
    
    public void SalvaStaff(Staff p){
        String cpf = formataCPF(p.getcpf());
        p.setcpf(cpf);
        int ondeMudar = -1;
        int i = 0;
        for (Staff f : staffs) {
            if (f.getcpf().equals(cpf)) {
                //se o funcionario ja estiver cadastrado retorna a posicao na lista
                ondeMudar=i;
            } 
            i++;
        }
        if (ondeMudar >= 0) {
            // atualiza cadastro de funcionario
            staffs.set(ondeMudar, p);
        }else{
            ///  cadastra novo funcionario
            staffs.add(p);
        }
        //salva dados no arquivo
        SalvaDadosEmArquivo();
    }
    
    
    
    /////////////////////////////
    public void SalvaPessoa(Cliente p) {
        String cpf = formataCPF(p.getcpf());
        //System.out.print(cpf);
        p.setcpf(cpf);
     //  cadastra pessoa
        
        if (!existePessoaPorCPF(cpf)) {
            // adicionar a nova pessoa
            adicionarPessoa(p);
        } else { // atualiza cadastro da pessoa
            atualizarPessoa(p);
            
        }
        //salva dados no arquivo
        SalvaDadosEmArquivo();
    }
    
        
    ///////////////////////////////
    public void adicionarPessoa(Cliente p) {
        clientes.add(p);
        //salva dados no arquivo
        SalvaDadosEmArquivo();
    }

  
    
    public Cliente buscarPessoaPorCPF(String cpf) {
        MontaListaPessoa();
        String cpfPesssaNum;      
        for (Cliente p : pessoas) {
            cpfPesssaNum = p.getcpf().replace("-", "").replace(".", "");;
            if (p.getcpf().equals(cpf)) {
                return p;
            } else {
                if ( cpfPesssaNum.equals(cpf) ){
                    return p;
                }
            }
        }
        return new Cliente("Nao Encontrado", cpf, "","");
    }
    
    public Staff buscarStaffPorCPF(String cpf) {
        String cpfPesssaNum;      
        for (Staff p : staffs) {
            cpfPesssaNum = p.getcpf().replace("-", "").replace(".", "");;
            if (p.getcpf().equals(cpf)) {
                return p;
            } else {
                if ( cpfPesssaNum.equals(cpf) ){
                    return p;
                }
            }
        }
        return new Staff("Nao Encontrado", formataCPF(cpf), "","","");
    }
    
   
    public boolean existePessoaPorCPF(String cpf) {
        MontaListaPessoa();
        // busca a pessoa pelo nome
        for (Cliente p : pessoas) {
            if (p.getcpf().equals(cpf)) {
                return true;
            }
        }
        // não achou? retorna falso
        return false;
    }
    
    
    ///////////////////////////////////
    public void atualizarPessoa(Cliente p) {
        // sinaliza que será feita uma busca
        int ondeMudar = -1;
        // busca a pessoa pelo nome
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getcpf().equals(p.getcpf())) {
                ondeMudar = i;
                break;
            }
        }
        // se achou a pessoa pra mudar
        if (ondeMudar >= 0) {
            if( p instanceof Staff ){
                SalvaStaff((Staff)p);
            }else{
                clientes.set(ondeMudar, p);
            }
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
        p.setQtda(p.getQtda() - quantidade);
        cardapio.add(item, p);
        
        //salva dados no arquivo
        SalvaDadosEmArquivo();
    }
    //public void setItemPedido(Produto d){pedido.add(d);}
    
    
    
    
    @Override
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
