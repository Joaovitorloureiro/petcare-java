import java.util.ArrayList;
import java.util.List;

public class Agendamento {
    private int id;
    private String dataHora;
    private String tipo;
    private String status;
    private Animal animal;
    private Veterinario veterinario;
    private String sala;
    private Notificador notificador;
    private List<String> historico;

    public Agendamento(int id, String dataHora, String tipo, Animal animal,
                       Veterinario veterinario, String sala, Notificador notificador) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id deve ser maior que zero.");
        }
        
        if (dataHora == null || dataHora.trim().isEmpty()) {
            throw new IllegalArgumentException("A data e hora não podem ser vazias.");
        }
        
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("O tipo não pode ser vazio.");
        }
        
        if (animal == null) {
            throw new IllegalArgumentException("O animal não pode ser nulo.");
        }
        
        if (veterinario == null) {
            throw new IllegalArgumentException("O veterinário não pode ser nulo.");
        }
        
        if (sala == null || sala.trim().isEmpty()) {
            throw new IllegalArgumentException("A sala não pode ser vazia.");
        }
        
        if (notificador == null) {
            throw new IllegalArgumentException("O notificador não pode ser nulo.");
        }

        this.id = id;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.animal = animal;
        this.veterinario = veterinario;
        this.sala = sala;
        this.notificador = notificador;
        this.status = "AGENDADO";
        this.historico = new ArrayList<>();
    }

    public boolean agendar() {
        if (!validarHorario()) {
            System.out.println("Horário inválido. Apenas entre 08h e 18h.");
            return false;
        }

        if (!validarVeterinario()) {
            System.out.println("Veterinário indisponível.");
            return false;
        }

        historico.add("Agendamento criado: " + dataHora);
        notificarTutor();
        return true;
    }

    public void cancelar(String motivo) {
        this.status = "CANCELADO";
        historico.add("Cancelado: " + motivo);
        notificador.enviarCancelamento(this);
    }

    public void reagendar(String novaData) {
        this.dataHora = novaData;
        historico.add("Reagendado para: " + novaData);
        notificador.enviarReagendamento(this);
    }

    public boolean validarHorario() {
        try {
            String horaTexto = dataHora.substring(11, 13);
            int hora = Integer.parseInt(horaTexto);
            return hora >= 8 && hora < 18;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validarVeterinario() {
        return veterinario.isDisponivel();
    }

    public boolean reservarRecursos() {
        return true;
    }

    public String getStatus() {
        return status;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getSala() {
        return sala;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void setSala(String sala) {
        if (sala == null || sala.trim().isEmpty()) {
            throw new IllegalArgumentException("A sala não pode ser vazia.");
        }
        this.sala = sala;
    }

    public void notificarTutor() {
        notificador.enviarConfirmacao(this);
    }

    public void exibir() {
        System.out.println("=== AGENDAMENTO ===");
        System.out.println("ID: " + id);
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Tipo: " + tipo);
        System.out.println("Status: " + status);
        System.out.println("Animal: " + animal.getNome());
        System.out.println("Veterinário: " + veterinario.getNome());
        System.out.println("Sala: " + sala);
    }
}