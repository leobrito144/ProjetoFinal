function logar(){
    var dados = {
        email:document.getElementById("txtRacfOuEmail").value,
        racf:document.getElementById("txtRacfOuEmail").value,
        senha:document.getElementById("txtSenha").value
    }
     var pacote={
         method:"POST",
         body:JSON.stringify(dados),
         headers:{
             "Content-type":"application/json"
         }
     }
     fetch("http://localhost:8080/login",pacote).
        then(res => res.json()).
            then(res => {
                    localStorage.setItem("user",JSON.stringify(res));
                    window.location="usuario.html";
                }).
                catch(err => {
                    window.alert("ERRO");
                });
}