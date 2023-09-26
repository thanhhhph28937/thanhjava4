<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .bg-login {
        position: relative;
        width: 100%;
        min-height: auto;
        background-position: right 0px top 0px;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
    }

    .login-form {
        border: 1px solid #DDD;
        border-radius: 4px;
        max-width: 400px;
        padding: 20px;
        margin-top: 100px;
        margin-left: auto;
        margin-right: auto;
    }

</style>
<div class="bg-login">
    <div class="login-form">
        <h3>Sign up</h3>
        <br>
        <form method="POST" action="logout">
            <div class="mb-3">
                <label class="form-label">Id:</label>
                <input name="id" type="text" class="form-control" required placeholder="id?"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Name:</label>
                <input name="fullname" type="text" class="form-control" required placeholder="name?"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Password:</label>
                <input name="password"  class="form-control" required placeholder="password?"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Email:</label>
                <input name="email"  class="form-control"  required placeholder="email?"/>
            </div>
            <div>
                <span id="error" style="color:#ff0000">${mes}</span>
            </div>
            <br>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary" onsubmit="return check()">Sign up</button>
            </div>
        </form>
        <p class="text-center"><a href="login">Login</a></p>
    </div>
</div>
<script>
    function check(){
    let email=document.getElementsByTagName('input')[3].value;
    let reg=/^\w+@[a-zA-Z]+.[a-zA-Z]+(.[a-zA-Z]+)?(.[a-zA-Z]+)?$/;
    if(!email.match(reg)){
        alert('Email sai định dạng!!!');
        return false;
    }
    return true;
    }
</script>

