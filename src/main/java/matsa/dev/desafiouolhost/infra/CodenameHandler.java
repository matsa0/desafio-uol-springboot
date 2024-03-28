package matsa.dev.desafiouolhost.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import matsa.dev.desafiouolhost.model.GroupType;
import matsa.dev.desafiouolhost.service.CodenameService;

@Component
public class CodenameHandler {

    @Autowired
    private CodenameService service;

    
    public String findCodename(GroupType groupType) {

        String firstCodename = null;

        if(groupType == GroupType.AVENGERS) { //precisa ser acessado de forma static
            firstCodename = service.getAvengersCodenames().stream().findFirst().orElseThrow();
            
            //depois de achar o primeiro elemento, você deve removê-lo da lista, pois não podem se repetir
            service.getAvengersCodenames().remove(firstCodename);
            return firstCodename;
        }
        else {
            firstCodename = service.getJLeagueCodenames().stream().findFirst().orElseThrow();
    
            service.getJLeagueCodenames().remove(firstCodename);
            return firstCodename;
        }

    }
}
