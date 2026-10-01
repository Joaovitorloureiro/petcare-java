public class Exame extends RegistroClinico {
    private String tipoExame;
    private String resultado;
    private String laboratorio;

    public Exame(int id, String data, String descricao, Veterinario veterinario, String tipoExame) {
        super(id, data, descricao, veterinario);
        this.tipoExame = tipoExame;
        this.resultado = "";
        this.laboratorio = "";
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public String getResultado() {
        return resultado;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setResultado(String resultado) {
        if (isFinalizado()) {
            System.out.println("Exame finalizado. Não é possível alterar o resultado.");
            return;
        }
        this.resultado = resultado;
    }

    public void setLaboratorio(String laboratorio) {
        if (isFinalizado()) {
            System.out.println("Exame finalizado. Não é possível alterar o laboratório.");
            return;
        }
        this.laboratorio = laboratorio;
    }

    @Override
    public void exibir() {
        System.out.println("=== EXAME ===");
        super.exibir();
        System.out.println("Tipo de exame: " + tipoExame);
        System.out.println("Resultado: " + resultado);
        System.out.println("Laboratório: " + laboratorio);
    }
}