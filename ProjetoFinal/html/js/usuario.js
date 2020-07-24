function carregarUsuario(){

    var usuarioLogado = localStorage.getItem("user");
    if(!usuarioLogado){
        window.location="index.html";
    }else{
        var usuarioJson = JSON.parse(usuarioLogado);
        document.getElementById("dados").innerHTML=

        "<h5 id='nomeUsuario'>" + usuarioJson.nome + "</h5>" +
        "<h5>" + usuarioJson.email + "<br>" + 
        "Código: " + usuarioJson.racf + "<br></h5>";
    
    }
}