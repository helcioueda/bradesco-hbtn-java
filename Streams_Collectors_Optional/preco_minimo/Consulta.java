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
}