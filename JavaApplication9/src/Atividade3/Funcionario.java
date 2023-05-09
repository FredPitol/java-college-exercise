package Atividade3;

public class Funcionario {
    
    public String nome;
    public int id;
                                            //DUVIDA - Corrigir 
                                            //Construtor de classe, atribuindo valor inicial as variáveis da classe 
    public Funcionario(String nome, int id){
    
    this.nome = nome;
    this.id = id;
    
    }                                       //Fim do construtor
    
                                            //Inicio método getName
    public String recebeNome(){
        return nome;
    }
                                            //Fim método getName
                                            //Inicio método recebeId
    public int recebeId(){
        return id;
    }
                                            //Fim método getID
}