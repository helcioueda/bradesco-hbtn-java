// Blog.java
import java.util.ArrayList;
import java.util.HashMap; // Usado para contagem, pois a ordem não importa aqui
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap; // Usado para maps onde as chaves devem ser ordenadas (como Autor)
import java.util.TreeSet; // Usado para garantir unicidade e ordem

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        if (this.postagens.contains(postagem)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        this.postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagemPorCategoria = new TreeMap<>();
        for (Post post : postagens) {
            Categorias categoria = post.getCategoria();
            contagemPorCategoria.put(categoria, contagemPorCategoria.getOrDefault(categoria, 0) + 1);
        }
        return contagemPorCategoria;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsDoAutor = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getAutor().equals(autor)) {
                postsDoAutor.add(post);
            }
        }
        return postsDoAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsDaCategoria = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getCategoria().equals(categoria)) {
                postsDaCategoria.add(post);
            }
        }
        return postsDaCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> postsPorCategoria = new TreeMap<>();

        for (Categorias cat : Categorias.values()) {
            postsPorCategoria.put(cat, new TreeSet<>());
        }

        for (Post post : postagens) {
            postsPorCategoria.get(post.getCategoria()).add(post);
        }
        return postsPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> postsPorAutor = new TreeMap<>();

        for (Post post : postagens) {
            postsPorAutor.computeIfAbsent(post.getAutor(), k -> new TreeSet<>()).add(post);
        }
        return postsPorAutor;
    }
}