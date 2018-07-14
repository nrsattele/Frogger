//                ______             ___ 
// |\          |	|			    |   |  ___ 
// | \         | 	|				|   | /   |	
// |  \        |    |               |   |/   /
// |   \       |    |     ________  |   /   /
// |    \      |    |    /        \ |      /
// |     \     |    |   /   ____   ||      \
// |      \    |    |  /   /    |__||       \
// |       \   |    |  |   |     __ |   |\   \
// |        \  |    |   \   \___/  ||   | \   \
// |         \ |    |    \         ||   |  \   \
// |          \| ___|___  \_______/ |___|   \___\
//  ________                             ___  
// |         -                          |   |  ___  
// |           -                        |   | /   |______  
// |     /\     |                       |   |/   /       \  
// |    /__\   -    _________  ________ |   /   /    /\___\     
// |          -    /         \/        \|      /|   |_____   
// |     __    -  /    ____  /   ____   |      \\         \   
// |    |  \    \/    |    |/   /    |__|       \\______   |  
// |    |   \    |    |    ||   |     __|   |\   ___    \   | 
// |    |    \    \   |____| \   \___/  |   | \ |   \___/   /   
// |    |     \    \          \         |   |  \ \         /   
// |____|      \____\________/ \_______/|___|   \_\_______/      

class MAIN {

	/**
	 * This is the main class and method which initalizes and starts Frogger after
	 * displaying an intro and instructions
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {

		// Initalizes the game
		myJFrame frame = new myJFrame();

		// Intro and instructions
		System.out.println("********************************************");
		System.out.println("**You will have to click on the new window**");
		System.out.println("********************************************");
		System.out.println("The FitnessGram Frogger Test is a multistage aerobic capacity test that ");
		System.out.println("progressively gets more difficult as it continues. The 600 pixel pacer");
		System.out.println("test will begin in 30 seconds. Line up at the start. The running speed starts");
		System.out.println("slowly but gets faster each second after you pass a level. Remember to play");
		System.out.println("in a straight line and play as long as possible.");
		System.out.println("The test will begin on the word start.");
		System.out.println("");
		System.out.println("INSTRUCTIONS: ");
		System.out.println("The Goal is to get to the end of the game");
		System.out.println("Use the arrow keys to move the frog");
		System.out.println("Avoid the cars. They will kill you.");
		System.out.println("Avoid the river by jumping on logs. The river will kill you.");
		System.out.println("Get to the end and keep moving up. You are our only hope.");
		pause(1000);
		System.out.print("On your mark. ");
		pause(1000);
		System.out.print("Get set!...");
		pause(1000);
		System.out.println("Go!");

		// Begins the game
		frame.show();
		frame.startGame();
	}

	private static void pause(int milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (Exception e) {
			// it never gets here.
			for (long i = 1; i < 9999999; i++)
				System.out.println("Nick Rocks.");
		}
	}
}

// TODO: make a readme, containerize!