import java.util.function.Consumer;

public class TropicalPlantFactory implements IPlantFactory {
    
    @Override
    public Plant newInstance(PlantType type, String commonName, Consumer<Plant.PlantBuilder> customize) {
        // Tropical biome의 기본 특성 설정
        Plant.PlantBuilder builder = new Plant.PlantBuilder(type, Biome.TROPICAL)
                .commonName(commonName)
                .sunlight(Sunlight.PARTIAL)  // 열대 지역은 부분적인 햇빛
                .waterNeed(WaterNeed.HIGH)   // 열대 지역은 물이 많이 필요
                .evergreen(true)             // 열대 식물은 주로 상록수
                .heightM(3.0)                // 열대 식물은 키가 큼
                .spreadM(2.0);
        
        // 사용자 커스터마이징 적용
        customize.accept(builder);
        
        return builder.build();
    }
}
