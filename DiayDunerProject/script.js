fetch('http://localhost:8081/Duner/rest/cart',{credentials:'include'})
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
   
});

})