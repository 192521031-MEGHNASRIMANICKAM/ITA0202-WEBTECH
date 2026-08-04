function analyzeResult(){

let name=document.getElementById("name").value;

let marks=[
Number(document.getElementById("m1").value),
Number(document.getElementById("m2").value),
Number(document.getElementById("m3").value),
Number(document.getElementById("m4").value),
Number(document.getElementById("m5").value)
];

let total=0;

for(let i=0;i<marks.length;i++){

total+=marks[i];

}

let average=total/marks.length;

let highest=Math.max(...marks);

let lowest=Math.min(...marks);

let grade="";
let result="";

if(average>=90)
grade="A+";
else if(average>=80)
grade="A";
else if(average>=70)
grade="B";
else if(average>=60)
grade="C";
else if(average>=50)
grade="D";
else
grade="F";

if(lowest>=40)
result="PASS";
else
result="FAIL";

let student={
name:name,
total:total,
average:average.toFixed(2),
highest:highest,
lowest:lowest,
grade:grade,
result:result
};

document.getElementById("student").innerHTML=student.name;
document.getElementById("total").innerHTML=student.total;
document.getElementById("average").innerHTML=student.average;
document.getElementById("highest").innerHTML=student.highest;
document.getElementById("lowest").innerHTML=student.lowest;
document.getElementById("grade").innerHTML=student.grade;
document.getElementById("result").innerHTML=student.result;

}
