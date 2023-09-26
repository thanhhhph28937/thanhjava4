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
        <h3>Quen mat khau</h3>
        <br>
        <form method="POST" action="quenmk">
            <div class="mb-3">
                <label class="form-label">Email:</label>
                <input name="email" type="text" class="form-control" required placeholder="Email?"/>
            </div>


             <div><a href="quenmk">Quen mat khau</a></div>

            <div>
                <span id="error" style="color:red">${mes}</span>
            </div>
            <br>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary" onsubmit="return check()">Lay lai mat khau</button>
            </div>
        </form>
        <p class="text-center"><a href="login">Login</a></p>

    </div>
</div>
<script>
    function check(){
    let em1=document.getElementsByTagName('input')[0].value;
    let reg=/^\w+@[a-zA-Z]+.[a-zA-Z]+(.[a-zA-Z]+)?(.[a-zA-Z]+)?$/;
    if(!em1.match(reg)){
        alert("Email sai định dạng!!!");
        return false;
    }

     return true;
    }

</script>

