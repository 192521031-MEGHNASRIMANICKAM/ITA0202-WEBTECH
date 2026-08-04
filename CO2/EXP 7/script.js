const questions=[

{answer:"a"},
{answer:"b"},
{answer:"b"},
{answer:"b"},
{answer:"c"}

];

function checkScore(){

let score=0;

for(let i=1;i<=questions.length;i++){

let answer=document.querySelector('input[name="q'+i+'"]:checked');

if(answer!=null){

if(answer.value==questions[i-1].answer){

score++;

}

}

}

let result=document.getElementById("result");

let message="";

if(score>=4){

message="PASS";

}else{

message="FAIL";

}

result.innerHTML="Score : "+score+" / "+questions.length+"<br>"+message;

}
