package Atividade3;
import java.util.*;

public class Pedido {
    private int orderId;
    private float valorTotalCalculado;
    private Date dataPedido;
    private List<ItensPedido> itens;

    public Pedido(int orderId, Date orderDate, List<ItensPedido> itens) {
        this.orderId = orderId;
        this.dataPedido = orderDate;
        this.itens = itens;
        recebeValorTotalCalculado();
    }

    public void recebeValorTotalCalculado() {
        valorTotalCalculado = 0;
        for (ItensPedido item : itens) {
            valorTotalCalculado += item.recebeQuantidadeItens() * item.recebeValorUnitario();
        }
    }

    public int recebeIDDoPedido() {
        return orderId;
    }
    public float recebeValorTotal() {
        return valorTotalCalculado;
    }

    public void mostrarItens() {
          for (ItensPedido i : itens) {
            System.out.println(i);
           
        }
    }
    
    public Date recebeData() {
        return dataPedido;
    }

    
    
    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
        recebeValorTotalCalculado();
    }
    
    public String getItensPedidoString() {
    StringBuilder sb = new StringBuilder();
    for (ItensPedido item : itens) {
        sb.append(item.toString()).append(System.lineSeparator());
    }
    return sb.toString();
}
   
 
}

