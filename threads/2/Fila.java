import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private final Queue<Integer> fila;
    private final int capacidade;

    public Fila(int capacidade) {
        this.fila = new LinkedList<>();
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            System.out.println("Fila cheia. Produtor " + Thread.currentThread().getId() + " esperando...");
            wait();
        }
        fila.add(item);
        System.out.println("Produtor " + Thread.currentThread().getId() + " adicionou: " + item + ". Tamanho da fila: " + fila.size());
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            System.out.println("Fila vazia. Consumidor " + Thread.currentThread().getId() + " esperando...");
            wait();
        }
        int item = fila.poll();
        System.out.println("Consumidor " + Thread.currentThread().getId() + " retirou: " + item + ". Tamanho da fila: " + fila.size());
        notifyAll();
        return item;
    }
}