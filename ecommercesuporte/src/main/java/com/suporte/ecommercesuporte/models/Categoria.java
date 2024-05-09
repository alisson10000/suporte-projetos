package com.suporte.ecommercesuporte.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    // Nome da categoria
    @NotBlank(message = "O nome da categoria é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome da categoria deve ter entre 3 e 50 caracteres.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "O nome da categoria deve conter apenas letras, números e espaços.")
    @Column(name = "nome_categoria", nullable = false)
    private String nome;

    // Produtos associados a esta categoria
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Produto> produtos;

    // Construtor padrão
    public Categoria() {
        produtos = new ArrayList<>();
    }

    // Construtor completo
    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        produtos = new ArrayList<>();
    }

    // Método getter para o ID da categoria
    public Long getId() {
        return id;
    }

    // Método setter para o ID da categoria
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para o nome da categoria
    public String getNome() {
        return nome;
    }

    // Método setter para o nome da categoria
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para a lista de produtos associados à categoria
    public List<Produto> getProdutos() {
        return produtos;
    }

    // Método setter para a lista de produtos associados à categoria
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
