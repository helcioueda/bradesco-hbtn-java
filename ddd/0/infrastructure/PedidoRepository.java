package infrastructure;


import java.util.HashMap;
import java.util.Map;


import domain.Pedido;


public class PedidoRepository {


    private final Map<String, Pedido> pedidos = new HashMap<>();

    public void salvar(Pedido pedido) {
        this.pedidos.put(pedido.getId(), pedido);
    }

    public Pedido buscarPorId(String id) {
        return this.pedidos.get(id);
    }
}