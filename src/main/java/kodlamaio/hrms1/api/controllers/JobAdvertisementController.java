package kodlamaio.hrms1.api.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms1.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	
	@PostMapping("/add")
	
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){		
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id){
		return this.jobAdvertisementService.changeOpenToClose(id);
	}
	
	@GetMapping("/getAllOpenJobAdvertisementList")
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList(){
		return this.jobAdvertisementService.getAllOpenJobAdvertisementList();
	}
	
	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAt(){
		return this.jobAdvertisementService.findAllByOrderByPublishedAt();
	}
	
	@GetMapping("/getAllOpenJobAdvertisementByEmployer")
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementByEmployer(int id){
		return this.jobAdvertisementService.getAllOpenJobAdvertisementByEmployer(id);
	}
}
