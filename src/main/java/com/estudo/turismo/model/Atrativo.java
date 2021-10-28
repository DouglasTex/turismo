package com.estudo.turismo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name="TB_ATRATIVO")
public class Atrativo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome, cidade, estado, tipo;
	
	private float latitude, longitude;
	

	@Lob //indica que a variável será um formato de texto grande
	private String descricao;
	@Lob
	private String fonte;
	
	public Atrativo(String nome, String cidade, String estado, String tipo, String descricao, String fonte, float latitude, float longitude) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.tipo = tipo;
		this.descricao = descricao;
		this.fonte = fonte;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Atrativo() {
		
	}
	
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, nome='%s', cidade='%s', estado='%s', tipo='%s', descricao='%s', fonte='%s']",
				id, nome, cidade, estado, tipo, descricao, fonte);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return id;
	}

	public void setCodigo(Long codigo) {
		this.id = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

}
