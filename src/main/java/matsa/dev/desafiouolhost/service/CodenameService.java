package matsa.dev.desafiouolhost.service;


import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Service
@Getter
public class CodenameService {
    
    @Autowired
    private RestTemplate restTemplate;

    //Enviromente provê acesso a arquivos de configuração .properties(assim vamos pegar as urls)
    @Autowired
    private Environment environment;

    private List<String> avengersCodenames = new ArrayList<>();
    private List<String> jLeagueCodenames = new ArrayList<>();

    ObjectMapper objMapper = new ObjectMapper();
    
    @SuppressWarnings("null")
    //método que vai bater na url e carregar as informações em uma lista(inicializado toda vez que a aplicação rodar @PostConstruct)
    @PostConstruct
    public void loadJsonData() {
        try {

            String response = environment.getProperty("avengers"); //pega a url no app.properties
            String jsonResponse = restTemplate.getForObject(response, String.class);

            JsonNode node = objMapper.readTree(jsonResponse); //vai ler os nós da resposta json
            ArrayNode arrAvengers = (ArrayNode) node.get("vingadores"); //vai armazenar todos os nodes no ArrayNode

            for(JsonNode n : arrAvengers) {
                this.avengersCodenames.add(n.get("codinome").asText());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData() {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(environment.getProperty("justice_league"));

            NodeList list = document.getElementsByTagName("codinome");
            
            for(int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                String nodeString = node.getTextContent();
                this.jLeagueCodenames.add(nodeString);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
