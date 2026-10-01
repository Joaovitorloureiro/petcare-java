public class Cirurgia extends RegistroClinico {
    private String tipoCirurgia;
    private String anestesia;
    private String observacoes;
    private boolean internacao;

    public Cirurgia(int id, String data, String descricao, Veterinario veterinario, String tipoCirurgia) {
        super(id, data, descricao, veterinario);
        this.tipoCirurgia = tipoCirurgia;
        this.anestesia = "";
        this.observacoes = "";
        this.internacao = false;
    }

    public String getTipoCirurgia() {
        return tipoCirurgia;
    }

    public String getAnestesia() {
        return anestesia;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public boolean isInternacao() {
        return internacao;
    }

    public void setAnestesia(String anestesia) {
        if (isFinalizado()) {
            System.out.println("Cirurgia finalizada. Não é possível alterar a anestesia.");
            return;
        }
        this.anestesia = anestesia;
    }

    public void setObservacoes(String observacoes) {
        if (isFinalizado()) {
            System.out.println("Cirurgia finalizada. Não é possível alterar observações.");
            return;
        }
        this.observacoes = observacoes;
    }

    public void setInternacao(boolean internacao) {
        if (isFinalizado()) {
            System.out.println("Cirurgia finalizada. Não é possível alterar a internação.");
            return;
        }
        this.internacao = internacao;
    }

    @Override
    public void exibir() {
        System.out.println("=== CIRURGIA ===");
        super.exibir();
        System.out.println("Tipo de cirurgia: " + tipoCirurgia);
        System.out.println("Anestesia: " + anestesia);
        System.out.println("Observações: " + observacoes);
        System.out.println("Internação: " + internacao);
    }
}
