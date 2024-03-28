package matsa.dev.desafiouolhost.model.dto;

import matsa.dev.desafiouolhost.model.GroupType;
/*
Quando você declara uma classe como um record, o compilador do Java automaticamente gera 
alguns métodos para você. Esses métodos incluem métodos de acesso para cada campo declarado na classe
*/
public record PlayerDTO(
    //Esse dto vai receber essas informações de uma requisição HTTP
    String name,
    String email,
    String phone,
    GroupType groupType
) {

}

