import model.Funcionario;
import repository.FuncionarioRepo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class main {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private NumberFormat moeda = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

    /* 
     * Executa as tasks do exercício 3.1 ao 3.12, imprimindo os resultados no console.
     */
    public void executar_main(String[] args) {
        System.out.println("3.1: Inserir todos os funcionários:");
        task_3_1();
        System.out.println("3.2: Remover funcionários com o nome João da lista de funcionários:");
        task_3_2();
        System.out.println("3.3: Imprimir todos os funcionários com todas suas informações:");
        task_3_3();
        System.out.println("3.4: Os funcionários receberam 10% de aumento de salário:");
        task_3_4();
        System.out.println("3.5: Agrupar os funcionários por função em um MAP, sendo a chave a função e o valor a lista de funcionários:");
        task_3_5();
        System.out.println("3.6: Imprimir funcionários , agrupados por função:");
        task_3_6();
        System.out.println("3.8: Imprimir os funcionários que fazem aniversário no mês 10 e 12:");
        task_3_8();
        System.out.println("3.9: Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade:");
        task_3_9();
        System.out.println("3.10: Imprimir a lista de funcionários por ordem alfabética:");
        task_3_10();
        System.out.println("3.11: Imprimir o total dos salários dos funcionários:");
        task_3_11();
        System.out.println("3.12: Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$ 1,212.00:");
        task_3_12();
    }
    
    /* Task 3.1 
     * Carregar a lista de funcionários do repositório
     */
    private void task_3_1() {
        funcionarios = FuncionarioRepo.loadFuncionarios();
        System.out.println("ok");
    }

    /* Task 3.2
     * Remover funcionários com o nome João da lista de funcionários
     */
    private void task_3_2() {
        // Remover funcionários com o nome João da lista de funcionários
        funcionarios.removeIf(funcionario -> funcionario.getPessoa().getNome().equalsIgnoreCase("Joao"));
    }

    /* Task 3.3
     * Imprimir todos os funcionários com todas suas informações
     */
    private void task_3_3() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getPessoa().getNome() +
                    ", Data de nascimento: " + funcionario.getPessoa().getDataNasc().format(formatoData) +
                    ", Salário: " + funcionario.getSalario() +
                    ", Função: " + funcionario.getFuncao());
        }
        System.out.println();
    }

    /* Task 3.4
     * Aplicar um aumento de 10% no salário de todos os funcionários
     */
    private void task_3_4() {
        // Os funcionários receberam 10% de aumento de salário, atualizando a lista de funcionários com os novos salários
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(new BigDecimal("0.10"));
            BigDecimal novoSalario = salarioAtual.add(aumento).setScale(2, RoundingMode.HALF_UP);
            funcionario.setSalario(novoSalario);
        }
    }

    /* Task 3.5
     * Agrupar os funcionários por função, em um MAP, sendo a chave a função e o valor a lista de funcionários 
     */
    private Map<String, List<Funcionario>> task_3_5() {
        // Criar um mapa para armazenar a contagem de funcionários por função
        Map<String, List<Funcionario>> contagemPorFuncao = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            contagemPorFuncao.put(funcao, contagemPorFuncao.getOrDefault(funcao, new ArrayList<>()));
            contagemPorFuncao.get(funcao).add(funcionario);
        }
        
        return contagemPorFuncao;
    }

    /* Task 3.6
     * Exibir os funcionários agrupados por função
     */
    private void task_3_6() {
        // Le os dados agrupados
        Map<String, List<Funcionario>> contagemPorFuncao = task_3_5();
        String funcaoAtual = "";
        for (Map.Entry<String, List<Funcionario>> entry : contagemPorFuncao.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcionariosDaFuncao = entry.getValue();
            if (!funcao.equals(funcaoAtual)) {
                System.out.println("Função: " + funcao);
                funcaoAtual = funcao;   
            }
            for (Funcionario funcionario : funcionariosDaFuncao) {
                System.out.println(" - " + funcionario.getPessoa().getNome() + ", Salário: R$ " + moeda.format(funcionario.getSalario().doubleValue()));
            }
        }
        System.out.println();
    }
    
    /* Task 3.8
     * Exibir os funcionários que nasceram no mes 10 e 12
     */
    private void task_3_8() {
        for (Funcionario funcionario : funcionarios) {
            int mesNascimento = funcionario.getPessoa().getDataNasc().getMonthValue();
            if (mesNascimento == 10 || mesNascimento == 12) {
                System.out.println(funcionario.getPessoa().getNome() + " - " + funcionario.getPessoa().getDataNasc().format(formatoData));
            }
        }
    }

    /* Task 3.9
     * Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
     */
    private void task_3_9() {
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .max(Comparator.comparing(f -> f.getPessoa().getDataNasc()))
                .orElse(null);
        if (funcionarioMaisVelho != null) {
            System.out.println("Nome: " + funcionarioMaisVelho.getPessoa().getNome() + ", Idade: "
                    + ChronoUnit.YEARS.between(funcionarioMaisVelho.getPessoa().getDataNasc(), LocalDate.now()));
        }
    }

    /* Task 3.10
     * Ordenar a lista de funcionários pelo nome
     */
    private void task_3_10() {
        funcionarios.sort(Comparator.comparing(f -> f.getPessoa().getNome()));
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getPessoa().getNome() + " - " + funcionario.getPessoa().getDataNasc().format(formatoData) + " - R$ " + moeda.format(funcionario.getSalario().doubleValue()) + " - " + funcionario.getFuncao());
        }
    }

    /* Task 3.11
     * Calcular o total dos salários
     */
    private void task_3_11() {
        double totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        System.out.println("Total dos salários: R$ " + moeda.format(totalSalarios));
    }

    /* Task 3.12
     * Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
     */
    private void task_3_12() {
        double salarioMinimo = 1212.00;

        for (Funcionario funcionario : funcionarios) {
            double qtdeSalarioMinimo = funcionario.getSalario().doubleValue() / salarioMinimo;
            System.out.println("Funcionário: " + funcionario.getPessoa().getNome() + " - " + BigDecimal.valueOf(qtdeSalarioMinimo).setScale(2, RoundingMode.HALF_UP).toString() + " salários mínimos");
        }
    }
    
    public static void main(String[] args) {
        new main().executar_main(args);
    }
}
