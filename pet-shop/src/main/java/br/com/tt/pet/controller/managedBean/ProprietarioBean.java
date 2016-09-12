package br.com.tt.pet.controller.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.pet.dao.Dao;
import br.com.tt.pet.dao.IDao;
import br.com.tt.pet.model.Endereco;
import br.com.tt.pet.model.Proprietario;
import br.com.tt.util.faces.MessageUtil;

@ManagedBean(name = "proprietario")
@SessionScoped
public class ProprietarioBean {

	private Proprietario proprietario;
	private Endereco endereco;
	private List<Proprietario> proprietarios;
	private IDao<Proprietario> dao;

	@PostConstruct
	private void init() {

		dao = new Dao<Proprietario>(Proprietario.class);
		proprietario = new Proprietario();
		endereco = new Endereco();
		proprietarios = new ArrayList<Proprietario>();
		proprietarios = dao.consultar();

	}

	public void salvar() {

		try {

			proprietario.setEndereco(endereco);
			dao.salvar(proprietario);
			proprietarios = dao.consultar();
			MessageUtil.info("Proprietario Salvo...", "Proprietario salvo com sucesso!");

		} catch (Exception e) {

			MessageUtil.error("Error ao Cadastrar Dados - Verifique os dados informados ",
					" *Error ao Gravar Dados...");

		} finally {

			proprietario = new Proprietario();
			endereco = new Endereco();
		}

	}

	public void cancelar() {

		MessageUtil.warn("O Cadastro foi Cancelado...", " Cancelado o Cadastro!");
		proprietario = new Proprietario();
		endereco = new Endereco();

	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Proprietario> getProprietarios() {

		//Locale loc = Locale.getDefault();
		for (Proprietario proprietario : proprietarios) {
			System.out.println("Lista nome do proprietario: " + proprietario.getNome());

		}
		return proprietarios;
	}

}
