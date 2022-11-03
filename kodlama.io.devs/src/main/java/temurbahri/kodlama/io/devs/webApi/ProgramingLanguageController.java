package temurbahri.kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import temurbahri.kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.CreateProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.DeleteProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.requests.programlanguagesreguests.UpdateProgrammingLanguageRequest;
import temurbahri.kodlama.io.devs.business.response.programlanguagesresponses.GetAllProgrammingLanguageResponse;
import temurbahri.kodlama.io.devs.business.response.programlanguagesresponses.GetByIdProgrammingLanguageResponse;
import temurbahri.kodlama.io.devs.entities.concretes.ProgrammingLanguages;

@RestController
@RequestMapping("/api/programingLanguages")
public class ProgramingLanguageController {
	
	
	private ProgramingLanguageService languageService;

	public ProgramingLanguageController(ProgramingLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
    public List<GetAllProgrammingLanguageResponse> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/getbyid")
    public GetByIdProgrammingLanguageResponse getById(int id){
        return languageService.getById(id);
    }
    
    @PostMapping("/save")
    public void save(CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
        languageService.save(createProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest){
        languageService.delete(deleteProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        languageService.update(id, updateProgrammingLanguageRequest);
    }
	
	
	
	
	
	
	
	
	

}
