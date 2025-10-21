import java.util.function.Consumer;

public interface IPlantFactory {
    

    Plant newInstance(PlantType type, String commonName, Consumer<Plant.PlantBuilder> customize);
    
    default Plant newInstance(PlantType type, String commonName) {
        return newInstance(type, commonName, builder -> {});
    }
}
