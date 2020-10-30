package models;

public enum NomeCurso {
    ADMINISTRACAO_EMPRESAS("Administração de Empresas"),
    BIOMEDICINA("BioMedicina"),
    CIENCIAS_BIOLOGICAS("Ciências Biológicas"),
    CIENCIAS_DA_COMPUTACAO("Ciências da Computação"),
    DIREITO("Direito"),
    EDUCACAO_FISICA("Educação Física"),
    FARMACOLOGIA("Farmacologia"),
    REDE_DE_COMPUTADORES("Rede de Computadores"),
    SISTEMAS_DE_INFORMACOES("Sistemas de Informações");

    private final String descricao;

    NomeCurso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
