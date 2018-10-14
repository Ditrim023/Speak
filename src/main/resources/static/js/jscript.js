function openNav() {
    document.getElementById("myList").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.getElementById("input-box").style.left = "600px";
}

function closeNav() {
    document.getElementById("myList").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.getElementById("input-box").style.left = "500px";
}

openNav();



window.onload = function(){
    var status = document.getElementsByClassName('status');
    for (var i = 0; i < status.length; i++) {
      if(status[i].innerHTML=="ONLINE"){
          status[i].style.color = "green";
      }else{
          status[i].style.color = "red";
      }
    }

}

openNav();
