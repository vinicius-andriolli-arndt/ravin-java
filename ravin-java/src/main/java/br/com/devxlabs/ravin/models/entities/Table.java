package br.com.devxlabs.ravin.models.entities;

import java.util.List;

import br.com.devxlabs.ravin.enums.TableStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
@jakarta.persistence.Table (name =  "restaurant_table")
public class Table {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Employee employee;
	
	@OneToMany(mappedBy = "table",cascade = CascadeType.ALL)
	private List<Commanda> commands;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(unique = true)
	private int number;
	
	@Enumerated(value = EnumType.STRING)
	private TableStatus tableStatus;

	public Table() {
		// TODO Auto-generated constructor stub
	}

	public Table(int id, Employee employee, List<Commanda> commands, String name, String code, int number,
			TableStatus tableStatus) {
		super();
		this.id = id;
		this.employee = employee;
		this.commands = commands;
		this.name = name;
		this.code = code;
		this.number = number;
		this.tableStatus = tableStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Commanda> getCommands() {
		return commands;
	}

	public void setCommands(List<Commanda> commands) {
		this.commands = commands;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public TableStatus getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(TableStatus tableStatus) {
		this.tableStatus = tableStatus;
	}
}
