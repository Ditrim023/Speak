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

setInterval((function(){
    $.getJSON('http://localhost:8080/json/1room', function(data) {
        $.each(data,function (key,value) {
            var test=
                '<p>'+value.text+'--'+
                value.author+'</p>'+ '<br>'


        })
        console.log(data.length);
    });
}),5000);

// window.onload = function(){
//     var  dataJson = '[{\n' +
//         '  "author": "user0",\n' +
//         '  "text": "cxcxcx"\n' +
//         '},{\n' +
//         '"author": "RudeBot",\n' +
//         '"text": "freak"\n' +
//         '},{\n' +
//         '"author": "RudeBot",\n' +
//         '"text": "idiot"\n' +
//         '}]';
//     function foo() {
//         var ourData = JSON.parse(dataJson);
//         console.log(ourData.length);
//     }
//     setInterval(foo, 5000);
// };
//----------------------------------------------------------------------------

