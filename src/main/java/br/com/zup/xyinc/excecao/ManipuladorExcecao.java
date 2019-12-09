package br.com.zup.xyinc.excecao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ManipuladorExcecao extends ResponseEntityExceptionHandler {

	private static final String CONSTANT_VALIDATION_MIN = "Min";
	private static final String CONSTANT_VALIDATION_NOT_BLANK = "NotBlank";
	private static final String CONSTANT_VALIDATION_NOT_NULL = "NotNull";
	private static final String CONSTANT_VALIDATION_SIZE = "Size";
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Erro> erros = gerarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> gerarListaDeErros(BindingResult bindingResult) {

		List<Erro> erros = new ArrayList<>();

		bindingResult.getFieldErrors().forEach(fieldError -> {
			String mensagemUsuario = tratarMensagemDeErroParaUsuario(fieldError);
			String mensagemDesenvolvedor = fieldError.toString();
			erros.add(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		});
		return erros;
	}
	
	private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {

		if (fieldError.getCode().equals(CONSTANT_VALIDATION_NOT_BLANK) || fieldError.getCode().equals(CONSTANT_VALIDATION_NOT_NULL)) {
			return fieldError.getDefaultMessage().concat(" é obrigatório.");
		}
		
		if (fieldError.getCode().equals(CONSTANT_VALIDATION_SIZE)) {
			return fieldError.getDefaultMessage().concat(String.format(" deve ter entre %s e %s caracteres.", fieldError.getArguments()[2], fieldError.getArguments()[1]));
		}

		if(fieldError.getCode().equals(CONSTANT_VALIDATION_MIN)) {
			return fieldError.getDefaultMessage().concat(String.format(" deve ter valor maior ou igual a %s.", fieldError.getArguments()[1]));
		}
		
		return fieldError.toString();
	}

}
