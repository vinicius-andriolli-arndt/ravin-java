package br.com.devxlabs.ravin.models.entities;

import java.util.List;

import br.com.devxlabs.ravin.enums.CommandaStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Commanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "table_id")
	private Table table;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderDetail> orders;
	
	@Column(unique = true, nullable = false)
	private String code;
	
	private String comments;
	
	@Enumerated(value = EnumType.STRING)
	private CommandaStatus commandaStatus;

	public Commanda() {
		// TODO Auto-generated constructor stub
	}

	public Commanda(int id, Table table, Customer customer, List<OrderDetail> orders, String code,
			String comments, CommandaStatus commandaStatus) {
		super();
		this.id = id;
		this.table = table;
		this.customer = customer;
		this.orders = orders;
		this.code = code;
		this.comments = comments;
		this.commandaStatus = commandaStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public CommandaStatus getCommandaStatus() {
		return commandaStatus;
	}

	public void setCommandaStatus(CommandaStatus commandaStatus) {
		this.commandaStatus = commandaStatus;
	}

	@Override
	public String toString() {
		return "Commanda [id=" + id + ", table=" + table + ", customer=" + customer + ", orders=" + orders + ", code="
				+ code + ", comments=" + comments + ", commandaStatus=" + commandaStatus + "]";
	}	
}
