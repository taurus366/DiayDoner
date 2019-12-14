const url = "https://cors-anywhere.herokuapp.com/";
const myurl = "http://test-env.atf4k3jipr.us-east-2.elasticbeanstalk.com/rest/cart";
fetch("https://cors-anywhere.herokuapp.com/http://test-env.atf4k3jipr.us-east-2.elasticbeanstalk.com/rest/cart",{credentials:'include',header:('Access-Control-Allow-Origin', "ali") })
.then(response => response.json())
.then((data)=> {
    
 var table = document.getElementById('table_cart');
  data.forEach(function(i){
  console.log(i);

 var tr = document.createElement('tr');

    tr.innerHTML = 
    '<td>' + i.product_name + '</td>' +
    '<td>' + '<textarea readonly id="" cols="40" rows="3">'+i.ketchup + i.mayonnaise + i.chili + i.spotted_salt +'</textarea>' + '</td>' +
    '<td>' + i.price + '</td>' +
    '<td>'+ '<button value="'+ i.article_id +'"type="submit" name="button">Изтрий</button>'+ '</td>';
        

    table.appendChild(tr);
   
}).catch((err) => {
    console.log(err);
});

})

function deletedMessage(){
    alert("АРТИКУЛЪТ БЕШЕ ИЗТРИТ ОТ ВАШАТА КОШНИЦА!");
}

function ready(){
    if(confirm("СИГУРНИ ЛИ СТЕ, ЧЕ ИСКАТЕ ДА ИЗТРИЕТЕ АРТИКУЛА ОТ КОШНИЦАТА?")){
     deletedMessage();
        return true;
        
    }else {
        return false;
    }

}

let allowCrossDomain = function(req, res, next) {
    res.header('Access-Control-Allow-Origin', "*");
    res.header('Access-Control-Allow-Headers', "*");
    next();
  }
  app.use(allowCrossDomain);