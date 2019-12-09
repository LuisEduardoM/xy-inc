package br.com.zup.xyinc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.xyinc.entidade.PontoInteresse;

@Repository
public interface PontoInteresseRepositorio extends JpaRepository<PontoInteresse, Long> {

}
