<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>

    <style>
        body{
            background: #EFF8FF;
        }
        /*容器*/
        .panel{
            width: 100%;
            margin: 1rem 0px 0;
            position: absolute;

            display: flex;
            justify-content: center;
        }
        .box0{
            width: 570px;
            height: 900px;
            background-color: #f8f6f6;
            position: absolute;
            margin: auto auto auto -300px;
        }
        .box-top{
            width:557px;
            height: 45px;
            background-color: #57a5e5;
            position: absolute;
            top:0px;
            /*border-radius: 7 7 0 0;*/
            color:white;
            font-size: 15px;
            padding-left: 15px;
            line-height: 45px;
        }
        .box-bottom{
            width: 570px;
            height: 850px;
            background-color: #EFF8FF;
            position: absolute;
            top:45px;
            left:0px;
            bottom: 0px;
            border:solid 1px 	#D4D4D4;
        }
        .innerbox0{
            width: 570px;
            height: 550px;
            /*background-color: pink;*/
            margin-top: 15px;
            padding-left:0px;
            padding-top: 15px;
            position: relative;
        }
        /*元素*/
        .innerbox0 ul li{
            list-style: none;
            font-size: 14px;
            position: absolute;
            margin-left: 90px;
        }
        .innerbox0 ul input{
            border: solid 2px #D4D4D4;
            border-radius: 4px	4px	4px	4px;
            width: 200px;
            height: 28px;
            margin-left: 5px;
        }
        .innerbox0 ul div{
            position: absolute;
        }
        a{
            text-decoration: none;
        }
        /*细节*/
        #li_username{
            top: 200px;
        }
        #li_email{
            top: 260px;
        }
        #li_code{
            top: 320px;
        }
        #li_password{
            top: 380px;
        }
        #li_repeat_password{
            top: 440px;
        }
        #li_sex{
            top: 500px;
        }
        #radio_man{
            width: auto;
            height: auto;
        }
        #radio_woman{
            width: auto;
            height: auto;
        }
        #li_birth{
            top: 560px;
        }
        #li_addr{
            top: 620px;
        }
        #li_desc{
            top: 680px;
        }
        /*验证码下面那些*/
        #li_code-codeInput{
            width: 140px;
            margin-left: 20px;
        }

        #input_submit{
            width:105px;
            height: 40px;
            /*border-radius: 5px 5px 5px 5px;*/
            background-color:#00CC00;
            color:white;
            font-size: 20px;
            position: absolute;
            left:100px;
            top: 742px;

        }
        /*提示信息*/
        #sUsername,#sEmail,#sCode,#sPassword,#sRepeatPassword,#sSex,#sBirth,#sAddr,#sDesc{
            margin-left: 94px;
        }
        #sUsername{
            width: 335px;
            height:25px;
            position: absolute;
            left:105px;
            top:232px;
            /*background-color:pink;*/
            /*border: solid 1px #D4D4D4;*/
        }
        #sEmail{
            width: 335px;
            height:25px;
            position: absolute;
            left:105px;
            top:292px;
            /*background-color:pink;*/
            /*border: solid 1px #D4D4D4;*/

        }

        #sCode{
            width: 335px;
            height:25px;
            color:silver;
            position: absolute;
            left:105px;
            top:352px;
            /*background-color:pink;*/
            /*border: solid 1px #D4D4D4;*/
        }
        .code_button{
            height: 28px;
            margin-left: 4px;
        }

        #sPassword{
            width: 335px;
            height:25px;
            position: absolute;
            left:105px;
            top:412px;
            /*background-color:pink;*/
            /*border: solid 1px #D4D4D4;*/

        }
        #sRepeatPassword{
            width: 335px;
            height:25px;
            color:silver;
            position: absolute;
            left:105px;
            top:472px;
        }
        #sSex{
            width: 335px;
            height:25px;
            color:silver;
            position: absolute;
            left:105px;
            top:532px;
        }
        #sBirth{
            width: 335px;
            height:25px;
            color:silver;
            position: absolute;
            left:105px;
            top:592px;
        }
        #sAddr{
            width: 335px;
            height:25px;
            color:silver;
            position: absolute;
            left:105px;
            top:652px;
        }
        #sDesc{
            width: 335px;
            height:25px;
            color:silver;
            position: absolute;
            left:105px;
            top:712px;
        }
        #last{
            width:270px;
            height:35px;
            position: absolute;
            left:130px;
            top:750px;
            font-size: 15px;
            line-height: 34px;
        }
        #agreement{
            width: auto;
            height: auto;
        }

        /*对小飞机图片进行设置*/
        #register_fly{
            height: 270px;
            width: 350px;
            position: absolute;
            margin-top: 480px;
            margin-left: 1000px;
        }

        /*头像*/
        #con1-li {
            width: 300px;
            height: auto;
            overflow: hidden;
            margin: -40px 150px auto;
            color: #FFFFFF;
        }

        .con1 .btn {
            width: 50%;
            height: 40px;
            line-height: 40px;
            text-align: center;
            background: #d8b49c;
            display: block;
            font-size: 16px;
            border-radius: 5px;
            margin-left: 24px;
        }

        .upload {
            float: left;
            position: relative;
        }

        .con1_upload-input {
            display: block;
            width: 100%;
            height: 40px;
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
            border-radius: 5px;
        }

        #cvs_head_portrait {
            border: 1px solid #000;
            margin: 20px 0 20px 50px;
        }

    </style>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        window.onload = function (){
            //给表单绑定提交事件
            document.getElementById("form").onsubmit = function (){
                if (checkBirth() && checkUsername() && checkEmail() && checkPassword() && checkRePassword() && checkAddr() && checkDesc() && checkAgree()){
                    return true;
                } else {
                    alert("输入信息不符合格式要求，请检查输入信息")
                    return false;
                }
            }
            //聚焦清除原有提示信息
            $('#nickname-id').focus(function (){
                $('#sUsername').children().remove()
            })
            $('#email-id').focus(function (){
                $('#sEmail').children().remove()
            })
            $('#li_code-codeInput').focus(function (){
                $('#sCode').children().remove()
            })
            $('#password-id').focus(function (){
                $('#sPassword').children().remove()
            })
            $('#repeat-id').focus(function (){
                $('#sRepeatPassword').children().remove()
            })
            $('#addr-id').focus(function (){
                $('#sAddr').children().remove()
            })
            $('#desc-id').focus(function (){
                $('#sDesc').children().remove()
            })

            //调用所有的校验函数校验信息
            $('#nickname-id').blur(function (){
                checkUsername()
            })
            $('#email-id').blur(function (){
                checkEmail()
            })
            $('#password-id').blur(function (){
                checkPassword()
            })
            $('#repeat-id').blur(function (){
                checkRePassword()
            })
            $('#addr-id').blur(function (){
                checkAddr()
            })
            $('#desc-id').blur(function (){
                checkDesc()
            })

            //校验用户名是否为空
            var nicknameIsAvailable = null
            var nicknameIsExist = null
            function checkUsername(){
                var username = $('#nickname-id').val()
                var sUsername = document.getElementById('sUsername')
                if (username.length == 0){
                    sUsername.innerHTML = "<b style='color: red'>!!!昵称不能为空</b>"
                    return false
                }
                checkNicknameExist(username)
                if (!nicknameIsAvailable){
                    sUsername.innerHTML = "<b style='color: red'>!!!昵称已被注册</b>"
                    return false
                }
                return true
            }
            //校验用户昵称是否已被注册
            function checkNicknameExist(nickname){
                $.ajax({
                    url: "http://localhost:8080/userServlet",
                    async: false,
                    type: 'post',
                    data: {"action":"nicknameExist", "nickname":nickname},
                    success: function (data){
                        nicknameIsExist = JSON.parse(data)
                        if (nicknameIsExist == 1){
                            nicknameIsAvailable = false
                        } else {
                            nicknameIsAvailable = true
                        }
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown)
                    }
                })
            }

            //校验邮箱
            var emailAvailable = null
            var emailIsAvailable = null
            function checkEmail(){
                //获取email值
                var email = $('#email-id').val()
                //定义正则表达式
                var reg_email = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/
                //判断是否符合正则表达式规则
                var judge = reg_email.test(email)
                //提示信息
                var sEmail = document.getElementById("sEmail")
                if (judge) {
                    //提示正确信息
                    sEmail.innerHTML = "<b>输入合法</b>"
                } else {
                    //提示错误信息
                    sEmail.innerHTML = "<b style='color: red'>!!!邮箱格式有误</b>"
                    return false
                }
                checkEmailExist(email)
                if (!emailIsAvailable){
                    sEmail.innerHTML = "<b style='color: red'>!!!邮箱已被注册</b>"
                }
                return (judge && emailIsAvailable)
            }

            //校验邮箱是否已被注册
            function checkEmailExist(email){
                $.ajax({
                    url: "http://localhost:8080/userServlet",
                    async: false,
                    type: 'post',
                    data: {"action":"emailExist", "username":email},
                    success: function (data){
                        emailAvailable = JSON.parse(data)
                        if (emailAvailable == 1){
                            emailIsAvailable = false
                        } else {
                            emailIsAvailable = true
                        }
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown)
                    }
                })
            }

            //发送邮箱验证码
            $('.code_button').on('click',function (){
                $.ajax({
                    url: "http://localhost:8080/userServlet",
                    type: 'post',
                    data: {"action":"sendEmail", "emailAddress":$('#email-id').val()},
                    success: function (){
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
                $(".code_button").attr('disabled','disabled');
                var sum = 60;
                count = 1;
                var i = setInterval(function(){
                    if(count > 60){
                        $(".code_button").attr('disabled',false);
                        $(".code_button").text("获取邮箱验证码");
                        clearInterval(i);
                    }else{
                        $(".code_button").text("重新获取"+(sum - count)+'秒');
                    }
                    count++;
                },1000);

            })


            //校验密码
            function checkPassword(){
                //1.获取密码值
                var password = $('#password-id').val()
                //2.定义正则表达式
                var reg_password = /^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)(?!([^(0-9a-zA-Z)])+$).{6,16}$/;
                //3.判断值是否符合正则的规则
                var judge = reg_password.test(password);
                //4.提示信息
                var sPassword = document.getElementById('sPassword')

                if(judge){
                    //提示正确信息
                    sPassword.innerHTML = "<b>输入合法</b>";
                }else{
                    //提示错误信息这里可以放图片是图片 也可以放文字
                    // s_password.innerHTML = "<img src='images4/7.jpg'>";
                    sPassword.innerHTML = "<b style='color: red'>!!!密码长度应由6~16个字母、数字或字符组成</b>";
                }
                return judge;
            }

            //校验确认密码
            function checkRePassword(){
                //1.获取密码的值
                var password = $('#password-id').val()
                var rePassword = $('#repeat-id').val()
                //2.提示信息
                var sRepassword = document.getElementById('sRepeatPassword')


                if(password == rePassword){
                    //提示正确信息
                    sRepassword.innerHTML = "<b>与原密码一致,输入合法</b>";
                    return true
                }
                else {
                    //提示错误信息
                    sRepassword.innerHTML = "<b style='color: red'>须与上方密码保持一致</b>";
                    return false
                }
            }

            //校验地区
            function checkAddr(){
                var username = $('#addr-id').val()
                var sUsername = document.getElementById('sAddr')
                if (username.length == 0){
                    sUsername.innerHTML = "<b style='color: red'>!!!所属地区不能为空</b>"
                    return false
                }
                return true
            }
            //校验个人签名
            function checkDesc(){
                var username = $('#desc-id').val()
                var sUsername = document.getElementById('sDesc')
                if (username.length == 0){
                    sUsername.innerHTML = "<b style='color: red'>!!!请简单写句个性签名哦</b>"
                    return false
                }
                return true
            }

            //初始化日期下拉框
            $(function () {
                $.ms_DatePicker({
                    YearSelector: ".sel_year",
                    MonthSelector: ".sel_month",
                    DaySelector: ".sel_day"
                });
            });
            (function($){
                $.extend({
                    ms_DatePicker: function (options) {
                        var defaults = {
                            YearSelector: "#sel_year",
                            MonthSelector: "#sel_month",
                            DaySelector: "#sel_day",
                            FirstText: "--",
                            FirstValue: 0
                        };
                        var opts = $.extend({}, defaults, options);
                        var $YearSelector = $(opts.YearSelector);
                        var $MonthSelector = $(opts.MonthSelector);
                        var $DaySelector = $(opts.DaySelector);
                        var FirstText = opts.FirstText;
                        var FirstValue = opts.FirstValue;

                        // 初始化
                        var str = "<option value=\"" + FirstValue + "\">"+FirstText+"</option>";
                        $YearSelector.html(str);
                        $MonthSelector.html(str);
                        $DaySelector.html(str);

                        // 年份列表
                        var yearNow = new Date().getFullYear();
                        var yearSel = $YearSelector.attr("rel");
                        for (var i = yearNow; i >= 1900; i--) {
                            var sed = yearSel==i?"selected":"";
                            var yearStr = "<option value=\"" + i + "\" " + sed+">"+i+"</option>";
                            $YearSelector.append(yearStr);
                        }

                        // 月份列表
                        var monthSel = $MonthSelector.attr("rel");
                        for (var i = 1; i <= 12; i++) {
                            var sed = monthSel==i?"selected":"";
                            var monthStr = "<option value=\"" + i + "\" "+sed+">"+i+"</option>";
                            $MonthSelector.append(monthStr);
                        }

                        // 日列表(仅当选择了年月)
                        function BuildDay() {
                            if ($YearSelector.val() == 0 || $MonthSelector.val() == 0) {
                                // 未选择年份或者月份
                                $DaySelector.html(str);
                            } else {
                                $DaySelector.html(str);
                                var year = parseInt($YearSelector.val());
                                var month = parseInt($MonthSelector.val());
                                var dayCount = 0;
                                switch (month) {
                                    case 1:
                                    case 3:
                                    case 5:
                                    case 7:
                                    case 8:
                                    case 10:
                                    case 12:
                                        dayCount = 31;
                                        break;
                                    case 4:
                                    case 6:
                                    case 9:
                                    case 11:
                                        dayCount = 30;
                                        break;
                                    case 2:
                                        dayCount = 28;
                                        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                                            dayCount = 29;
                                        }
                                        break;
                                    default:
                                        break;
                                }

                                var daySel = $DaySelector.attr("rel");
                                for (var i = 1; i <= dayCount; i++) {
                                    var sed = daySel==i?"selected":"";
                                    var dayStr = "<option value=\"" + i + "\" "+sed+">" + i + "</option>";
                                    $DaySelector.append(dayStr);
                                }
                            }
                        }
                        $MonthSelector.change(function () {
                            BuildDay();
                        });
                        $YearSelector.change(function () {
                            BuildDay();
                        });
                        if($DaySelector.attr("rel")!=""){
                            BuildDay();
                        }
                    } // End ms_DatePicker
                });
            })(jQuery);


            //校验出生日期
            function checkBirth(){
                if ($(".sel_year option:selected").text() == "--" || $(".sel_month option:selected").text() == "--" ||
                    $(".sel_day option:selected").text() == "--") {
                    $('#sBirth').text("请选择出生日期")
                    return false
                }
                return true
            }
            //校验同意服务条款
            function checkAgree(){
                if($('#agreement').is(':checked')) {
                    return true
                }
                alert("请同意服务条款，否则无法注册")
                return false
            }
        }

    </script>
