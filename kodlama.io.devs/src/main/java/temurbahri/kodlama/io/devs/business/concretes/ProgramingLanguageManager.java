package temurbahri.kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import temurbahri.kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import temurbahri.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import temurbahri.kodlama.io.devs.entities.concretes.ProgramingLanguage;


@Service
public class ProgramingLanguageManager  implements ProgramingLanguageService{
	
	private ProgramingLanguageRepository programinLanguageRepository;
	
	

	public ProgramingLanguageManager(ProgramingLanguageRepository programinLanguageRepository) {
		this.programinLanguageRepository = programinLanguageRepository;
	}

	@Override
	public List<ProgramingLanguage> getAll() {
		
		return programinLanguageRepository.getAll();
	}

	@Override
	public ProgramingLanguage getId(int id) {
		
		return programinLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgramingLanguage programingLanguage) {
		 for (ProgramingLanguage language : programinLanguageRepository.getAll()){
	            if (check(language.getName())&&programingLanguageIsEmpty(programingLanguage)){
	                this.programinLanguageRepository.add(programingLanguage);

	            }
	        }
		
	}

	 private boolean check(String name) {
		 for (ProgramingLanguage language : this.programinLanguageRepository.getAll()){
	            if (language.getName().equalsIgnoreCase(name)){
	                return true;

	            }

	        }
	        return false;
	}

	private boolean programingLanguageIsEmpty(ProgramingLanguage programingLanguage){
	        if (programingLanguage.getName().isEmpty()|| programingLanguage.getName().isBlank()){
	            return false;
	        }
	        return true;
	    }

	@Override
	public void delete(int id) {
		programinLanguageRepository.delete(id);
		
	}

	@Override
	public void update(ProgramingLanguage programingLanguage) {
		programinLanguageRepository.update(programingLanguage);
		
		
	}

}
