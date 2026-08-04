document.getElementById("regForm").addEventListener("submit", function(event){

event.preventDefault();

let name=document.getElementById("name").value.trim();
let email=document.getElementById("email").value.trim();
let phone=document.getElementById("phone").value.trim();
let age=document.getElementById("age").value;
let department=document.getElementById("department").value;
let password=document.getElementById("password").value;
let confirm=document.getElementById("confirm").value;

let gender=document.querySelector('input[name="gender"]:checked');

let msg=document.getElementById("message");

let emailPattern=/^[^\s@]+@[^\s@]+\.[^\s@]+$/;
let phonePattern=/^[0-9]{10}$/;

if(name==""){
msg.innerHTML="Enter your name";
msg.style.color="red";
return;
}

if(!emailPattern.test(email)){
msg.innerHTML="Invalid Email";
msg.style.color="red";
return;
}

if(!phonePattern.test(phone)){
msg.innerHTML="Phone number must contain 10 digits";
msg.style.color="red";
return;
}

if(age<17 || age>30){
msg.innerHTML="Enter valid age";
msg.style.color="red";
return;
}

if(department==""){
msg.innerHTML="Select Department";
msg.style.color="red";
return;
}

if(gender==null){
msg.innerHTML="Select Gender";
msg.style.color="red";
return;
}

if(password.length<6){
msg.innerHTML="Password must be at least 6 characters";
msg.style.color="red";
return;
}

if(password!=confirm){
msg.innerHTML="Passwords do not match";
msg.style.color="red";
return;
}

msg.innerHTML="Registration Successful!";
msg.style.color="green";

document.getElementById("regForm").reset();

});
