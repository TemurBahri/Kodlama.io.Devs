package temurbahri.kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import temurbahri.kodlama.io.devs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology,Integer> {
	

}
