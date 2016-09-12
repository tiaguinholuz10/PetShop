package br.com.tt.pet.controller.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.pet.dao.Dao;
import br.com.tt.pet.dao.IDao;
import br.com.tt.pet.model.Pet;
import br.com.tt.util.faces.MessageUtil;

@ManagedBean
@SessionScoped

public class PetBean {

	private Pet pet = new Pet();
	private List<Pet> pets;
	private IDao<Pet> dao;

	@PostConstruct
	private void init() {
		dao = new Dao<Pet>(Pet.class);
		pets = new ArrayList<Pet>();
		pets = dao.consultar();
		pet = new Pet();
	}

	public void alterar(Pet pet) {

		this.pet = pet;

	}

	public void cancelar() {

		MessageUtil.warn("O Cadastro foi Cancelado...", " Cancelado o Cadastro!");
		pet = new Pet();

	}

	public void salvar() {

		try {

			dao.salvar(pet);
			MessageUtil.info("Pet Salvo...", "O cadastro Pet foi salvo com sucesso!");
			pets = dao.consultar();

		} catch (Exception e) {

			MessageUtil.error("Error ao Cadastrar Dados - Verifique os dados informados  ",
					"*Error ao Gravar Dados...");
		} finally {

			pet = new Pet();

		}
	}

	public List<Pet> getPets() {

		for (Pet pet : pets) {
			System.out.println("Lista nome do pet: " + pet.getNome());
		}
		return pets;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

}
