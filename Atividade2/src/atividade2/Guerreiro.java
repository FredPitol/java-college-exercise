
package atividade2;

public class Guerreiro {
    String nome; //Atributo: nome do guerreiro
    int vidas; //Atributo: quantidade de vidas do guerreiro
    
    
    public String getNome() {
        //Este método retorna qual o nome o guerreiro
        return this.nome;
    }

    public void setNome(String nome) {
        //Este método define o nome do guerreiro
        this.nome = nome;
    }

    public int getVidas() {
        //Este metodo retorna a quantidade de vidas do guerreiro
        return this.vidas;
    }
    
    public String vidaextra(){
        // Este método ler (obtido via teclado) um pedido de Misericórdia do Guerreiro por mais UMA(1) Vida;
        String misericordia = InOut.leString("Implore pela sua misericordia: ");
        return misericordia;
    }
    
    
    
    
    
}
