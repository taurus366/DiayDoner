
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
