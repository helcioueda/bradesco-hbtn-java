import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private List<String> hobbies;
    
    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public String getCargo() {
        return cargo;
    }
    
    public List<String> getHobbies() {
        return hobbies;
    }
    
    public double getSalario() {
		return salario;
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

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return codigo == pessoa.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}