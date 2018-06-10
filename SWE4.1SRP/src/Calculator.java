public class Calculator {
	private Math math;
	public int value1;
	public int value2;
	public Calculator(int value1, int value2) {
		math = new Math();
		this.value1= value1;
		this.value2= value2;
	}

	public void calculateAll(String message) {
		if(message.equals("add"))
		System.out.println("Add " + value1 + " " +  value2 + "=" + math.add(value1, value2));
		else
		System.out.println("Substract " + value1 + " " +  value2 + "=" + math.substract(value1, value2));
		System.out.println("Multiply " + value1 + " " +  value2 + "=" + math.multiply(value1, value2));
	}
}
