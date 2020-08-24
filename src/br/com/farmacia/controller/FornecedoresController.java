package br.com.farmacia.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;

@ManagedBean(name = "MBFornecedores")//utilizado para passar a função de referencia para outras classes
@ViewScoped
public class FornecedoresController {
	
	private Fornecedores fornecedores;
	

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}


	private ListDataModel<Fornecedores>itens;

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}
	
	
	@PostConstruct //vai iniciar com a lista aberta
	public void prepararPesquisa() {
		try {
			FornecedoresDAO fornecedorDAO = new FornecedoresDAO();
			ArrayList<Fornecedores>lista = fornecedorDAO.listProviders();
			
			itens = new ListDataModel<Fornecedores>(lista);//colocando a variavel lista dentro de um ListDataModel do primefaces
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void novo() {
			try {
				FornecedoresDAO fornecedorDAO = new FornecedoresDAO();
				fornecedorDAO.insertProvider(fornecedores);
			} catch (Exception e) {
				System.out.println("erro: " + e);
			}
	}
	
}
