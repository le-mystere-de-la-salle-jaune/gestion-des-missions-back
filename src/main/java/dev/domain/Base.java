package dev.domain;

/**
 * Interface permettant de lier BaseEntity et BaseVM (car ces classes vont
 * implémenter l'interface Base) afin de renvoyer directement l'entité dans le
 * cadre de la méthode toVm() si l'entité en question n'a pas de VM
 * 
 * @author ctorres
 *
 */
public interface Base {

}
