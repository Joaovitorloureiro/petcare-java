import java.util.ArrayList;
import java.util.List;

public class HistoricoClinico {
    private int idAnimal;
    private List<Consulta> consultas;
    private List<Vacina> vacinas;
    private List<Cirurgia> cirurgias;
    private List<Exame> exames;
    private List<Tratamento> tratamentos;
    private boolean finalizado;

    public HistoricoClinico(int idAnimal) {
        this.idAnimal = idAnimal;
        this.consultas = new ArrayList<>();
        this.vacinas = new ArrayList<>();
        this.cirurgias = new ArrayList<>();
        this.exames = new ArrayList<>();
        this.tratamentos = new ArrayList<>();
        this.finalizado = false;
    }

    public void adicionarConsulta(Consulta consulta) {
        if (finalizado) {
            System.out.println("Não é possível adicionar consulta. Histórico finalizado.");
            return;
        }
        consultas.add(consulta);
    }

    public void adicionarVacina(Vacina vacina) {
        if (finalizado) {
            System.out.println("Não é possível adicionar vacina. Histórico finalizado.");
            return;
        }
        vacinas.add(vacina);
    }

    public void adicionarCirurgia(Cirurgia cirurgia) {
        if (finalizado) {
            System.out.println("Não é possível adicionar cirurgia. Histórico finalizado.");
            return;
        }
        cirurgias.add(cirurgia);
    }

    public void adicionarExame(Exame exame) {
        if (finalizado) {
            System.out.println("Não é possível adicionar exame. Histórico finalizado.");
            return;
        }
        exames.add(exame);
    }

    public void adicionarTratamento(Tratamento tratamento) {
        if (finalizado) {
            System.out.println("Não é possível adicionar tratamento. Histórico finalizado.");
            return;
        }
        tratamentos.add(tratamento);
    }

    public void finalizar() {
        this.finalizado = true;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public List<Cirurgia> getCirurgias() {
        return cirurgias;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public List<Tratamento> getTratamentos() {
        return tratamentos;
    }

    public void exibir() {
        System.out.println("=== HISTÓRICO CLÍNICO ===");
        System.out.println("ID do Animal: " + idAnimal);
        System.out.println("Consultas: " + consultas.size());
        System.out.println("Vacinas: " + vacinas.size());
        System.out.println("Cirurgias: " + cirurgias.size());
        System.out.println("Exames: " + exames.size());
        System.out.println("Tratamentos: " + tratamentos.size());
        System.out.println("Finalizado: " + finalizado);
    }
}