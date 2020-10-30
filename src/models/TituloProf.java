package models;

public enum TituloProf {
    BACHAREL("Bacharel"),
    ESPECIALISTA_LATO_SENSU("Especialista Lato Sensu"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado");

    private final String descricao;

    TituloProf(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
