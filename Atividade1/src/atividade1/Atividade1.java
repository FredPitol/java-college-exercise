
package atividade1;

import java.util.ArrayList;
import java.util.List;

public class Atividade1 {

    
    /*PREFEITURA*/
    public static void main(String[] args) {
       //Atribuicao de nome ao municipio
       String nome_municipio = InOut.leString("Informe qual é o municipio: "); 
       
       //Instanciação da classe Municipio
       Municipio municipio = new Municipio();      
       
       //Instanciação da classe imovel    
       Imovel imovel = new Imovel();
       imovel.nome = InOut.leString("Nome do proprietario do imovel: ");
       imovel.matricula = InOut.leString("Matricula do imovel: ");
       imovel.imposto = InOut.leFloat("Imposto a ser pago: ");
       imovel.mesesAtraso = InOut.leInt("Total de meses atrasados: ");
               
       municipio.cadastrarimovel(imovel);
       InOut.MsgDeAviso("Prefeitura de " + nome_municipio, "Imovel " + imovel.matricula + " adicionado com sucesso!!!");
       
       int menu = InOut.leInt("Digite 1 para calcular o imposto do imovel ou 2 para sair: ");
       if (menu == 1){
           municipio.atualizaimposto(municipio.calculaimposto(imovel.imposto, imovel.mesesAtraso), imovel);
           InOut.MsgDeInformacao("Caluculo do imposto: ", "Imposto re-calculado com sucesso!!");
           InOut.MsgDeAviso("Caluculo do imposto: ", "O imovel " + imovel.matricula + " ira pagar " + imovel.imposto + "R$ de IPTU" + " ao municipio de " + nome_municipio);
           InOut.MsgDeInformacao("Prefeitura " + nome_municipio, "A prefeitura possui " + municipio.consultaImovel() +" imovel cadastrados!");
       }
       
       
                
      
    }
    
}
