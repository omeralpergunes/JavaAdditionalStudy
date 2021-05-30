package kodlamaio.hrms1.entities.concretes;

import java.time.LocalDate;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_positions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertiments"})
public class JobPosition {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name= "created_at", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name= "is_active", columnDefinition = "boolean true")
	private boolean isActive = true;
	
	@Column(name= "is_deleted", columnDefinition = "boolean false")
	private boolean isDeleted = false;
	
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvertisement> jobAdvertisements;

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getJobTitle() {
		// TODO Auto-generated method stub
		return false;
	} 
}
