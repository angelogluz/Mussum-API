package local.mail;

import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * metedo para enviar uma mensagem de quantos usuarios foram excluidos
     * @param quantidade numero inteiro de usuarios excluidos
     */
    public void notificaRemocaoDeUsuarios(int quantidade) {
        enviar(
                "adsfatecsenac@gmail.com",
                Arrays.asList("angelogl@gmail.com", "adsfatecsenac@gmail.com"),
                "Notificação de usuários removidos",
                "Olá, <br/><br/> " + quantidade + " " +
                        "usuários foram removidos " +
                        "<br/><br/>" +
                        "Att,<br/>" +
                        "Equipe Mussum Nutela");
    }

    /**
     * Metodo de enviar mensagem de remetente ao destinatario
     * @param remetente email de quem está a enviar a mensagem
     * @param destinatarios email para quem deve ser enviado
     * @param assunto um breve assunto sobre a mensagem
     * @param mensagem mensagem a ser enviada para o destinatário
     */
    public void enviar(String remetente, List<String> destinatarios, String assunto, String mensagem) {
        MimeMessage message = mail.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(remetente);
            helper.setTo(destinatarios.toArray(new String[destinatarios.size()]));
            helper.setSubject(assunto);
            helper.setText(mensagem, true);

            mail.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Não foi possível enviar e-mail");
        }
    }
}
