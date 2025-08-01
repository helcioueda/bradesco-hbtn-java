import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {

    private String nome;
    private double preco;
    private double percentualMarkup = 10.0; // Markup inicial de 10%

    public Supplier<Double> precoComMarkup = () -> {
        return preco * (1 + (percentualMarkup / 100.0));
    };

    public Consumer<Double> atualizarMarkup = novoMarkup -> {
        this.percentualMarkup = novoMarkup;
    };

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPercentualMarkup() {
        return percentualMarkup;
    }
}