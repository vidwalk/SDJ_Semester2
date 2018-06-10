public class CarStoppedLightsOff extends CarState {

	public void trigger(Car car) {
		car.setState(new CarForwardLightsOn());
	}

	public void complete(Car car) {
		car.setState(new CarBackwardLightsOn());
	}

}
