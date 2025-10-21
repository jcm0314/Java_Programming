public class Plant {
    // 필수 필드
    private final PlantType type;
    private final Biome biome;
    private final String commonName;
    
    // 선택적 필드
    private final Sunlight sunlight;
    private final WaterNeed waterNeed;
    private final boolean evergreen;
    private final double heightM;
    private final double spreadM;
    private final boolean toxic;
    private final Bloom bloom;
    private final Phenophase phenophase;

    // private 생성자: PlantBuilder를 통해서만 객체 생성 가능
    private Plant(PlantBuilder builder) {
        this.type = builder.type;
        this.biome = builder.biome;
        this.commonName = builder.commonName;
        this.sunlight = builder.sunlight;
        this.waterNeed = builder.waterNeed;
        this.evergreen = builder.evergreen;
        this.heightM = builder.heightM;
        this.spreadM = builder.spreadM;
        this.toxic = builder.toxic;
        this.bloom = builder.bloom;
        this.phenophase = builder.phenophase;
        
        // 유효성 검증
        validate();
    }

    private void validate() {
        // SUCCULENT는 WaterNeed.LOW가 필수
        if (type == PlantType.SUCCULENT && waterNeed != WaterNeed.LOW) {
            throw new IllegalStateException("SUCCULENT plants must have WaterNeed.LOW");
        }
        
        // FERN은 개화 정보(Bloom)를 가질 수 없음
        if (type == PlantType.FERN && bloom != null) {
            throw new IllegalStateException("FERN plants cannot have bloom information");
        }
        
        // yourcode: CACTUS는 DESERT biome과 LOW water need가 필수
        if (type == PlantType.CACTUS) {
            if (biome != Biome.DESERT) {
                throw new IllegalStateException("CACTUS plants must be in DESERT biome");
            }
            if (waterNeed != WaterNeed.LOW) {
                throw new IllegalStateException("CACTUS plants must have WaterNeed.LOW");
            }
        }
    }

    // Getters
    public PlantType getType() { return type; }
    public Biome getBiome() { return biome; }
    public String getCommonName() { return commonName; }
    public Sunlight getSunlight() { return sunlight; }
    public WaterNeed getWaterNeed() { return waterNeed; }
    public boolean isEvergreen() { return evergreen; }
    public double getHeightM() { return heightM; }
    public double getSpreadM() { return spreadM; }
    public boolean isToxic() { return toxic; }
    public Bloom getBloom() { return bloom; }
    public Phenophase getPhenophase() { return phenophase; }

    @Override
    public String toString() {
        return "Plant{" +
                "type=" + type +
                ", biome=" + biome +
                ", commonName='" + commonName + '\'' +
                ", sunlight=" + sunlight +
                ", waterNeed=" + waterNeed +
                ", evergreen=" + evergreen +
                ", heightM=" + heightM +
                ", spreadM=" + spreadM +
                ", toxic=" + toxic +
                ", bloom=" + bloom +
                ", phenophase=" + phenophase +
                '}';
    }

    // PlantBuilder: Plant의 정적 내부 클래스
    public static class PlantBuilder {
        // 필수 필드
        private final PlantType type;
        private final Biome biome;
        private String commonName;
        
        // 선택적 필드 (기본값 설정)
        private Sunlight sunlight = Sunlight.FULL;
        private WaterNeed waterNeed = WaterNeed.MEDIUM;
        private boolean evergreen = false;
        private double heightM = 1.0;
        private double spreadM = 0.5;
        private boolean toxic = false;
        private Bloom bloom = null;
        private Phenophase phenophase = Phenophase.DORMANT;

        // 필수 필드를 받는 생성자
        public PlantBuilder(PlantType type, Biome biome) {
            this.type = type;
            this.biome = biome;
        }

        // 메서드 체이닝을 지원하는 설정 메서드들
        public PlantBuilder commonName(String commonName) {
            this.commonName = commonName;
            return this;
        }

        public PlantBuilder sunlight(Sunlight sunlight) {
            this.sunlight = sunlight;
            return this;
        }

        public PlantBuilder waterNeed(WaterNeed waterNeed) {
            this.waterNeed = waterNeed;
            return this;
        }

        public PlantBuilder evergreen(boolean evergreen) {
            this.evergreen = evergreen;
            return this;
        }

        public PlantBuilder heightM(double heightM) {
            this.heightM = heightM;
            return this;
        }

        public PlantBuilder spreadM(double spreadM) {
            this.spreadM = spreadM;
            return this;
        }

        public PlantBuilder toxic(boolean toxic) {
            this.toxic = toxic;
            return this;
        }

        public PlantBuilder bloom(Bloom bloom) {
            this.bloom = bloom;
            return this;
        }

        public PlantBuilder phenophase(Phenophase phenophase) {
            this.phenophase = phenophase;
            return this;
        }

        // 최종 Plant 객체 생성
        public Plant build() {
            if (commonName == null || commonName.isEmpty()) {
                throw new IllegalStateException("Common name is required");
            }
            return new Plant(this);
        }
    }
}
