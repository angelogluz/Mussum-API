package local.handler;


    import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
    import java.util.NoSuchElementException;

    import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

    @ControllerAdvice
    public class MussumExceptionHandler extends ResponseEntityExceptionHandler {

        // Classe do Spring que acessa o messages.properties
        @Autowired
        private MessageSource messageSource;

        @Override
        protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                      HttpHeaders headers, HttpStatus status, WebRequest request) {

            String mensagemClienteUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
            String mensagemClienteDesenvolvedor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
            List<Erro> erros = Arrays.asList(new Erro(mensagemClienteUsuario, mensagemClienteDesenvolvedor));
            return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
        }



        @ExceptionHandler(value = {DataIntegrityViolationException.class })
        public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
            String mensagemClienteUsuario = messageSource.getMessage("recurso.operacao-nao-permitida", null, LocaleContextHolder.getLocale());
            String mensagemClienteDesenvolvedor = ExceptionUtils.getRootCauseMessage(ex);
            List<Erro> erros = Arrays.asList(new Erro(mensagemClienteUsuario, mensagemClienteDesenvolvedor));
            return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }
        @ExceptionHandler(value = {NoSuchElementException.class })
        public ResponseEntity<Object> NoSuchElementException(NoSuchElementException ex, WebRequest request) {
            String mensagemClienteUsuario = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
            String mensagemClienteDesenvolvedor = ExceptionUtils.getRootCauseMessage(ex);
            List<Erro> erros = Arrays.asList(new Erro(mensagemClienteUsuario, mensagemClienteDesenvolvedor));
            return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }


        private List<Erro> criarListaDeErros(BindingResult bindingResult) {
            List<Erro> erros = new ArrayList<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                String mensagemClienteUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                String mensagemClienteDesenvolvedor = fieldError.toString();
                erros.add(new Erro(mensagemClienteUsuario, mensagemClienteDesenvolvedor));
            }

            return erros;
        }

        public static class Erro {

            private String mensagemClienteUsuario;
            private String mensagemClienteDesenvolvedor;

            public Erro(String mensagemClienteUsuario, String mensagemClienteDesenvolvedor) {
                this.mensagemClienteUsuario = mensagemClienteUsuario;
                this.mensagemClienteDesenvolvedor = mensagemClienteDesenvolvedor;
            }

            public String getMensagemClienteUsuario() {
                return mensagemClienteUsuario;
            }

            public String getMensagemClienteDesenvolvedor() {
                return mensagemClienteDesenvolvedor;
            }

        }

    }


