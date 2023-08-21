package br.com.devxlabs.ravin.controllers.interfaces;

import java.util.List;

import br.com.devxlabs.ravin.entities.Employee;

public interface EmployeeControllerInterface extends ControllerInterface<Employee> {
	
	public List<Employee> listAvailableWaiters();

}
