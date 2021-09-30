package model;

import java.util.ArrayList;

public class ManagerStore {
	private ArrayList<Employee> employees;
	private ArrayList<Customer> customers;
	private Store store;
	private Warehouse warehouse;
	public ManagerStore(Store store, Warehouse warehouse) {
		this.store = store;
		this.warehouse = warehouse;
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
	}
	
}
