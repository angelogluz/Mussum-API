package local.controller;

import local.model.Usuario;
import local.repository.UsuarioRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioDAO;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_PESQUISAR_CURSO')") //TODO: Criar uma regra específica para o relatório
    // Filtro desabilitado para testes
    public ResponseEntity<byte[]> buscarUsuarios(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim) throws JRException {
//        List<Usuario> usuarios =  usuarioDAO.findByCreatedAtBetween(inicio,fim); //TODO: Testar e corrigir Repository
        List<Usuario> usuarios =  usuarioDAO.findAll();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("DATE_START", Date.valueOf(inicio));
        parametros.put("DATE_END", Date.valueOf(fim));
        //parametros.put("REPORT_LOCALE", new Locale("pt","BR")); //TODO: Ativar caso precise formatar

        InputStream x
                = getClass().getResourceAsStream("/reports/Usuarios.jrxml");
        JasperReport is
                = JasperCompileManager.compileReport(x);

        JasperPrint print = JasperFillManager.fillReport(is,parametros, new JRBeanCollectionDataSource(usuarios));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .body(JasperExportManager.exportReportToPdf(print));


    }
}
