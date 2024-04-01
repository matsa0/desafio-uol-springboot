document.getElementById("register-btn").addEventListener("click", function() {

    const name = document.getElementById("input-name").value
    const email = document.getElementById("input-email").value
    const phone = document.getElementById("input-phone").value
    
    const groupTypeAvengers = document.getElementById("input-avengers")
    const groupTypeJLeague = document.getElementById("input-jLeague")

    let groupType
    if(groupTypeAvengers.checked) {
        groupType = "AVENGERS"
    }
    else if(groupTypeJLeague.checked) {
        groupType = "JUSTICE_LEAGUE"
    }

    const data = {
        name: name,
        email: email,
        phone: phone,
        groupType: groupType
    }

    register(data)
})

document.getElementById("show-players-btn").addEventListener("click", function() {
    document.getElementById("show-players").style.display = "block"
    showPlayers()
})

const url = "http://localhost:8080/players"
function register(data) {

    //fetch() é uma função que permite fazer requisições de recursos de rede(requisições HTTP em torno de promises)
    //.then() e .catch() para lidar com a resposta ou quaisquer erros que possam ocorrer durante a requisição.
    fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': "application/json"
        },
        body: JSON.stringify(data) //corpo da requisição convertido para JSON
    })
    .then(response => {
        return response.json()
    })
    .then(data => {
        console.log(data)
    })
    .catch(error => {
        console.log("POST ERROR > ", error)
    })
}

function showPlayers() {
    fetch(url, {
        method: "GET",
        headers: {
            'Content-Type': "application/json"
        }
    })
    .then(response => {
        return response.json()
    })
    .then(players => {
        const tableBody = document.querySelector('#show-players tbody') //selecionando o elemento tbody na table de id #show-players(elemento pai)

        tableBody.innerHTML = "" //limpa o tbody toda vez para não haver repetições

        players.forEach(player => {
            const tableRow = document.createElement("tr") //cria o elemento tr no tbody

            //innerHTML é uma propriedade do DOM que representa o conteúdo HTML do elemento(você pode obter ou modificar o conteúdo com esta propriedade)
            tableRow.innerHTML = 
            `
                <td>${player.name}</td>
                <td>${player.email}</td>
                <td>${player.phone}</td>
                <td>${player.codename}</td>
                <td>${player.groupType}</td>
            `

            //adicionando a linha à tabela(elemento filho)
            tableBody.appendChild(tableRow)

        });
    })
    .catch(error => {
        console.log("GET ERROR > ", error)
    })
}