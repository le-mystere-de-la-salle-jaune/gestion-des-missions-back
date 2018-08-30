package dev.controller.vm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.reflect.ConstructorUtils;

import dev.domain.BaseEntity;
import dev.service.BaseService;

public class VMUtils<T extends BaseEntity, U extends BaseEntity, S extends BaseVM> {

	private Class<T> entityClass;
	private Class<S> VMClass;
	// private BaseService<U> service;

	public VMUtils(Class<T> entityClass, Class<S> VMClass) {
		this.entityClass = entityClass;
		this.VMClass = VMClass;
		// this.service = service;
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

	public BaseEntity transformIntoEntity(BaseVM vm, BaseService<U> service) {
		Constructor<T> entityConstructor = ConstructorUtils.getMatchingAccessibleConstructor(this.entityClass,
				this.VMClass, BaseService.class);
		System.out.println(entityConstructor);
		if (entityConstructor == null) {
			try {
				return ConstructorUtils.getMatchingAccessibleConstructor(this.entityClass, this.VMClass)
						.newInstance(vm);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			try {
				return entityConstructor.newInstance(vm, service);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	/*
	 * private List<Method> getSetters(Class<T> classParam) { List<Method>
	 * methods = new ArrayList<>(); methods =
	 * Arrays.asList(classParam.getMethods()); for (Method currentMethod :
	 * methods) { if (!currentMethod.getName().startsWith("set") ||
	 * currentMethod.getParameterTypes().length != 1) {
	 * methods.remove(currentMethod); } } return methods; }
	 * 
	 * private List<Method> getGetters(Class<S> classParam) { List<Method>
	 * methods = new ArrayList<>(); methods =
	 * Arrays.asList(classParam.getMethods()); for (Method currentMethod :
	 * methods) { if (!currentMethod.getName().startsWith("get") ||
	 * currentMethod.getParameterTypes().length != 0) {
	 * methods.remove(currentMethod); } } return methods; }
	 */

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

}
