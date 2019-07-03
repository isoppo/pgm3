/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 * @author Felipe-Isoppo
 */
public class Caixa {
    
    ArrayList<Atendimento> atendimentos= new ArrayList();
    private float valorFaturado;
    
    public float getValorFaturado (){
        valorFaturado=0;
        for (Atendimento atend : atendimentos){
            for (Produto prod : atend.getPedido()){
                valorFaturado = valorFaturado +prod.getPreco()*prod.getQtda();
            }
        }
        
    return valorFaturado;
    }
    
    
    public Caixa(ArrayList<Atendimento> a) {
        this.atendimentos = a;
    }
    
}
