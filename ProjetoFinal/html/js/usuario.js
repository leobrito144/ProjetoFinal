function carregarUsuario(){

    var usuarioLogado = localStorage.getItem("user");
    if(!usuarioLogado){
        window.location="index.html";
    }else{
        var usuarioJson = JSON.parse(usuarioLogado);
        document.getElementById("dados").innerHTML=

        "<h5 id='nomeUsuario'>" + usuarioJson.nome + "<br>" +
        usuarioJson.email + "<br>" + 
        usuarioJson.racf + "<br></h5>";
    
    }
}

function periodo(){
    var periodo = document.getElementById("periodo").value;
    if(periodo == 1){
        window.location="relatorios.html";
    }else if (periodo == 2){
        window.location="relatorios2.html";
    }else{
        window.alert("Selecione uma opção!!");
    }

}