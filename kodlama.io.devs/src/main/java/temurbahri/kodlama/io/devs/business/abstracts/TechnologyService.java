package temurbahri.kodlama.io.devs.business.abstracts;

import java.util.List;

import temurbahri.kodlama.io.devs.business.requests.technologyrequests.CreateTechnologyRequest;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.DeleteTechnologyRequest;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.UpdateTechnologyRequest;
import temurbahri.kodlama.io.devs.business.response.techonogyresponses.GetAllTechnologyResponse;

public interface TechnologyService {

	List<GetAllTechnologyResponse> getAll();

	void save(CreateTechnologyRequest createPTechnologyRequest);

	void delete(DeleteTechnologyRequest deleteTechnologyRequest);

	void update(int id, UpdateTechnologyRequest updateTechnologyRequest);

}
