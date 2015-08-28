package threadsObserver;


import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends Observable{
  
  protected RandomUser user;

  public void fetchRandomUser() {
  	try {
  		FetchRandomUserThread fetchThread = new FetchRandomUserThread();
  		fetchThread.start();
  	} catch(Exception e){}
  }

  public void fetched(RandomUser user) {
  	setChanged();
  	notifyObservers(user);
  }

  class FetchRandomUserThread extends Thread {

  	public void run() {
  		try {
  			fetched(RandomUserGenerator.getRandomUser());

  		} catch (InterruptedException ex) {
  			Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
  		}
  	}

  }

}
