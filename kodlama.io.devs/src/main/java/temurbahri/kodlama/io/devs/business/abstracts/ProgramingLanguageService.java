package temurbahri.kodlama.io.devs.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.CreateProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.DeleteProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.UpdateProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.response.programlanguagesresponses.GetAllProgrammingLanguageResponse;
import temurbahri.kodlama.io.devs.business.response.programlanguagesresponses.GetByIdProgrammingLanguageResponse;

@Service
public interface ProgramingLanguageService {
	
	
	List<GetAllProgrammingLanguageResponse> getAll();
	
	GetByIdProgrammingLanguageResponse getById(int id);
	
	void save(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
    void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
    void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);

}
