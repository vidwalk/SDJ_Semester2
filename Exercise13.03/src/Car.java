public class Car {

	private CarState carState;

	public Car() {
		carState = new CarStoppedLightsOff();
	}

	public void trigger() {
		carState.trigger(this);
	}

	public void complete() {
		carState.complete(this);
	}

	public void setState(CarState carState) {
		this.carState = carState;
	}

	public String status() {
		return carState.status();
	}

}
