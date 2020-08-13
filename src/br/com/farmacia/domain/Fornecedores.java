package br.com.farmacia.domain;

public class Fornecedores {

	private int codigoFornecedor;
	private String nome;
	private String email;
	private String telefone;
	
	
	
	public int getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(int codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		String saida = codigoFornecedor + " - " + nome + " - " + email + " - " + telefone;
		
		return saida;
	}
	
	
}
