package models;

import java.util.Date;

public class Professor {
    private Integer identProf;
    private String nomeProf;
    private EnderecoProfessor endProf;
    private Date dataNasc;
    private EspecProf especProf;
    private TituloProf tituloProf;

    public Professor(Integer identProf, String nomeProf, EnderecoProfessor endProf, Date dataNasc,
                     EspecProf especProf, TituloProf tituloProf) {
        this.identProf = identProf;
        this.nomeProf = nomeProf;
        this.endProf = endProf;
        this.dataNasc = dataNasc;
        this.especProf = especProf;
        this.tituloProf = tituloProf;
    }

    public Integer getIdentProf() {
        return identProf;
    }

    public void setIdentProf(Integer identProf) {
        this.identProf = identProf;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public EnderecoProfessor getEndProf() {
        return endProf;
    }

    public void setEndProf(EnderecoProfessor endProf) {
        this.endProf = endProf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public EspecProf getEspecProf() {
        return especProf;
    }

    public void setEspecProf(EspecProf especProf) {
        this.especProf = especProf;
    }

    public TituloProf getTituloProf() {
        return tituloProf;
    }

    public void setTituloProf(TituloProf tituloProf) {
        this.tituloProf = tituloProf;
    }
}
