import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
	
public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream()
                .filter(produto -> produto.getCategoria() == CategoriaProduto.LIVRO)
                .collect(Collectors.toList());
    }
    
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        Optional<Produto> produtoMaiorPreco = produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .findFirst();

        return produtoMaiorPreco.orElse(null);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(pedido -> pedido.getProdutos().stream()
                                         .anyMatch(p -> p.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }
 
    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(produto -> {
                    // Verifica se o produto é eletrônico para aplicar o desconto
                    if (produto.getCategoria() == CategoriaProduto.ELETRONICO) {
                        double novoPreco = produto.getPreco() * 0.85; // 100% - 15% = 85%
                        produto.setPreco(novoPreco); // Modifica o preço do objeto
                    }
                    return produto; // Retorna o produto, modificado ou não
                })
                .collect(Collectors.toList());
    }
}