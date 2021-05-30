package kodlamaio.hrms1.business.abstracts;

import java.util.List;

import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
}
