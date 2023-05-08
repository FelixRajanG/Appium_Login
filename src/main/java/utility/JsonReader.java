package utility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader 
{
	JSONParser  parser;
	FileReader file;
	Object obj;
	JSONObject jsonObject;
	
	public JsonReader() throws IOException, ParseException 
	{
		parser = new JSONParser();
		file = new FileReader(".\\UserData.json");
		obj = parser.parse(file);
        jsonObject = (JSONObject)obj;
	}
	
	public String readJsonContent(String key) 
	{
		String content = (String)jsonObject.get(key);
		return content;
	}
}
