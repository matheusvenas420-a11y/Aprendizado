function cadastrar() {
    const nome = document.getElementById("nome").value;
    const valor = document.getElementById("valor").value;
    const prazo = document.getElementById("prazo").value;
    const tipo = document.getElementById("tipo").value;

    fetch("http://localhost:8080/ordens", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nome: nome,
            valor: valor,
            prazo: prazo,
            tipo_servico: tipo
        })
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
    })
    .catch(err => {
        console.error(err);
        alert("Erro ao conectar com o servidor");
    });
}