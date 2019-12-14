var url = 'https://cors-anywhere.herokuapp.com/';
var myurl = 'http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/rest/articles'
fetch(url + myurl,{mode:'cors'})
.then(response => response.json())
.then((data)=> {
  data.forEach(function(i){
  console.log(i);
 

  var test = document.getElementById('select');
  var option = document.createElement("option");
  option.innerHTML = '<option>' + i.title + " " +(i.price) +"лв" + '</option>';
  option.value = i.Id;
  test.appendChild(option);
   



    
   /** tr.innerHTML = '<td>' + i.title + '</td>' +
        '<td>' + '<textarea readonly id="" cols="45" rows="10">'+i.id +'</textarea>' + '</td>' +
        '<td valign="top" >' + i.Title + '</td>' +
		'<td>' + '<img src="'+i.price+'" alt="" border=0 height=120 width=180></img>' +'</th>'+
		'<td>'+'<button type="button">ADD to Cart</button>'+
		'<button type="button">Remove from Cart</button>'+ '</th>';
		'<td>' +'<textarea readonly id="" cols="45" rows="10">afsasfas</textarea>' +'</th>'
		
    table.appendChild(tr);
    **/
    
});

})

function required(select) {
    select.style.borderColor = "white";
    select.style.color = "black";
if(select.value == "Меню"){
   alert("Моля Изберете от Меню, където е червено");
   select.style.borderColor = "red";
   select.style.color = "red";
   return false;
}  
}

function thankyouMessage(){
    alert("ПОРЪЧКАТА Е ПОЛУЧЕНA , БЛАГОДАРИМ ВИ!");
}