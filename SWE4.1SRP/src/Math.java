
public class Math {


public int add(int value1, int value2) {
	return value1+value2;
}

public int multiply(int value1, int value2) {
	return value1*value2;
}

public int substract(int value1, int value2) {
	return value1-value2;
}

public void draw(int value1, int value2) {
	for(int i=0 ; i< value1; i++)
		System.out.print("-");
	System.out.print("\n");
	for(int j=0 ; j< value2; j++)
		{
		for(int i= 0; i<value1;i++)
		{
		if(i==0 || i== value1 -1)
			System.out.print("|");
		else
			System.out.print(" ");
		}
		System.out.print("\n");
		}
	for(int i=0 ; i< value1; i++)
		System.out.print("-");
	}
}
