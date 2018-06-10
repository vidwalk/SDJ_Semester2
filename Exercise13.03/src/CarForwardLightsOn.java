public class CarForwardLightsOn extends CarState {

	public void trigger(Car car) {
		car.setState(new CarStopsLightsOff());
	}

}
