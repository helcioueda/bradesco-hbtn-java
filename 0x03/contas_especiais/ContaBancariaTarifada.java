import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;
    private static final double TARIFA_POR_TRANSACAO = 0.10;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor); // Invoca o método depositar da superclasse
        this.saldo -= TARIFA_POR_TRANSACAO; // Desconta a tarifa da transação
        this.quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor); // Invoca o método sacar da superclasse
        this.saldo -= TARIFA_POR_TRANSACAO; // Desconta a tarifa da transação
        this.quantidadeTransacoes++;
    }
}