import java.util.Locale;

public class Pessoa {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }
    
    @Override
    public String toString() {
    	Locale.setDefault(new Locale("pt", "BR"));
    	
        return String.format(Locale.getDefault(), "[%d] %s %s %d R$ %.6f",
            this.codigo, this.nome, this.cargo, this.idade, this.salario);
    }
}