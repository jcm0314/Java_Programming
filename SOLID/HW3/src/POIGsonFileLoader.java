import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * POIGsonFileLoader 클래스
 * JSON 파일에서 POI (Point of Interest) 데이터를 로드하는 유틸리티 클래스
 * Gson 라이브러리를 사용하여 JSON 파싱 수행
 */
public class POIGsonFileLoader {
    /**
     * JSON 파일에서 POI 목록을 로드
     * @param filePath POI 데이터가 저장된 JSON 파일 경로
     * @return POI 객체들의 리스트
     * @throws java.io.IOException 파일 읽기 오류 시 발생
     */
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
        // 기존 parse 로직 재사용
        // name/location 읽은 뒤:
        IPOI base = new POI(name, new Location(latitude, longitude));
        if (category != null) base = new CategoryPOIDecorator(base, category);
        if (tags != null && !tags.isEmpty()) base = new HashtagPOIDecorator(base, tags.toArray(new String[0]));
        result.add(base);
        return result;
    }

    /**
     * JSON 객체에서 Double 값을 읽어오는 헬퍼 메서드
     * 다양한 필드명과 데이터 타입을 지원 (primary 필드명, alternate 필드명)
     * @param o JSON 객체
     * @param primary 주요 필드명
     * @param alternate 대체 필드명
     * @return Double 값 또는 null (파싱 실패 시)
     */
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
