package application;


import domain.Cliente;
import domain.Pedido;
import domain.Produto;
import infrastructure.PedidoRepository;


public class PedidoService {


    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        this.pedidoRepository.salvar(pedido);
        return pedido;
    }

    public void adicionarProduto(String pedidoId, Produto produto) {
        Pedido pedido = this.pedidoRepository.buscarPorId(pedidoId);
        if (pedido != null) {
            pedido.adicionarProduto(produto);
            this.pedidoRepository.salvar(pedido);
        } else {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
    }

    public void pagarPedido(String pedidoId) {
        Pedido pedido = this.pedidoRepository.buscarPorId(pedidoId);
        if (pedido != null) {
            pedido.pagar();
            this.pedidoRepository.salvar(pedido);
        } else {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
    }

    public void cancelarPedido(String pedidoId) {
        Pedido pedido = this.pedidoRepository.buscarPorId(pedidoId);
        if (pedido != null) {
            pedido.cancelar();
            this.pedidoRepository.salvar(pedido);
        } else {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
    }
}