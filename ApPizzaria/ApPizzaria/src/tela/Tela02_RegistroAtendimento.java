
package tela;
import Objetos.*;
import InterfaceDao.*;
//import DaoDinamico.Dao;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * @author Felipe-Isoppo
 */
public class Tela02_RegistroAtendimento extends javax.swing.JFrame {
    
    /**
     * Creates new form Tela02_RegistroAtendimento
     */
    
        // instância de acesso aos dados (vínculo feito pela janela pai)
    public Dao dao;
    // Dao dao = new Dao();
    // referência à janela pai (vínculo feito pela janela pai)
    public Tela01_Inicial papai;
    
    //registro de atendimentos do dao
    //ArrayList<Atendimento> atendimentosDao;  //= dao.getAtendimentos();
    
    // contador inicial de atendimentos do caixa, re-inicia a contagem em 1 toda
    // vez que o caixa é iniciado.
    int idAtendimento=1;
    
    // inicia o registro de atendimentos do caixa
    //ArrayList<Atendimento> atendimentos = new ArrayList();
    Atendimento at;
   
    Staff atendente;
    
    public Tela02_RegistroAtendimento(java.awt.Frame parent, boolean modal, Dao dao) {
        //super(parent, modal);
        this.dao=dao;
        //atendimentosDao = dao.getAtendimentos();
        initComponents();
        setLocationRelativeTo(null);
        jPanel2.setEnabled(false);
        jPanel3.setEnabled(false);
        btCadastrarPedido.setEnabled(false);
        btFecharCaixa.setEnabled(false);
        textAreaDetalhePedido.setEnabled(false);
        bradioPedidiosFechados.setEnabled(false);
        bradioPedidiosAbertos.setEnabled(false);
        listaDePedidos.setEnabled(false);
        btEditarPedido.setEnabled(false);
        btCancelarPedido.setEnabled(false);
        //cria uma lista vazia para adicionar os itens do pedido
        listaDePedidos.setModel(new DefaultListModel());
        
        bradioPedidiosAbertos.setSelected(true);
        bradioPedidiosFechados.setSelected(false);
       
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void AtualizaListPedido(ArrayList<Atendimento> atendimentos){
        
        //atendimentosDao = dao.getAtendimentos();
        //Atendimento atendido = dao.getAtendimentos().get(atendimentos.size()-1);
        //Atendimento atendido = atendimentosDao.get(0);
        if (bradioPedidiosFechados.isSelected()) {
            atendimentos = dao.getAtendimentosEncerrado();
        }
        
        
        //cria uma lista vazia para adicionar os itens do pedido
        listaDePedidos.setModel(new DefaultListModel());
        for (Atendimento aten : atendimentos){
            //cria uma lista temporaria
            DefaultListModel tmp = (DefaultListModel) listaDePedidos.getModel();
        
            // adiciona no fim na lista auxiliar
            String x = String.format("%2s - %-10s", aten.getidAtendimento(), aten.getCliente().getNome());
            tmp.add(tmp.getSize(), x);
            // reconfigurar itens da lista (inclui lista temporaria na tela)
            listaDePedidos.setModel(tmp);
        }
        
        /*
        System.out.println(""+at.getidAtendimento()+ " Cliente: "+at.getCliente() + " hora:" + at.getDataAtendimento());
        for (Atendimento p : atendimentosDao){
            System.out.println(""+p.getidAtendimento()+ " Cliente: "+p.getCliente() + " hora:" + p.getDataAtendimento());
        }*/
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btCadastrarPedido = new javax.swing.JButton();
        btFecharCaixa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bradioPedidiosAbertos = new javax.swing.JRadioButton();
        bradioPedidiosFechados = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDePedidos = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaDetalhePedido = new javax.swing.JTextArea();
        jScrollBar2 = new javax.swing.JScrollBar();
        btEditarPedido = new javax.swing.JButton();
        btCancelarPedido = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        textCpf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btLoginOk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setTitle("Registro de Pedidos");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Caixa"), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N

        btCadastrarPedido.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btCadastrarPedido.setText("Cadastrar Pedido");
        btCadastrarPedido.setName(""); // NOI18N
        btCadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarPedidoActionPerformed(evt);
            }
        });

        btFecharCaixa.setText("Fechar o Caixa");
        btFecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFecharCaixa)
                    .addComponent(btCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N

        bradioPedidiosAbertos.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        bradioPedidiosAbertos.setText("Pedidos Abertos");
        bradioPedidiosAbertos.setToolTipText("");
        bradioPedidiosAbertos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bradioPedidiosAbertosActionPerformed(evt);
            }
        });

        bradioPedidiosFechados.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        bradioPedidiosFechados.setText("Pedidos Fechados");
        bradioPedidiosFechados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bradioPedidiosFechadosActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        listaDePedidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        listaDePedidos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaDePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listaDePedidosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listaDePedidos);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Detalhe do Pedido Selecionado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textAreaDetalhePedido.setColumns(20);
        textAreaDetalhePedido.setRows(5);
        jScrollPane2.setViewportView(textAreaDetalhePedido);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );

        jScrollBar2.getAccessibleContext().setAccessibleParent(jScrollPane2);

        btEditarPedido.setText("Editar Pedido");
        btEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarPedidoActionPerformed(evt);
            }
        });

        btCancelarPedido.setText("Cancelar Pedido");
        btCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btEditarPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelarPedido))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(2, 2, 2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bradioPedidiosAbertos)
                        .addGap(36, 36, 36)
                        .addComponent(bradioPedidiosFechados)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bradioPedidiosAbertos)
                    .addComponent(bradioPedidiosFechados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelarPedido)
                            .addComponent(btEditarPedido))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Autenticação de funcionario"));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Login:");

        jPasswordField1.setText("jPasswordField1");

        textCpf.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        textCpf.setText("00055533311");
        textCpf.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Senha:");

        btLoginOk.setText("OK");
        btLoginOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btLoginOk)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btLoginOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharCaixaActionPerformed
        //atendimentosDao = dao.getAtendimentos();
        papai.caixa= new Caixa(dao.getAtendimentos());
        dao.SalvaCaixa(papai.caixa);
        //System.out.print("" +papai.caixa.getValorFaturado());
        this.dispose(); //retorna para a tela anterior e deve solicitar para fechar o caixa
    }//GEN-LAST:event_btFecharCaixaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose(); // se clicar em fechar janela, retorna para a tela anterior e deve solicitar para fechar o caixa
    }//GEN-LAST:event_formWindowClosing

    private void btCadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarPedidoActionPerformed
       
        at = new Atendimento(idAtendimento,atendente);
         // criar nova instância da tela 3
        Tela03_Atendimento tela3 = new Tela03_Atendimento(new javax.swing.JFrame(), true, at, dao,false);
        // associar o DAO da tela3 ao DAO desta janela(tela2) 
        this.dao = tela3.dao;
        // associar combobox para poder atualizar quando fechar a janela modal
        tela3.filho = this;
        // tornar a janela visível
        tela3.setVisible(true);
        
        textAreaDetalhePedido.setText("");
        
        /*
        System.out.print(String.valueOf(tela3.atendimento.getidAtendimento()));
        
        */
        idAtendimento++;
    }//GEN-LAST:event_btCadastrarPedidoActionPerformed

    private void btLoginOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginOkActionPerformed

        atendente = dao.buscarStaffPorCPF(textCpf.getText());
        textCpf.setText(atendente.getcpf());
        jLabel3.setText(atendente.getNome());
        
        if (atendente.getNome().equals("Nao Encontrado") ){
            jPanel2.setEnabled(false);
            jPanel3.setEnabled(false);
            btCadastrarPedido.setEnabled(false);
            btFecharCaixa.setEnabled(false);
            textAreaDetalhePedido.setEnabled(false);
            bradioPedidiosFechados.setEnabled(false);
            bradioPedidiosAbertos.setEnabled(false);
            listaDePedidos.setEnabled(false);
            btEditarPedido.setEnabled(false);
            btCancelarPedido.setEnabled(false);
        }else{
            jPanel2.setEnabled(true);
            jPanel3.setEnabled(true);
            btCadastrarPedido.setEnabled(true);
            btFecharCaixa.setEnabled(true);
            textAreaDetalhePedido.setEnabled(true);
            bradioPedidiosFechados.setEnabled(true);
            bradioPedidiosAbertos.setEnabled(true);
            listaDePedidos.setEnabled(true);
            btEditarPedido.setEnabled(true);
            btCancelarPedido.setEnabled(true);
        }

        
    }//GEN-LAST:event_btLoginOkActionPerformed

    private void btEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarPedidoActionPerformed
        
        //AtualizaListPedido(dao.getAtendimentos());
        
        int selectAtend = listaDePedidos.getSelectedIndex();
        if (selectAtend>=0){
            if (bradioPedidiosAbertos.isSelected()) {
                String idAtend= dao.getAtendimentosAbertos().get(selectAtend).getidAtendimento();
                //System.out.print(idAtend);
                
                at =dao.getAtendimento(idAtend);
                
                Tela03_Atendimento tela3 = new Tela03_Atendimento(new javax.swing.JFrame(), true, at, dao, true);
                // associar o DAO da tela3 ao DAO desta janela(tela2) 
                this.dao = tela3.dao;
                // associar combobox para poder atualizar quando fechar a janela modal
                tela3.filho = this;
                // tornar a janela visível
                tela3.setVisible(true);
                textAreaDetalhePedido.setText("");
                //tela3.carregarDadosPedidoNaTela(at);
                  
            }          
        }
        
    }//GEN-LAST:event_btEditarPedidoActionPerformed

    private void bradioPedidiosAbertosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bradioPedidiosAbertosActionPerformed
        bradioPedidiosFechados.setSelected(false);
        textAreaDetalhePedido.setText("");
        AtualizaListPedido(dao.getAtendimentosAbertos());
        
    }//GEN-LAST:event_bradioPedidiosAbertosActionPerformed

    private void bradioPedidiosFechadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bradioPedidiosFechadosActionPerformed
        bradioPedidiosAbertos.setSelected(false);
        textAreaDetalhePedido.setText("");
        AtualizaListPedido(dao.getAtendimentosEncerrado());
        
        
    }//GEN-LAST:event_bradioPedidiosFechadosActionPerformed

    private void listaDePedidosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDePedidosMouseReleased
        int selectAtend = listaDePedidos.getSelectedIndex();
        
        //textAreaDetalhePedido.setText(""+selectAtend);
        if (bradioPedidiosAbertos.isSelected()) {
            float valor = 0;
            Atendimento atendSelec = dao.getAtendimentosAbertos().get(selectAtend);
            //String p = atendSelec.getCliente().getNome() + atendSelec.getDataAtendimento();
            
            String p = String.format("Status: %-16s Data: %16s \nNome: %-15.12s   CPF: %14s   \n", 
                    atendSelec.getStatusAtendimento(), atendSelec.getDataAtendimento(), 
                    atendSelec.getCliente().getNome(),
                    atendSelec.getCliente().getcpf() );
                    p = p + String.format("%3s  | %10.7s   | %-5s |  %-26.24s \n",
                            "ID", "Valor Unt.", "Qtda.", "Produto");
                    for (Oferta pedido : atendSelec.getPedido()){
                        p = p + String.format("%3d  |R$%8.2f   | %5s |    %-26.24s \n", 
                                pedido.getItem(), 
                                pedido.getPreco(), pedido.getQtda(), 
                                pedido.getDescricao());
                        valor = pedido.getQtda()*pedido.getPreco()+ valor;
                    }
                    p = p + String.format("TOTAL= R$%4.2f", valor);
                    //"valor total= " + valor %10.2f produtoSelecionado, quantidadeSelecionada, prod.getPreco()));
                    
            textAreaDetalhePedido.setText( p );
            
        }
        
    }//GEN-LAST:event_listaDePedidosMouseReleased

    private void btCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarPedidoActionPerformed
        int selectAtend = listaDePedidos.getSelectedIndex();
        if (selectAtend>=0){
            textAreaDetalhePedido.setText("");
            if (bradioPedidiosAbertos.isSelected()) {
                String idAtend= dao.getAtendimentosAbertos().get(selectAtend).getidAtendimento();
                //System.out.print(idAtend);
                dao.removeAtendimento(idAtend);
              
                AtualizaListPedido(dao.getAtendimentosAbertos());
            }else{ textAreaDetalhePedido.setText("Pedido Fechado nao pode ser Cancelado.");}
            

        }
    }//GEN-LAST:event_btCancelarPedidoActionPerformed

   /*
    public static void iniciarTela02() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela02_RegistroAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela02_RegistroAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela02_RegistroAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela02_RegistroAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela02_RegistroAtendimento(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bradioPedidiosAbertos;
    private javax.swing.JRadioButton bradioPedidiosFechados;
    private javax.swing.JButton btCadastrarPedido;
    private javax.swing.JButton btCancelarPedido;
    private javax.swing.JButton btEditarPedido;
    private javax.swing.JButton btFecharCaixa;
    private javax.swing.JButton btLoginOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaDePedidos;
    private javax.swing.JTextArea textAreaDetalhePedido;
    private javax.swing.JTextField textCpf;
    // End of variables declaration//GEN-END:variables
}
