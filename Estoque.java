import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<ItemEstoque> itens;
    private Notificador notificador;

    public Estoque(Notificador notificador) {
        this.itens = new ArrayList<>();
        this.notificador = notificador;
    }

    public void adicionarItem(ItemEstoque item) {
        itens.add(item);
    }

    public void registrarEntrada(int id, int qtd, String responsavel) {
        for (ItemEstoque item : itens) {
            if (item != null && item.getId() == id) {
                item.darEntrada(qtd, responsavel);
                return;
            }
        }
    }

    public boolean registrarSaida(int id, int qtd, String responsavel) {
        for (ItemEstoque item : itens) {
            if (item != null && item.getId() == id) {
                boolean saiu = item.darSaida(qtd, responsavel);

                if (saiu && item.isAbaixoMinimo()) {
                    notificador.enviarAlertaEstoque(item.getNome());
                }

                return saiu;
            }
        }
        return false;
    }

    public boolean reservarParaProced(Agendamento ag) {
        return true;
    }

    public void verificarAlertas() {
        for (ItemEstoque item : itens) {
            if (item.isAbaixoMinimo()) {
                notificador.enviarAlertaEstoque(item.getNome());
            }
        }
    }

    public ItemEstoque buscarItem(String nome) {
        for (ItemEstoque item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }

    public List<ItemEstoque> rastrearControlados() {
        List<ItemEstoque> controlados = new ArrayList<>();

        for (ItemEstoque item : itens) {
            if (item.isControlado()) {
                controlados.add(item);
            }
        }

        return controlados;
    }

    public void alertarVencimentos() {
        for (ItemEstoque item : itens) {
            if (item.isVencido()) {
                notificador.enviarAlerta("ESTOQUE", "Item vencido: " + item.getNome());
            }
        }
    }

    public void gerarRelatorioRastreab() {
        System.out.println("=== RELATÓRIO DE RASTREABILIDADE ===");
        for (ItemEstoque item : rastrearControlados()) {
            item.exibir();
        }
    }

    public void exibir() {
        System.out.println("=== ESTOQUE ===");
        for (ItemEstoque item : itens) {
            item.exibir();
        }
    }
}