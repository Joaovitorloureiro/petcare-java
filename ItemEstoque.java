public class ItemEstoque {
    private int id;
    private String nome;
    private int quantidade;
    private int quantidadeMinima;
    private String lote;
    private String validade;
    private boolean controlado;
    private String responsavelRetirada;
    private String categoria;

    public ItemEstoque(int id, String nome, int quantidade, int quantidadeMinima, String lote) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.lote = lote;
        this.validade = "";
        this.controlado = false;
        this.responsavelRetirada = "";
        this.categoria = "";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getLote() {
        return lote;
    }

    public boolean isControlado() {
        return controlado;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setControlado(boolean controlado) {
        this.controlado = controlado;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void darEntrada(int qtd, String responsavel) {
        if (qtd > 0) {
            this.quantidade += qtd;
            this.responsavelRetirada = responsavel;
        }
    }

    public boolean darSaida(int qtd, String responsavel) {
        if (qtd <= 0 || qtd > quantidade) {
            return false;
        }

        if (controlado) {
            if (lote == null || lote.isEmpty()
                    || validade == null || validade.isEmpty()
                    || responsavel == null || responsavel.isEmpty()) {
                return false;
            }
        }

        this.quantidade -= qtd;
        this.responsavelRetirada = responsavel;
        return true;
    }

    public boolean reservar(int qtd) {
        if (qtd > 0 && qtd <= quantidade) {
            quantidade -= qtd;
            return true;
        }
        return false;
    }

    public boolean isAbaixoMinimo() {
        return quantidade < quantidadeMinima;
    }

    public boolean isVencido() {
        return false;
    }

    public void exibir() {
        System.out.println("=== ITEM ESTOQUE ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Quantidade mínima: " + quantidadeMinima);
        System.out.println("Lote: " + lote);
        System.out.println("Validade: " + validade);
        System.out.println("Controlado: " + controlado);
        System.out.println("Responsável: " + responsavelRetirada);
        System.out.println("Categoria: " + categoria);
    }
}