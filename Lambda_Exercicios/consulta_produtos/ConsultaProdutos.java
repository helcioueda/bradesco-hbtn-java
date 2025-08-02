import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (criterio.testar(produto)) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }
}