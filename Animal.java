import java.time.LocalDate;
import java.time.Period;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private String dataNascimento;
    private double peso;
    private Tutor tutor;
    private HistoricoClinico historico;

    public Animal(int id, String nome, String especie, String raca, Tutor tutor) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.tutor = tutor;
        this.dataNascimento = "";
        this.peso = 0.0;
        this.historico = new HistoricoClinico(id);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public HistoricoClinico getHistorico() {
        return historico;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
            throw new IllegalArgumentException("A data de nascimento não pode ser vazia.");
        }

        try {
            LocalDate data = LocalDate.parse(dataNascimento);
            if (data.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("A data de nascimento não pode ser futura.");
            }
            this.dataNascimento = dataNascimento;
        } catch (Exception e) {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato YYYY-MM-DD.");
        }
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public int calcularIdade() {
        try {
            LocalDate nascimento = LocalDate.parse(dataNascimento);
            return Period.between(nascimento, LocalDate.now()).getYears();
        } catch (Exception e) {
            return 0;
        }
    }

    public void exibir() {
        System.out.println("=== ANIMAL ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Raça: " + raca);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Idade: " + calcularIdade() + " anos");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Tutor: " + tutor.getNome());
    }
}