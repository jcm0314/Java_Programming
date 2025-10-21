public class App {
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern + Builder Pattern Demo ===\n");
        
        // 1. TropicalPlantFactory 사용 예제
        System.out.println("1. Tropical Plants:");
        IPlantFactory tropicalFactory = new TropicalPlantFactory();
        
        // 기본 설정으로 생성
        Plant orchid = tropicalFactory.newInstance(PlantType.HERB, "Orchid");
        System.out.println(orchid);
        
        // 커스터마이징하여 생성
        Plant palm = tropicalFactory.newInstance(PlantType.TREE, "Palm Tree", builder -> {
            builder.heightM(10.0)
                   .spreadM(5.0)
                   .bloom(new Bloom(Season.SUMMER, "White", 4));
        });
        System.out.println(palm);
        
        // 2. DesertPlantFactory 사용 예제
        System.out.println("\n2. Desert Plants:");
        IPlantFactory desertFactory = new DesertPlantFactory();
        
        // SUCCULENT은 WaterNeed.LOW가 필수 (기본값이 LOW이므로 OK)
        Plant aloe = desertFactory.newInstance(PlantType.SUCCULENT, "Aloe Vera", builder -> {
            builder.heightM(0.5)
                   .spreadM(0.3)
                   .toxic(false);
        });
        System.out.println(aloe);
        
        // yourcode: 새로운 CACTUS PlantType 사용
        Plant cactus = desertFactory.newInstance(PlantType.CACTUS, "Saguaro Cactus", builder -> {
            builder.heightM(12.0)
                   .spreadM(2.0)
                   .phenophase(Phenophase.FLOWERING)
                   .bloom(new Bloom(Season.SPRING, "White", 2));
        });
        System.out.println(cactus);
        
        // 3. TemperatePlantFactory 사용 예제
        System.out.println("\n3. Temperate Plants:");
        IPlantFactory temperateFactory = new TemperatePlantFactory();
        
        // FERN은 bloom 정보를 가질 수 없음
        Plant fern = temperateFactory.newInstance(PlantType.FERN, "Boston Fern", builder -> {
            builder.sunlight(Sunlight.SHADE)
                   .waterNeed(WaterNeed.HIGH)
                   .heightM(0.6)
                   .spreadM(0.8);
            // bloom을 설정하지 않음 (FERN은 개화하지 않음)
        });
        System.out.println(fern);
        
        Plant oak = temperateFactory.newInstance(PlantType.TREE, "Oak Tree", builder -> {
            builder.heightM(20.0)
                   .spreadM(15.0)
                   .evergreen(false)
                   .phenophase(Phenophase.FRUITING);
        });
        System.out.println(oak);
        
        // 4. 직접 Builder 사용 예제
        System.out.println("\n4. Direct Builder Usage:");
        Plant customPlant = new Plant.PlantBuilder(PlantType.SHRUB, Biome.TEMPERATE)
                .commonName("Rose Bush")
                .sunlight(Sunlight.FULL)
                .waterNeed(WaterNeed.MEDIUM)
                .heightM(1.5)
                .spreadM(1.2)
                .toxic(false)
                .bloom(new Bloom(Season.SUMMER, "Red", 8))
                .phenophase(Phenophase.FLOWERING)
                .build();
        System.out.println(customPlant);
        
        // 5. 유효성 검증 테스트
        System.out.println("\n5. Validation Tests:");
        
        // 잘못된 케이스 1: SUCCULENT에 WaterNeed.HIGH 설정 시도
        try {
            Plant invalidSucculent = new Plant.PlantBuilder(PlantType.SUCCULENT, Biome.DESERT)
                    .commonName("Invalid Succulent")
                    .waterNeed(WaterNeed.HIGH)  // 오류 발생!
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        // 잘못된 케이스 2: FERN에 bloom 정보 설정 시도
        try {
            Plant invalidFern = new Plant.PlantBuilder(PlantType.FERN, Biome.TEMPERATE)
                    .commonName("Invalid Fern")
                    .bloom(new Bloom(Season.SPRING, "Purple", 3))  // 오류 발생!
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        // yourcode: 잘못된 케이스 3: CACTUS를 TROPICAL biome에 생성 시도
        try {
            Plant invalidCactus = tropicalFactory.newInstance(PlantType.CACTUS, "Invalid Cactus", builder -> {
                builder.heightM(5.0);
            });
        } catch (IllegalStateException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        System.out.println("\n=== Demo Complete ===");
    }
}
