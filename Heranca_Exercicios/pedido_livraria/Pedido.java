public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens; 

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        double subtotalGeral = 0.0;
        for (ItemPedido item : itens) {
            subtotalGeral += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }

        return subtotalGeral * (1 - (percentualDesconto / 100.0));
    }
}