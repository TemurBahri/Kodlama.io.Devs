package temurbahri.kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import temurbahri.kodlama.io.devs.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageRepository {
	
	List<ProgramingLanguage> getAll();
	
	ProgramingLanguage getById(int id);
	
	void add(ProgramingLanguage language);

	void delete(int id);

	void update(ProgramingLanguage language);
	
	

}
