package dev.controller.vm;

public class BaseVM {

	private Long id;

	public BaseVM() {

	}

	public BaseVM(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
