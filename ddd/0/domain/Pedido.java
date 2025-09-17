package domain;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Pedido {


    private final String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;


    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public void pagar() {
        if (this.status == StatusPedido.PENDENTE) {
            this.status = StatusPedido.PAGO;
        } else {
            throw new IllegalStateException("O pedido não pode ser pago.");
        }
    }

    public void cancelar() {
        if (this.status != StatusPedido.PAGO) {
            this.status = StatusPedido.CANCELADO;
        } else {
            throw new IllegalStateException("O pedido já foi pago e não pode ser cancelado.");
        }
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public StatusPedido getStatus() {
        return status;
    }
}