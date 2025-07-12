import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }


    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
        System.out.println("Aluno '" + nome + "' adicionado com sucesso.");
    }


    public void excluirAluno(String nome) {
        Iterator<Aluno> iterator = alunos.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                encontrado = true;
                System.out.println("Aluno '" + nome + "' excluído com sucesso.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno '" + nome + "' não encontrado na lista.");
        }
    }

    public void buscarAluno(String nome) {
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno.getNome());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno '" + nome + "' não encontrado.");
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Alunos ---");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        gestao.adicionarAluno("Joao", 10);
        gestao.adicionarAluno("Jose", 11);
        gestao.adicionarAluno("Maria", 9);

        gestao.listarAlunos();

        gestao.buscarAluno("Jose");

        gestao.excluirAluno("Jose");

        gestao.excluirAluno("Pedro");

        gestao.buscarAluno("Maria");
    }
}