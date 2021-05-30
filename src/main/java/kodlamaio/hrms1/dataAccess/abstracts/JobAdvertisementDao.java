package kodlamaio.hrms1.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isOpen = true")
	List<JobAdvertisement> getAllOpenJobAdvertisementList();
	
	@Query("From JobAdvertisement where isOpen = true Order By publishedAt Desc")
	List<JobAdvertisement> findAllByOrderByPublishedAtDesc();
	
	@Query("From JobAdvertisement where isOpen = true and employer_id =:id")
	List<JobAdvertisement> getAllOpenJobAdvertisementByEmployer(int id);

}
