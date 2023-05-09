
package Atividade3;
import java.util.*;

public class Loja {
    private String nomeFantasia;
    private String cnpj;
    private List<Pedido> orders;

    public Loja(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.orders = new ArrayList<>();
    }

    public void fazerPedido(Pedido order) {
        orders.add(order);
    }

    public Pedido procuraPedido(int orderId) {
        for (Pedido order : orders) {
            if (order.recebeIDDoPedido() == orderId) {
                return order;
            }
        }
        return null;
    }

    public boolean deletaPedido(int orderId) {
        Iterator<Pedido> iterator = orders.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().recebeIDDoPedido() == orderId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean modificaPedido(int orderId, List<ItensPedido> newItems) {
        Pedido order = procuraPedido(orderId);
        if (order != null) {
            order.setItens(newItems);
            return true;
        }
        return false;
    }
    
  
    
    public String pegaNome(){
        return nomeFantasia;
    }
                                            //Fim método getName
                                            //Inicio método pegaCnpj
    public String pegaCnpj(){
        return cnpj;
    }
}

