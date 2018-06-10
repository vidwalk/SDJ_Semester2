public class CarBackwardLightsOn extends CarState {

	public void trigger(Car car) {
		car.setState(new CarStopsLightsOff());
	}

}
