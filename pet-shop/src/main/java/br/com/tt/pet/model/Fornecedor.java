package br.com.tt.pet.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Fornecedor {

	@Id
	@SequenceGenerator(name = "fornecedor_seq", sequenceName = "fornecedor_seq", allocationSize = 1)
	@GeneratedValue(generator = "fornecedor_seq", strategy = GenerationType.SEQUENCE)

	@Column(name = "id_fornecedor", nullable = false, unique = true)
	private Long id;

	@Column(name = "cnpj_fornecedor", nullable = false, length = 14, unique = true)
	private String cnpj;

	@Column(name = "razao_social", length = 60)
	private String rsocial;

	@Column(name = "nome_fantasia", length = 60)
	private String name_fan;

	@Column(name = "telefone_principal", length = 16)
	private String phone_pri;

	@Column(name = "telefone_opcional", length = 16)
	private String phone_op;

	@Column(name = "email_principal", length = 45)
	private String email_pri;

	@Column(name = "email_opcional", length = 45)
	private String email_op;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRsocial() {
		return rsocial;
	}

	public void setRsocial(String rsocial) {
		this.rsocial = rsocial;
	}

	public String getName_fan() {
		return name_fan;
	}

	public void setName_fan(String name_fan) {
		this.name_fan = name_fan;
	}

	public String getPhone_pri() {
		return phone_pri;
	}

	public void setPhone_pri(String phone_pri) {
		this.phone_pri = phone_pri;
	}

	public String getPhone_op() {
		return phone_op;
	}

	public void setPhone_op(String phone_op) {
		this.phone_op = phone_op;
	}

	public String getEmail_pri() {
		return email_pri;
	}

	public void setEmail_pri(String email_pri) {
		this.email_pri = email_pri;
	}

	public String getEmail_op() {
		return email_op;
	}

	public void setEmail_op(String email_op) {
		this.email_op = email_op;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
