package dev.controller.vm;

import dev.domain.Base;

public abstract class BaseVM implements Base {

	private Long id;

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
