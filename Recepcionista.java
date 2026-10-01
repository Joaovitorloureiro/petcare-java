public class Recepcionista extends Usuario {

    private String turno;

    public Recepcionista(int id, String nome, String email, String senha, String turno) {
        super(id, nome, email, senha, "RECEP");
        this.turno = turno;
    }
    
    public void agendarConsulta(String nomeAnimal) {
        System.out.println("Consulta agendada para: " + nomeAnimal);
    }

    public void cadastrarCliente(String nome) {
        System.out.println("Cliente cadastrado: " + nome);
    }

    @Override
    public void exibir() {
        System.out.println("=== RECEPCIONISTA ===");
        super.exibir();
        System.out.println("Turno: " + turno);
    }

}