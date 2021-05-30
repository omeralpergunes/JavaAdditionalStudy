package kodlamaio.hrms1.business.abstracts;

import java.util.List;



import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobPosition;

public interface JobPositionService {

	Result add(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> getJobByTitle(String title);
}
