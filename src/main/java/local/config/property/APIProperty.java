package local.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mussumapi")
public class APIPropertyy {

    private String originPermitida = "http://localhost:8080";

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }

    private final Seguranca seguranca = new Seguranca();

    public Seguranca getSeguranca() {
        return seguranca;
    }

    /**
     * Configurações de propriedades de segurança em perfis diferentes
     */
    public static class Seguranca{
        private boolean enableHttps;

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
    }



}
