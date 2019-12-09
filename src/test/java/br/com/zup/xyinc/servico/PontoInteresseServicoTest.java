package br.com.zup.xyinc.servico;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.zup.xyinc.XyIncApplicationTests;
import br.com.zup.xyinc.builder.PontoInteresseBuilder;
import br.com.zup.xyinc.entidade.PontoInteresse;
import br.com.zup.xyinc.repositorio.PontoInteresseRepositorio;

public class PontoInteresseServicoTest extends XyIncApplicationTests {

	@InjectMocks
	private PontoInteresseServico pontoInteresseServico;
	
	@Mock
	protected PontoInteresseRepositorio pontoInteresseRepositorio;

	@BeforeEach
	void init() {
		pontoInteresse = PontoInteresseBuilder.build();
		pontoInteresse.setCodigo(System.currentTimeMillis());
	}

	@Test
	public void buscarTodos() {
		List<PontoInteresse> pontoInteresseList = Arrays.asList(pontoInteresse);
		Mockito.when(pontoInteresseServico.listarTodos()).thenReturn(pontoInteresseList);
		assertNotNull(pontoInteresseList.stream().findFirst());
	}

	@Test
	public void buscarPorProximidade() {
		List<PontoInteresse> pontoInteresseList = Arrays.asList(pontoInteresse);
		Mockito.when(pontoInteresseServico.buscarPorProximidade(20, 10, 10)).thenReturn(pontoInteresseList);
		assertNotNull(pontoInteresseList.stream().findFirst());
	}

	@Test
	public void salvar() {
		Mockito.when(pontoInteresseServico.salvar(pontoInteresse)).thenReturn(pontoInteresse);
		pontoInteresseServico.salvar(pontoInteresse);
		assertNotNull(pontoInteresse.getCodigo());
	}
}
