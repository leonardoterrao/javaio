package javaio.serializacao;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Pessoa implements Serializable {

	private final String cpf;
	private final String nome;
	private final Date dataNascimento;

	public Pessoa(String cpf, String nome, Date dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento.toLocaleString() + "]";
	}

}
