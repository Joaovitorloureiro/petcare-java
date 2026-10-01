public class Consulta extends RegistroClinico { 
    private String motivo;
    private String prescricao;
    private String dataRetorno;
    
    public Consulta(int id, String data, String descricao, Veterinario veterinario, String motivo) {
      super(id, data, descricao, veterinario);
      this.motivo = motivo;
      this.prescricao = "";
      this.dataRetorno = "";

    }

    public String getMotivo() {
        return motivo;
    }

    public void setPrescricao(String prescricao) {
        if(isFinalizado()) {
            System.out.println("Consulta finalizada. Não é possivel alterar prescrição.");
            return;
        }
        this.prescricao = prescricao;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setDataRetorno(String dataRetorno) {
        if(isFinalizado()) {
            System.out.println("Consulta finalizada. Não é possível alterar data de retorno. ");
            return;
        }
        this.dataRetorno = dataRetorno;
    }

    public String getDataRetorno(){
        return dataRetorno;
    }

    @Override
    public void exibir() {
        System.out.println("=== CONSULTA ===");
        super.exibir();
        System.out.println("Motivo: " + motivo);
        System.out.println("Prescrição: " + prescricao);
        System.out.println("Data de retorno: " + dataRetorno);
    }

}
