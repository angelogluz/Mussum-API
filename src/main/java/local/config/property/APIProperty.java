package local.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mussumapi")
public class APIProperty {

    private final Seguranca seguranca = new Seguranca();
    private final Mail mail = new Mail();
    private String originPermitida = "http://localhost:8080";

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }

    public Mail getMail() {
        return mail;
    }

    public Seguranca getSeguranca() {
        return seguranca;
    }

    /**
     * Configurações de propriedades de segurança em perfis diferentes
     */
    public static class Seguranca {
        private boolean enableHttps;

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
    }

    public static class Mail {
        private String host;
        private int port;
        private String username;
        private String password;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
