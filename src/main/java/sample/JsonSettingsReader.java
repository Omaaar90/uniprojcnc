package main.java.sample;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class JsonSettingsReader {

    public static void main(String[] args) throws ParseException, IOException {
InputStream is = JsonSettingsReader.class.getResourceAsStream("JsonSettings.json");
        Reader reader =  new InputStreamReader(is, "utf-8");

        Object obj;
        obj = new JSONParser().parse(reader);
        JSONObject jo =  (JSONObject) obj;

        String Drill = (String) jo.get("Drill");
        Long xHome = (Long) jo.get("HomePosition.X");
        Long yHome = (Long) jo.get("HomePosition.Y");
        Long cSpeed = (Long) jo.get("CuttingSpeed");
        Long tDiameter = (Long) jo.get("ToolDiameter");
        Long weight = (Long) jo.get("Weight");
        String wSpace = (String) jo.get("WorkingSpace");
        Object object =  jo.get("Home");

        System.out.println(Drill);
        System.out.println(xHome);
        System.out.println(cSpeed + "m/min");
        System.out.println(tDiameter);
    }


}
