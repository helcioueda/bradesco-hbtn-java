import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        try {
            ContaBancariaBasica conta1 = new ContaBancariaBasica("AAA", 50.0);
            System.out.printf("Conta %s - saldo: %.2f\n", conta1.getNumeracao(), conta1.getSaldo()); // 0.00
            conta1.depositar(100);
            System.out.printf("Conta %s - saldo: %.2f\n", conta1.getNumeracao(), conta1.getSaldo()); // 100.00
            conta1.sacar(25);
            System.out.printf("Conta %s - saldo: %.2f\n", conta1.getNumeracao(), conta1.getSaldo()); // 75.00
            conta1.aplicarAtualizacaoMensal(); // Tarifa min(10, 7.5) = 7.5; Juros = 75 * (50/100)/12 = 3.125. Saldo = 75 - 7.5 + 3.125 = 70.625
            System.out.printf("Conta %s - saldo: %.2f\n\n", conta1.getNumeracao(), conta1.getSaldo()); // 70.63
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        try {
            ContaBancariaBasica conta2 = new ContaBancariaBasica("BBB", 100.0);
            System.out.printf("Conta %s - saldo: %.2f\n", conta2.getNumeracao(), conta2.getSaldo()); // 0.00
            conta2.depositar(10);
            System.out.printf("Conta %s - saldo: %.2f\n", conta2.getNumeracao(), conta2.getSaldo()); // 10.00
            conta2.sacar(10);
            System.out.printf("Conta %s - saldo: %.2f\n", conta2.getNumeracao(), conta2.getSaldo()); // 0.00
            conta2.aplicarAtualizacaoMensal(); // Tarifa min(10, 0) = 0; Juros = 0. Saldo = 0 - 0 + 0 = 0
            System.out.printf("Conta %s - saldo: %.2f\n\n", conta2.getNumeracao(), conta2.getSaldo()); // 0.00
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        try {
            ContaBancariaBasica conta3 = new ContaBancariaBasica("CCC", 120.0);
            System.out.printf("Conta %s - saldo: %.2f\n", conta3.getNumeracao(), conta3.getSaldo()); // 0.00
            conta3.depositar(1600);
            System.out.printf("Conta %s - saldo: %.2f\n", conta3.getNumeracao(), conta3.getSaldo()); // 1600.00
            conta3.aplicarAtualizacaoMensal(); // Tarifa min(10, 160) = 10. Juros = 1600 * (120/100)/12 = 160. Saldo = 1600 - 10 + 160 = 1750
            System.out.printf("Conta %s - saldo: %.2f\n\n", conta3.getNumeracao(), conta3.getSaldo()); // 1750.00
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        try {
            ContaBancariaBasica conta4 = new ContaBancariaBasica("DDD", 70.0);
            System.out.printf("Conta %s - saldo: %.2f\n", conta4.getNumeracao(), conta4.getSaldo()); // 0.00
            conta4.depositar(0); // Lança OperacaoInvalidaException
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n"); // Valor para deposito deve ser maior que 0
        }

        try {
            ContaBancariaBasica conta5 = new ContaBancariaBasica("EEE", 50.0);
            System.out.printf("Conta %s - saldo: %.2f\n", conta5.getNumeracao(), conta5.getSaldo()); // 0.00
            conta5.depositar(25);
            System.out.printf("Conta %s - saldo: %.2f\n", conta5.getNumeracao(), conta5.getSaldo()); // 25.00
            conta5.sacar(30); // Lança OperacaoInvalidaException
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n"); // Valor de saque deve ser menor que o saldo atual
        }
    }
}