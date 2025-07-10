import atividades.Atividade; 

public class MaquinaWorkflow {

    public void executar(Workflow workflow) {
        if (workflow == null) {
            throw new IllegalArgumentException("Workflow não pode ser nulo.");
        }
        //System.out.println("Iniciando execução do Workflow...");
        for (Atividade atividade : workflow.getAtividades()) {
            atividade.executar(); 
        }
        //System.out.println("Workflow concluído.");
    }
}