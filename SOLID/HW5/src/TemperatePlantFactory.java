import java.util.function.Consumer;

public class TemperatePlantFactory implements IPlantFactory {
    
    @Override
    public Plant newInstance(PlantType type, String commonName, Consumer<Plant.PlantBuilder> customize) {
        // Temperate biome의 기본 특성 설정
        Plant.PlantBuilder builder = new Plant.PlantBuilder(type, Biome.TEMPERATE)
                .commonName(commonName)
                .sunlight(Sunlight.FULL)      // 온대 지역은 완전한 햇빛
                .waterNeed(WaterNeed.MEDIUM)  // 온대 지역은 중간 정도의 물
                .evergreen(false)             // 온대 식물은 주로 낙엽수
                .heightM(2.0)                 // 온대 식물은 중간 크기
                .spreadM(1.5);
        
        // 사용자 커스터마이징 적용
        customize.accept(builder);
        
        return builder.build();
    }
}
