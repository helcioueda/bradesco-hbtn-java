import atividades.Atividade;
import java.util.ArrayList;
import java.util.List;

public class Workflow {
    private List<Atividade> atividades;

    public Workflow() {
        this.atividades = new ArrayList<>();
    }

    public void registrarAtividade(Atividade atividade) {
        if (atividade == null) {
            throw new IllegalArgumentException("Atividade não pode ser nula.");
        }
        this.atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return new ArrayList<>(atividades);
    }
}