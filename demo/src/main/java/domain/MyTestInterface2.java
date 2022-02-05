package domain;

public interface MyTestInterface2 {
	public default void toDo() {
		System.out.println("Hi this is default method2.");
	}
}
