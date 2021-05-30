package kodlamaio.hrms1.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	
	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (!CheckIfNullField(jobAdvertisement)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advert has been added.");
	}

	@Override
	public Result update(JobAdvertisement jobAdvert) {
		this.jobAdvertisementDao.save(jobAdvert);
		return new SuccessResult("Job advert has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("Job advert has been deleted.");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public Result changeOpenToClose(int id) {
		if (getById(id) == null) {
			return new ErrorResult("There is no such job advert");

		}
		if (getById(id).getData().isOpen() == false) {
			return new ErrorResult("There job advert is already closed.");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setOpen(false);
		update(jobAdvertisement);
		return new SuccessResult("Job advert has been successfully closed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllOpenJobAdvertisementList());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAt() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllOpenJobAdvertisementByEmployer(id));
	}

	private boolean CheckIfNullField(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getJobPosition() != null && jobAdvertisement.getDescription() != null && jobAdvertisement.getClass() != null
				&& jobAdvertisement.getOpenPositionCount() != 0) {
			return true;
		}
		return false;
	}
}