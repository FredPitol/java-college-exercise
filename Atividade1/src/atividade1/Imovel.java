
package atividade1;


public class Imovel {
    String nome; //Atributo: nome do dono do imovel
    float imposto; //Atributo: Imposto do imovel
    int mesesAtraso; //Atributo: Meses de atraso do pagamento 
    String matricula; //Atributo: matricula do imovel
        
    public Imovel() {
        //Método construtor da classse
    }

    //Método construtor da classe
    public Imovel(String nome, float imposto, int mesesAtraso, String matricula) {
        this.nome = nome;
        this.imposto = imposto;
        this.mesesAtraso = mesesAtraso;
        this.matricula = matricula;
    }

    public void setImposto(float imposto) {
        //Método que atribui o imposto ao imovel
        this.imposto = imposto;
    }

    
    
}
