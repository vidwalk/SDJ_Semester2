
public class CleaningPerson implements Runnable {
	private ToiletBuilding toilet;

	public CleaningPerson(ToiletBuilding toilet)
	{
		this.toilet = toilet;
	}
	@Override
	public void run() {
		System.out.println("Enters to start cleaning");
		toilet.cleanToilets();
		System.out.println("Finished cleaning");
		toilet.endCleaningToilets();
	}

}
