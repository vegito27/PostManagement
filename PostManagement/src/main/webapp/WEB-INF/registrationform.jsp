<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
    <style>
    .register{
    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
    margin-top: 3%;
    padding: 3%;
}

.register-left{
    text-align: center;
    color: #fff;
    margin-top: 4%;
}

.register-left a{
    border: none;
    border-radius: 1.5rem;
    padding: 2% 10% 3% 10%;
    width: 60%;
    background: #f8f9fa;
    font-weight: bold;
    color: #383d41;
    margin-top: 30%;
    margin-bottom: 3%;
    cursor: pointer;
}

.register-right{
    background: #f8f9fa;
    border-top-left-radius: 10% 50%;
    border-bottom-left-radius: 10% 50%;
}

.register-left img{
    margin-top: 15%;
    margin-bottom: 5%;
    width: 25%;
    -webkit-animation: mover 2s infinite  alternate;
    animation: mover 1s infinite  alternate;
}
@-webkit-keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
@keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
.register-left p{
    font-weight: lighter;
    padding: 12%;
    margin-top: -9%;
}
.register .register-form{
    padding: 10%;
    margin-top: 10%;
}
.btnRegister{
    float: right;
    margin-top: 10%;
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    background: #0062cc;
    color: #fff;
    font-weight: 600;
    width: 50%;
    cursor: pointer;
}
.register .nav-tabs{
    margin-top: 3%;
    border: none;
    background: #0062cc;
    border-radius: 1.5rem;
    width: 28%;
    float: right;
}
.register .nav-tabs .nav-link{
    padding: 2%;
    height: 34px;
    font-weight: 600;
    color: #fff;
    border-top-right-radius: 1.5rem;
    border-bottom-right-radius: 1.5rem;
}
.register .nav-tabs .nav-link:hover{
    border: none;
}
.register .nav-tabs .nav-link.active{
    width: 100px;
    color: #0062cc;
    border: 2px solid #0062cc;
    border-top-left-radius: 1.5rem;
    border-bottom-left-radius: 1.5rem;
}
.register-heading{
    text-align: center;
    margin-top: 8%;
    margin-bottom: -15%;
    color: #495057;
}
</style>


</head>

<body >

 <form  action="register.do" method="POST" onsubmit="return validateDetails()"  >

<div class="container register">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3>Welcome</h3>
            <p>Now you can see you upcoming posts!</p>
            <a href="login.do" name="login">Login</a><br/>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Register here!</h3>
                    <div class="row register-form">


                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" id="firstname" class="form-control" onfocus="hide('redname')" name="firstname" placeholder="First Name *" value="" />
                                <span id="redname" style="color:red;display:none;">please enter your name***</span>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="lastname" placeholder="Last Name *" value="" />
                            </div>

                            <div class="form-group">
                                <input type="email" id="emailid" class="form-control" name="email" onfocus="hide('redemail')" placeholder="Your Email *" value="" />
                                <span  id="redemail" style="color:red;display:none">Please enter the valid email**</span>
                            </div>

                            <div class="form-group">
                                <input type="password" id="password" class="form-control" name="password" onfocus="hide('redpass')" placeholder="Password *" value="" />
                                <span  id="redpass" style="color:red;display:none">Please enter the valid password**</span>
                            </div>
                            <div class="form-group">
                                <input type="password" id="confirmpassword" class="form-control" name="confirmpassword" onfocus="hide('redconfirmpassword')" placeholder="Confirm Password *" value="" />
                                <span  id="redconfirmpassword" style="color:red;display:none">Please enter the confirm password**</span>

                            </div>
                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <input type="radio" name="gender" value="male" checked>
                                        <span> Male </span>
                                    </label>
                                    <label class="radio inline">
                                        <input type="radio" name="gender" value="female">
                                        <span>Female </span>
                                    </label>
                                    <label class="radio inline">
                                        <input type="radio" name="gender" value="female">
                                        <span>Others </span>
                                    </label>
                                </div>
                            </div>
                        </div>


                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" id="mobile" minlength="10" maxlength="10"  onfocus="hide('redmobile')"name="mobile" class="form-control" placeholder="Your Phone *" value="" />
                           <span id="redmobile" style="color:red;display:none">Please enter the valid mobile no.**</span>
                            </div>
                            <div class="form-group">
                                    <input type="text"  name="address" class="form-control" placeholder="Your Address **" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text"  name="city" class="form-control" placeholder="Your City *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text"  maxlength="8" name="pincode" class="form-control" placeholder="Pincode *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text"  name="state" class="form-control" placeholder="Your state *" value="" />
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="country">
                                    <option class="hidden"  selected disabled>Please select your Country</option>
                                    <option>India</option>
                                    <option>China</option>
                                    <option>USA</option>
                                    <option>Nepal</option>
                                    <option>Bhutan</option>
                                    <option>SriLanka</option>
                                    <option>UK</option>
                                    <option>Germany</option>
                                    <option>SouthAfrica</option>
                                </select>
                            </div>

                            <input type="submit" class="btnRegister"  value="Register"/>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div></form>

</body>
<script>


function hide(id){
document.getElementById(id).style.display="none"
}

function display(id){
document.getElementById(id).style.display="block"
}

function validateDetails() {

 var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

 var email=document.getElementById("emailid").value;

 var mobile=document.getElementById("mobile").value;

 var firstname=document.getElementById("firstname").value;

var password=document.getElementById("password").value;

var confirmpassword=document.getElementById("confirmpassword").value;

var isvalid=true;

if(firstname=="" || firstname==null){
   document.getElementById("redname").style.display="block"
   isvalid=false
 }
if (email.match(mailformat)==false ) {
     document.getElementById("redemail").style.display="block";
      isvalid=false
           }

    if (email==null || email=="") {
 document.getElementById("redemail").style.display="block";
      isvalid=false
           }

if(mobile=="" || mobile==null){
document.getElementById("redmobile").style.display="block";
 isvalid=false
 }

if(password=="" || password==null){
document.getElementById("redpass").style.display="block";
 isvalid=false
 }

if(confirmpassword=="" || confirmpassword==null){
 document.getElementById("redconfirmpassword").style.display="block";
  isvalid=false
  }

if(password==confirmpassword && isvalid==true){
return true;
}

else if(password!=confirmpassword && isvalid==true){

document.getElementById("redconfirmpassword").style.display="block";

return false;

     }else{

     return false;
     }
     return true;
   }


</script>


</html>>