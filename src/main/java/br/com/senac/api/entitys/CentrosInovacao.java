package br.com.senac.api.entitys;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CentrosInovacao {

    // ID da movimentação
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cidade
    @Column(nullable = false)
    private String cidade;

    // Estado
    @Column(nullable = false)
    private String estado;

    // Nome do agente
    @Column(nullable = false)
    private String nome;

    // Endereço do agente
    @Column(nullable = false)
    private String endereco;

    // CEP
    @Column(nullable = false)
    private Long cep;

    // Data de fundação
    @Column(nullable = false)
    private LocalDate data;

    // Descrição
    @Column
    private String descricao;

    // Link
    @Column
    private String link;

    // Telefone
    @Column
    private String telefone;


    //  Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
