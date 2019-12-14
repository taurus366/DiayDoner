fetch('http://localhost:8081/Duner/rest/articles',{mode:'cors'})
.then(response => response.json())
.then((data)=> {
  data.forEach(function(i){
  console.log(i);
 

  var test = document.getElementById('select');
  var option = document.createElement("option");
  option.innerHTML = '<option>' + i.title + " " +i.price+"лв" + '</option>';
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

function checkCookie() {
    var cookieName = getCookie("myStrCookie");
    if (cookieName != ""){
        return true;
    }else {
        alert("Моля първо добавете храна в Кошницата и след това може да посетите Кошницата!");
        return false;
    }
}

// function clean(gap) {
//     gap.value = ""
//     gap.placeholder = ""
//     }


    // if value doesn't work!
//   function test(index) {
//      var test = document.getElementById('test3'); 
//      var test4 = document.createElement("test4");  
//       test4.innerHTML = index.options[index.selectedIndex].text
//       test.appendChild(test4);
//     }


 /** <div class="img" ></div>
            <p class="choosedItem">СНИМКА НА ИЗБРАНИЯ ПРОДУКТ</p>
            <img  class="image" src="https://fastfoodchocho.com/wp-content/uploads/elementor/thumbs/436436-c380d62928f0df060ae67406145e2ea5-nw9cs51fxnaop6hj35ofx1mer0olyw3kuyxgokks8w.png" alt="" ></img>
        </div>
        **/


       fetch('http://localhost:8081/Duner/rest/cart')
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

       function thankyouMessage(){
           alert("ПОРЪЧКАТА Е ПОЛУЧЕНA , БЛАГОДАРИМ ВИ!");
       }

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
