var obj = JSON.parse(data);
var food = obj.food;

window.onload = function loadMenu(){
	var txt="";
	for(var index=0; index<food.length; index++){
		var name = food[index].name;
		var price = food[index].price;
		var id = "food" + food[index].id;

		txt+='<div id="' + id + '" class="item" draggable="true" ondragstart="drag(event)"><h5>' + name + '</h5>Rs. ' + price +  '</div>';
	}
	document.getElementById('items').innerHTML = txt;	
}

function allowDrop(ev) {
    ev.preventDefault();
    ev.dataTransfer.dropEffect = "copy";
}

function drag(ev) {
	ev.dataTransfer.dropEffect = "copy";
    ev.dataTransfer.setData("text", ev.target.id);

}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));

    var id = ev.id;
    alert(id);
}

