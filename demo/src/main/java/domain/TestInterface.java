package domain;

public interface TestInterface {
	
	public default void toDo() {
		System.out.println("Hi this is default method.");
	}
}
