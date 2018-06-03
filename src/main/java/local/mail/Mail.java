package local.mail;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;

@Component
public class Mail {

    @Autowired
    private JavaMailSender mail;

	public void notificaRemocaoDeUsuarios (int quantidade){
        enviar(
                "adsfatecsenac@gmail.com",
                Arrays.asList("angelogl@gmail.com","adsfatecsenac@gmail.com"),
                "Notificação de usuários removidos",
                "Olá, <br/><br/> "+quantidade+ " " +
                        "usuários foram removidos " +
                        "<br/>" +
                        "Att,<br/><br/>" +
                        "Equipe Mussum Nutela");
    }

    public void enviar(String remetente, List<String> destinatarios, String assunto, String mensagem){
        MimeMessage message = mail.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(remetente);
            helper.setTo(destinatarios.toArray(new String[destinatarios.size()]));
            helper.setSubject(assunto);
            helper.setText(mensagem,true);

            mail.send(message);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException ("Não foi possível enviar e-mail");
        }
    }
}
