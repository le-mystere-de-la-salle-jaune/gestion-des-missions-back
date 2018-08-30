package dev.controller.vm;

import java.lang.reflect.InvocationTargetException;

import dev.domain.BaseEntity;

public class VMUtils<T extends BaseEntity, S extends BaseVM> {

	private Class<T> entityClass;
	private Class<S> VMClass;

	public VMUtils(Class<T> entityClass, Class<S> VMClass) {
		this.entityClass = entityClass;
		this.VMClass = VMClass;
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
			return this.entityClass.getConstructor(this.VMClass).newInstance(vm);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
