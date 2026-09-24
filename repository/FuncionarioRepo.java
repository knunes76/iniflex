package repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import model.Funcionario;
import model.Pessoa;

import java.util.ArrayList;

public class FuncionarioRepo {
    

    public static List<Funcionario> loadFuncionarios() {

        List<Funcionario> funcionarios = new ArrayList<>();
        // Implementação para carregar os funcionários do banco de dados ou de um arquivo
        funcionarios.add(new Funcionario(new Pessoa("Maria", LocalDate.of(2000, 10, 18)),
                new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(
                new Funcionario(new Pessoa("Joao", LocalDate.of(1990, 5, 12)), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario(new Pessoa("Caio", LocalDate.of(1961, 5, 2)), new BigDecimal("9836.14"),
                "Coordenador"));
        funcionarios.add(new Funcionario(new Pessoa("Miguel", LocalDate.of(1988, 10, 14)),
                new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario(new Pessoa("Alice", LocalDate.of(1995, 1, 5)), new BigDecimal("2234.68"),
                "Recepcionista"));
        funcionarios.add(new Funcionario(new Pessoa("Heitor", LocalDate.of(1999, 11, 19)),
                new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario(new Pessoa("Arthur", LocalDate.of(1993, 3, 31)),
                new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(
                new Funcionario(new Pessoa("Laura", LocalDate.of(1994, 7, 8)), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario(new Pessoa("Heloísa", LocalDate.of(2003, 5, 24)),
                new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(
                new Funcionario(new Pessoa("Helena", LocalDate.of(1996, 9, 2)), new BigDecimal("2799.93"), "Gerente"));
        
        return funcionarios;
    }
}
