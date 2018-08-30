package dev.service.vm;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.controller.vm.LigneDeFraisVM;
import dev.service.LigneDeFraisService;

@Service
public class LigneDeFraisServiceVM {

	private LigneDeFraisService ligneDeFraisService;

	/**
	 * @param ligneDeFraisService
	 */
	public LigneDeFraisServiceVM(LigneDeFraisService ligneDeFraisService) {
		super();
		this.ligneDeFraisService = ligneDeFraisService;
	}

	public List<LigneDeFraisVM> findAll() {
		return ligneDeFraisService.list().stream().map(LigneDeFraisVM::new).collect(Collectors.toList());
	}

	public LigneDeFraisVM findById(Long id) {
		return new LigneDeFraisVM(ligneDeFraisService.findById(id));
	}

}
