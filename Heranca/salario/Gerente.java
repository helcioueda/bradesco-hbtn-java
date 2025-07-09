public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        double bonus = 0.0;
        if (departamento.alcancouMeta()) {
            bonus += salarioFixo * 0.20; 

            double diferenca = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            bonus += diferenca * 0.01;
        }
        return bonus;
    }
}