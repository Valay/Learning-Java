
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ClockAngle {
	//Find the angle between minute and hour clock given time
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String time = br.readLine();
			
			double hours = Double.parseDouble(time.split(" ")[0]);
			double minutes = Double.parseDouble(time.split(" ")[1]);
			
			//System.out.println(hours+ " "+minutes);
			
			double minute_angle = (minutes/60.0) * 360.0;
			double hour_angle = ((hours/12.0)*360.0) + ((minute_angle/360.0)*30);
			
			System.out.println(Math.abs(hour_angle-minute_angle));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
