
package tela;

import javax.swing.DefaultListModel;
import InterfaceDao.*;
//import DaoDinamico.Dao;
import Objetos.*;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * @author Felipe-Isoppo
 */
public class Tela03_Atendimento extends javax.swing.JDialog {
    
    // instância de acesso aos dados (vínculo feito pela janela filho)
    public Dao dao;
    
    // referência à janela pai (vínculo feito pela janela pai)
    public Tela02_RegistroAtendimento filho;
    
    public Tela01_Inicial filho1;
    
    public Atendimento atendimento; // = new Atendimento(filho.at);
    
    int item = 0;
    int itemtela = 1;
    ArrayList<Produto> pedido= new ArrayList();
    boolean ApenasCadastroPessoas = false;
    boolean ApenasCadastroStaff = false;
    /**
     * Creates new form Tela03_Atendimento
     */
    public Tela03_Atendimento(java.awt.Frame parent, boolean modal, Atendimento at, Dao dao, boolean editar) {
        super(parent, modal);
        this.dao = dao;
        this.atendimento = at;
        initComponents();
        
        //mostra o numero do pedido (ID)
        jLabel9.setText(String.valueOf(atendimento.getidAtendimento()));
        
        //inicia o atendimento selecionada a opcao de retirar produto no Balcao 
        checkBoxRetirarNoBalcao.setSelected(true);
        
        //mostra o nome do atendente no formulario de pedidos
        jLabel10.setText(atendimento.getAtendente().getNome());
        
        // desabilita as funcoes de registro do pedido
            btAtribuirClienteAoPedido.setEnabled(false);
            listPedido.setEnabled(false);
            btCancelarItem.setEnabled(false);
            btConlcuirAtendimento.setEnabled(false);
            comboBoxCardapio.setEnabled(false);
            comboBoxQtd.setEnabled(false);
            btIncluirItemAoPedido.setEnabled(false);
            jPanel2.setEnabled(false);
            jPanel5.setEnabled(false);
            checkBoxRetirarNoBalcao.setEnabled(false);
            checkBoxDelivery.setEnabled(false);
        
        // localiza a janela no centro do monitor
        setLocationRelativeTo(null);
        // carrega o cardapio no combo box
        carregarCardapioNaLista(); 
        
        //cria uma lista vazia para adicionar os itens do pedido
        listPedido.setModel(new DefaultListModel());
        if (editar) {
            carregarDadosPedidoNaTela(at);
        }
        
        //verifica se o acesso é apenas para cadastro de pessoas via tela inicial
        if (atendimento.getAtendente().getNome().equals("")){
            //verifica se o acesso é apenas para cadastro de funcionarios via tela inicial
            Staff x = (Staff)atendimento.getAtendente();
            if (x.getFuncao().equals("cadastro")){
                //System.out.print(x.getFuncao());
                ApenasCadastroStaff=true;
                habilitarTelaCadastroStaff();
            }else {
                ApenasCadastroPessoas=true;
                habilitarTelaCadastroClientes();
            }
        }
        //verifica se o acesso é apenas para cadastro de funcionarios via tela inicial
        if (atendimento.getAtendente().getNome().equals("cadastro")){
            ApenasCadastroStaff=true;
            habilitarTelaCadastroStaff();
        }
        
    }
    
    public void habilitarTelaCadastroStaff(){
        btAtribuirClienteAoPedido.setEnabled(false);
        
        listPedido.setEnabled(false);
        btCancelarItem.setEnabled(false);
        btConlcuirAtendimento.setEnabled(false);
        comboBoxCardapio.setEnabled(false);
        comboBoxQtd.setEnabled(false);
        btIncluirItemAoPedido.setEnabled(false);
        jPanel2.setEnabled(false);
        jPanel5.setEnabled(false);
        checkBoxRetirarNoBalcao.setEnabled(false);
        checkBoxDelivery.setEnabled(false);
        textObs.setEnabled(true);
        jLObs.setEnabled(true);
        jLObs.setText("Cargo/funcao:");
        
              
    }
    
