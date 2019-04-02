// var ourRequest = new XMLHttpRequest();
// // ourRequest.open('GET','https://learnwebcode.github.io/json-example/animals-1.json');
// // ourRequest.open('GET','http://localhost:8080/main/hello');
// ourRequest.open('GET','http://localhost:8080/json/1room');
// ourRequest.onload = function(){
//     var ourData = JSON.parse(ourRequest.responseText);
//     console.log(ourData.length);
// };
// ourRequest.send();
// // ourRequest.open('GET','1room.json');

// setInterval((function(){
//     $.getJSON('http://localhost:8080/json/1room', function(data) {
//         $.each(data,function (key,value) {
//             var test=
//                 '<p>'+value.text+'--'+
//                 value.author+'</p>'+ '<br>'
//
//
//         })
//         console.log(data.length);
//     });
// }),5000);
//---------------------------------------------------------------------

setInterval((function () {
    var id = document.getElementById('idRoom').value;
   $.getJSON('http://localhost:8080/json/'+id, function (data) {
        var countElemFromJson = data.length;
        var countElemFromPage = document.getElementById('out').getElementsByTagName('tr').length;
        if (countElemFromJson != countElemFromPage) {
            var diff = countElemFromJson - countElemFromPage;
            var result = data.slice(-diff);
            $.each(result, function (key, value) {
                $('#out').append('<tr>'+'<td>'+'<a>' + value.author +'</a>'+ ': ' +'<span>'+ value.text + '</span>'+'</td>'+'</tr>'+'<br>');
            })
        }

    }
   );
}), 4000);
//----------------------------------------------------------------------

