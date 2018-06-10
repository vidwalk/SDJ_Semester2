public abstract class CarState {

	public abstract void trigger(Car car);

	public void complete(Car car) {

	}

	public String status() {
		return  getClass().getSimpleName();
	}

}
