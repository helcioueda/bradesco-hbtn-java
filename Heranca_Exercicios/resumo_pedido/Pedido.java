import produtos.Dvd;
import produtos.Livro;

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
    
    public void apresentarResumoPedido() {
        double totalProdutos = 0.0; // Soma dos preços líquidos * quantidade, sem desconto
        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item : itens) {
            String tipoProduto;
            // Verifica o tipo real do produto para a string "Tipo"
            if (item.getProduto() instanceof Livro) {
                tipoProduto = "Livro";
            } else if (item.getProduto() instanceof Dvd) {
                tipoProduto = "Dvd";
            } else {
                tipoProduto = "Produto Desconhecido"; // Caso haja outros tipos de Produto
            }

            double precoLiquido = item.getProduto().obterPrecoLiquido();
            double totalItem = item.calcularSubtotal();
            totalProdutos += totalItem;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipoProduto,
                    item.getProduto().getTitulo(),
                    precoLiquido,
                    item.getQuantidade(),
                    totalItem);
        }

        double valorDesconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedidoComDesconto = calcularTotal(); // Usa o método já existente

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedidoComDesconto);
        System.out.println("----------------------------");
    }    
}