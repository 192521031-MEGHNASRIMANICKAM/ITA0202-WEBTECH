function updateClock(){

let now=new Date();

let h=String(now.getHours()).padStart(2,'0');
let m=String(now.getMinutes()).padStart(2,'0');
let s=String(now.getSeconds()).padStart(2,'0');

document.getElementById("clock").innerHTML=h+":"+m+":"+s;

}

function updateCountdown(){

// Change this date to your exam date
let examDate=new Date("December 15, 2026 09:00:00").getTime();

let now=new Date().getTime();

let distance=examDate-now;

if(distance<0){

document.getElementById("countdown").innerHTML="Exam Started!";
return;

}

let days=Math.floor(distance/(1000*60*60*24));

let hours=Math.floor((distance%(1000*60*60*24))/(1000*60*60));

let minutes=Math.floor((distance%(1000*60*60))/(1000*60));

let seconds=Math.floor((distance%(1000*60))/1000);

document.getElementById("countdown").innerHTML=
days+" Days "+
hours+" Hours "+
minutes+" Minutes "+
seconds+" Seconds";

}

setInterval(function(){

updateClock();
updateCountdown();

},1000);

updateClock();
updateCountdown();
