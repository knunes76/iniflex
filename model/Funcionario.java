package model;

import java.math.BigDecimal;

public class Funcionario {
    private Pessoa pessoa;
    private BigDecimal salario;
    private String funcao;

    public Funcionario(Pessoa pessoa, BigDecimal salario, String funcao) {
        this.pessoa = pessoa;
        this.salario = salario;
        this.funcao = funcao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

	public void setSalario(BigDecimal salarioAtual) {
		this.salario = salarioAtual;
	}
}
