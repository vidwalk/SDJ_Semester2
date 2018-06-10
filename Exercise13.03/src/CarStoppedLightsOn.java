public class CarStoppedLightsOn extends CarState {

	public void trigger(Car car) {
		car.setState(new CarStoppedLightsOff());
	}

}
