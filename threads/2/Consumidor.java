public class Consumidor extends Thread {
    private final Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                fila.retirar();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumidor " + getId() + " foi interrompido.");
            Thread.currentThread().interrupt();
        }
    }
}