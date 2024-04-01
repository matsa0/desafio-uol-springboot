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
        console.log(error)
    })

}