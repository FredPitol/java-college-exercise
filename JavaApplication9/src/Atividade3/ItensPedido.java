
package Atividade3;


public class ItensPedido {
    private String item;
    private int quantidade;
    private float valorUnitario;

    public ItensPedido(String item, int quantidade, float valorUnitario) {
        this.item = item;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }
                            //metodo 
    public int recebeQuantidadeItens() {
        return quantidade;
    }

    public float recebeValorUnitario() {
        return valorUnitario;
    }
    
     @Override
     
    public String toString() {
        return String.format("Nome do produto:%s%nQuantidade: %d%nValor unitário: %f%n", item, quantidade,valorUnitario);
    } 
}
    

