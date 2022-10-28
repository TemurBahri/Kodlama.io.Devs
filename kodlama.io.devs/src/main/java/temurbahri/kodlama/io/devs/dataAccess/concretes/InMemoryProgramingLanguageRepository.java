package temurbahri.kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import temurbahri.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import temurbahri.kodlama.io.devs.entities.concretes.ProgramingLanguage;

public class InMemoryProgramingLanguageRepository implements ProgramingLanguageRepository {
	
	List<ProgramingLanguage> programingLanguages;
	
	public InMemoryProgramingLanguageRepository() {
		
		programingLanguages = new ArrayList<ProgramingLanguage>();
		
		programingLanguages.add(new ProgramingLanguage(1,"JAVA"));
		programingLanguages.add(new ProgramingLanguage(2,"C#"));
		programingLanguages.add(new ProgramingLanguage(3,"GO"));
		programingLanguages.add(new ProgramingLanguage(4,"KOTLiN"));
		programingLanguages.add(new ProgramingLanguage(5,"PYTHON"));
		
	}

	@Override
	public List<ProgramingLanguage> getAll() {
		
		return programingLanguages;
	}

	@Override
	public ProgramingLanguage getById(int id) {
		for (ProgramingLanguage language : programingLanguages) {
			if (language.getId()==id) {
				return language;
			}
		}
		
		return null;
		
	}

	@Override
	public void add(ProgramingLanguage language) {
		programingLanguages.add(language);
		
	}

	@Override
	public void delete(int id) {
		for(ProgramingLanguage language:programingLanguages) {
			if(language.getId()==id) {
				programingLanguages.remove(language);
			}
		}
		
	}

	@Override
	public void update(ProgramingLanguage language) {
		for(ProgramingLanguage programingLanguages:programingLanguages) {
			if(language.getId()==programingLanguages.getId()) {
				language.setName(programingLanguages.getName());
			}
		}
		
	}

}
