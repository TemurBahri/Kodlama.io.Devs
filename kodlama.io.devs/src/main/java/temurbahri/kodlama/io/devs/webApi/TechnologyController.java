package temurbahri.kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import temurbahri.kodlama.io.devs.business.abstracts.TechnologyService;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.CreateTechnologyRequest;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.DeleteTechnologyRequest;
import temurbahri.kodlama.io.devs.business.requests.technologyrequests.UpdateTechnologyRequest;
import temurbahri.kodlama.io.devs.business.response.techonogyresponses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

	TechnologyService technologyService;

	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("/getAll")
	public List<GetAllTechnologyResponse> getAll() {
		return this.technologyService.getAll();
	}

	@PostMapping("/save")
	public void save(CreateTechnologyRequest createProgrammingLanguageTechnologyRequest) {
		this.technologyService.save(createProgrammingLanguageTechnologyRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(deleteTechnologyRequest);
	}

	@PutMapping("/update")
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(id, updateTechnologyRequest);
	}

}
