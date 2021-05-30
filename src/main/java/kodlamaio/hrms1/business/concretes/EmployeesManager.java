package kodlamaio.hrms1.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.EmployeesService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms1.dataAccess.abstracts.EmployeesDao;
import kodlamaio.hrms1.entities.concretes.Employee;

@Service
public class EmployeesManager implements EmployeesService{

private EmployeesDao employeesDao;
	
	@Autowired
	public EmployeesManager(EmployeesDao employeesDao) {
		this.employeesDao = employeesDao;
	    }

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeesDao.findAll());
}}
