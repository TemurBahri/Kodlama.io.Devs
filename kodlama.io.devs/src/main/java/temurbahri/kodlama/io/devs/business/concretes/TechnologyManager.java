package temurbahri.kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import temurbahri.kodlama.io.devs.business.abstracts.TechnologyService;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.CreateTechnologyRequest;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.DeleteTechnologyRequest;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.UpdateTechnologyRequest;
import temurbahri.kodlama.io.devs.business.response.techonogyresponses.GetAllTechnologyResponse;
import temurbahri.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import temurbahri.kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import temurbahri.kodlama.io.devs.entities.concretes.ProgrammingLanguages;
import temurbahri.kodlama.io.devs.entities.concretes.Technology;


@Service
public class TechnologyManager implements TechnologyService {
	
	private TechnologyRepository technologyRepository;
	private ProgramingLanguageRepository programmingLanguageRepository;
	
	
	

	public TechnologyManager(TechnologyRepository technologyRepository,ProgramingLanguageRepository programingLanguageRepository) {
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programingLanguageRepository;
	}

	

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> responses = new ArrayList<>();

        for (Technology technology: technologies) {
        	GetAllTechnologyResponse response = new GetAllTechnologyResponse();

            response.setName(technology.getName());
            response.setLanguageName(technology.getProgrammingLanguage().getName());

            responses.add(response);
        }
        return responses;
	}

	@Override
	public void save(CreateTechnologyRequest createTechnologyRequest) {
		 Technology techonology = new Technology();
	        ProgrammingLanguages programmingLanguage =
	                programmingLanguageRepository.findById(createTechnologyRequest.getProgramLanguageId()).get();

	        techonology.setName(createTechnologyRequest.getName());
	        techonology.setProgrammingLanguage(programmingLanguage);

	        technologyRepository.save(techonology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyRepository.deleteById(deleteTechnologyRequest.getId());
		
	}

	@Override
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology =
				technologyRepository.findById(id).get();

        ProgrammingLanguages programmingLanguage
                = programmingLanguageRepository.findById(updateTechnologyRequest.getProgrammingLanguageId()).get();

        technology.setName(updateTechnologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);

        technologyRepository.save(technology);
		
	}

}
