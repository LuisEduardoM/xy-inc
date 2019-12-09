package br.com.zup.xyinc.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zup.xyinc.XyIncApplicationTests;
import br.com.zup.xyinc.builder.PontoInteresseBuilder;
import br.com.zup.xyinc.entidade.PontoInteresse;
import br.com.zup.xyinc.repositorio.PontoInteresseRepositorio;
import br.com.zup.xyinc.servico.PontoInteresseServico;

@AutoConfigureMockMvc
public class PontoInteresseControladorTest extends XyIncApplicationTests {

	@InjectMocks
	private PontoInteresseControlador pontoInteresseControlador;
	
	@Mock
	private PontoInteresseServico pontoInteresseServicoMock;
	
	@InjectMocks
	private PontoInteresseServico pontoInteresseServico;
	
	@Mock
	private PontoInteresseRepositorio pontoInteresseRepositorio;

	private MockMvc mvc;

	private final String BASE_PATH = "http://localhost:8100/pontoInteresse";
	
	@BeforeEach
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(pontoInteresseControlador).build();
	}

	@Test	
	public void listarTodos() throws Exception {
		String path = BASE_PATH + "/listarTodos";
		Mockito.when(pontoInteresseServicoMock.listarTodos()).thenReturn(PontoInteresseBuilder.buildAll());
		mvc.perform(get(path).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(7)));
	}

	@Test
	public void buscarPorProximidade() throws Exception {
		String path = BASE_PATH + "/buscarPorProximidade?coordenadaX=20&coordenadaY=10&distanciaMaxima=10";
		Mockito.when(pontoInteresseRepositorio.findAll()).thenReturn(PontoInteresseBuilder.buildAll());
		List<PontoInteresse> pontosEncontradosList = pontoInteresseServico.buscarPorProximidade(20, 10, 10);
		Mockito.when(pontoInteresseServicoMock.buscarPorProximidade(20, 10, 10)).thenReturn(pontosEncontradosList);
		mvc.perform(get(path).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(4)));
	}

	@Test
	public void salvar() throws Exception {
		String path = BASE_PATH + "/salvar";
		pontoInteresse = PontoInteresseBuilder.build();

		Mockito.when(pontoInteresseServicoMock.salvar(PontoInteresseBuilder.build())).thenReturn(pontoInteresse);
		mvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(pontoInteresse))).andExpect(status().isCreated())
				.andExpect(jsonPath("$.codigo", is(pontoInteresse.getCodigo())));
	}
	
	@Test
	public void salvarInvalido() throws Exception {
		String path = BASE_PATH + "/salvar";
		pontoInteresse = new PontoInteresse("Teatro", -1, 1);
		
		Mockito.when(pontoInteresseServicoMock.salvar(PontoInteresseBuilder.build())).thenReturn(pontoInteresse);
		mvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(pontoInteresse))).andExpect(status().isBadRequest());
	}
}
