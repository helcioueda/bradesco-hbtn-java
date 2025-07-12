import java.util.HashMap;
import java.util.Map;

public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;

    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, String telefone, String email) {
        if (contatos.containsKey(nome)) {
            System.out.println("Erro: Contato com nome " + nome + " já existe!");
            return;
        }

        for (Contato contatoExistente : contatos.values()) {
            if (contatoExistente.getEmails().contains(email)) {
                System.out.println("Erro: Email " + email + " em uso por outro contato!");
                return;
            }
        }

        Contato novoContato = new Contato();
        novoContato.adicionarTelefone(telefone);
        novoContato.adicionarEmail(email); 

        contatos.put(nome, novoContato);
        System.out.println("Contato " + nome + " adicionado com sucesso!");
    }

    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }
        for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
            String nome = entry.getKey();
            Contato contato = entry.getValue();
            System.out.println("Nome: " + nome);
            contato.exibirContato();
            System.out.println("-------------------------------");
        }
    }

    public void buscarContato(String nome) {
        if (contatos.containsKey(nome)) {
            System.out.println("Contato encontrado: " + nome);
            contatos.get(nome).exibirContato();
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("Contato " + nome + " removido com sucesso!");
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();

        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        System.out.println();

        System.out.println("\nExibindo todos os contatos:");
        gestao.exibirContatos();

        System.out.println("\n\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");

        System.out.println("\n\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");

        System.out.println("\n\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");

        System.out.println("\n\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}