package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.DaoCustomer;
import model.Customer;

@ManagedBean
@SessionScoped
public class ControllerCustomer {
	
	private Customer customer;
	private DaoCustomer dao;
	
	public ControllerCustomer() {
		customer = new Customer();
		dao = new DaoCustomer();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DaoCustomer getDao() {
		return dao;
	}

	public void setDao(DaoCustomer dao) {
		this.dao = dao;
	}
	
	public void gravar(Customer obj){
		dao.gravar(obj);
		customer = new Customer();
		
	}
	
	public void listar(){
		
	}

}
