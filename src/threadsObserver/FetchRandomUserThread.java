package threadsObserver;

import randomperson.RandomUser;
import randomperson.RandomUserGenerator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FetchRandomUserThread extends Thread {


	public void run() {
		try {
			RandomUserControl.fetched(RandomUserGenerator.getRandomUser());
			
		} catch (InterruptedException ex) {
			Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}