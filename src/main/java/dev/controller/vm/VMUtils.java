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

	public VMUtils() {
		super();
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

	public BaseEntity transformIntoEntity(BaseVM vm) {
		try {
			if (service == null) {
				return this.entityClass.getConstructor(this.VMClass).newInstance(vm);
			} else {
				return this.service.findById(vm.getId());
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public Class<S> getVMClass() {
		return VMClass;
	}

	public void setVMClass(Class<S> vMClass) {
		VMClass = vMClass;
	}

	public BaseService<T> getService() {
		return service;
	}

	public void setService(BaseService<T> service) {
		this.service = service;
	}

}
