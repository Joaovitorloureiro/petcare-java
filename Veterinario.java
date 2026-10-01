public class Veterinario extends Usuario {

    private String crmv;
    private String especialidade;
    private boolean disponivel;

    public Veterinario(int id, String nome, String email, String senha, String crmv, String especialidade) {
        super(id, nome, email, senha, "VET");
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.disponivel = true;
    }
    
    public String getCrmv() {
        return crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void atenderAnimal(String nomeAnimal) {
        System.out.println("Atendendo o animal: " + nomeAnimal);
    }

    public void emitirReceita(String medicamento) {
        System.out.println("Receita emitida para: " + medicamento);

    }

    @Override
    public void exibir(){
        System.out.println("=== VETERINARIO ===");
        super.exibir();
        System.out.println("CRMV: " + crmv);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Disponível: " + disponivel);
    }
}
