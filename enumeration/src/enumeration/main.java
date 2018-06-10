package enumeration;

import java.util.Random;

public class main {
public static void main(String[] args)
{
	Random random = new Random();
	Places[] places = Places.values();
	for(int i = 0; i < places.length; i++)
		System.out.println(places[i]);
}
}
