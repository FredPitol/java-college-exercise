
package atividade2;

import java.util.Scanner;

public class Atividade2 {  
    
    /*JOGO DO ORACULO*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Oraculo oraculo1 = new Oraculo(); //Intancia de um oraculo
        oraculo1.setNome("Master"); //Nome do oráculo instanciado
        
        String nome_guerreiro = InOut.leString("Qual o nome do seu guerreiro: ");
        oraculo1.guerreiro1.setNome(nome_guerreiro); //Nome do guerreiro instanciado na criacao do oraculo
        
        oraculo1.guerreiro1.vidas = oraculo1.setVidas(); //Atribui ao stributo de vida do guerreiro, a quantidade de vidas definidas pelo metodo (oraculo1.setVidas())
        InOut.MsgDeInformacao("Vidas: ", "O oráculo lhe concedeu: " + oraculo1.guerreiro1.vidas + " vidas");
        
        InOut.MsgSemIcone("--Jogo 1--", oraculo1.prologoIntroducao()); //Introducao do jogo
        
        
        int num_sorteado = oraculo1.loadLevel1(); //Numero aleatorio de 1 a 100 sorteado pelo metodo (oraculo1.loadLevel1()), Aqui o jogo e iniciado!       
        int palpite = 0; //Variavel de controle
        
        boolean jogo1_perdido = false; //Variavel de controle
        
         
        /*JOGO 1*/
        InOut.MsgSemIcone("--Jogo 1--", "Tente acertar o numero de 1 a 100 gerado pelo Oraculo! A cada erro você perderá uma vida "); //Mensagem Introdutoria jogo 1
        while (palpite != num_sorteado && oraculo1.guerreiro1.getVidas() > 0){ 
            /*
            Enquanto o palpite do guerreiro à respeito do numero aleatorio sorteado de 1 a 100 estiver 
            incorreto e ele possuir vidas para gastar, ele poderá tentar acertar o numero sorteado de 
            acordo com as dicas fornecidas. O jogo 1 acaba se o guerreiro acertar o numero ou se suas
            vidas acabarem.
            */
            
            palpite = InOut.leInt("Digite qual o seu palpite: "); //Recebe do teclado o palpite do guerreiro
            
            if (palpite == num_sorteado){ 
                //Se o palpite for = ao numero sorteado o guerreiro ganha o JOGO 1
                InOut.MsgDeInformacao("--Jogo 1--", "Parabens voce acertou!!!");               
                InOut.MsgDeAviso("--Jogo 1--", "Restam " + oraculo1.guerreiro1.vidas + " vidas");
            }
            else if (palpite < num_sorteado){
                //Se o palpite for < que o numero sorteado o guerreiro perde uma(1) vida, e recebe uma dica sobre o número sorteado
                InOut.MsgDeInformacao("--Jogo 1--", "O numero sorteado e MAIOR!!!");
                oraculo1.guerreiro1.vidas -= 1;
                InOut.MsgDeAviso("--Jogo 1--", "Restam " + oraculo1.guerreiro1.vidas + " vidas");
                
            }
            else if (palpite > num_sorteado){
                //Se o palpite for > que o numero sorteado o guerreiro perde uma(1) vida, e recebe uma dica sobre o número sorteado
                InOut.MsgDeInformacao("--Jogo 1--", "O numero sorteado e MENOR!!!");               
                oraculo1.guerreiro1.vidas -= 1;
                InOut.MsgDeAviso("--Jogo 1--", "Restam " + oraculo1.guerreiro1.vidas + " vidas");
            }        
        }
        
