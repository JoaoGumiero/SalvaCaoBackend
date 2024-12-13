package salva_cao.api.model.enums;

public enum HealthStatus {
    HEALTHY("Saudável"),
    SICK("Doente"),
    INJURED("Machucado"),
    RECOVERING("Recuperação");

    private final String description;

    HealthStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
