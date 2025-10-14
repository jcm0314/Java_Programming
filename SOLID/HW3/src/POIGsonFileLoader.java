import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class POIGsonFileLoader {

    public static List<POI> load(String filePath) throws java.io.IOException {
        List<POI> result = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            // JSON 파일 파싱
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray poisArray = jsonObject.getAsJsonArray("pois");

            // JSON 배열의 각 POI 요소를 반복 처리
            for (JsonElement element : poisArray) {
                JsonObject obj = element.getAsJsonObject();
                
                // POI 이름 추출
                String name = obj.get("name").getAsString();
                
                // 위치 정보 추출
                JsonObject locObj = obj.getAsJsonObject("location");
                if (locObj == null) continue; // 위치 정보가 없으면 건너뜀

                // 위도와 경도 추출 (다양한 필드명 지원)
                Double lat = readDouble(locObj, "latitude", "lat");
                Double lon = readDouble(locObj, "longitude", "lon");
                if (lat == null || lon == null) continue; // 좌표가 없으면 건너뜀

                // POI 객체 생성 및 리스트에 추가
                result.add(new POI(name, new Location(lat, lon)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<IPOI> loadAsDecorated(String filePath) throws IOException {
        List<IPOI> result = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray poisArray = jsonObject.getAsJsonArray("pois");

            for (JsonElement element : poisArray) {
                JsonObject obj = element.getAsJsonObject();
                String name = obj.get("name").getAsString();
                JsonObject locObj = obj.getAsJsonObject("location");
                if (locObj == null) continue;
                Double lat = readDouble(locObj, "latitude", "lat");
                Double lon = readDouble(locObj, "longitude", "lon");
                if (lat == null || lon == null) continue;

                IPOI base = new POI(name, new Location(lat, lon));

                // category 데코레이터 적용
                String category = null;
                if (obj.has("category") && !obj.get("category").isJsonNull()) {
                    category = obj.get("category").getAsString();
                }
                if (category != null && !category.isEmpty()) {
                    base = new CategoryPOIDecorator(base, category);
                }

                // hashtags 데코레이터 적용
                List<String> tags = new ArrayList<>();
                if (obj.has("hashtags") && obj.get("hashtags").isJsonArray()) {
                    JsonArray tagArr = obj.getAsJsonArray("hashtags");
                    for (JsonElement tagElem : tagArr) {
                        if (tagElem.isJsonPrimitive() && tagElem.getAsJsonPrimitive().isString()) {
                            tags.add(tagElem.getAsString());
                        }
                    }
                }
                if (!tags.isEmpty()) {
                    base = new HashtagPOIDecorator(base, tags.toArray(new String[0]));
                }

                result.add(base);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static Double readDouble(JsonObject o, String primary, String alternate) {
        // 주요 필드명으로 먼저 시도
        JsonElement e = o.get(primary);
        if (e == null || e.isJsonNull()) {
            // 주요 필드명이 없으면 대체 필드명으로 시도
            e = o.get(alternate);
        }
        if (e == null || e.isJsonNull()) return null;

        if (e.isJsonPrimitive()) {
            try {
                // 숫자 타입인 경우
                if (e.getAsJsonPrimitive().isNumber()) return e.getAsDouble();
                // 문자열 타입인 경우 (문자열로 된 숫자)
                if (e.getAsJsonPrimitive().isString())
                    return Double.parseDouble(e.getAsString().trim());
            } catch (NumberFormatException ignore) {
                // 파싱 실패 시 null 반환
            }
        }
        return null;
    }
}
