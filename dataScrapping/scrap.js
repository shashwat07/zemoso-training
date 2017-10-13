var link = document.getElementById('DownloadLink');
var data = document.getElementsByClassName("MsoPlainText");
var CSV,flag = true, currentDepartment,main_data = [];


function DataExtractor(){
	var i = 0;
	while(flag){
		getData(data[i++].innerText);
	}
}

function getData(string){
	var str="";
	var regex = /\S+\s\S+\s\d+/;
	for(var i=0;i<string.length;i++){
		if(string[i]=='\xa0'){
			continue;
		}
		else{
			str+=string[i];
		}
	}
	if(str.indexOf("DEPARTMENT") >= 0){
		currentDepartment = str;
	}
	if(str.indexOf("DEPARTMENT OF NEUROLOGY") >= 0){
		currentDepartment = "DEPARTMENT OF NEUROLOGY";
	}

	if(str == "ACCOMMODATION CHARGES W.E.F. 01.09.2006"){
		flag = false;
	}
    else if(regex.test(str)){
    	str = str.split(" ");
    	var temp_string='';
    	if(str[str.length-1] == "" ){
    		for(var i=1;i<str.length-2;i++){
    			temp_string+=str[i] + " ";
    		}
    		var new_data = { "Department":currentDepartment,"Code" :str[0],"Description": temp_string, "Rate":str[str.length-2] };
    	}
    	else if (str[str.length-1] == " "){
    		for(var i=1;i<str.length-2;i++){
    			temp_string+=str[i] + " ";
    		}
    		var new_data = { "Department":currentDepartment,"Code" :str[0],"Description": temp_string, "Rate":str[str.length-2] };
    	}
    	else {
    		for(var i=1;i<str.length-1;i++){
    			temp_string+=str[i] + " ";
    		}
    		var new_data = { "Department":currentDepartment,"Code" :str[0],"Description": temp_string, "Rate":str[str.length-1] };
    	}
    	
    	
    	main_data.push(new_data);
    }
}

function toCsv(objArray, sDelimiter, cDelimiter) {
	var i, l, names = [], name, value, obj, row, output = "", n, nl;

	if (typeof (sDelimiter) === "undefined" || sDelimiter === null) {
		sDelimiter = '"';
	}
	if (typeof (cDelimiter) === "undefined" || cDelimiter === null) {
		cDelimiter = ",";
	}

	for (i = 0, l = objArray.length; i < l; i += 1) {
		obj = objArray[i];
		row = "";
		if (i === 0) {
			for (name in obj) {
				if (obj.hasOwnProperty(name)) {
					names.push(name);
					row += [sDelimiter, name, sDelimiter, cDelimiter].join("");
				}
			}
			row = row.substring(0, row.length - 1);
			output += row;
		}

		output += "\n";
		row = "";
		for (n = 0, nl = names.length; n < nl; n += 1) {
			name = names[n];
			value = obj[name];
			if (n > 0) {
				row += ","
			}
			row += toCsvValue(value, '"');
		}
		output += row;
	}

	return output;
}

function toCsvValue(theValue, sDelimiter) {
	var t = typeof (theValue), output;

	if (typeof (sDelimiter) === "undefined" || sDelimiter === null) {
		sDelimiter = '"';
	}
	if (t === "undefined" || t === null) {
		output = "";
	} else if (t === "string") {
		output = sDelimiter + theValue + sDelimiter;
	} else {
		output = String(theValue);
	}

	return output;
}

function CSVDownloader( CSV ){
	if (CSV == '') {        
        alert("Invalid data");
        return;
    }

    var fileName = 'HospitalData';   
    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);
    link.href = uri;
    link.download = fileName + ".csv";
}

function myFunction (){
	DataExtractor();
	CSV = toCsv(main_data);
	CSVDownloader(CSV);
}
