package models;

public class Curso {
    private Integer codCurso;
    private NomeCurso nomeCurso;
    private String tipoCurso;
    private Integer cargaHoraria;
    private Integer codInstituto;

    public Curso(Integer codCurso, NomeCurso nomeCurso, String tipoCurso, Integer cargaHoraria, Integer codInstituto) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.tipoCurso = tipoCurso;
        this.cargaHoraria = cargaHoraria;
        this.codInstituto = codInstituto;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public NomeCurso getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(NomeCurso nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getCodInstituto() {
        return codInstituto;
    }

    public void setCodInstituto(Integer codInstituto) {
        this.codInstituto = codInstituto;
    }
}
