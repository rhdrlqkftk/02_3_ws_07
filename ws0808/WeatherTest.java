package ws;

import java.util.List;

public class WeatherTest {
	public static void main(String[] args) {
		WeatherDao dao = WeatherDao.getInstance(); 
		List<weather> wes = dao.getWeatherList();
		for (weather w: wes) 
		{
			System.out.println(w);
		}
	}
	
}
