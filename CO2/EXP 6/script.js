let tasks=[];

function addTask(){

let input=document.getElementById("taskInput");
let text=input.value.trim();

if(text==""){

alert("Enter a Task");
return;

}

tasks.push({name:text,completed:false});

input.value="";

displayTasks();

}

function displayTasks(){

let list=document.getElementById("taskList");

list.innerHTML="";

for(let i=0;i<tasks.length;i++){

let li=document.createElement("li");

let span=document.createElement("span");

span.innerHTML=tasks[i].name;

span.className="task";

if(tasks[i].completed){

span.classList.add("completed");

}

li.appendChild(span);

let actions=document.createElement("div");

actions.className="actions";

let completeBtn=document.createElement("button");

completeBtn.innerHTML="✔";

completeBtn.onclick=function(){

tasks[i].completed=!tasks[i].completed;
displayTasks();

};

let editBtn=document.createElement("button");

editBtn.innerHTML="Edit";

editBtn.onclick=function(){

let newTask=prompt("Edit Task",tasks[i].name);

if(newTask!=null && newTask!=""){

tasks[i].name=newTask;

displayTasks();

}

};

let deleteBtn=document.createElement("button");

deleteBtn.innerHTML="Delete";

deleteBtn.onclick=function(){

tasks.splice(i,1);

displayTasks();

};

actions.appendChild(completeBtn);
actions.appendChild(editBtn);
actions.appendChild(deleteBtn);

li.appendChild(actions);

list.appendChild(li);

}

}
