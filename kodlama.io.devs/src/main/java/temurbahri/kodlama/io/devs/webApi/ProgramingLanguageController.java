package temurbahri.kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import temurbahri.kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import temurbahri.kodlama.io.devs.entities.concretes.ProgramingLanguage;

@RestController
@RequestMapping("/api/programingLanguages")
public class ProgramingLanguageController {
	
	
	private ProgramingLanguageService languageService;

	public ProgramingLanguageController(ProgramingLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getId")
	public ProgramingLanguage getById(int id) {
		return this.languageService.getId(id);
	}
	
	
	@GetMapping("/getall")
	public List<ProgramingLanguage> getAll() {
		return languageService.getAll();
	}
	
	
	
	
	
	
	
	
	

}
