var data = document.getElementsByClassName("MsoPlainText");
var re = /([A-Z0-9]{3,6})([ b-s&;]*)([A-Z ]*)([b-s&; \n]*)([0-9]*)/g;
var index=11;
while(index<50){
	var patt = data[index].innerHTML;
	var res = re.exec(patt);
	if(res!=null){
		console.log(res[1]);
		console.log(res[2]);
		console.log(res[3]);
		console.log(res[4]);
		console.log(res[5]);		
	}
	index++;
}
/*
function paint(index){
	while(){

	}
}*/