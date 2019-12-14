function UserAction(id,name) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             alert(this.responseText);
         }
    };
    xhttp.open("DELETE", "localhost:8081/Duner/rest/delete/cart", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(id);
}

function deleteData(item) {
    return fetch("localhost:8081/Duner/rest/delete/cart" + '/' + item, {
      method: 'delete'
    })
    .then(response => response.json());
  }