package ws;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherDao 
{
	private static WeatherDao wdao= new WeatherDao(); 
	
	public static WeatherDao getInstance()
	{
			return wdao;
	}
	private List<weather> weatherList =new ArrayList<weather>(); 
	public WeatherDao()
	{
		weatherList.clear(); 
	}
	public List<weather> getWeatherList()
	{
		connectXML();
		return weatherList; 
	}
	public void connectXML()
	{
//		weatherList.clear(); 
		String murl ="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3020053000";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			try {
				Document doc=  parser.parse(new URL(murl).openConnection().getInputStream());
				Element root = doc.getDocumentElement();// root -> rss
				NodeList datas = root.getElementsByTagName("data");
				for (int i = 0; i < datas.getLength(); i++) 
				{
					Node data = datas.item(i);
					weather we = new weather();
					NodeList dataitems = data.getChildNodes();
					for (int j = 0; j < dataitems.getLength(); j++) 
					{
						Node node = dataitems.item(j);
						if(node.getNodeName().equals("hour"))
						{
							we.setHour(Integer.parseInt((node.getFirstChild().getNodeValue().trim())));							
						}
						else if(node.getNodeName().equals("temp")) 
						{
							we.setTemp(Double.parseDouble((node.getFirstChild().getNodeValue().trim())));
						}
						else if(node.getNodeName().equals("wfKor"))
						{
							we.setWfKor((node.getFirstChild().getNodeValue().trim()));
						}
						else if(node.getNodeName().equals("reh"))
						{
							we.setReh(Integer.parseInt(node.getFirstChild().getNodeValue().trim()));
						}
					}
					weatherList.add(we);
				}
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
