package models;

import java.util.Date;

public class Aluno {
    private Integer matricula;
    private String nome;
    private Date dataNasc;
    private Integer codCurso;
    private String nomeCurso;
    private Disciplina disciplina;
    private Double np1;
    private Double np2;

    public Double media(Double np1, Double np2) {
        Double result;
        result = (np1 + np2) / 2;
        return result;
    }

    private Integer faltas;

    public Aluno(Integer matricula, String nome, Date dataNasc, Integer codCurso, String nomeCurso,
                 Disciplina disciplina, Double np1, Double np2, Integer faltas) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.disciplina = disciplina;
        this.np1 = np1;
        this.np2 = np2;
        this.faltas = faltas;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Double getNp1() {
        return np1;
    }

    public void setNp1(Double np1) {
        this.np1 = np1;
    }

    public Double getNp2() {
        return np2;
    }

    public void setNp2(Double np2) {
        this.np2 = np2;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }
}
