package kodlamaio.hrms1.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms1.business.abstracts.AuthService;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.Employer;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmpolyer(@RequestBody Employer employer, String confirmPassword)
	{
		return authService.registerEmployer(employer, confirmPassword);
	}
	
	@PostMapping("/registerJobSeeker")
	public Result registerJobSeeker(@RequestBody JobSeeker jobSeeker, String confirmPassword)
	{
		return authService.registerJobSeeker(jobSeeker, confirmPassword);
	}
}
