package helpers;

import org.json.JSONObject;

import java.io.*;
import java.util.Properties;

public class Helpers {

    private static String path="";

    private JSONObject jsonObject;

    public Helpers(String path) throws IOException {
        StringBuilder jsonData = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        }

        try {
            jsonObject = new JSONObject(jsonData.toString());
        } catch (Exception e) {
            throw new IOException("Invalid JSON format in file: " + path, e);
        }
    }

    public String getValue(String key) {
        return jsonObject.optString(key, null); // returns null if key not found
    }


//    public static Properties userData=LoadProperties(path);
//
//    private static Properties LoadProperties(String path)
//    {
//        Properties pro=new Properties();
//        //stream for reading file
//        try {
//            FileInputStream stream=new FileInputStream(path);
//            pro.load(stream);
//        } catch (FileNotFoundException e) {
//            System.out.println("Error occured "+e.getMessage());
//        } catch (IOException e) {
//            System.out.println("Error occured "+e.getMessage());
//        }
//        return pro;
//    }
}
