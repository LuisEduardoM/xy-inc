package br.com.zup.xyinc.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.xyinc.entidade.PontoInteresse;
import br.com.zup.xyinc.repositorio.PontoInteresseRepositorio;

@Service
public class PontoInteresseServico {

	@Autowired
	private PontoInteresseRepositorio pontoInteresseRepositorio;

	public List<PontoInteresse> listarTodos() {
		return pontoInteresseRepositorio.findAll();
	}

	public List<PontoInteresse> buscarPorProximidade(Integer coordenadaX, Integer coordenadaY, Integer distanciaMaxima) {
		return listarTodos().stream()
				.filter(item -> Math.sqrt(Math.pow((item.getCoordenadaX() - coordenadaX), 2)
						+ Math.pow((item.getCoordenadaY() - coordenadaY), 2)) <= distanciaMaxima)
				.collect(Collectors.toList());
	}

	public PontoInteresse salvar(PontoInteresse pontoInteresse) {
		return pontoInteresseRepositorio.save(pontoInteresse);
	}
}
