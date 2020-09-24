
function validateform(){

var email=document.getElementById("validemail");

var password=document.getElementById("validpass");

if(email=="" || email==null){
document.getElementById("validemail").style.display="visible";
return false;
}

if(password=="" || password==null){
document.getElementById("validpass").style.display="visible";
return false;
}




}