    public void habilitarTelaCadastroClientes(){
        btAtribuirClienteAoPedido.setEnabled(false);
        
        listPedido.setEnabled(false);
        btCancelarItem.setEnabled(false);
        btConlcuirAtendimento.setEnabled(false);
        comboBoxCardapio.setEnabled(false);
        comboBoxQtd.setEnabled(false);
        btIncluirItemAoPedido.setEnabled(false);
        jPanel2.setEnabled(false);
        jPanel5.setEnabled(false);
        checkBoxRetirarNoBalcao.setEnabled(false);
        checkBoxDelivery.setEnabled(false);
        textObs.setEnabled(false);
        jLObs.setEnabled(false);
        
        
    }
    
    public void carregarDadosFormulario (Cliente c){
        Cliente buscaPessoa = c;
        // mostra na tele os dados do cpf buscado
        textNome.setText(buscaPessoa.getNome());
        textCpf.setText(buscaPessoa.getcpf());
        textAreaEndereco.setText(buscaPessoa.getEndereco());
        textFone.setText(buscaPessoa.getTelefone());
    }
    
    public void carregarDadosPedidoNaTela (Atendimento a){
        this.atendimento=a;
        this.pedido=a.getPedido();
        Cliente buscaPessoa = dao.buscarPessoaPorCPF(a.getCliente().getcpf());
        carregarDadosFormulario(buscaPessoa);
        btAtribuirClienteAoPedido.setEnabled(true);
   
        
        //mostra na tela de detalhes do pedido
        jLabel12.setText(buscaPessoa.getcpf()+"-"+buscaPessoa.getNome());
        jLabel13.setText(buscaPessoa.getEndereco());
        
        jLabel11.setText(a.getDataAtendimento());
        if (checkBoxRetirarNoBalcao.isSelected()){
            jLabel14.setText("Retirar no Balcao");
        } else 
        { jLabel14.setText("Entrega Motoboy");
        }
        
        
        // habilita as funcoes de registro do pedido
        listPedido.setEnabled(true);
        btCancelarItem.setEnabled(true);
        btConlcuirAtendimento.setEnabled(true);
        comboBoxCardapio.setEnabled(true);
        comboBoxQtd.setEnabled(true);
        btIncluirItemAoPedido.setEnabled(true);
        jPanel2.setEnabled(true);
        jPanel5.setEnabled(true);
        checkBoxRetirarNoBalcao.setEnabled(true);
        checkBoxDelivery.setEnabled(true);
        
        
        //mostra os itens do pedido
        
        //cria uma lista temporaria
        DefaultListModel tmp = (DefaultListModel) listPedido.getModel();
        for (Produto prod : atendimento.getPedido()){
            item = prod.getItem();
            // adiciona no fim na lista auxiliar
            String x = String.format("%2d %-50s %-5s %10.2f", item, prod.getDescricao(), prod.getQtda(), prod.getPreco());
            tmp.add(tmp.getSize(), x);
            // reconfigurar itens da lista (inclui lista temporaria na tela)
            listPedido.setModel(tmp);
            
        } 
        
        itemtela = item+1;
    }
    
    public Atendimento getAtendimento(){return atendimento;}
    
