import java.time.LocalDate;

public class Vacina extends RegistroClinico {
    private String nomeVacina;
    private String dataAplicacao;
    private String dataReforco;
    private String lote;
    private String fabricante;
    
    public Vacina(int id, String data, String descricao, Veterinario veterinario, String nomeVacina) {
        super(id, data, descricao, veterinario);
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = data;
        this.dataReforco = "";
        this.lote = "";
        this.fabricante = "";
    }

     public String getNomeVacina() {
        return nomeVacina;
    }

    public String getDataReforco() {
        return dataReforco;
    }

    public void setDataReforco(String dataReforco) {
        if (isFinalizado()) {
            System.out.println("Vacina finalizada. Não é possível alterar reforço.");
            return;
        }
        this.dataReforco = dataReforco;
    }

    public boolean precisaReforco() {
        if (dataReforco == null || dataReforco.isEmpty()) {
            return false;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate reforco = LocalDate.parse(dataReforco);
        return reforco.isBefore(hoje);
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public void exibir() {
        System.out.println("=== VACINA ===");
        super.exibir();
        System.out.println("Nome da vacina: " + nomeVacina);
        System.out.println("Data de aplicação: " + dataAplicacao);
        System.out.println("Data de reforço: " + dataReforco);
        System.out.println("Lote: " + lote);
        System.out.println("Fabricante: " + fabricante);
    }
    

}
