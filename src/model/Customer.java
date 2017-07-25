package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer id_customer;
	@CPF
	private String cpf_cnpj;
	@NotEmpty
	private String nm_customer;
	private Boolean is_active;
	@NotNull
	private Double vl_total;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId_customer() {
		return id_customer;
	}

	public void setId_customer(Integer id_customer) {
		this.id_customer = id_customer;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNm_customer() {
		return nm_customer;
	}

	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Double getVl_total() {
		return vl_total;
	}

	public void setVl_total(Double vl_total) {
		this.vl_total = vl_total;
	}
	
	

}
