package models;

public class Disciplina {
    private Integer codDisc;
    private String nomeDisc;
    private Integer cargaHoraria;
    private String aulasSemana;

    public Disciplina() {
    }

    public Disciplina(Integer codDisc, String nomeDisc, Integer cargaHoraria) {
        this.codDisc = codDisc;
        this.nomeDisc = nomeDisc;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(Integer codDisc, String nomeDisc, Integer cargaHoraria, String aulasSemana) {
        this.codDisc = codDisc;
        this.nomeDisc = nomeDisc;
        this.cargaHoraria = cargaHoraria;
        this.aulasSemana = aulasSemana;
    }

    public Disciplina(Integer codDisc, String nomeDisc) {
        this.codDisc = codDisc;
        this.nomeDisc = nomeDisc;
    }

    public Integer getCodDisc() {
        return codDisc;
    }

    public void setCodDisc(Integer codDisc) {
        this.codDisc = codDisc;
    }

    public String getNomeDisc() {
        return nomeDisc;
    }

    public void setNomeDisc(String nomeDisc) {
        this.nomeDisc = nomeDisc;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getAulasSemana() {
        return aulasSemana;
    }

    public void setAulasSemana(String aulasSemana) {
        this.aulasSemana = aulasSemana;
    }
}
