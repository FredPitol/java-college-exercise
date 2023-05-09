
package atividade2;
import java.util.StringTokenizer;

public class Oraculo {
    String nome; //Atributo: nome do oráculo
    Guerreiro guerreiro; //Atributo: guerreiro gerado ao instanciar um oraculo

    Guerreiro guerreiro1 = new Guerreiro(); //Instancia de um guerreiro
    
    
    public void setNome(String nome) {
         // Metodo que recebe um string, e atribui ela ao nome do oraculo
        this.nome = nome;
    }
    
    
    public int setVidas(){
        // Este método faz o sorteio do número de vidas do Guerreiro. A quantidade de vidas deve ser entre [9, 12] vidas;    
        int n_vidas = (int) (Math.random() * 4) + 9;
        
        return n_vidas;
    }
    
    public String prologoIntroducao(){
        //Este método exibe na tela um Prólogo (com Nomes) do Oráculo para o Guerreiro + A quantidade de vidas do Guerreiro
     
        String texto = ("Oraculo: " + this.nome + " / Guerreiro: " + guerreiro1.getNome()  + " / Vidas: " + guerreiro1.getVidas());
        
        return texto;
    }
    
    public int loadLevel1(){
        /*
        Este método faz o sorteio de um Número entre [1, 100]. O Oráculo deve dar uma
        dica ao Guerreiro: Segredo é MENOR ou MAIOR que o PALPITE do número escolhido (obtido via teclado)
        pelo Guerreiro. Cada erro do Guerreiro é uma vida a menos!
        */
        int numero = (int) (Math.random() * 100) + 1;
     
        return numero;
    }
    
    public int loadLevel2(int opcao){
        /*
        Este método faz um jogo de PAR ou ÍMPAR com o Oráculo. O Guerreiro
        decide na variável Opção: PAR ou ÍMPAR e o método retorna se o Guerreiro Ganhou ou Perdeu: SE a
        SOMA deu PAR ou ÍMPAR. O Oráculo e O Guerreiro irão receber números sorteados entre [0, 5].
        */
        int num_oraculo = (int) (Math.random() * 4) + 1;
        int num_guerreiro = (int) (Math.random() * 4) + 1;
        int soma = num_oraculo + num_guerreiro;
        
        int tipo;
        if (soma % 2 == 0){
            tipo = 1;
        }
        else{
            tipo = 0;
        }
        
        
        if (opcao == tipo){
            return 1;
        }
        else{
            return 0;
        }
            
           
    
    }
    
    
    
    
    
    public String prologoVencedor(){
        //Este método exibe na tela um Prólogo (com Nomes) do Oráculo para o Guerreiro: VENCEDOR;
        String prologoVencedor = "PARABENS!!! " + guerreiro1.getNome() + ", VOCE VENCEU!!!";
        
        
        return prologoVencedor;
    }
    
    public String prologoPerdedor(){
        // Este método exibe na tela um Prólogo (com Nomes) do Oráculo para o Guerreiro: PERDEDOR;
        String prologoPerdedor = "Nao foi dessa vez " + guerreiro1.getNome() + ", VOCE FOI DERROTADO!!!";

        
        return prologoPerdedor;
    }
    
    public boolean decidirVidaExtra(String misericordia){
        /*
        Este método recebe o Pedido de Misericórdia do
        Guerreiro e o Oráculo decide se concede ou não uma (1) Vida Extra. A vida extra será concedida se o
        Pedido de Misericórdia do Guerreiro tiver mais que cinco palavras.     
        */
        
        StringTokenizer tokenizer = new StringTokenizer(misericordia);
        int quantidade_palavras = tokenizer.countTokens();
        
        if (quantidade_palavras > 5){
            return true;
        
        }
        else{
            return false;
        }
        
        
    }
    
    
}
