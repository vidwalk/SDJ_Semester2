package model;

public abstract class Math {
private Calculator calculator;

public Math(Calculator calculator)
{
	this.calculator = calculator;
}

public abstract void update(int value1, int value2);
}
