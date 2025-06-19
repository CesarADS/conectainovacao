package br.com.senac.api.useCases.parquesCientificos.domains;
import java.time.LocalDate;

public class ParquesCientificosRequestDom {

    private String cidade;
    private String estado;
    private String nome;
    private String endereco;
    private Long cep;
    private LocalDate data;
    private String descricao;
    private String link;
    private String telefone;
    private String instituicao_financeira;


    // Getters and Setters
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getInstituicao_financeira() {
        return instituicao_financeira;
    }

    public void setInstituicao_financeira(String instituicao_financeira) {
        this.instituicao_financeira = instituicao_financeira;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}