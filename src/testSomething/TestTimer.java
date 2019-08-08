package testSomething;

import java.util.Timer;

public class TestTimer {
	Timer timer;

	public TestTimer(int time) {
		timer = new Timer();
		timer.schedule(new TestTimerTask(), time*1000);
	}
	public TestTimer() {
		timer = new Timer();
		timer.schedule(new TestTimerTask(), 1000, 2000);
	}
	
	public static void main(String[] args) {
		new TestTimer();
		System.out.println("这是一次演习");
	}
	
}
