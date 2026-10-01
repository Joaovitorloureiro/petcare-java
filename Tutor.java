public class Tutor extends Usuario {
    
    private String telefone;
    private String endereco;

    public Tutor(int id, String nome, String email, String senha, String telefone, String endereco) {
        super(id, nome, email, senha, "TUTOR");
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void visualizarHistorico() {
        System.out.println("Exibindo historico dos animais...");
    }

    public void visualizarFaturas() {
        System.out.println("Exibindo faturas...");
    }

    @Override
    public void exibir() {
        System.out.println("=== TUTOR ===");
        super.exibir();
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
    
}
