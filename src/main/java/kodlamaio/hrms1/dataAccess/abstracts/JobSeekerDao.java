package kodlamaio.hrms1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms1.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

	JobSeeker findJobSeekerByNationalId(String nationalId);
}
