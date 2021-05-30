package kodlamaio.hrms1.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms1.business.abstracts.EmployeesService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeesService employeesService;

	@Autowired
	public EmployeesController(EmployeesService employeesService) {
		super();
		this.employeesService = employeesService;
	}
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return this.employeesService.getAll();
}}
