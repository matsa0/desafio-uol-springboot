package matsa.dev.desafiouolhost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConfig {

    //@Bean marca um método de um componente spring
    //restTemplate() vai produzie um bean do tipo RestTemplate e sempre que precisar esse método será chamado
    @Bean 
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*
    Um RestTemplate é uma classe fornecida pelo Spring Framework que simplifica a comunicação com 
    serviços RESTful através de HTTP. Ele fornece métodos convenientes para enviar solicitações 
    HTTP e receber respostas, além de abstrair detalhes de baixo nível, como a criação e 
    gerenciamento de conexões HTTP.
    */
}
