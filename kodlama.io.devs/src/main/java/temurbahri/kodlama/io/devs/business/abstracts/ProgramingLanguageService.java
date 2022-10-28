package temurbahri.kodlama.io.devs.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import temurbahri.kodlama.io.devs.entities.concretes.ProgramingLanguage;

@Service
public interface ProgramingLanguageService {
	List<ProgramingLanguage> getAll();
	
	ProgramingLanguage getId(int id);
	
	void add(ProgramingLanguage programingLanguage);
	
	void delete(int id);

    void update(ProgramingLanguage programingLanguage);

}
