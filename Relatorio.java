public class Relatorio {
    private int id;
    private int mes;
    private int ano;
    private int totalAtendimentos;
    private double faturamentoTotal;
    private double totalDespesas;
    private double taxaRetorno;
    private double tempMedioAtend;
    private String procedMaisRealizado;

    public Relatorio(int id, int mes, int ano) {
        this.id = id;
        this.mes = mes;
        this.ano = ano;
        this.totalAtendimentos = 0;
        this.faturamentoTotal = 0.0;
        this.totalDespesas = 0.0;
        this.taxaRetorno = 0.0;
        this.tempMedioAtend = 0.0;
        this.procedMaisRealizado = "Nenhum";
    }

    public int getId() {
        return id;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void gerar() {
        System.out.println("Relatório gerado com sucesso.");
    }

    public String getEstatisticas() {
        return "Atendimentos: " + totalAtendimentos
                + " | Faturamento: R$ " + faturamentoTotal
                + " | Despesas: R$ " + totalDespesas
                + " | Taxa de retorno: " + taxaRetorno
                + " | Tempo médio: " + tempMedioAtend
                + " | Procedimento mais realizado: " + procedMaisRealizado;
    }

    public double calcularFaturamento() {
        return faturamentoTotal;
    }

    public double calcularTaxaRetorno() {
        return taxaRetorno;
    }

    public double calcularTempMedio() {
        return tempMedioAtend;
    }

    public String getProcedMaisRealizado() {
        return procedMaisRealizado;
    }

    public void exportar() {
        System.out.println("Relatório exportado.");
    }

    public void exibir() {
        System.out.println("=== RELATÓRIO ===");
        System.out.println("ID: " + id);
        System.out.println("Mês/Ano: " + mes + "/" + ano);
        System.out.println("Total de atendimentos: " + totalAtendimentos);
        System.out.println("Faturamento total: R$ " + faturamentoTotal);
        System.out.println("Total de despesas: R$ " + totalDespesas);
        System.out.println("Taxa de retorno: " + taxaRetorno);
        System.out.println("Tempo médio de atendimento: " + tempMedioAtend);
        System.out.println("Procedimento mais realizado: " + procedMaisRealizado);
    }
}