package domain;

public class MyTestImplementation implements TestInterface, MyTestInterface2 {

	@Override
	public void toDo() {
		TestInterface.super.toDo();
		MyTestInterface2.super.toDo();
	}

	public static void main(String[] args) {

		MyTestImplementation m = new MyTestImplementation();
		m.toDo();

	}
}
