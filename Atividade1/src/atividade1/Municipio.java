
package atividade1;

import java.util.HashMap;
import java.util.Map;

public class Municipio {       
    
    //Instanciacao de um MAP(listaImovel) dentro da classe
    Map<String, Imovel> listaImovel = new HashMap<>(); 
     
    //Funcao para calcular um imposto com base no imposto de um imovel e na quantidade de meses em atraso.
    public float calculaimposto(float imposto, int mesesAtraso){
        if (mesesAtraso > 12){
            //Se o atraso passar de 12 meses, o imposto será o imposto padrão + 10%
            float multa = imposto * 0.1f;  
            return multa;
        }
        if (mesesAtraso >= 11){
            //Se o atraso for de 11 ou 12 meses, o imposto será o imposto padrão + 5.4%
            float multa = imposto * 0.054f;
            return multa;
        }
        if (mesesAtraso >= 9){
            //Se o atraso for de 9 ou 10 meses, o imposto será o imposto padrão + 3%
            float multa = imposto * 0.03f;
            return multa;
        }
        if (mesesAtraso >= 6){
            //Se o atraso for de 6 a 8 meses, o imposto será o imposto padrão + 2.3%
            float multa = imposto * 0.023f;
            return multa;
        }
        else{
           //Se o atraso for de até 5 meses, o imposto será o imposto padrão + 1%
           float multa = imposto * 0.01f;
           return multa;
        }                                  
    }
    
    //Função que recebe um imovel(i) qualquer, previamente estanciado, e o relaciona com o municipio.
    public void cadastrarimovel(Imovel i){
        listaImovel.put(i.matricula, i);//EX: im1.matricula--> INDICE ÚNICO, im1---> IMOVEL 
    }
    
    //Função para atribuir o valor do imposto atualizado ao objeto instanciado
    public void atualizaimposto(float imposto_calculado, Imovel i){
        float imposto_atualizado = imposto_calculado + i.imposto;
        i.imposto = imposto_atualizado;
    }
    
    public int consultaImovel(){
        int quantidade_imoveis = listaImovel.size();
        return quantidade_imoveis;
    }
    
   
    
    
    
}
