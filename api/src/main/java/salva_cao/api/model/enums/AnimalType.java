package salva_cao.api.model.enums;

public enum AnimalType {
    CAT("Gato"),
    DOG("Cachorro");

    private final String name;

    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
