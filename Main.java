public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA PETCARE ===\n");

        // ===== USUÁRIOS =====
        Usuario usuario = new Usuario(1, "João Silva", "joao@email.com", "123", "ADMIN");

        if (usuario.login("joao@email.com", "123")) {
            System.out.println("Login realizado com sucesso!\n");
        } else {
            System.out.println("Falha no login!\n");
        }

        usuario.exibir();

        System.out.println("\n============================\n");

        Administrador admin = new Administrador(
                10,
                "Ana Admin",
                "ana@petcare.com",
                "123"
        );

        Recepcionista recepcionista = new Recepcionista(
                11,
                "Maria Recepção",
                "maria@petcare.com",
                "123",
                "Manhã"
        );

        admin.exibir();
        System.out.println();

        recepcionista.exibir();

        System.out.println("\n============================\n");

        // ===== TUTOR =====
        Tutor tutor = new Tutor(
                2,
                "Maria Souza",
                "maria@email.com",
                "123",
                "99999-9999",
                "Rua A, 123"
        );

        tutor.exibir();

        System.out.println("\n============================\n");

        // ===== ANIMAL =====
        Animal animal = new Animal(1, "Rex", "Cachorro", "Labrador", tutor);
        animal.setPeso(12.3);
        animal.setDataNascimento("2020-04-10");
        animal.exibir();

        System.out.println("\n============================\n");

        // ===== VETERINÁRIO =====
        Veterinario vet = new Veterinario(
                3,
                "Dr. Carlos",
                "carlos@petcare.com",
                "123",
                "CRMV-ES 1234",
                "Clínico Geral"
        );

        vet.exibir();

        System.out.println("\n============================\n");

        // ===== NOTIFICADOR =====
        Notificador notificador = new Notificador("EMAIL", tutor.getEmail());

        // ===== AGENDAMENTO =====
        Agendamento agendamento = new Agendamento(
                1,
                "2026-04-10 10:00",
                "Consulta",
                animal,
                vet,
                "Sala 1",
                notificador
        );

        System.out.println("Tentando realizar agendamento...\n");

        if (agendamento.agendar()) {
            System.out.println("Agendamento realizado com sucesso!\n");
        } else {
            System.out.println("Erro ao agendar.\n");
        }

        agendamento.exibir();

        System.out.println("\n============================\n");

        // ===== CONSULTA =====
        Consulta consulta = new Consulta(
                1,
                "2026-04-10",
                "Consulta de rotina",
                vet,
                "Check-up"
        );
        consulta.setPrescricao("Vitamina e repouso");
        consulta.setDataRetorno("2026-04-20");
        animal.getHistorico().adicionarConsulta(consulta);

        // ===== VACINA =====
        Vacina vacina = new Vacina(
                2,
                "2026-04-10",
                "Vacinação anual",
                vet,
                "Antirrábica"
        );
        vacina.setDataReforco("2027-04-10");
        vacina.setLote("VAC123");
        vacina.setFabricante("VetPharma");
        animal.getHistorico().adicionarVacina(vacina);

        // ===== EXAME =====
        Exame exame = new Exame(
                3,
                "2026-04-11",
                "Exame de sangue",
                vet,
                "Hemograma"
        );
        exame.setResultado("Sem alterações");
        exame.setLaboratorio("Lab Vet");
        animal.getHistorico().adicionarExame(exame);

        // ===== CIRURGIA =====
        Cirurgia cirurgia = new Cirurgia(
                4,
                "2026-04-12",
                "Cirurgia ortopédica",
                vet,
                "Correção de fratura"
        );
        cirurgia.setAnestesia("Geral");
        cirurgia.setObservacoes("Procedimento realizado com sucesso");
        cirurgia.setInternacao(true);
        animal.getHistorico().adicionarCirurgia(cirurgia);

        // ===== TRATAMENTO =====
        Tratamento tratamento = new Tratamento(
                "Antibiótico por 7 dias",
                "2026-04-10",
                "2026-04-17"
        );
        animal.getHistorico().adicionarTratamento(tratamento);

        System.out.println("=== REGISTROS CLÍNICOS ===");
        consulta.exibir();
        System.out.println();
        vacina.exibir();
        System.out.println();
        exame.exibir();
        System.out.println();
        cirurgia.exibir();
        System.out.println();
        tratamento.exibir();

        System.out.println("\n============================\n");

        // ===== HISTÓRICO CLÍNICO =====
        animal.getHistorico().exibir();

        System.out.println("\n============================\n");

        // ===== REAGENDAMENTO =====
        System.out.println("Reagendando...\n");
        agendamento.reagendar("2026-04-11 14:00");
        agendamento.exibir();

        System.out.println("\n============================\n");

        // ===== CANCELAMENTO =====
        System.out.println("Cancelando agendamento...\n");
        agendamento.cancelar("Imprevisto do tutor");

        System.out.println("\nHistórico do agendamento:");
        for (String h : agendamento.getHistorico()) {
            System.out.println("- " + h);
        }

        System.out.println("\n============================\n");

        // ===== ESTOQUE =====
        Notificador notificadorEstoque = new Notificador("EMAIL", "estoque@petcare.com");
        Estoque estoque = new Estoque(notificadorEstoque);

        ItemEstoque item1 = new ItemEstoque(1, "Dipirona", 50, 10, "L001");
        item1.setCategoria("Medicamento");

        ItemEstoque item2 = new ItemEstoque(2, "Seringa", 5, 8, "L002");
        item2.setCategoria("Material");

        estoque.adicionarItem(item1);
        estoque.adicionarItem(item2);

        estoque.exibir();

        System.out.println("\nSaídas de estoque:");
        estoque.registrarSaida(1, 45, "Ana");
        estoque.registrarSaida(2, 1, "Carlos");

        System.out.println();
        estoque.verificarAlertas();

        System.out.println("\n============================\n");

        // ===== FATURA =====
        Fatura fatura = new Fatura(
                1,
                tutor,
                150.0,
                "Consulta veterinária",
                notificador
        );

        fatura.emitir();
        System.out.println("Boleto: " + fatura.gerarBoleto());
        System.out.println("Link de pagamento: " + fatura.gerarLinkPagamento());
        fatura.exibir();

        System.out.println("\n============================\n");

        // ===== RELATÓRIO =====
        Relatorio relatorio = new Relatorio(1, 4, 2026);
        relatorio.gerar();
        relatorio.exibir();

        System.out.println("\n============================\n");

        // ===== LOG DE AUDITORIA =====
        LogAuditoria log = new LogAuditoria(admin, "GERAR_RELATORIO", "Relatorio", 1);
        log.registrar();
        log.exibir();

        System.out.println("\n============================\n");

        System.out.println("=== FIM DO SISTEMA ===");
    }
}