</head>
<body>
<div class="panel">
    <img src="http://localhost:8080/pages/img/background/registerFly.png" id="register_fly">

    <div class="box0">
        <div class="box-top">欢迎加入微聊</div>

        <div class="box-bottom">
            <div class="innerbox0">
                <form method="post" action="http://localhost:8080/userServlet" id="form">
                    <input type="hidden" name="action" value="register">
                    <ul id="ul0">
                        <li class="con1" id="con1-li">
                            <canvas id="cvs_head_portrait" width="100" height="100"></canvas>
                            <span class="btn upload">选择头像<input type="file" class="con1_upload-input" id="upload-input"></span>
                        </li><br>
                        <li id="li_username"><span style="color: red;">*</span>用户昵称<input type="text" name="nickname" id="nickname-id"></li>
                            <div id="sUsername"></div>
                        <li id="li_email"><span style="color: red;">*</span>用户邮箱<input type="text" name="username" id="email-id"></li>
                            <div id="sEmail"></div>
                        <li id="li_code"><span style="color: red;">*</span>验证码<input type="text" name="input_code" id="li_code-codeInput"><button class="code_button" type="button">发送验证码</button></li>
                            <div id="sCode"></div>
                        <li id="li_password"><span style="color: red;">*</span>用户密码<input type="password" name="password" id="password-id"></li>
                            <div id="sPassword"></div>
                        <li id="li_repeat_password"><span style="color: red;">*</span>确认密码<input type="password" name="input_repeat_password" id="repeat-id">
                        </li>
                            <div id="sRepeatPassword"></div>
                        <li id="li_sex"><span style="color: red;">*</span>我的性别<input type="radio" name="sex" id="radio_man" checked>男<input
                                type="radio" name="sex" id="radio_woman">女
                        </li>
                            <div id="sSex"></div>
                        <li id="li_birth"><span style="color: red;">*</span>我的生日
                            <select class="sel_year" name="YYYY">
                                <option value=""></option>
                            </select>
                            <font>年</font>
                            <select class="sel_month" name="MM">
                                <option value="">请选择</option>
                            </select>
                            <font>月</font>
                            <select class="sel_day" name="DD">

                                <option value="">请选择</option>
                            </select>
                            <font>日</font>
                        </li>
                            <div id="sBirth"></div>
                        <li id="li_addr"><span style="color: red;">*</span>所在地区<input type="text" name="userAddr" id="addr-id"></li>
                            <div id="sAddr"></div>
                        <li id="li_desc"><span style="color: red;">*</span>个性签名<input type="text" name="userDesc" id="desc-id"></li>
                            <div id="sDesc"></div>
                        <div id ="last">
                            <input type="checkbox" id="agreement">同意<a href="">"服务条款"</a>	和<a href="">"隐私相关政策"</a>
                        </div>
                        <li><input type="submit" id="input_submit" value="立即注册"></li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

