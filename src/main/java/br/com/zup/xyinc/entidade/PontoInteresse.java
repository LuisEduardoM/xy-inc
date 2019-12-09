package br.com.zup.xyinc.entidade;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ponto_interesse")
public class PontoInteresse implements Serializable {

	private static final long serialVersionUID = 1782859465680160422L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@NotBlank(message = "Nome")
	@Column(name = "nome")
	private String nome;
	
	@Min(value = 0, message = "Coordenada X")
	@NotNull(message = "Coordenada X")
	@Column(name = "coordenada_x")
	private Integer coordenadaX;
	
	@Min(value = 0, message = "Coordenada Y")
	@NotNull(message = "Coordenada Y")
	@Column(name = "coordenada_y")
	private Integer coordenadaY;
	
	public PontoInteresse() {
	}

	public PontoInteresse(String nome, Integer coordenadaX, Integer coordenadaY) {
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public Integer getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, coordenadaX, coordenadaY, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PontoInteresse)) {
			return false;
		}
		PontoInteresse other = (PontoInteresse) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(coordenadaX, other.coordenadaX)
				&& Objects.equals(coordenadaY, other.coordenadaY) && Objects.equals(nome, other.nome);
	}
}
