import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogAuditoria {
    private int id;
    private String dataHora;
    private Usuario usuario;
    private String acao;
    private String entidadeAfetada;
    private int idEntidade;
    private String ipOrigem;

    private static List<LogAuditoria> logs = new ArrayList<>();

    public LogAuditoria(Usuario usuario, String acao, String entidadeAfetada, int idEntidade) {
        this.id = logs.size() + 1;
        this.dataHora = LocalDateTime.now().toString();
        this.usuario = usuario;
        this.acao = acao;
        this.entidadeAfetada = entidadeAfetada;
        this.idEntidade = idEntidade;
        this.ipOrigem = "127.0.0.1";
    }

    public void registrar() {
        logs.add(this);
    }

    public String getAcao() {
        return acao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDataHora() {
        return dataHora;
    }

    public int getIdEntidade() {
        return idEntidade;
    }

    public static List<LogAuditoria> buscarPorUsuario(Usuario usuario) {
        List<LogAuditoria> resultado = new ArrayList<>();

        for (LogAuditoria log : logs) {
            if (log.getUsuario().getEmail().equals(usuario.getEmail())) {
                resultado.add(log);
            }
        }

        return resultado;
    }

    public static List<LogAuditoria> buscarPorEntidade(String entidade) {
        List<LogAuditoria> resultado = new ArrayList<>();

        for (LogAuditoria log : logs) {
            if (log.entidadeAfetada.equalsIgnoreCase(entidade)) {
                resultado.add(log);
            }
        }

        return resultado;
    }

    public void exibir() {
        System.out.println("=== LOG DE AUDITORIA ===");
        System.out.println("ID: " + id);
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Ação: " + acao);
        System.out.println("Entidade afetada: " + entidadeAfetada);
        System.out.println("ID da entidade: " + idEntidade);
        System.out.println("IP de origem: " + ipOrigem);
    }
}