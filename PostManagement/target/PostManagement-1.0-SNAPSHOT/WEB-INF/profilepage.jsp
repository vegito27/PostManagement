<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container emp-profile">
    <form action="list.do">
        <div class="row">

            <div class="col-md-4">

                <a href="#" class="intro-banner-vdo-play-btn pinkBg" target="_blank">
                    <i class="glyphicon glyphicon-play whiteText" aria-hidden="true"></i>
                    <span class="ripple pinkBg"></span>
                    <span class="ripple pinkBg"></span>
                    <span class="ripple pinkBg"></span>
                </a>
            </div>

            <div class="col-md-6">
                <div class="profile-head">
                    <h5>
                        ${firstname}&nbsp${lastname}
                    </h5>
                    <h6>

                    </h6>
                    <p class="proile-rating">TOTAL POSTS : <span>${postcount}</span></p>
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-l-2">
               <button type="submit" class="btn btn-danger"><b>Back To Users</b></button>&nbsp
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div class="profile-work">
                </div>
            </div>


            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>User Id</label>
                            </div>
                            <div class="col-md-6">
                                <p>${id}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Name</label>
                            </div>
                            <div class="col-md-6">
                                <p>${firstname}&nbsp${lastname}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email</label>
                            </div>
                            <div class="col-md-6">
                                <p>${email}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Mobile</label>
                            </div>
                            <div class="col-md-6">
                                <p>${mobile}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Gender</label>
                            </div>
                            <div class="col-md-6">
                                <p>${gender}</p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label>Address</label>
                            </div>
                            <div class="col-md-6">
                                <p>${address}&nbsp${city}-${pincode}</p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label>State</label>
                            </div>
                            <div class="col-md-6">
                                <p>${state}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Country</label>
                            </div>
                            <div class="col-md-6">
                                <p>${country}</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>


        </div>
    </form>
</div>





<style>
.pinkBg {
    text-align:center;
    background:pink!important;
    background-image: linear-gradient(90deg, #fd5581, #fd8b55);
}
.intro-banner-vdo-play-btn{
    height:60px;
    width:60px;
    position:absolute;
    top:50%;
    left:50%;
    text-align:center;
    margin:-30px 0 0 -30px;
    border-radius:100px;
    z-index:1;
    margin-top:40%;
}
.intro-banner-vdo-play-btn i{
    line-height:56px;
    font-size:30px
}
.intro-banner-vdo-play-btn .ripple{
    position:absolute;
    width:160px;
    height:160px;
    z-index:-1;
    left:50%;
    top:50%;
    opacity:0;
    margin:-80px 0 0 -80px;
    border-radius:100px;
    -webkit-animation:ripple 1.8s infinite;
    animation:ripple 1.8s infinite
}

@-webkit-keyframes ripple{
    0%{
        opacity:1;
        -webkit-transform:scale(0);
        transform:scale(0)
    }
    100%{
        opacity:0;
        -webkit-transform:scale(1);
        transform:scale(1)
    }
}
@keyframes ripple{
    0%{
        opacity:1;
        -webkit-transform:scale(0);
        transform:scale(0)
    }
    100%{
        opacity:0;
        -webkit-transform:scale(1);
        transform:scale(1)
    }
}
.intro-banner-vdo-play-btn .ripple:nth-child(2){
    animation-delay:.3s;
    -webkit-animation-delay:.3s
}
.intro-banner-vdo-play-btn .ripple:nth-child(3){
    animation-delay:.6s;
    -webkit-animation-delay:.6s
}




<!--img {-->
<!--    max-width: 100%;-->
<!--    height: auto;-->
<!--}-->


<!--.upload-button {-->
<!--  font-size: 1.2em;-->
<!--}-->

<!--.upload-button:hover {-->
<!--  transition: all .3s cubic-bezier(.175, .885, .32, 1.275);-->
<!--  color: #999;-->
<!--}-->

<!--.p-image:hover {-->
<!--  transition: all .3s cubic-bezier(.175, .885, .32, 1.275);-->
<!--}-->

<!--.p-image {-->
<!--  position: absolute;-->
<!--  top: 167px;-->
<!--  right: 30px;-->
<!--  color: #666666;-->
<!--  transition: all .3s cubic-bezier(.175, .885, .32, 1.275);-->
<!--}-->


<!--.profile-pic {-->
<!--    max-width: 200px;-->
<!--    max-height: 200px;-->
<!--    display: block;-->
<!--}-->


<!--.circle {-->
<!--    border-radius: 1000px !important;-->
<!--    overflow: hidden;-->
<!--    width: 128px;-->
<!--    height: 128px;-->
<!--    border: 8px solid rgba(255, 255, 255, 0.7);-->
<!--    position: absolute;-->
<!--    top: 72px;-->
<!--}-->


body{
background: -webkit-linear-gradient(left, #3931af, #00c6ff);
}
.emp-profile{
padding: 3%;
margin-top: 3%;
margin-bottom: 3%;
border-radius: 0.5rem;
background: #fff;
}
.profile-img{
text-align: center;
}
.profile-img img{
width: 70%;
height: 100%;
}
.profile-img .file {
position: relative;
overflow: hidden;
margin-top: -20%;
width: 70%;
border: none;
border-radius: 0;
font-size: 15px;
background: #212529b8;
}
.profile-img .file input {
position: absolute;
opacity: 0;
right: 0;
top: 0;
}
.profile-head h5{
color: #333;
}
.profile-head h6{
color: #0062cc;
}
.profile-edit-btn{
border: none;
border-radius: 1.5rem;
width: 70%;
padding: 2%;
font-weight: 600;
color: #6c757d;
cursor: pointer;
}
.proile-rating{
font-size: 12px;
color: #818182;
margin-top: 5%;
}
.proile-rating span{
color: #495057;
font-size: 15px;
font-weight: 600;
}
.profile-head .nav-tabs{
margin-bottom:5%;
}
.profile-head .nav-tabs .nav-link{
font-weight:600;
border: none;
}
.profile-head .nav-tabs .nav-link.active{
border: none;
border-bottom:2px solid #0062cc;
}
.profile-work{
padding: 14%;
margin-top: -15%;
}
.profile-work p{
font-size: 12px;
color: #818182;
font-weight: 600;
margin-top: 10%;
}
.profile-work a{
text-decoration: none;
color: #495057;
font-weight: 600;
font-size: 14px;
}
.profile-work ul{
list-style: none;
}
.profile-tab label{
font-weight: 600;
}
.profile-tab p{
font-weight: 600;
color: #0062cc;
}
    </style>


<script>
$(document).ready(function() {


    var readURL = function(input) {

        if (input.files && input.files[0]) {

            var reader = new FileReader();

            reader.onload = function (e) {

                $('.profile-pic').attr('src', e.target.result);

            }

            reader.readAsDataURL(input.files[0]);

        }
    }

    $(".file-upload").on('change', function(){

        readURL(this);

    });


    $(".upload-button").on('click', function() {

       $(".file-upload").click();

    });
});



</script>