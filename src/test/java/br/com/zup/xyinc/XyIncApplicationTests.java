package br.com.zup.xyinc;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.xyinc.entidade.PontoInteresse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class XyIncApplicationTests {

	protected PontoInteresse pontoInteresse;
	
	@Test
	void contextLoads() {
	}

}
