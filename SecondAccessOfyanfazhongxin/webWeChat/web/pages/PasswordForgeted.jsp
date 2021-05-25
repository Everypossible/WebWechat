<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        body{
          background-color: rgba(185,225,250,0.1);
        }
        .panel_top{
          font-size: 2rem;
          height: 90px;
          border-bottom: silver 2px solid;
          padding-left: 350px;
          padding-top: 30px;
        }
        .panel_left{
          padding-left: 250px;
        }
        .panel_right{
          position: relative;
          left: 820px;
          top: -300px;
        }
        .panel_right div{
          margin-top: 10px;
          font-size: 20px;
          color: silver;
        }
        .panel_right input{
          height: 26px;
          font-size: 18px;
          color: #424245;
          letter-spacing: 1px;
          margin-left: 10px;
        }
        .right_code{
          margin-left: 92px;
        }
        .right_password{
          margin-left: 92px;
        }
        .right_repeat{
          margin-left: 72px;
        }
        .right_code_input{
          width: 100px;
        }
        .right_code_button{
          height: 30px;
          margin-left: 5px;
        }
        .right_submit_buttom{
          margin-left: 200px;
          margin-top: 20px;
          font-size: 18px;
          color: #3d3b3b;
          background-color: #95d3f3;
          border-color: silver;
        }
        .error{
            height: 20px;
            margin-left: 170px;
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        window.onload = function (){
            //只有所有输入框输入都合法才能提交表单
            document.getElementById("form").onsubmit = function (){
                if (checkUsername() && checkPassword() && checkRePassword() && checkCode()){
                    return true
                } else {
                    return false
                }
            }
            //检查用户名是否为空
            function checkUsername(){
                var username = $('#username-id').val()
                if (username == ""){
                    //输入框为空
                    return false
                }
                return true
            }

            //核对邮箱验证码
            var codeIsCorrect = null
            function checkCode(){
                $.ajax({
                    url: "http://localhost:8080/userServlet",
                    type: 'post',
                    data: {"action":"codeIsCorrect", "input_code":$('#input_code').val()},
                    success: function (data){
                        codeIsCorrect = JSON.parse(data)
                        alert(codeIsCorrect)
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown)
                    }
                })
                if (codeIsCorrect == 1){
                    return true
                }
                $(".sCode").text("验证码不正确")
                return false
            }

            //发送邮箱验证码
            $('.right_code_button').on('click',function (){
                $.ajax({
                    url: "http://localhost:8080/userServlet",
                    type: 'post',
                    data: {"action":"sendEmail", "emailAddress":$('#username-id').val()},
                    success: function (data){

                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown)
                    }
                })
                //页面获取验证码按钮样式处理
                var count = 61;
                $(".right_code_button").attr('disabled','disabled');
                var sum = 60;
                count = 1;
                var i = setInterval(function(){
                    if(count > 60){
                        $(".right_code_button").attr('disabled',false);
                        $(".right_code_button").text("获取邮箱验证码");
                        clearInterval(i);
                    }else{
                        $(".right_code_button").text("重新获取"+(sum - count)+'秒');
                    }
                    count++;
                },1000);

            })
            //检查密码是否为空
            function checkPassword(){
                var password = $('#password-id').val()
                if (password == ""){
                    //输入框为空
                    return false
                }
                return true
            }
            //校验确认密码
            function checkRePassword(){
                //1.获取密码的值
                var password = $('#password-id').val()
                var rePassword = $('#rePassword-id').val()
                if(password == rePassword){
                    return true
                }
                else {
                    return false
                }
            }

            //用户名输入框失去焦点
            $('#username-id').blur(function (){
                if (!checkUsername()){
                    //输入框为空
                    $('.sEmail').text("用户名不能为空")
                }
            })
            //密码输入框失去焦点
            $('#password-id').blur(function (){
                if (!checkPassword()){
                    //输入框为空
                    $('.sPassword').text("密码不能为空")
                }
            })
            //确认密码框失去焦点
            $('#rePassword-id').blur(function (){
                if (!checkRePassword()){
                    //输入框为空
                    $('.sRePassword').text("与上方密码不符")
                }
            })
            //用户名输入框获得焦点
            $('#username-id').focus(function (){
                //移除为空的提示信息
                $('.sEmail').text("")
            })
            //验证码获得焦点
            $('#input_code').focus(function (){
                //移除为空的提示信息
                $('.sCode').text("")
            })
            //密码输入框获得焦点
            $('#password-id').focus(function (){
                //移除为空的提示信息
                $('.sPassword').text("")
            })
            //确认密码框获得焦点
            $('#rePassword-id').focus(function (){
                $('.sRePassword').text("")
            })
        }

    </script>
</head>
<body>
<div class="panel">
  <div class="panel_top">忘记密码</div>
  <div class="panel_left"><img src="http://localhost:8080/pages/img/background/registerFly.png"></div>
  <div class="panel_right">
      <form method="post" action="http://localhost:8080/userServlet" id="form">
          <input type="hidden" name="action" value="resetPassword">
          <div><span>账号(绑定的邮箱):</span><input type="text" name="username" id="username-id"></div>
          <div class="error sEmail"></div>
          <div class="right_code"><span>验证码:</span><input type="text" name="input_code" class="right_code_input" id="input_code"><button type="button" class="right_code_button">获取验证码</button></div>
          <div class="error sCode"></div>
          <div class="right_password"><span>新密码:</span><input type="password" name="newPassword" id="password-id"></div>
          <div class="error sPassword"></div>
          <div class="right_repeat"><span>确认密码:</span><input type="password" name="rePassword" id="rePassword-id"></div>
          <div class="error sRePassword"></div>
          <div><button type="submit" class="right_submit_buttom">确认重置</button></div>
      </form>
  </div>
</div>
</body>
</html>