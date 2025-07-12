public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes = new String[]{"Amanda", "Beatriz", "Carlos", "Daniela", "Eduardo",
                "Fabio", "Gustavo", "Hingrid", "Isabela", "Joao", "Leise", "Maria",
                "Norberto", "Otavio", "Paulo", "Quirino", "Renata", "Sabata",
                "Tais", "Umberto", "Vanessa", "Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public void buscaLinear(String nome) {
        System.out.println("Procurando pelo nome: \"" + nome + "\"");
        boolean encontrado = false;
        
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Passando pelo indice:" + i);
            if (nomes[i] == nome) {
                encontrado = true;
                System.out.println("Nome pesquisado é " + nomes[i] + " que está na posição " + i);
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }

    public void buscaBinaria(String nome) {
        System.out.println("Procurando o nome: \"" + nome + "\"");

        int inicio = 0;
        int fim = nomes.length - 1;
        boolean encontrado = false;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; 
            System.out.println("Passando pelo indice: " + meio);

            int comparacao = nome.compareToIgnoreCase(nomes[meio]);

            if (comparacao == 0) { 
                System.out.println("Nome " + nome + " encontrado na posição " + meio);
                encontrado = true;
                break; 
            } else if (comparacao < 0) { 
                fim = meio - 1;
            } else { 
                inicio = meio + 1;
            }
        }

        if (!encontrado) {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
}