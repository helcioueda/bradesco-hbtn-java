import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                () -> new TreeMap<>(Comparator.reverseOrder()),
                Collectors.toCollection(TreeSet::new)
            ));
    }
}