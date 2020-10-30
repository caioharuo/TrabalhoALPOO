package models;

public enum EspecProf {
    DIGITO("Digito"),
    INFORMATICA("Informática"),
    MATEMATICA("Matemática"),
    MEDICINA("Medicina");

    private final String descricao;

    EspecProf(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
