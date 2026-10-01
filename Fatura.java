public class Fatura {

    private int id;
    private Tutor tutor;
    private double valor;
    private String dataEmissao;
    private String dataVencimento;
    private String status;
    private String descricaoServico;
    private Notificador notificador;

    public Fatura(int id, Tutor tutor, double valor, String descricaoServico, Notificador notificador) {
        this.id = id;
        this.tutor = tutor;
        this.valor = valor;
        this.descricaoServico = descricaoServico;
        this.notificador = notificador;
        this.dataEmissao = java.time.LocalDate.now().toString();
        this.dataVencimento = java.time.LocalDate.now().plusDays(7).toString();
        this.status = "PENDENTE";
    }

    public void emitir() {
        System.out.println("Fatura emitida para: " + tutor.getNome());
        notificador.enviarAlerta(tutor.getEmail(), "Fatura emitida no valor de R$ " + valor);

    }

    public String gerarBoleto() {
        return "BOLETO - " + id + "-" + tutor.getNome().replace(" ", "").toUpperCase();
    }

    public String gerarLinkPagamento() {
        return "https://pagamento.petcare.com/fatura/" + id;
    }

    public void registrarPagamento() {
        this.status = "PAGO";
    }

    public boolean confirmarPagOnline() {
        return true;
    }

    public boolean isPendente() {
        return status.equals("PENDENTE");
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void exibir() {
        System.out.println("=== FATURA ===");
        System.out.println("ID: " + id);
        System.out.println("Tutor: " + tutor.getNome());
        System.out.println("Valor: R$ " + valor);
        System.out.println("Descrição: " + descricaoServico);
        System.out.println("Data de emissão: " + dataEmissao);
        System.out.println("Data de vencimento: " + dataVencimento);
        System.out.println("Status: " + status);
    }

}