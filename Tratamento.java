public class Tratamento {
    private String descricao;
    private String dataInicio;
    private String dataFim;

    public Tratamento(String descricao, String dataInicio, String dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void exibir() {
        System.out.println("=== TRATAMENTO ===");
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de início: " + dataInicio);
        System.out.println("Data de fim: " + dataFim);
    }
}