    public void carregarCardapioNaLista() {
        // limpa itens
        comboBoxCardapio.removeAllItems();
        // preenche os livros
        for (Produto produtos : dao.retornarCardapio()) {
            comboBoxCardapio.addItem(produtos.getDescricao());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLCpf = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jLFone = new javax.swing.JLabel();
        jLEndereco = new javax.swing.JLabel();
        jLObs = new javax.swing.JLabel();
        btSalvarPessoa = new javax.swing.JButton();
        btBuscarPessoa = new javax.swing.JButton();
        textCpf = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        textFone = new javax.swing.JTextField();
        textObs = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaEndereco = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listPedido = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLFuncionario = new javax.swing.JLabel();
        jLData = new javax.swing.JLabel();
        btCancelarItem = new javax.swing.JButton();
        jLCliente = new javax.swing.JLabel();
        btConlcuirAtendimento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btAtribuirClienteAoPedido = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxCardapio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboBoxQtd = new javax.swing.JComboBox<>();
        btIncluirItemAoPedido = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        checkBoxRetirarNoBalcao = new javax.swing.JCheckBox();
        checkBoxDelivery = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Pessoas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N

        jLCpf.setText("CPF:");

        jLNome.setText("Nome:");

        jLFone.setText("Fone:");

        jLEndereco.setText("Endereço:");

        jLObs.setText("Observação:");

        btSalvarPessoa.setText("Salvar");
        btSalvarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarPessoaActionPerformed(evt);
            }
        });

        btBuscarPessoa.setText("Buscar");
        btBuscarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPessoaActionPerformed(evt);
            }
        });

        textCpf.setText("05194043511");

        textAreaEndereco.setColumns(20);
        textAreaEndereco.setRows(5);
        jScrollPane1.setViewportView(textAreaEndereco);

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCpf)
                            .addComponent(jLNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCpf)
                            .addComponent(textNome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLFone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLEndereco)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textObs))))
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalvarPessoa)
                .addGap(32, 32, 32)
                .addComponent(btBuscarPessoa)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCpf)
                    .addComponent(textCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLFone)
                    .addComponent(textFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLObs)
                    .addComponent(textObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvarPessoa)
                    .addComponent(btBuscarPessoa)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro do Atendimento"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do Pedido"));

        listPedido.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listPedido);

        jLabel4.setText("Item:");

        jLabel5.setText("Descrição:");

        jLabel6.setText("Quantidade:");

        jLabel7.setText("Valor( R$ ):");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLFuncionario.setText("Atendente:");

        jLData.setText("Data:");

        btCancelarItem.setBackground(new java.awt.Color(255, 255, 255));
        btCancelarItem.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btCancelarItem.setText("Cancelar Item Selecionado");
        btCancelarItem.setActionCommand("");
        btCancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarItemActionPerformed(evt);
            }
        });

        jLCliente.setText("Cliente:");

        btConlcuirAtendimento.setBackground(new java.awt.Color(255, 255, 255));
        btConlcuirAtendimento.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btConlcuirAtendimento.setText("Concluir Atendimeto");
        btConlcuirAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConlcuirAtendimentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Endereço:");

        jLabel8.setText("ID:");

        jLabel10.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btCancelarItem)
                                .addGap(28, 28, 28)
                                .addComponent(btConlcuirAtendimento, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(95, 95, 95)
                        .addComponent(jLData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLFuncionario)
                    .addComponent(jLabel9)
                    .addComponent(jLData)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCliente)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelarItem)
                    .addComponent(btConlcuirAtendimento)))
        );

        btConlcuirAtendimento.getAccessibleContext().setAccessibleDescription("");

        btAtribuirClienteAoPedido.setBackground(new java.awt.Color(255, 255, 255));
        btAtribuirClienteAoPedido.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btAtribuirClienteAoPedido.setText("=>");
        btAtribuirClienteAoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtribuirClienteAoPedidoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cardápio"));

        jLabel1.setText("Item:");

        comboBoxCardapio.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxCardapio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Qtd.:");

        comboBoxQtd.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxQtd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        btIncluirItemAoPedido.setBackground(new java.awt.Color(255, 255, 255));
        btIncluirItemAoPedido.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btIncluirItemAoPedido.setText("Incluir Item ao Pedido");
        btIncluirItemAoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirItemAoPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxCardapio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btIncluirItemAoPedido)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btIncluirItemAoPedido)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Serviço"));

        checkBoxRetirarNoBalcao.setText("Retirar no Balcão");
        checkBoxRetirarNoBalcao.setRolloverEnabled(true);
        checkBoxRetirarNoBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRetirarNoBalcaoActionPerformed(evt);
            }
        });

        checkBoxDelivery.setText("Delivery");
        checkBoxDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxRetirarNoBalcao)
                    .addComponent(checkBoxDelivery))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxRetirarNoBalcao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDelivery)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtribuirClienteAoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btAtribuirClienteAoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    this.dispose(); //retorna para a tela anterior e deve solicitar para fechar o caixa
    }//GEN-LAST:event_formWindowClosing

    private void btIncluirItemAoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirItemAoPedidoActionPerformed
        // buscar nome do item selecionado
        String produtoSelecionado = comboBoxCardapio.getSelectedItem().toString();
        // buscar quantidade do item selecionado
        int quantidadeSelecionada = Integer.parseInt(comboBoxQtd.getSelectedItem().toString(),10);

        //procura o produto no cardapio que possui a mesma descricao do item selecionado no combobox
        Produto prod = dao.buscarProduto(produtoSelecionado);
        
        //guarda o numero de ref do produto do cardapio;
        int itemMenu = prod.getItem();
        
        //altera a quantidade do estoque no Cardapio
        dao.retiraItemDoEstoque(itemMenu, quantidadeSelecionada);
        
        //cria uma lista temporaria
        DefaultListModel tmp = (DefaultListModel) listPedido.getModel();
        // adiciona no fim na lista auxiliar
        String x = String.format("%2d %-50s %-5s %10.2f", itemtela, produtoSelecionado, quantidadeSelecionada, prod.getPreco());
        tmp.add(tmp.getSize(), x);
        // reconfigurar itens da lista (inclui lista temporaria na tela)
        listPedido.setModel(tmp);
        
        //altera o valor do item para coincidir com o item do pedido e altera a quantidade, conforme pedido
        Produto oProd = new Produto(item+1, prod.getPreco(), prod.getDescricao(),
                quantidadeSelecionada ,quantidadeSelecionada ,prod.getUnidade() );
        
        //System.out.println(""+oProd.getItem()+ " "+oProd.getDescricao() + " Subtotal:" + oProd.getPreco());
        
        pedido.add(oProd);
        /*
        for (Oferta p : pedido){
            System.out.println(""+p.getItem()+ " "+p.getDescricao() + " Subtotal:" + p.getPreco());
        }*/
 
        //incrementa os itens do pedido
        item++;
        itemtela++;
        
        
    }//GEN-LAST:event_btIncluirItemAoPedidoActionPerformed

    private void btCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarItemActionPerformed
        //identifica o item selecionado
        int posi = listPedido.getSelectedIndex();
        // criar lista auxiliar
        DefaultListModel tmp = (DefaultListModel) listPedido.getModel();
        // remove item selecionado da lista auxiliar
        tmp.remove(posi);
        // reconfigurar itens da lista (coloca lista auxiliar na tela)
        listPedido.setModel(tmp);
        
        //remove o item selecionado do arrayList pedido
        pedido = dao.removeItemPedido(posi, pedido);

        /*
        for (Oferta p : pedido){
            System.out.println(""+p.getItem()+ " "+p.getDescricao() + " Subtotal:" + p.getPreco());
        }*/
        item--;
        
    }//GEN-LAST:event_btCancelarItemActionPerformed

    private void btSalvarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarPessoaActionPerformed
       
        // cria a nova pessoa
        Pessoa novaPessoa;
       
        if (textCpf.getText().equals("")){   
          // nao salva, nao faz nada.
          jLabel15.setText("Necessário Cadastrar CPF");
        }else {
            if (textObs.getText().equals("")){
                
                if (!ApenasCadastroStaff) {
                    novaPessoa = (Cliente)new Cliente(textNome.getText(), textCpf.getText(),  textAreaEndereco.getText(), textFone.getText());
                    dao.SalvaPessoa(novaPessoa);
                    if (!ApenasCadastroPessoas) {
                        btAtribuirClienteAoPedido.setEnabled(true);
                    } else {
                        this.dispose();
                    }
                }else{
                    jLabel15.setText("Defina uma Função");
                }
            }else{
                Staff funcionario = new Staff(textNome.getText(), textCpf.getText(),  textAreaEndereco.getText(), textFone.getText(), textObs.getText());   
                dao.SalvaStaff(funcionario);
                dao.SalvaPessoa(funcionario);
                if (!ApenasCadastroStaff) {
                    btAtribuirClienteAoPedido.setEnabled(true);
                }else {
                    this.dispose();
                }
            }  
        }
        
    }//GEN-LAST:event_btSalvarPessoaActionPerformed

    private void btBuscarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPessoaActionPerformed
        
        if (ApenasCadastroStaff){
            Staff buscaPessoa = dao.buscarStaffPorCPF(textCpf.getText());
            carregarDadosFormulario(buscaPessoa);
            textObs.setText(buscaPessoa.getFuncao());  
            
        }else{
        Cliente buscaPessoa = dao.buscarPessoaPorCPF(textCpf.getText());
        // mostra na tele os dados do cpf buscado
        carregarDadosFormulario(buscaPessoa);
        /*
        textNome.setText(buscaPessoa.getNome());
        textCpf.setText(buscaPessoa.getcpf());
        textAreaEndereco.setText(buscaPessoa.getEndereco());
        textFone.setText(buscaPessoa.getTelefone());
        */
        
        //se o cpf nao for encontrado desabilita os botoes de registro de pedidos
        if (textNome.getText().equals("Nao Encontrado")){ 
            btAtribuirClienteAoPedido.setEnabled(false);
            listPedido.setEnabled(false);
            btCancelarItem.setEnabled(false);
            btConlcuirAtendimento.setEnabled(false);
            comboBoxCardapio.setEnabled(false);
            comboBoxQtd.setEnabled(false);
            btIncluirItemAoPedido.setEnabled(false);
            jPanel2.setEnabled(false);
            jPanel5.setEnabled(false);
            checkBoxRetirarNoBalcao.setEnabled(false);
            checkBoxDelivery.setEnabled(false);
        }else{
            // se o cpf for encontrado habilita o botao de incluir dados do cliente no pedido
            if (!ApenasCadastroPessoas) {
                btAtribuirClienteAoPedido.setEnabled(true);
            }
        }
        }
        
    }//GEN-LAST:event_btBuscarPessoaActionPerformed

    private void btAtribuirClienteAoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtribuirClienteAoPedidoActionPerformed
        //atribui os dados da janela ao objeto Atendimento
        atendimento.setCliente(new Cliente(textNome.getText(),textCpf.getText(),textAreaEndereco.getText(), textFone.getText()));
       
        //mostra na tela de detalhes do pedido
        jLabel12.setText(textCpf.getText()+"-"+textNome.getText());
        jLabel13.setText(textAreaEndereco.getText());
        //Date data = new Date(System.currentTimeMillis());
        jLabel11.setText(atendimento.getDataAtendimento());
        if (checkBoxRetirarNoBalcao.isSelected()){
            jLabel14.setText("Retirar no Balcao");
        } else 
        { jLabel14.setText("Entrega Motoboy");
        }
        
        // habilita as funcoes de registro do pedido
        listPedido.setEnabled(true);
        btCancelarItem.setEnabled(true);
        btConlcuirAtendimento.setEnabled(true);
        comboBoxCardapio.setEnabled(true);
        comboBoxQtd.setEnabled(true);
        btIncluirItemAoPedido.setEnabled(true);
        jPanel2.setEnabled(true);
        jPanel5.setEnabled(true);
        checkBoxRetirarNoBalcao.setEnabled(true);
        checkBoxDelivery.setEnabled(true);
        
        
        
    }//GEN-LAST:event_btAtribuirClienteAoPedidoActionPerformed

    private void checkBoxRetirarNoBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRetirarNoBalcaoActionPerformed
        checkBoxDelivery.setSelected(false);
        jLabel14.setText("Retirar no Balcao");

    }//GEN-LAST:event_checkBoxRetirarNoBalcaoActionPerformed

    private void checkBoxDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDeliveryActionPerformed
        checkBoxRetirarNoBalcao.setSelected(false);
        jLabel14.setText("Entrega Motoboy");
        
    }//GEN-LAST:event_checkBoxDeliveryActionPerformed

    private void btConlcuirAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConlcuirAtendimentoActionPerformed
        atendimento.setPedido(pedido);
        //salva este atendimento na lista de atendimentos do dao
        dao.SalvaAtendimento(atendimento);
        //atuliza a lista de Atendimentos na tela2
        filho.AtualizaListPedido(dao.getAtendimentosAbertos());
        
        this.dispose(); //retorna para a tela anterior e deve solicitar para fechar o caixa
        
        //atendimento.setPedido(pedido);
        
        
        
    }//GEN-LAST:event_btConlcuirAtendimentoActionPerformed

    /*public static void main(String args[]) {
     
    
        // Create and display the dialog 
    Atendimento att = new Atendimento();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela03_Atendimento(new javax.swing.JFrame(), true, att).setVisible(true);
                 
                
               
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtribuirClienteAoPedido;
    private javax.swing.JButton btBuscarPessoa;
    private javax.swing.JButton btCancelarItem;
    private javax.swing.JButton btConlcuirAtendimento;
    private javax.swing.JButton btIncluirItemAoPedido;
    private javax.swing.JButton btSalvarPessoa;
    private javax.swing.JCheckBox checkBoxDelivery;
    private javax.swing.JCheckBox checkBoxRetirarNoBalcao;
    private javax.swing.JComboBox<String> comboBoxCardapio;
    private javax.swing.JComboBox<String> comboBoxQtd;
    private javax.swing.JLabel jLCliente;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLFone;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLObs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listPedido;
    private javax.swing.JTextArea textAreaEndereco;
    private javax.swing.JTextField textCpf;
    private javax.swing.JTextField textFone;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textObs;
    // End of variables declaration//GEN-END:variables
}
