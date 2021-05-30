package kodlamaio.hrms1.business.abstracts;


import java.util.List;

import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	Result changeOpenToClose(int id);
	DataResult<JobAdvertisement> getById(int id);	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList();
	DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAt();
	DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementByEmployer(int id);
}
