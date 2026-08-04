let display=document.getElementById("display");

function append(value){

display.value+=value;

}

function clearDisplay(){

display.value="";

}

function deleteLast(){

display.value=display.value.slice(0,-1);

}

function calculate(){

try{

display.value=eval(display.value);

}

catch{

display.value="Error";

}

}

function sqrt(){

display.value=Math.sqrt(Number(display.value));

}

function square(){

display.value=Math.pow(Number(display.value),2);

}

function power(){

let x=prompt("Enter Base");
let y=prompt("Enter Exponent");

display.value=Math.pow(Number(x),Number(y));

}

function sin(){

display.value=Math.sin(Number(display.value)*Math.PI/180);

}

function cos(){

display.value=Math.cos(Number(display.value)*Math.PI/180);

}

function tan(){

display.value=Math.tan(Number(display.value)*Math.PI/180);

}

function log(){

display.value=Math.log10(Number(display.value));

}

function pi(){

display.value=Math.PI;

}

function e(){

display.value=Math.E;

}
