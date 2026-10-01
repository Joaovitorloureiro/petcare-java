public class Administrador extends Usuario {
    
    private int nivelAcesso;
    private String departamento;

    public Administrador(int id, String nome, String email, String senha) {
        super(id, nome, email, senha, "ADMIN");
        this.nivelAcesso = 1;
        this.departamento = "Geral";

    }

    public boolean excluirRegistro(int id, String tipo) {
        System.out.println("Registro " + tipo + " com ID " + id + " excluído.");
        return true;

    }

    public void ajustarEstoque(String item, int qtd) {
        System.out.println("Estoque ajustado: " + item + " | Quantidade: " + qtd);
    }

    public void gerenciarUsuario(Usuario u) {
        System.out.println("Gerenciando usuario: " + u.getNome());
    }

    @Override
    public void exibir(){
        System.out.println("=== ADMINISTRADOR ===");
        super.exibir();
        System.out.println("Nível de acesso: " + nivelAcesso);
        System.out.println("Departamento: " + departamento);
    }

}
