package models;

public class EnderecoProfessor {
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String Estado;
    private Integer telFixo;
    private Integer celular;

    public EnderecoProfessor(String logradouro, Integer numero, String bairro, String cidade, String estado, Integer telFixo, Integer celular) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        Estado = estado;
        this.telFixo = telFixo;
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Integer getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(Integer telFixo) {
        this.telFixo = telFixo;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }
}
