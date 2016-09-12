package br.com.tt.pet.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Proprietario {

	@Id
	@SequenceGenerator(name = "proprietario_seq", sequenceName = "proprietario_seq", allocationSize = 1)
	@GeneratedValue(generator = "proprietario_seq", strategy = GenerationType.SEQUENCE)

	@Column(name = "codigo_proprietario", nullable = false, unique = true)
	private Long id;

	@Column(name = "nome_do_proprietario", nullable = false, length = 60)
	private String nome;

	@Column(name = "documento_CPF", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "telefone_principal", length = 16)
	private String phone_prin;

	@Column(name = "telefone_opcional", length = 16)
	private String phone_op;

	@Column(name = "email", length = 60)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascimento")
	private Date dt_nasc;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone_prin() {
		return phone_prin;
	}

	public void setPhone_prin(String phone_prin) {
		this.phone_prin = phone_prin;
	}

	public String getPhone_op() {
		return phone_op;
	}

	public void setPhone_op(String phone_op) {
		this.phone_op = phone_op;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

}
