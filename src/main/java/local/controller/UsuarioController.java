package local.controller;

import de.svenjacobs.loremipsum.LoremIpsum;
import local.model.Usuario;
import local.repository.UsuarioRepository;
import local.util.PasswordGenerator;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioDAO;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_PESQUISAR_CURSO')") //TODO: Criar uma regra específica para o relatório
    // Filtro desabilitado para testes
    // TODO: Migrar funcionalidade para uma Service
    public ResponseEntity<byte[]> buscarUsuarios(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim) throws JRException {
        List<Usuario> usuarios =  usuarioDAO.findByCreatedAtBetween(inicio,fim); //TODO: Testar e corrigir Repository
//        List<Usuario> usuarios =  usuarioDAO.findAll();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("DATE_START", Date.valueOf(inicio));
        parametros.put("DATE_END", Date.valueOf(fim));
        //parametros.put("REPORT_LOCALE", new Locale("pt","BR")); //TODO: Ativar caso precise formatar

        InputStream x
                = getClass().getResourceAsStream("/reports/Usuaris.jrxml");
        JasperReport is
                = JasperCompileManager.compileReport(x);

        JasperPrint print = JasperFillManager.fillReport(is,parametros, new JRBeanCollectionDataSource(usuarios));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .body(JasperExportManager.exportReportToPdf(print));


    }

    @PostConstruct
    public void lerolero(){
        LoremIpsum ipsum = new LoremIpsum();
        List<Usuario> usuarios = new ArrayList<>();
        String words = ipsum.getParagraphs(5);
        for (int i = 0; i < 50; i++) {
            Usuario u = new Usuario();
            u.setEmail(ipsum.getWords(1,new Random().nextInt(50))+"@gmail.com");
            u.setNome(ipsum.getWords(3,new Random().nextInt(50)));
            u.setSenha(PasswordGenerator.generate(ipsum.getWords(1)));
            usuarios.add(u);
        }
        usuarioDAO.saveAll(usuarios);
    }
}
