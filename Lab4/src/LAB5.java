// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
import model.*;
import parser.*;
import finder.*;
import sort.*;
import util.PrintUtil;
import java.util.List;


/**
 * 자연재해 데이터 관리 프로그램의 메인 클래스
 * 화산과 지진 데이터를 파싱, 검색, 정렬하는 기능을 테스트
 * 각 기능별 테스트 케이스를 실행하고 결과를 출력
 */
public class LAB5 {
    public static void main(String[] args) throws Exception {
        // 테스트 데이터 생성
        String[][] volcanoData = {
            {"2020", "1", "12", "Taal", "Luzon-Philippines", "Philippines", "14.011", "120.998", "311", "Stratovolcano", "4"},
            {"2021", "3", "5", "Sangay", "Ecuador", "Ecuador", "-2.005", "-78.341", "5286", "Stratovolcano", "2"},
            {"2021", "3", "", "Pacaya", "Guatemala", "Guatemala", "14.382", "-90.601", "2569", "Complex volcano", "1"},
            {"2021", "4", "9", "Soufriere St. Vincent", "W Indies", "St. Vincent & the Grenadines", "13.330", "-61.180", "1220", "Stratovolcano", "4"},
            {"2021", "5", "19", "Stromboli", "Italy", "Italy", "38.789", "15.213", "924", "Stratovolcano", "2"},
            {"2021", "5", "22", "Nyiragongo", "Africa-C", "Congo, DRC", "-1.520", "29.250", "3470", "Stratovolcano", "2"},
            {"2021", "9", "19", "La Palma", "Canary Is", "Spain", "28.570", "-17.830", "2426", "Stratovolcano", "3"},
            {"2021", "12", "4", "Semeru", "Java", "Indonesia", "-8.108", "112.922", "3657", "Stratovolcano", "4"},
            {"2022", "1", "15", "Hunga Tonga-Hunga Ha'apai", "Tonga-SW Pacific", "Tonga", "-20.553", "-175.384", "114", "Submarine volcano", "5"},
            {"2022", "6", "22", "Popocatepetl", "Mexico", "Mexico", "19.023", "-98.622", "5393", "Stratovolcano", "2"},
            {"2022", "10", "9", "Stromboli", "Italy", "Italy", "38.789", "15.213", "924", "Stratovolcano", "2"},
            {"2022", "12", "4", "Stromboli", "Italy", "Italy", "38.789", "15.213", "924", "Stratovolcano", "2"},
            {"2022", "12", "4", "Semeru", "Java", "Indonesia", "-8.108", "112.922", "3657", "Stratovolcano", "4"},
            {"2023", "7", "7", "Bagana", "Bougainville-SW Paci", "Papua New Guinea", "-6.137", "155.196", "1855", "Lava cone", "2"},
            {"2024", "5", "11", "Marapi", "Sumatra", "Indonesia", "-0.380", "100.474", "2885", "Complex volcano", "2"},
            {"2024", "6", "3", "Kanlaon", "Philippines-C", "Philippines", "10.410", "123.130", "2422", "Stratovolcano", "3"},
            {"2024", "8", "17", "Sheveluch", "Kamchatka", "Russia", "56.653", "161.360", "3283", "Stratovolcano", "4"}
        };

        String[][] earthquakeData = {
            {"2020", "1", "28", "CUBA: GRANMA; CAYMAN IS; JAMAICA", "19.440", "-78.755", "10", "7.7"},
            {"2020", "3", "25", "RUSSIA: KURIL ISLANDS", "48.986", "157.693", "57", "7.5"},
            {"2020", "6", "18", "KERMADEC ISLANDS: S OF, RAOUL", "-33.294", "-177.838", "10", "7.4"},
            {"2020", "6", "23", "MEXICO: OAXACA", "16.029", "-95.901", "26", "7.4"},
            {"2020", "7", "17", "PAPUA NEW GUINEA: MOROBE, OROA", "-7.843", "147.766", "80", "7"},
            {"2020", "7", "22", "ALASKA", "55.030", "-158.522", "28", "7.8"},
            {"2020", "10", "19", "ALASKA", "54.608", "-159.655", "33", "7.6"},
            {"2020", "10", "30", "GREECE: SAMOS; TURKEY: IZMIR", "37.918", "26.790", "21", "7"},
            {"2021", "2", "10", "NEW CALEDONIA: LOYALTY ISLANDS", "-23.054", "171.601", "10", "7.7"},
            {"2021", "2", "13", "JAPAN: OFF FUKUSHIMA", "37.745", "141.749", "49", "7.1"},
            {"2021", "3", "4", "KERMADEC ISLANDS: S OF, RAOUL", "-29.613", "-177.843", "55", "7.4"},
            {"2021", "3", "4", "KERMADEC ISLANDS: SSE OF RAOUL ISLAND", "-29.740", "-177.267", "19", "8.1"},
            {"2021", "3", "20", "JAPAN: HONSHU ISLAND", "38.452", "141.648", "43", "7"},
            {"2021", "5", "21", "CHINA: QINGHAI PROVINCE", "34.598", "98.251", "10", "7.3"},
            {"2021", "7", "29", "ALASKA PENINSULA", "55.325", "-157.841", "32", "8.2"},
            {"2021", "8", "11", "PHILIPPINES: MINDANAO", "6.455", "126.742", "65", "7.1"},
            {"2021", "8", "12", "SOUTH SANDWICH ISLANDS", "-57.596", "-25.187", "63", "7.5"}
        };

        String[][] tsunamiData = {
            {"2020", "5", "29", "2", "4", "INDONESIA", "LESSER SUNDA: BALI: IJEN VOLCANO", "-8.058", "114.242", "3", "1"},
            {"2020", "6", "23", "4", "1", "MEXICO", "OFF COAST OF OAXACA", "16.029", "-95.901", "1.57", "9"},
            {"2020", "10", "30", "4", "1", "TURKEY", "AEGEAN SEA", "37.918", "26.790", "5.3", "268"},
            {"2021", "3", "4", "4", "1", "NEW ZEALAND", "S OF RAOUL ISLAND, KERMADEC ISLANDS", "-29.740", "-177.267", "1", "174"},
            {"2022", "1", "15", "4", "4", "TONGA", "TONGA ISLANDS", "-20.536", "-175.382", "22", "783"},
            {"2022", "9", "19", "4", "1", "MEXICO", "MEXICO", "18.367", "-103.252", "0.79", "14"},
            {"2022", "11", "30", "4", "1", "NEW ZEALAND", "LAKE TAUPO, NORTH ISLAND", "-38.808", "175.906", "1", "4"},
            {"2023", "9", "16", "4", "8", "GREENLAND", "DICKSON FJORD, GREENLAND", "72.810", "-26.950", "200", "3"},
            {"2024", "1", "1", "4", "3", "JAPAN", "HONSHU: W COAST", "37.498", "137.242", "7.23", "396"},
            {"2024", "4", "2", "4", "1", "TAIWAN", "E. TAIWAN-RYUKYU ISLANDS", "23.819", "121.562", "1", "12"},
            {"2024", "8", "7", "4", "8", "USA", "PEDERSEN LAGOON, AK", "59.904", "-149.825", "17", "3"},
            {"2025", "2", "", "3", "8", "ANTARCTICA", "DALK GLACIER", "-69.417", "76.450", "1", "1"}
            };
           
        // 파서 생성
        VolcanoParser volcanoParser = new VolcanoParser();
        EarthquakeParser earthquakeParser = new EarthquakeParser();
        TsunamiParser tsunamiParser = new TsunamiParser();

        // 파싱
        List<Volcano> volcanoList = volcanoParser.parse(volcanoData);
        List<Earthquake> earthquakeList = earthquakeParser.parse(earthquakeData);
        List<Tsunami> tsunamiList = tsunamiParser.parse(tsunamiData);

        // 배열로 변환
        Volcano[] volcanoes = volcanoList.toArray(new Volcano[0]);
        Earthquake[] earthquakes = earthquakeList.toArray(new Earthquake[0]);
        Tsunami[] tsunamis = tsunamiList.toArray(new Tsunami[0]);

        PrintUtil.printTitle("Finder 테스트");
        PrintUtil.printCount("화산", volcanoes.length);
        PrintUtil.printCount("지진", earthquakes.length);
        
        // Volcano Finder 테스트
        PrintUtil.printTitle("1. Volcano Country Finder 테스트");
        VolcanoCountryFinderStrategy countryStrategy = new VolcanoCountryFinderStrategy("Italy");
        Finder<Volcano> countryFinder = new Finder<>(countryStrategy);
        List<Volcano> italyVolcanoes = countryFinder.find(volcanoList);
        System.out.println("이탈리아 화산:");
        for (Volcano v : italyVolcanoes) {
            System.out.println(v);
        }

        PrintUtil.printTitle("2. Volcano Elevation Finder 테스트");
        VolcanoElevationFinderStrategy elevationStrategy = new VolcanoElevationFinderStrategy(3000, 6000);
        Finder<Volcano> elevationFinder = new Finder<>(elevationStrategy);
        List<Volcano> highVolcanoes = elevationFinder.find(volcanoList);
        System.out.println("고도 3000-6000m 화산:");
        for (Volcano v : highVolcanoes) {
            System.out.println(v);
        }

        PrintUtil.printTitle("3. Volcano Type Finder 테스트");
        VolcanoTypeFinderStrategy typeStrategy = new VolcanoTypeFinderStrategy("Stratovolcano");
        Finder<Volcano> typeFinder = new Finder<>(typeStrategy);
        List<Volcano> stratovolcanoes = typeFinder.find(volcanoList);
        System.out.println("성층화산:");
        for (Volcano v : stratovolcanoes) {
            System.out.println(v);
        }

        PrintUtil.printTitle("4. Volcano VEI Finder 테스트");
        VolcanoVeiFinderStrategy veiStrategy = new VolcanoVeiFinderStrategy(VolcanicExplosivityIndex.VEI_4);
        Finder<Volcano> veiFinder = new Finder<>(veiStrategy);
        List<Volcano> vei4Volcanoes = veiFinder.find(volcanoList);
        System.out.println("VEI 4 화산:");
        for (Volcano v : vei4Volcanoes) {
            System.out.println(v);
        }

        // Earthquake Finder 테스트
        PrintUtil.printTitle("5. Earthquake Depth Finder 테스트");
        EarthquakeDepthFinderStrategy depthStrategy = new EarthquakeDepthFinderStrategy(10, 30);
        Finder<Earthquake> depthFinder = new Finder<>(depthStrategy);
        List<Earthquake> shallowEarthquakes = depthFinder.find(earthquakeList);
        System.out.println("깊이 10-30km 지진:");
        for (Earthquake e : shallowEarthquakes) {
            System.out.println(e);
        }

        PrintUtil.printTitle("6. Earthquake Magnitude Finder 테스트");
        EarthquakeMagnitudeFinderStrategy magnitudeStrategy = new EarthquakeMagnitudeFinderStrategy(8.0, 9.0);
        Finder<Earthquake> magnitudeFinder = new Finder<>(magnitudeStrategy);
        List<Earthquake> strongEarthquakes = magnitudeFinder.find(earthquakeList);
        System.out.println("진도 8.0-9.0 지진:");
        for (Earthquake e : strongEarthquakes) {
            System.out.println(e);
        }

        // Tsunami Finder 테스트
        PrintUtil.printTitle("7. Tsunami Event Validity Finder 테스트");
        TsunamiEventValidityFinderStrategy validityStrategy = new TsunamiEventValidityFinderStrategy(TsunamiEventValidity.VALID_EVENT);
        Finder<Tsunami> validityFinder = new Finder<>(validityStrategy);
        List<Tsunami> validTsunamis = validityFinder.find(tsunamiList);
        System.out.println("유효한 쓰나미 이벤트:");
        for (Tsunami t : validTsunamis) {
            System.out.println(t);
        }

        PrintUtil.printTitle("8. Tsunami Cause Code Finder 테스트");
        TsunamiCauseCodeFinderStrategy causeStrategy = new TsunamiCauseCodeFinderStrategy(TsunamiCauseCode.EARTHQUAKE);
        Finder<Tsunami> causeFinder = new Finder<>(causeStrategy);
        List<Tsunami> earthquakeTsunamis = causeFinder.find(tsunamiList);
        System.out.println("지진으로 인한 쓰나미:");
        for (Tsunami t : earthquakeTsunamis) {
            System.out.println(t);
        }

        PrintUtil.printTitle("9. Tsunami Country Finder 테스트");
        TsunamiCountryFinderStrategy tsunamiCountryStrategy = new TsunamiCountryFinderStrategy("JAPAN");
        Finder<Tsunami> tsunamiCountryFinder = new Finder<>(tsunamiCountryStrategy);
        List<Tsunami> japanTsunamis = tsunamiCountryFinder.find(tsunamiList);
        System.out.println("일본의 쓰나미:");
        for (Tsunami t : japanTsunamis) {
            System.out.println(t);
        }

        PrintUtil.printTitle("10. Tsunami Maximum Water Height Finder 테스트");
        TsunamiMaximumWaterHeightFinderStrategy heightStrategy = new TsunamiMaximumWaterHeightFinderStrategy(5.0, 20.0);
        Finder<Tsunami> heightFinder = new Finder<>(heightStrategy);
        List<Tsunami> highTsunamis = heightFinder.find(tsunamiList);
        System.out.println("최대 수위 5.0-20.0m 쓰나미:");
        for (Tsunami t : highTsunamis) {
            System.out.println(t);
        }

        PrintUtil.printTitle("11. Tsunami Number of Runup Finder 테스트");
        TsunamiNumberOfRunupFinderStrategy runupStrategy = new TsunamiNumberOfRunupFinderStrategy(100, 500);
        Finder<Tsunami> runupFinder = new Finder<>(runupStrategy);
        List<Tsunami> manyRunupTsunamis = runupFinder.find(tsunamiList);
        System.out.println("런업 횟수 100-500회 쓰나미:");
        for (Tsunami t : manyRunupTsunamis) {
            System.out.println(t);
        }

        PrintUtil.printTitle("Sorter 테스트");
        
        // Volcano Sorter 테스트
        PrintUtil.printTitle("1. Volcano Sorter 테스트");
        System.out.println("연도 기준 정렬:");
        VolcanoSorter.sort(volcanoes, 0);
        for (Volcano v : volcanoes) {
            System.out.println(v);
        }

        PrintUtil.printTitle("VEI 기준 정렬");
        VolcanoSorter.sort(volcanoes, 10);
        for (Volcano v : volcanoes) {
            System.out.println(v);
        }

        // Earthquake Sorter 테스트
        PrintUtil.printTitle("2. Earthquake Sorter 테스트");
        System.out.println("연도 기준 정렬:");
        EarthquakeSorter.sort(earthquakes, 0);
        for (Earthquake e : earthquakes) {
            System.out.println(e);
        }

        PrintUtil.printTitle("진도 기준 정렬");
        EarthquakeSorter.sort(earthquakes, 7);
        for (Earthquake e : earthquakes) {
            System.out.println(e);
        }

        // Tsunami Sorter 테스트
        PrintUtil.printTitle("3. Tsunami Sorter 테스트");
        System.out.println("이벤트 유효성 기준 정렬:");
        TsunamiSorter.sortByEventValidity(tsunamiList);
        for (Tsunami t : tsunamiList) {
            System.out.println(t);
        }

        PrintUtil.printTitle("원인 코드 기준 정렬");
        TsunamiSorter.sortByCauseCode(tsunamiList);
        for (Tsunami t : tsunamiList) {
            System.out.println(t);
        }

        PrintUtil.printTitle("국가 기준 정렬");
        TsunamiSorter.sortByCountry(tsunamiList);
        for (Tsunami t : tsunamiList) {
            System.out.println(t);
        }

        PrintUtil.printTitle("최대 수위 기준 정렬");
        TsunamiSorter.sortByMaximumWaterHeight(tsunamiList);
        for (Tsunami t : tsunamiList) {
            System.out.println(t);
        }

        PrintUtil.printTitle("런업 횟수 기준 정렬");
        TsunamiSorter.sortByNumberOfRunup(tsunamiList);
        for (Tsunami t : tsunamiList) {
            System.out.println(t);
        }

        PrintUtil.printTitle("통합 정렬 메소드 테스트");
        System.out.println("연도 기준 정렬 (criteria=0):");
        TsunamiSorter.sort(tsunamiList, 0);
        for (Tsunami t : tsunamiList) {
            System.out.println(t);
        }

        PrintUtil.printTitle("최대 수위 기준 정렬 (criteria=8)");
        TsunamiSorter.sort(tsunamiList, 8);
        for (Tsunami t : tsunamiList) {
            System.out.println(t);
        }
    }
}
