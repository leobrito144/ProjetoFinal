function popularTabela(lista){
    var strItaumon =
        "<div class='row d-flex justify-content-center'><div class ='col-12'>" +
        "<table border='1' cellpadding=5 width ='100% align='center'>"+
        "<tr>"+
        "<td style='text-align: center;'>Id do Alarme</td><td style='text-align: center;'>Quantidade</td>"+
        "</tr>";
        
        for(count=0;count<lista.length;count++){
            strItaumon += 
                "<tr>" +
                "<td>" + lista[count].alarme + "</td>" +
                "<td>" + lista[count].qtde + "</td>" +
                "</tr>";
        }

        strItaumon += "</table></div></div>";
        document.getElementById("itaumon").innerHTML = strItaumon;
}

function carregarItaumon(){
    var dados = {
        inicio:document.getElementById("txtInicio").value,
        fim:document.getElementById("txtFim").value,
    }
     var pacote={
         method:"POST",
         body:JSON.stringify(dados),
         headers:{
             "Content-type":"application/json"
         }
    }
    var usuario = localStorage.getItem("user");
    if(!usuario){
        window.location="index.html"
    }else{
        fetch("http://localhost:8080/alarme/totaldata",pacote).
        then(res => res.json()).
            then(res => 
                popularTabela(res));
        }
}