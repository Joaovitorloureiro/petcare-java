# PetCare — Sistema de Clínica Veterinária (Java)

Projeto acadêmico da disciplina **Programação Orientada a Objetos I** — Ciências da Computação, Universidade de Vila Velha (UVV).
Desenvolvido em dupla: João Vitor de Carvalho Loureiro e Murilo Cipriano Carvalho.

## O que o sistema faz
- **Usuários:** classe base `Usuario` com login; perfis por herança: `Administrador`, `Recepcionista`, `Tutor` e `Veterinario`.
- **Animais e histórico clínico:** cada `Animal` tem um `HistoricoClinico` com consultas, vacinas, exames, cirurgias e tratamentos.
- **Registros clínicos:** `Consulta`, `Vacina`, `Exame` e `Cirurgia` herdam de `RegistroClinico`.
- **Agendamento:** valida horário (08h às 18h) e disponibilidade do veterinário; permite reagendar e cancelar, guardando histórico e notificando o tutor.
- **Estoque:** entradas e saídas com responsável e alerta quando um item fica abaixo do mínimo.
- **Financeiro:** emissão de `Fatura` com boleto e link de pagamento (simulados).
- **Relatório mensal** e **log de auditoria** das ações dos usuários.

## Conceitos de POO aplicados
Encapsulamento, herança, composição/agregação entre classes e organização em 21 classes com responsabilidades separadas.

## Como executar
Requisito: Java (JDK) instalado.

```bash
javac -encoding UTF-8 *.java
java Main
```

No VS Code: abra `Main.java` e clique em **Run** acima do método `main`.
