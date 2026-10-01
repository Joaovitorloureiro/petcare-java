public class Notificador {
    private String canal;
    private String destinatario;
    private boolean ativo;

    public Notificador(String canal, String destinatario) {
        this.canal = canal;
        this.destinatario = destinatario;
        this.ativo = true;

    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        if(canal == null || canal.isEmpty()) {
            throw new IllegalArgumentException("Canal inválido.");
        }
        this.canal = canal;

    }

    public void enviarConfirmacao(Agendamento ag) {
        if(ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " -> " + destinatario + ": Agendamento confirmado para " + ag.getDataHora());
        }
    }

    public void enviarCancelamento(Agendamento ag) {
        if(ativo) {
            System.out.println("[NOTIFICADOR] " + canal + "  -> " + destinatario + ": Agendamento cancelado.");
        }
    }


    public void enviarReagendamento(Agendamento ag) {
        if(ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " -> " + destinatario + ": Agendamento remarcado para " + ag.getDataHora());
        }
    }

    public void enviarLembreteVacina(Animal a, String dt) {
        if(ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " -> " + destinatario + ": Lembrete de vacina para " + a.getNome() + " em " + dt);
        }
    }
    
    public void enviarAlertaEstoque(String item) {
        if(ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " -> " + destinatario + ": Alerta de estoque baixo para " + item);
        }
    }

    public void enviarAlerta(String dest, String msg) {
        if(ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " -> " + dest + ": " + msg);
        }
    }
    
}
