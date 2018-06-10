public class CarStopsLightsOff extends CarState {

	public void trigger(Car car) {
		car.setState(new CarStoppedLightsOn());
	}

}