        if (oraculo1.guerreiro1.vidas == 0){
            //Se ao final do jogo 1, a quantidade de vidas do guerreiro for 0, isso significa que ele perdeu o jogo
            jogo1_perdido = true;       
        }
                               
                
        boolean controle_vidaextra = false; //Variavel de controle
        
        
        /*JOGO 2*/
        while(oraculo1.guerreiro1.vidas > 0 || jogo1_perdido == true){
            /*
            Esse jogo so e iniciado se a quantidade de vidas do guerreiro for > 0 ou
            se o jogo 1 tiver sido perdido. Nesta segunda opcao obrigatoriamente  a 
            quantidade de vidas do guerreiro sera 0, no entanto se ele conseguir a misericordia 
            do oraculo ele tera a chance de jogar o jogo 2 e decidir o seu destino pela utima vez.
            Ja na primeira, a vidas seram > 0 e o guerreiro ira para a segunda parte da sua jornada.            
            */
            
            
            int opcao = 3; //Variavel decontrole
            int resultado = 4; //Variavel decontrole
            
            if(controle_vidaextra == true){
                //Se o guerreiro obter a misericordia do oraculo essa mensagem sera exibida
                InOut.MsgSemIcone("--Jogo 2--", "O oraculo foi benevolente, FACA SUA UTIMA JOGADA!");               
                jogo1_perdido = false;
            }
            
            if (oraculo1.guerreiro1.vidas > 0){
                //Se a quantidade de vidas do guerreiro for > 0 essa mensagem sera exibida representando o inicio do jogo 2                
                InOut.MsgSemIcone("--Jogo 2--", "Jogo 2 carregado, o oraculo gerou um numero de 0 a 5 para voce e outro para ele mesmo, a soma destes numeros dara: "); //Mensagem Introdutoria jogo 2

            }
            
            
            
            while (opcao != resultado && oraculo1.guerreiro1.vidas > 0){
                /*
                Enquanto a opcao digitada pelo guerreiro, informando se a soma dos numeros 
                gerados para ele e para o oraculo e par ou impar for != do que é esperado,
                novos numeros serao gerados e uma nova opcao sera informada pelo guerreiro
                (A cada erro uma vida e descontada do guerreiro).
                Se o guereiro acertar, suas vidas forem > 0 e ja tiver usado sua vida extra,
                o guerreiro se torna campeao, caso contrario ele saira como perdedor.
                */   
                
                InOut.MsgDeAviso("--Jogo 2--  ATENCAO!!!", " Se voce errar, novos numeros serao gerados!!!");
                opcao = InOut.leInt("Digite 0 para IMPAR ou 1 para PAR: "); //Opcao digitada pelo guerreiro
                resultado = oraculo1.loadLevel2(opcao);  //Soma dos numeros aleatorios e sua definicao de PAR ou IMPAR, obtidos atravez do metodo (oraculo1.loadLevel2(opcao))    

                if (resultado == 0 ){
                    //Se o resultado da chamda do metodo for = 0, significa que a soma dos numeros e IMPAR
                    InOut.MsgDeInformacao("--Jogo 2--", "A soma dos numeros eh IMPAR");

                }
                else{
                    //Se o resultado da chamda do metodo for != 0, significa que a soma dos numeros e PAR
                    InOut.MsgDeInformacao("--Jogo 2--", "A soma dos numeros eh PAR");


                }

                if (opcao == resultado){
                    //Se a opcao fornecida pelo guerreiro for = do resultado, o guerreiro se torna campeao e jogo e finalizado
                    InOut.MsgSemIcone("--Jogo 2--", "Voce ACERTOU parebens!!!");
                    InOut.MsgDeAviso("--Jogo 2--", oraculo1.prologoVencedor()); //Mensagem para o ganhador
                    break;
                }
                
                else{
                    //Se a opcao fornecida pelo guerreiro for != do resultado
                    if (opcao != resultado && controle_vidaextra == true){
                        //Se a vida extra tiver sido usada, ele ira descontar essa vida e o guereiro tera sido derrotado e fornecera o status do guerreiro
                        InOut.MsgDeErro("--Jogo 2--", "Voce ERROU!!!");
                        oraculo1.guerreiro1.vidas -= 1;
                        InOut.MsgDeAviso("--Jogo 2--", "Restam " + oraculo1.guerreiro1.vidas + " vidas");
                        System.out.println();   
                    }
                    else{
                        //Caso contrario, ele descontara uma vida e fornecera o status do guerreiro ate sua quantidade de vidas acabar ou ele acertar o resultado
                        InOut.MsgDeErro("--Jogo 2--", "Voce ERROU!!! Tente novamente!");
                        oraculo1.guerreiro1.vidas -= 1;
                        InOut.MsgDeAviso("--Jogo 2--", "Restam " + oraculo1.guerreiro1.vidas + " vidas");
                    }
                }  
            }   
                
        if (opcao == resultado){
            //Verifica se oguerreiro acertou a o resultado e finaliza o jogo
            break;
        }
            
           
            
            
            
            if (oraculo1.guerreiro1.vidas == 0 && controle_vidaextra == false){
                /*
                No caso das vidas do guerreiro tiverem acabado e ele ainda tiver utilizado sua vida extra
                ele podera obter a misericordia do oraculo
                */
                InOut.MsgDeInformacao("Ultima chance!", "Suas vidas acabaram!!! Implore por mais uma vida ou simplesmente DESISTA!");

                int escolha = InOut.leInt("Digite 0 para DESISTIR ou 1 para IMPLORAR: "); //O guerreiro escolhe se deseja desistir do jogo ou se vai implorar por mais uma vida
                
                if (escolha == 1){
                    //String misericordia = scanner.nextLine();
                    //String misericordia = oraculo1.guerreiro1.vidaextra();

                    if (oraculo1.decidirVidaExtra(oraculo1.guerreiro1.vidaextra()) == true){
                        /*
                        Atraves do metodo (oraculo1.guerreiro1.vidaextra()) que recebe um pedido de misericordia do guerreiro
                        o metodo (oraculo1.decidirVidaExtra(oraculo1.guerreiro1.vidaextra()), ira decidir se vai conceder essa vida ou nao
                        apartir do pressuposto que o pedido de misericordia tem que ter mais que 5 palavras
                        */
                        oraculo1.guerreiro1.vidas += 1;
                        controle_vidaextra = true; //Variavel de controle
                        
                    }
                    else{
                        //Se a misericordia nao for concedida ao guerreiro ele automaticamente perdera o jogo, que sera encerrado
                        InOut.MsgDeErro("JA ERA!!!", oraculo1.prologoPerdedor());
                        break;
                    }

                }
                else{
                    //Se o guerreiro optar por desistir do jogo, ele perdera e o jogo sera encerrado
                    InOut.MsgDeErro("JA ERA!!!", oraculo1.prologoPerdedor());
                    break;
                }                                              
            }
            
            if (oraculo1.guerreiro1.vidas == 0 && controle_vidaextra == true){
                //Caso após o jogo 2 a quantidade de vidas do guereiro for = 0 e a vida extra ja tiver sido usada, ele perdera e o jogo sera encerrado
                InOut.MsgDeErro("JA ERA!!!", oraculo1.prologoPerdedor());
            }
                    
            
        }
        
        
    }
    
 
}
