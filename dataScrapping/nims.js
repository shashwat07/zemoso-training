var data = document.getElementsByClassName("MsoPlainText");
var someData="";
var start,end,flagStart=true, flagEnd=true;

var regex = /([A-Z0-9]+)(\s+)([A-Z():/.&\+'\-,a-z0-9 ]+)(\s+)([0-9]+)(\s+)/;

for(var i=0;i<data.length;i++){
	var text = data[i].innerText;
	if(text.indexOf("1067")>=0 && flagStart){
		start = i;
		flagStart=false;
	}
	if(text.indexOf("ACCOMMODATION CHARGES W.E.F. 01.09.2006")>=0 && flagEnd){
		end = i;
		flagEnd=false;
	}
}

var dept = "ANAESTHESIOLOGY";
var code, desc, rate;
var finalData="DEPARTMENT#CODE#DESCRIPTION#RATE\n";

function extractData(){
	for(var i = start;i<end;i++){
		var myData = data[i].innerText;
		if(myData.indexOf("DEPARTMENT OF NEUROLOGY")>=0){
			dept="NEUROLOGY";
		}
		else if(myData.indexOf("DEPARTMENT OF")>=0){
			dept=myData.slice(14,myData.length);
		}
		else if(regex.test(myData)){
			var match = regex.exec(myData);
			code = match[1];
			desc = match[3];
			rate = match[5];
			finalData += dept + "#" + code + "#" + desc + "#" + rate + "\n";
		}
	}
	downloadCsv();
}

var csvContent = "data:text/csv;charset=utf-8,";

function downloadCsv(){
	csvContent += finalData;
	var encodedUri = encodeURI(csvContent);
	var link = document.createElement("a");
	link.setAttribute("href", encodedUri);
	link.setAttribute("download", "nims_tarrif.csv");
	document.body.appendChild(link);
	link.click();
}