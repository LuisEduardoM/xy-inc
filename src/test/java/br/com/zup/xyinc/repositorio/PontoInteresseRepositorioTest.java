package br.com.zup.xyinc.repositorio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import br.com.zup.xyinc.XyIncApplicationTests;
import br.com.zup.xyinc.builder.PontoInteresseBuilder;

public class PontoInteresseRepositorioTest extends XyIncApplicationTests {
	
	@Autowired
	protected PontoInteresseRepositorio pontoInteresseRepositorio;

	@BeforeEach
	void init() {
		pontoInteresse = PontoInteresseBuilder.build();
		pontoInteresse = pontoInteresseRepositorio.save(pontoInteresse);
	}

	@Test
	@Rollback
	public void salvar() {
		assertNotNull(pontoInteresse.getCodigo());
	}
}
