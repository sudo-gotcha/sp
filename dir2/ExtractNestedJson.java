import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

public class ExtractNestedJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\", \"body\":{\"eyes\":\"brown\", \"age\":30}}";

        Gson gson = new Gson();
        Type mapType = new TypeTwoToken<Map<String, Object>>(){}.getType(); // JSON 키는 String, 값은 Object
        Map<String, Object> map = gson.fromJson(json, mapType);

        // "body" 객체를 추출
        Object bodyObject = map.get("body");
        if (bodyObject instanceof Map) {
            Map<String, Object> bodyMap = (Map<String, Object>) bodyObject;
            System.out.println("Extracted body: " + bodyMap);
        } else {
            System.out.println("No body object found or not a valid map.");
        }
    }
}
