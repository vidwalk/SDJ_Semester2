package View;

public class Rectangle extends Shape{
protected double height;
protected double width;

public Rectangle(int xPos, int yPos, double height, double width)
{
	super(xPos,yPos);
	this.height = height;
	this.width = width;
}

public double getHeight() {
	return height;
}

public double getWidth() {
	return width;
}

@Override
public void draw() {
	// TODO Auto-generated method stub

}

@Override
public void erase() {
	// TODO Auto-generated method stub

}
}
