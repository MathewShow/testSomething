package testSomething;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimerTask;

public class TestTimerTask extends TimerTask{

	@Override
	public void run() {
		Date date = new Date(this.scheduledExecutionTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("����ִ�и��̵߳�ʱ��Ϊ:"+sdf.format(date));
		
	}
	
	
}
