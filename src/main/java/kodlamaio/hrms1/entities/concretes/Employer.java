package kodlamaio.hrms1.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User{

	@Column(name= "company_name")
	private String companyName;
	
	@Column(name= "website")
	private String website;
	
	@Column(name= "phone_number")
	private String phoneNumber;
	
	@Column(name = "is_verified", columnDefinition = "boolean false")
	private boolean isVerified = false;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

	public String getWebsite() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getCompanyName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}
}
