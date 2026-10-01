public class RegistroClinico {
    private int id;
    private String data;
    private String descricao;
    private Veterinario veterinario;
    private String laudoAnexo;
    private boolean finalizado;
    
    public RegistroClinico(int id, String data, String descricao, Veterinario veterinario) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.veterinario = veterinario;
        this.laudoAnexo = "";
        this.finalizado = false;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }
    
    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void finalizar() {
        this.finalizado = true;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void anexarLaudo(String path) {
        if(finalizado) {
            System.out.println("Registro finalizado. Não é possível anexar laudo.");
            return;
        }
        this.laudoAnexo = path;
    }

    public String getLaudo() {
        return laudoAnexo;
    }

    public void exibir() {
        System.out.println("=== REGISTRO CLÍNICO ===");
        System.out.println("ID: " + id);
        System.out.println("Data: " + data);
        System.out.println("Descrição: " + descricao);
        System.out.println("Veterinário: " + veterinario.getNome());
        System.out.println("Finalizado: " + finalizado);
    }
 
}
