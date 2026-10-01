import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;
    private boolean ativo;
    private LocalDate dataCadastro; 

    public Usuario(int id, String nome, String email, String senha, String perfil) {
        this.id = id;
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        this.perfil = perfil;
        this.ativo = true;
        this.dataCadastro = LocalDate.now(); 
    }

    public boolean login(String email, String senha) {
        return this.ativo && this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() {
        System.out.println("Logout realizado.");
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPerfil() {
        return perfil;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public LocalDate getDataCadastro() { 
        return dataCadastro;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Senha inválida");
        }
        this.senha = senha;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void exibir() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Perfil: " + perfil);
        System.out.println("Ativo: " + ativo);
        System.out.println("Data de cadastro: " + dataCadastro.format(formatter)); 
    }
}