package ie.ucd.csnl.comp47500.api;

public interface Position<E> {
	E getElement() throws IllegalStateException;
}
