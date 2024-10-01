package br.com.gestaotcc.gestaotcc.resources.service.api.config;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("br.com.gestaotcc.gestaotcc.resources.service.api");
        register(WebConfig.class);
        register(MultiPartFeature.class); // Adicione isto
    }
}