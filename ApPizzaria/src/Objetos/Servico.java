
package Objetos;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * @author Felipe-Isoppo
 */
public class Servico extends Oferta {
    
    private boolean agenda;
    private Date dataEntrega; // ("dd/MM/yyyy HH:mm")
    
    public boolean getAgenda() { return agenda; }
    public void setAgenda(boolean a) { this.agenda = a; }
    public String getDataEntrega() { return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dataEntrega); }
    public void setDataEntrega(String d) throws ParseException { this.dataEntrega = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(d); }
    
    // construtor
    public Servico(int item, float preco, String descricao, boolean a , Date d ) {
       super(item, preco, descricao ); this.agenda = a; this.dataEntrega = d;  } //formato de entrada da data "dd/MM/yyyy HH:mm"
    public Servico(int item, float preco, String descricao ) {
       super( item, preco, descricao ); this.agenda = false; this.dataEntrega = new Date(System.currentTimeMillis());  }
    
}