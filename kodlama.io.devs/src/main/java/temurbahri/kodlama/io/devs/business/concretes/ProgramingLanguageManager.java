package temurbahri.kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import temurbahri.kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.CreateProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.DeleteProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.UpdateProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.response.programlanguagesresponses.GetAllProgrammingLanguageResponse;
import temurbahri.kodlama.io.devs.business.response.programlanguagesresponses.GetByIdProgrammingLanguageResponse;
import temurbahri.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import temurbahri.kodlama.io.devs.entities.concretes.ProgrammingLanguages;


@Service
public class ProgramingLanguageManager  implements ProgramingLanguageService{
	
	private ProgramingLanguageRepository programmingLanguageRepository;
	
	

	public ProgramingLanguageManager(ProgramingLanguageRepository programinLanguageRepository) {
		this.programmingLanguageRepository = programinLanguageRepository;
	}



	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguages> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<>();

        for(ProgrammingLanguages programmingLanguage : programmingLanguages){
            GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
            response.setName(programmingLanguage.getName());

            programmingLanguageResponses.add(response);
        }

        return programmingLanguageResponses;
	}



	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguages programmingLanguages = programmingLanguageRepository.findById(id).get();
        GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
        response.setName(programmingLanguages.getName());

        return response;
	}



	@Override
	public void save(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		if(programmingLanguageExistValidator(createProgrammingLanguageRequest) && programmingLanguageExistValidator(createProgrammingLanguageRequest)){
            ProgrammingLanguages programmingLanguage = new ProgrammingLanguages();

            programmingLanguage.setName(createProgrammingLanguageRequest.getName());

            programmingLanguageRepository.save(programmingLanguage);
		}
		
	}



	private boolean programmingLanguageExistValidator(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		for (ProgrammingLanguages tempProgrammingLanguage : programmingLanguageRepository.findAll()) {
            if (tempProgrammingLanguage.getName().equalsIgnoreCase(createProgrammingLanguageRequest.getName())) {

                System.out.println("Bu kodlama dili zaten var.");
                return false;

            }
        }

        return true;
	}



	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
		
	}



	@Override
	public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		if(!updateProgrammingLanguageRequest.getName().isEmpty()){

            ProgrammingLanguages programmingLanguage = programmingLanguageRepository.findById(id).get();

            programmingLanguage.setName(updateProgrammingLanguageRequest.getName());

            programmingLanguageRepository.save(programmingLanguage);

        }
		
	}

	
	}


