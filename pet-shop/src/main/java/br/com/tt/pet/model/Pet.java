package br.com.tt.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pet {

	@Id
	@SequenceGenerator(name = "pet_seq", sequenceName = "pet_seq", allocationSize = 1)
	@GeneratedValue(generator = "pet_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@Column(name = "cor", nullable = false, length = 45)
	private String cor;

	@Column(name = "raca", nullable = false, length = 60)
	private String raca;

	@Column(name = "especie", nullable = false, length = 60)
	private String especie;

	@Column(name = "sexo", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "descricao", nullable = true, length = 100)
	private String desc;

	@Column(name = "observacoes", nullable = true, length = 250)
	private String obs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
