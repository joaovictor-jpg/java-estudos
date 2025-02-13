package br.com.jota.entities.enums;

public enum GamesStatusEnum {
    NON_STARTED("não iniciado"),
    INCOMPLETE("incompleto"),
    COMPLETE("completo");

    private String label;
    GamesStatusEnum(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
