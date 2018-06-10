public interface PublicToilet {
	void stepIntoCabin(); // wait if there are no available cabins
	// or a cleaning person is ready to clean toilets

	void leaveCabin();

	void startWashingHands(); // wait if there are no available faucets

	void stopWashingHands();

	void cleanToilets(); // wait until all toilets are emptied

	void endCleaningToilets();
}