package dev.controller.vm;

import java.lang.reflect.InvocationTargetException;

import dev.domain.BaseEntity;
import dev.service.BaseService;

public class VMUtils<T extends BaseEntity, S extends BaseVM> {

	private Class<T> entityClass;
	private Class<S> VMClass;
	private BaseService<T> service;

	public VMUtils(Class<T> entityClass, Class<S> VMClass, BaseService<T> service) {
		this.entityClass = entityClass;
		this.VMClass = VMClass;
		this.service = service;
	}

	public BaseVM transformIntoVM(BaseEntity entity) {
		try {
			return this.VMClass.getConstructor(this.entityClass).newInstance(entity);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	// TODO A TESTER
	public BaseEntity transformIntoEntity(BaseVM vm) {
		try {
			if (service == null) {
				return this.entityClass.getConstructor(this.VMClass).newInstance(vm);
			} else {
				System.out.println(this.service.findById(vm.getId()));
				return this.service.findById(vm.getId());
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
