package cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * @Felipe Isoppo
 */
public class Cadastro extends JFrame implements ActionListener{
    ArrayList<String> nome = new ArrayList<String>();
    ArrayList<String> telefone = new ArrayList<String>();
    ArrayList<String> endereco = new ArrayList<>();
    int pagina = 0;

    JLabel jlNome = new JLabel("Nome:");
    JLabel jlEndereco = new JLabel("Endereço:");
    JLabel jlTelefone = new JLabel("Telefone:");
    JLabel jlPagina = new JLabel("1");
    
    JTextField jtNome = new JTextField();
    JTextField jtEndereco = new JTextField();
    JTextField jtTelefone = new JTextField();
    //JTextField jtPagina = new JTextField();
    
    JButton jbInicio = new JButton("<<");
    JButton jbAnterior = new JButton("<");
    JButton jbProximo = new JButton(">");
    JButton jbFinal = new JButton(">>");
    
    public Cadastro(){
        super("Cadastro");
        setSize(300,200);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        nome.add("João");
        nome.add("Pedro");
        nome.add("Lucas");
        telefone.add("234-0049");
        telefone.add("3642-1234");
        telefone.add("5577-4321");
        endereco.add("Rua x, numero Tal");
        endereco.add("Rua y, numero Delta");
        endereco.add("Rua z, numero zeta");
        
        jtNome.setDisabledTextColor(Color.RED);
        jtNome.setHorizontalAlignment(JTextField.LEFT);
        jtEndereco.setDisabledTextColor(Color.RED);
        jtEndereco.setHorizontalAlignment(JTextField.LEFT);
        jtTelefone.setDisabledTextColor(Color.RED);
        jtTelefone.setHorizontalAlignment(JTextField.LEFT);
        
        jtNome.setBounds(80, 50, 200, 30);
        jtEndereco.setBounds(80, 90, 200, 30);
        jtTelefone.setBounds(80, 130, 200, 30);
        
        jtNome.setText(nome.get(pagina));
        jtEndereco.setText(endereco.get(pagina));
        jtTelefone.setText(telefone.get(pagina));   
                
        jlPagina.setBounds(145, 10, 20, 30);
        jlNome.setBounds(10, 50, 200, 30);
        jlEndereco.setBounds(10, 90, 200, 30);
        jlTelefone.setBounds(10, 130, 200, 30);
        
        jbInicio.setBounds(5, 10, 55, 30);
        jbAnterior.setBounds(65, 10, 55, 30);
        jbProximo.setBounds(180, 10, 55, 30);
        jbFinal.setBounds(240, 10, 55, 30);
        
        
        jbInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                pagina = 0;
                setPagina(pagina);
            }
        });
                
        jbAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                
                if (pagina-1>0){
                    pagina = pagina-1;
                    }else pagina = 0;
                setPagina(pagina);
            }
        });
                
        jbProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                
                if (pagina+1<nome.size()){
                    pagina = pagina+1;
                    }//else pagina = nome.size()-1;
                setPagina(pagina);
            }
        });
                
        jbFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                pagina = nome.size()-1;
                setPagina(pagina);
            }
        });
        
        add(jlNome);
        add(jlEndereco);
        add(jlTelefone);
        add(jtNome);
        add(jtEndereco);
        add(jtTelefone);
        add(jlPagina);
        add(jbInicio);
        add(jbAnterior);
        add(jbProximo);
        add(jbFinal);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setPagina(int pagina){
        String numero = ""+(1+pagina);
        jlPagina.setText(numero);
        jtNome.setText(nome.get(pagina));
        jtEndereco.setText(endereco.get(pagina));
        jtTelefone.setText(telefone.get(pagina));
    }

    public void actionPerformed(ActionEvent arg){
        
    } 
    
    public static void main(String[] args) {
       new Cadastro();
    }
    
    
    
}
