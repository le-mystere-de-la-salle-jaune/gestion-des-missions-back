package dev.service.vm;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.controller.vm.NoteDeFraisVM;
import dev.service.NoteDeFraisService;

@Service
public class NoteDeFraisServiceVM {

	private NoteDeFraisService noteDeFraisService;

	/**
	 * @param noteDeFraisService
	 */
	public NoteDeFraisServiceVM(NoteDeFraisService noteDeFraisService) {
		super();
		this.noteDeFraisService = noteDeFraisService;
	}

	public List<NoteDeFraisVM> findAll() {
		return noteDeFraisService.list().stream().map(NoteDeFraisVM::new).collect(Collectors.toList());
	}

	public NoteDeFraisVM findById(Long id) {
		return new NoteDeFraisVM(noteDeFraisService.findById(id));
	}

}
