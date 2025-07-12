import java.util.*;

public class Contato {
    private List<String> telefones;
    private Set<String> emails;

    public Contato() {
        telefones = new ArrayList<>();
        emails = new HashSet<>();
    }

    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    public boolean adicionarEmail(String email) {
        if (!emails.contains(email)) {
            emails.add(email);
            return true;  // Email adicionado com sucesso
        }
        return false;  // Email duplicado
    }

    public void exibirContato() {
        System.out.println("Telefones: " + telefones);
        System.out.println("Emails: " + emails);
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public Set<String> getEmails() {
        return emails;
    }
}