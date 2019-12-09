package br.com.zup.xyinc.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.xyinc.entidade.PontoInteresse;
import br.com.zup.xyinc.servico.PontoInteresseServico;

@RestController
@RequestMapping("/pontoInteresse")
public class PontoInteresseControlador {

	@Autowired
	private PontoInteresseServico pontoInteresseServico;

	@GetMapping("/buscarTodos")
	public List<PontoInteresse> buscarTodos() {
		return pontoInteresseServico.buscarTodos();
	}

	@GetMapping("buscarPorProximidade")
	public List<PontoInteresse> buscarPorProximidade(@RequestParam("coordenadaX") Integer coordenadaX,
			@RequestParam("coordenadaY") Integer coordenadaY, @RequestParam("distanciaMaxima") Integer distanciaMaxima) {
		return pontoInteresseServico.buscarPorProximidade(coordenadaX, coordenadaY, distanciaMaxima);
	}

	@PostMapping("/salvar")
	public ResponseEntity<PontoInteresse> salvar(@Valid @RequestBody PontoInteresse pontoInteresse) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pontoInteresseServico.salvar(pontoInteresse));
	}
}
