package com.suporte.ecommercesuporte.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

// Importações necessárias para as anotações JPA e Bean Validation (Hibernate Validator)
@Entity
@Table(name = "produtos")
// Anota a classe como entidade JPA e define o nome da tabela correspondente no banco de dados
public class Produto implements Serializable {

	/**
	A classe Produto representa um produto em uma loja virtual. Ela define as propriedades de um produto, incluindo
	nome, descrição, preço e estoque. Esta classe é uma entidade JPA (@Entity) que pode ser persistida em um banco de dados
	e implementa a interface Serializable para suporte a serialização e desserialização.
	*/
	
	
 
	
	/**
	A constante serialVersionUID é usada durante a desserialização de um objeto para verificar se a classe desserializada é compatível
	com a classe serializada. Definir explicitamente um valor para serialVersionUID ajuda a controlar a versão da classe e garantir
	a compatibilidade durante a desserialização, mesmo que haja alterações na classe.
	*/
	private static final long serialVersionUID = 1L;

	// Define um identificador primário
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id_produto", nullable = false)
private Long id;

    // Define o nome do produto com validações apropriadas
@NotNull(message = "O nome do produto é obrigatório")
@Size(max = 100, message = "O nome do produto não pode exceder 100 caracteres")
@Pattern(regexp = "^[\\p{L} \\p{P}]*$", message = "O nome só pode conter letras e espaços")
@Column(name = "nome_produto", nullable = false)
private String nome;

    // Define a descrição do produto com validações apropriadas
@NotNull(message = "A descrição do produto é obrigatória")
@Size(max = 500, message = "A descrição do produto não pode exceder 500 caracteres")
@Column(name = "descricao_produto", nullable = false)
private String descricao;

    // Define o preço do produto com validações apropriadas
@NotNull(message = "O preço do produto é obrigatório")
@Min(value = 0, message = "O preço não pode ser negativo")
@Max(value = 1000000, message = "O preço não pode exceder 1.000.000")
@Column(name = "preco_produto", nullable = false)
private double preco;

    // Define o estoque do produto com validações apropriadas
@NotNull(message = "O estoque do produto é obrigatório")
@Min(value = 0, message = "O estoque não pode ser negativo")
@Max(value = 1000000, message = "O estoque não pode exceder 1.000.000")
@Column(name = "estoque_produto", nullable = false)
private int estoque;


@ManyToOne
private Categoria categoria;

/*
 * -- Criação de um índice na coluna que armazena a chave estrangeira para a tabela de categorias na tabela de produtos
CREATE INDEX idx_categoria_id_categoria ON produtos (categoria_id_categoria);
realizar o script acima direto no banco de dados
 * */




    // Construtor sem argumentos necessário para o JPA e desserialização
public Produto() {}

    // Construtor completo
public Produto(String nome, String descricao, double preco, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Métodos getters e setters para acessar e modificar as propriedades do objeto
public Long getId() {
        return id;
    }
}