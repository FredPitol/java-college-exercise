
package Atividade3;
import java.util.*;

public class Atividade3 {
 
private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        //Estanciando e exibindo novo funcionário e loja 
        
        Loja loja = new Loja("Americanos", "11.235.68/0001-29");
        Funcionario funcionario1 = new Funcionario("Frederico", 001);
        System.out.printf("Sistema da loja %s%nCNPJ: %s%n", loja.pegaNome(), loja.pegaCnpj());
        
        InOut.MsgDeInformacao("Software de gestão de pedidos", "Loja" + loja.pegaNome() + "\n"
        + "Cnpj: " + loja.pegaCnpj() + "\n" + "Funcionário: " + funcionario1.recebeNome() + "\n"
        + "ID do funcionário: " + funcionario1.recebeId() + "\n");
        
      
        System.out.printf("Colaborador: %s%nMatrícula: %d%n %n",
                funcionario1.recebeNome(), funcionario1.recebeId());
        
        // Menu de opções 
        
        while (true) {
            
            
            
            /*System.out.printf("Menu de opcões %n"
                    + "1: Inserir pedido %n"
                    + "2: Procurar pedido %n"
                    + "3: Deletar pedido %n"
                    + "4: Modificar pedido %n"
                    + "0: Sair %n");
            */        
            int i = InOut.leInt("Menu de opcões\n"
                    + "1: Inserir pedido\n"
                    + "2: Procurar pedido\n"
                    + "3: Deletar pedido\n"
                    + "4: Modificar pedido\n"
                    + "0: Sair\n");

                    
            if (i == 0) {
                break;
            }

            switch (i) {
                case 1:
                    fazerPedido(loja);
                    break;
                case 2:
                    procurarPedido(loja);
                    break;
                case 3:
                    deletarPedido(loja);
                    break;
                case 4:
                    adicionarItems(loja);
                    break;
                default:
                    InOut.MsgDeAviso("Atenção","Comando inválido, tente novamente");
                    break;
            }
        }
    }

    private static void fazerPedido(Loja loja) {
        int idPedido = InOut.leInt("Digite o numero do pedido");
        
        int numItems = InOut.leInt("Digite a quantidade itens que quer inserir");
        List<ItensPedido> items = new ArrayList<>();
        for (int i = 0; i < numItems; i++) {
            
            String NomeItem = InOut.leString("Digite o nome do item");
            System.out.println("Digite a quantidade de itens:");
            int itemAmount = InOut.leInt("Digite a quantidade de itens");
            
            float valorUnitarioItem = InOut.leFloat("Digite o valor unitário do item");
            items.add(new ItensPedido(NomeItem, itemAmount, valorUnitarioItem));
        }
        Pedido order = new Pedido(idPedido, new Date(), items);
        loja.fazerPedido(order);
        InOut.MsgDeInformacao("Status do pedido", "Pedido efetuado com sucesso");
    }

    private static void procurarPedido(Loja loja) {
        
        int idDoPedido = InOut.leInt("Digite o id do pedido que deseja buscar");
        Pedido procuraPedido = loja.procuraPedido(idDoPedido);
        if (procuraPedido != null) {
            
            InOut.MsgDeInformacao("Informações do pedido", "Id do pedido: " +  
                    procuraPedido.recebeIDDoPedido() +"\n"+ "Valor total do pedido: " + procuraPedido.recebeValorTotal() 
                    + "\n" +"Data do pedido: " + procuraPedido.recebeData() + "\n" + "\nItens do pedido:\n" + procuraPedido.getItensPedidoString());
           
            /*
            System.out.printf("Id do pedido: %s%n"
                    + "Valor total do pedido: %s%n"
                    + "Data do pedido: %s%n"
                    ,procuraPedido.recebeIDDoPedido()
                    ,procuraPedido.recebeValorTotal()
                    ,procuraPedido.recebeData()
                    
            );
            */
            procuraPedido.mostrarItens();
        } else {
            InOut.MsgDeErro("ERRO", "Pedido não encontrado");
        }
    }

    private static void deletarPedido(Loja loja) {
        int idDoPedido = InOut.leInt("Digite o id do pedido para deleta-lo");
        if (loja.deletaPedido(idDoPedido)) {
            InOut.MsgDeAviso("Status do pedido", "Pedido deletado com sucesso");
        } else {
            InOut.MsgDeErro("Erro", "Pedido não encontrado");
        }
    }

    private static void adicionarItems(Loja store) {
        
        int idDoPedido = InOut.leInt("Digite o id do pedido para modifica-lo:");
        
        int numItems = InOut.leInt("Digite o numero de items a serem adicionados:");
        
        List<ItensPedido> novosItens = new ArrayList<>();
        
        for (int i = 0; i < numItems; i++) {
            
            String nomeDoItem = InOut.leString("Digite o nome do item");
            
            int quantidadeItem = InOut.leInt("Digite a quantidade de itens:");
            
            float valorUnitario = InOut.leFloat("Insira o valor unitário do item:");
            
            novosItens.add(new ItensPedido(nomeDoItem, quantidadeItem, valorUnitario));
        }
        if (store.modificaPedido(idDoPedido, novosItens)) {
            InOut.MsgDeAviso("Status do pedido", "Pedido modificado com sucesso.");
        } else {
            InOut.MsgDeErro("Erro", "Pedido não encontrado");
        }
    }
}