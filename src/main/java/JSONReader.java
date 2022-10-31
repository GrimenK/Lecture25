import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JSONReader {
    private static JSONObject jsonObject;
    private static final String PARAMS = "/Users/oleh/Desktop/Lecture26/src/main/resources/params.json";

    private static void initJson(){
        File file = new File(PARAMS);
        try {
            String jsonString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            jsonObject = new JSONObject(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        if(jsonObject == null){
            initJson();
        }
        return jsonObject.getString(key);
    }

}
