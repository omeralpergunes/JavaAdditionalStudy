package kodlamaio.hrms1.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.ValidationCodeService;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.dataAccess.abstracts.ValidationCodeDao;
import kodlamaio.hrms1.entities.concretes.ValidationCode;

@Service
public class ValidationCodeManager implements ValidationCodeService {

private ValidationCodeDao validationCodeDao;
	
	@Autowired
	public ValidationCodeManager(ValidationCodeDao	 validationCodeDao) {
		super();
		this.validationCodeDao = validationCodeDao;
	}

	@Override
	public Result add(ValidationCode code) {
		this.validationCodeDao.save(code);
		return new SuccessResult("Code has been saved.");
	}
}
