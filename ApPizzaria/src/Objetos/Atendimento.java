
package Objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Felipe-Isoppo
 */
public class Atendimento {
    
    
    private Date dataAtendimento; // ("dd/MM/yyyy HH:mm")
    private int idAtendimento;
    private ArrayList<Oferta> pedido = new ArrayList();
    private Pessoa cliente;
    private Pessoa atendente;
    private String statusAtendimento;
    
    public String getDataAtendimento() { return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dataAtendimento); }
    public void setDataAtendimento(String d) throws ParseException { 
        this.dataAtendimento = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(d); }
    public void setDataAtendimento(Date d){this.dataAtendimento =d;}
    public String getidAtendimento() { return "" + idAtendimento;}
    
    public void setItemPedido(Oferta d){pedido.add(d);}
    public void setPedido(ArrayList<Oferta> d){ pedido=d;}
    public ArrayList<Oferta> getPedido() { return pedido;}
    
    public Pessoa getCliente() { return cliente;}
    public void setCliente(Cliente c) { this.cliente = c;}
    
    public Pessoa getAtendente() { return atendente;}
    
    public String getStatusAtendimento() { return statusAtendimento;}
    public void setStatusAtendimento(String status) { statusAtendimento = status;}
    
    // construtor
    public Atendimento( ) {
       this.dataAtendimento = new Date(System.currentTimeMillis()); this.idAtendimento = 001; statusAtendimento = "Aberto";}
    
    public Atendimento( int id , ArrayList<Oferta> pedido) {
       this.dataAtendimento = new Date(System.currentTimeMillis()); this.idAtendimento = id; this.pedido = pedido; 
       this.cliente = null; this.atendente =null; statusAtendimento = "Aberto";}
    
    public Atendimento( int id , ArrayList<Oferta> pedido, Pessoa cliente, Pessoa atendente) {
       this.dataAtendimento = new Date(System.currentTimeMillis()); this.idAtendimento = id; 
       this.pedido = pedido; this.cliente = cliente; this.atendente = atendente; statusAtendimento = "Aberto";}
    
    public Atendimento( int id , Pessoa atendente) {
       this.dataAtendimento = new Date(System.currentTimeMillis()); this.idAtendimento = id; 
       this.pedido = null; this.cliente = null; this.atendente = atendente; statusAtendimento = "Aberto";}
    
    public Atendimento( Atendimento a) throws ParseException { 
        this.dataAtendimento = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(a.getDataAtendimento()); 
        this.idAtendimento = Integer.parseInt(a.getidAtendimento()); 
        this.pedido = a.getPedido();
        this.cliente = a.getCliente(); this.atendente= a.getAtendente();
        this.statusAtendimento = a.getStatusAtendimento();
    }
    
    
    
}
