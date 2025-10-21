import java.util.function.Consumer;

public class DesertPlantFactory implements IPlantFactory {
    
    @Override
    public Plant newInstance(PlantType type, String commonName, Consumer<Plant.PlantBuilder> customize) {
        // Desert biome의 기본 특성 설정
        Plant.PlantBuilder builder = new Plant.PlantBuilder(type, Biome.DESERT)
                .commonName(commonName)
                .sunlight(Sunlight.FULL)     // 사막은 완전한 햇빛
                .waterNeed(WaterNeed.LOW)    // 사막은 물이 적게 필요
                .evergreen(true)             // 사막 식물은 주로 상록
                .heightM(1.5)                // 사막 식물은 상대적으로 작음
                .spreadM(1.0);
        
        // 사용자 커스터마이징 적용
        customize.accept(builder);
        
        return builder.build();
    }
}
