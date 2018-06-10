package view;

import java.util.Scanner;

import controller.CalcController;

public class CalcConsole implements CalcView, Runnable {

	private CalcController controller;
	private Scanner input;

	public CalcConsole() {
		input = new Scanner(System.in);
	}

	@Override
	public void startView(CalcController controller) {
		this.controller = controller;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		TimerReset timer = new TimerReset(controller);
		Thread timeout = new Thread(timer);
		timeout.start();
		
		boolean continueWorking = true;
		while (continueWorking) {
			// Read input from user input.
			System.out.println("CalcController");
			System.out.println("--------------");
			System.out.println("1) Add digit");
			System.out.println("2) Press dot");
			System.out.println("3) +");
			System.out.println("4) -");
			System.out.println("5) *");
			System.out.println("6) /");
			System.out.println("7) =");
			System.out.println("8) Clear");
			System.out.println("0) Quit");
			System.out.print("Select an item 1-7: ");
			
			int choice = input.nextInt();
			input.nextLine();

			controller.execute(choice);
			timer.reset();
			if (choice == 0) {
				continueWorking = false;
			}
		}
	}

	@Override
	public String get(String text) {
		System.out.print("Enter " + text + ": ");
		return input.nextLine();
	}

	@Override
	public void show(String text) {
		System.out.println(text);
	}
}
