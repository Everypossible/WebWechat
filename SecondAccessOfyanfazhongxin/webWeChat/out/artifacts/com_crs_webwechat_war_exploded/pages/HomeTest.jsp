<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PC聊天</title>

<%--    富文本编辑器--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>


    <base href="http://localhost:8080/pages/">

    <style>
        * {
            list-style: none;
            padding: 0;
            margin: 0;
            font-size: 14px;
            text-decoration: none;
            color: black;
            outline: none;
        }

        html, body {
            width: 100%;
            height: 100%;
        }

        .main {

            height: 810px;
            width: 1005px;
            margin: auto;
            box-shadow: 0 0 3px 5px #e1e1e1;
        }

        .main .top {
            width: 1005px;
            height: 60px;
            background-color: #3bb4f2;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .main .top .top-left {
            height: 100%;
            width: 200px;
            float: left;
            position: relative;
        }

        .main .top .top-left .header {
            height: 48px;
            width: 48px;
            border-radius: 50%;
            line-height: 60px;
            display: inline-block;
            margin: 6px;
            border: 1px solid transparent;
        }

        .main .top .top-left .header:hover {
            border: 1px solid white;
        }

        .main .top .top-left .search {
            display: inline-block;
            height: 30px;
            position: absolute;
            margin: 17px 14px;
        }

        .main .top .top-left .search input {
            display: inline-block;
            width: 110px;
            height: 30px;
            border-radius: 40px;
            border: 1px solid ghostwhite;
            text-indent: 40px;
            background-color: #3bb4f2;

        }

        .main .top .top-left .search input:hover {
            border: 1px solid white;
        }

        .main .top .top-left .search .icon-sear {

            background-image: url("img/icon/search.png");
            background-size: 100% 100%;
            height: 28px;
            width: 28px;
            position: absolute;
            margin-top: 3px;
            margin-left: -104px;

        }

        .main .top .top-type {
            height: 100%;
            width: 270px;
            float: left;
            margin-left: 200px;
        }

        .main .top .top-type a.icon-site {
            display: inline-block;
            height: 40px;
            width: 40px;
            background-size: 100% 100%;
            margin: 10px 11px;
        }

        .main .top .top-type .news {
            /*background-image: url("img/icon/news.png");*/

        }

        .main .top .top-type .friend {
            background-image: url("img/icon/friend.png");

        }

        .main .top .top-type .file {
            background-image: url("img/icon/room.png");

        }

        .main .top .top-type .add {
            background-image: url("img/icon/add.png");

        }

        .main .top .top-right {
            height: 100%;
            width: 200px;
            float: right;
        }

        .main .top .top-right i.ic-same {
            display: inline-block;
            height: 20px;
            width: 20px;
            background-size: 100% 100%;
            margin: 19px 7px;
        }

        .main .top .top-right i.ic-same.ic-menu {
            margin-left: 48px;
        }

        .main .top .top-right .ic-menu {

            background-image: url("img/icon/menu.png");
        }

        .main .top .top-right .ic-shrink {
            background-image: url("img/icon/shrink.png");
        }

        .main .top .top-right .ic-boost {
            background-image: url("img/icon/boost.png");
        }

        .main .top .top-right .ic-close {
            background-image: url("img/icon/close.png");
        }

        .main .box {
            width: 100%;
            height: 740px;

            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
        }

        .main .box .chat-list {
            float: left;
            width: 250px;
            height: 101%;
            background-color: #f4f4f4;
        }

        .main .box .chat-list .list-box {
            height: 110px;
            width: 250px;
        }

        .main .box .chat-list .list-box.select {
            background-color: #dbdbdb;
        }

        .main .box .chat-list .list-box:hover {
            background-color: #dbdbdb;
        }

        .main .box .chat-list .list-box img.chat-head {
            height: 50px;
            width: 50px;
            border-radius: 50%;
            border: 1px solid #f4f4f4;
            margin: 15px 10px;
        }

        .main .box .chat-list .list-box .chat-rig {
            float: right;
            height: 50px;
            width: 178px;
            margin: 15px 0;
        }

        .main .box .chat-list .list-box .chat-rig .title {
            font-weight: 600;
            font-size: 17px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

        .main .box .chat-list .list-box .chat-rig .text {
            font-size: 12px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            color: #6C6C6C;
        }

        .main .box .box-right {
            float: left;
            width: 750px;
            height: 100%;
        }

        .main .box .box-right .recvfrom {
            width: 752px;
            height: 560px;

        }

        .main .box .box-right .recvfrom .nav-top {
            height: 45px;
            width: 100%;
        }

        .main .box .box-right .recvfrom .nav-top p {
            line-height: 45px;
            font-size: 18px;
            font-weight: 600;
            margin-left: 25px;
        }

        .main .box .box-right .recvfrom .news-top {
            height: 510px;
            border-top: 1px solid #6C6C6C;
            border-bottom: 1px solid #6C6C6C;
            overflow-y: scroll;
        }

        .main .box .box-right .recvfrom .news-top ul {
            height: 100%;
            width: 100%;
        }

        .main .box .box-right .recvfrom .news-top ul li {
            margin: 10px;
            min-height: 80px;
            position: relative;
            width: 600px;
        }

        .main .box .box-right .recvfrom .news-top ul li .avatar img {
            height: 30px;
            width: 30px;
            border-radius: 50%;
        }

        .main .box .box-right .recvfrom .news-top ul li .msg {
            top: -10px;
            margin: 8px;
            min-height: 80px;
        }

        .main .box .box-right .recvfrom .news-top ul li::after {
            clear: both;
            content: "";
            display: inline-block;
        }

        .main .box .box-right .recvfrom .news-top ul li .msg .msg-text {
            background-color: #dedede;
            border-radius: 5px;
            padding: 8px;
            letter-spacing: 1px;
            font-family: SimSun-ExtB;
        }

        .main .box .box-right .recvfrom .news-top ul li .msg time {
            float: right;
            color: #ccc;
        }

        .main .box .box-right .recvfrom .news-top ul li.other .avatar {
            position: absolute;
            left: 0;
            top: 0;
        }

        .main .box .box-right .recvfrom .news-top ul li.other .msg {
            position: relative;
            left: 40px;

        }

        .main .box .box-right .recvfrom .news-top ul li.self .avatar {
            position: absolute;
            right: -110px;
            top: 0;
        }

        .main .box .box-right .recvfrom .news-top ul li.self .msg {
            position: relative;
            right: -72px;
        }

        .main .box .box-right .sendto {
            width: 752px;
            height: 180px;
        }

        .main .box .box-right .sendto .but-nav ul li {
            float: left;
            height: 22px;
            width: 22px;
            margin: 7px 15px;
            background-size: 100% 100%;
        }

        .main .box .box-right .sendto .but-nav ul li:hover {
            background-color: #dbdbdb;
        }

        .main .box .box-right .sendto .but-text textarea {
            border: none;
            font-size: 22px;
            margin-left: 20px;
            width: 732px;
            height: 100px;
        }

        /*自添加*/
        .list{
            overflow: hidden;
            border: #e7e4e4 solid 1px;
            width: 80px;
            position: absolute;
            margin-top: 50px;
            margin-left: 620px;
            display: none;
        }

        .all dl dt{float: top}

        .msg-div {
            background-color: #6C6C6C;
            border-radius: 5px;
            padding: 8px;
        }
        #send-button{
            padding: 5px 25px;
            background-color: #86cbef;
            margin-right: 20px;
            position: relative;
            left: 660px;
            top: -35px;
            color: white;
        }

        .show{
            display: block;
        }
        .agree-request{
            float: right;
        }

    </style>

    <script>
        window.onload = function (){
            //启动summernote
            $('#summernote').summernote({
                placeholder: 'Hello Bootstrap 4',
                tabsize: 2,
                height: 125,
                width: 600,
                maxHeight: 125,
                minHeight: 125,
                toolbar:[
                    ['style',['style']],
                    ['font',['bold','underline','clear']],
                    ['fontname',['fontname']],
                    ['color',['color']],
                    ['para',['ul','ol','paragraph']],
                    ['table',['table']],
                    ['insert',['link','picture']],
                ]
            });
            //全局变量
            //用来存放双击左边列表时选定聊天对象的昵称
            var friendNickname = null
            // 设置发送消息按钮不可点击
            function dissend(){
                $("#send-button").attr('disabled', true)
                $("#send-button").css('background-color', '#d9e0e8')
            }
            dissend()
            function canSend(){
                $("#send-button").attr('disabled', false)
                $("#send-button").css('background-color', '#38a3f5')
            }

            //初始化左侧好友消息记录
            function requestAllFriends() {
                $.ajax({
                    url: "http://localhost:8080/FriendsServlet",
                    type: "post",
                    data: "action=showAllFriends",
                    async: false,
                    dataType: "text",
                    success: function requestSuccess (data){
                        showAllFriends(data);
                    },
                    error: function requsetError(){
                        alert("连接异常");
                    }
                });
            }
            function showAllFriends(data) {
                var allFriendsListJson = JSON.parse(data);
                for (var i in allFriendsListJson){
                    var addFriends = '<div class="list-box"><img class="chat-head" src="" alt="头像">' +
                        '<div class="chat-rig">' +
                        '<p class="title">' + allFriendsListJson[i].nickname + '</p>' +
                        '<p class="text">紧急！！！</p>' +
                        '</div>' +
                        '</div>';
                    $(addFriends).appendTo("#friends-list");
                }
            }
            requestAllFriends();

            //初始化左边的好友请求
            function showFriendsRequset(){
                $.ajax({
                    url: "http://localhost:8080/FriendRequestServlet",
                    type: "post",
                    data: "action=queryFriendRequestByReceiverNickname",
                    async: false,
                    dataType: "text",
                    success: function requestSuccess (data){
                        showRequest(data);
                    },
                    error: function requsetError(){
                        alert("连接异常");
                    }
                });
            }
            function showRequest(data){
                var requestListJson = JSON.parse(data);
                for (var i in requestListJson){
                    var addFriends = '<div class="list-box"><img class="chat-head" src="" alt="头像">' +
                        '<div class="chat-rig">' +
                        '<p class="title">' + requestListJson[i].senderName + '</p>' +
                        '<p class="text">好友申请</p>' +
                        '<button class="agree-request">同意</button>' +
                        '</div>' +
                        '</div>';
                    $(addFriends).appendTo("#friends-list");
                }
            }
            showFriendsRequset()
            //同意好友申请
            function agreeRequest(sender){
                //将好友加入到好友数据表并将申请记录的state置为1
                $.ajax({
                    url: "http://localhost:8080/FriendsServlet",
                    type: "post",
                    data: {"action":"agreeAddFriend", "requestSender":sender},
                    async: false,
                    dataType: "text",
                    success: function requestSuccess (data){
                    },
                    error: function requsetError(){
                        alert("连接异常");
                    }
                });
            }
            $('.list-box').on('click', '.agree-request', function (){
                agreeRequest($(this).parent().find('.title').text())
                $(this).attr('disabled', true)
                $(this).text("已同意")
            })

            // 添加好友和创建群聊菜单
            var preResult = $('.list').height();
            var pre = 0;

            $(".add.icon-site").click(function(){
                $('.list').toggleClass('show')
            });
            //点击添加好友
            var chatDiv = $("#chat-div");
            var addFriendsDiv = $("add-friends-div");

            addFriendsDiv.remove();

            $("#add-friends-dt").click(function (){
                chatDiv.remove();
                $(".box").append(addFriendsDiv);
            });

            //左侧好友列表双击事件
            $("#friends-list").on("dblclick", ".list-box", function (){
                //换好友聊天时刷新聊天框(删除之前那个聊天的标签)
                $(".news-list-ul").empty()
                //发送按钮可点击
                canSend()
                //获取双击处的好友昵称
                friendNickname = $(this).find(".title").text()
                $("#nav-top-p").text(friendNickname);
                alert(friendNickname)
                //从数据库读取数据初始化该好友的聊天记录
                $.ajax({
                    url: "http://localhost:8080/MessageServlet",
                    type: 'post',
                    data: {"userNickname":friendNickname, "action":"getMsgRecordByUserNickname"},
                    success: function (dataBackJson){
                        if (dataBackJson != null){
                            var dataBack = JSON.parse(dataBackJson)
                            for (var i = 0; i < dataBack.length; i++){
                                initChatList(dataBack[i])
                            }
                        }
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                })
            });

            //将从数据库获得的聊天记录渲染到右边的聊天框内
            function initChatList(msg){
                if (msg.msgSender == ${sessionScope.userNickname}){
                    //自己发的消息
                    $(".news-list-ul").append('' +
                        '<li class="self">' +
                        '<div class="avatar"><img src="" alt=""></div>' +
                        '<div class="msg">' +
                        '<p class="msg-name">' + msg.msgSender +'</p>' +
                        '<div class="msg-div">' + msg.msgInfo + '<emoji class="pizza"></emoji></div>' +
                        '<time>' + JSON.stringify(msg.msgDateTimeStr) +'</time>' +
                        '</div>' +
                        '</li>'
                    )
                    $(".news-list-ul").children(":last").get(0).scrollIntoView(false)
                } else {
                    //别人发的消息
                    $(".news-list-ul").append('' +
                        '<li class="other">' +
                        '<div class="avatar"><img src="" alt=""></div>' +
                        '<div class="msg">' +
                        '<p class="msg-name">' + msg.msgSender +'</p>' +
                        '<div class="msg-div">' + msg.msgInfo + '<emoji class="pizza"></emoji></div>' +
                        '<time>' + JSON.stringify(msg.msgDateTimeStr) +'</time>' +
                        '</div>' +
                        '</li>'
                    )
                    $(".news-list-ul").children(":last").get(0).scrollIntoView(false)
                }
            }


            // 第一版聊天功能
            var sendButton = document.getElementById("send-button");
            var socket = new WebSocket('ws://localhost:8080/websocket/chat/' + "${sessionScope.userNickname}");

            var msg = {}
            msg.msgSender = "${sessionScope.user.username}"
            // msg.msgSender = "测试群发发送者"
            msg.msgReceiver =  $("#nav-top-p").text()

            // 将消息内容发送到后台以存入数据库的函数
            function sendMsgByAjax(message){
                msg.msgInfo = message
                msg.action = "msgSendToMySQL"
                $.ajax({
                    url: "http://localhost:8080/MessageServlet",
                    type: 'post',
                    data: {"msg":JSON.stringify(msg), "action":"msgSendToMySQL"},
                    success: function (){
                        alert("发送成功")
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }

                })
            }

            //监听发送消息(监听发送按钮)
            sendButton.addEventListener('click', function () {
                // 发送富文本消息
                var makeupStr = $("#summernote").summernote('code')
                //判断内容是否为空
                if($('#summernote').summernote('isEmpty')){
                    alert('editor content is empty');
                } else {
                    var msg2 = {}
                    //获取消息内容
                    msg2.msgInfo = makeupStr
                    //获取群成员的昵称
                    var membersList = new Array()
                    $.ajax({
                        url: "http://localhost:8080/RoomServlet",
                        type: 'post',
                        async: false,
                        //这里的friendNickname是上方定义的全局变量，表示双击时获取到的好友(个人或群)的昵称
                        data: {"roomName":friendNickname, "action":"queryRoomMemberByRoomName"},
                        // data: {"roomName":"动态元素", "action":"queryRoomMemberByRoomName"},
                        success: function (dataBack){
                            //加双引号保证昵称是字符串，避免昵称是数字时因var的弱类型而识别为数字
                            membersList[0] = "${sessionScope.userNickname}"
                            var dataBackToList = JSON.parse(dataBack)
                            if (Array.prototype.isPrototypeOf(dataBackToList) && dataBackToList.length == 0){
                                //聊天对象是个人
                                membersList[1] = friendNickname
                                console.log("聊天对象是个人，他是：" + membersList)
                            } else {
                                //聊天对象是群
                                console.log("聊天对象是群：群成员是：" + dataBackToList)
                                for (var i = 1; i <= dataBackToList.length; i++){
                                    membersList[i] = dataBackToList[i-1]
                                }
                            }
                        },
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                            console.log(XMLHttpRequest.status);
                            console.log(XMLHttpRequest.readyState);
                            console.log(textStatus);
                            console.log(errorThrown);
                        }
                    })
                    msg2.msgReceiverList = membersList
                    //将消息对象(var2)转成JSON字符串
                    var msgSend = JSON.stringify(msg2)
                    console.log(msgSend)
                    socket.send(msgSend)
                    sendMsgByAjax(makeupStr)
                    $('#summernote').summernote('reset');
                }
            })

            // 收到消息
            socket.addEventListener('message', function (e){
                //浏览器控制台打印出消息
                console.log(e)
                console.log("接收到了数据：" + e.data)
                var msgJson = JSON.parse(e.data);
                //更新左边的消息记录栏
                if ($("#friends-list div:first-child").find(".title").text() != msgJson.msgSender){
                    //左边聊天记录栏第一个不是当前最新发送者
                    $.each($("#friends-list .title"), function (index, item) {
                        // console.log($(this).text())
                        //确认接收到的消息不是自己发送的
                        if ("${sessionScope.userNickname}" != "" + msgJson.msgSender + ""){
                            if ($(this).text() == "" + msgJson.msgSender + ""){
                                $(this).parent().parent().remove()
                                $('#friends-list').prepend($(this).parent().parent())
                                return false
                            }
                            if (index == $("#friends-list").children().length-1){
                                console.log("左边没有, 此时index=" + index)
                                //左边聊天栏本来就没有该好友的聊天记录
                                $('#friends-list').prepend('<div class="list-box"><img class="chat-head" src="" alt="头像">' +
                                    '<div class="chat-rig">' +
                                    '<p class="title">' + msgJson.msgSender + '</p>' +
                                    '<p class="text">紧急！！！</p>' +
                                    '</div>' +
                                    '</div>'
                                )
                            }
                        }
                    })
                }

                // 把接收到的消息显示到聊天窗口中
                $(".news-list-ul").append('' +
                    '<li class="self">' +
                    '<div class="avatar"><img src="" alt=""></div>' +
                    '<div class="msg">' +
                    '<p class="msg-name">' + msgJson.msgSender +'</p>' +
                    '<div class="msg-div">' + msgJson.msgInfo + '<emoji class="pizza"></emoji></div>' +
                    '<time>20:18</time>' +
                    '</div>' +
                    '</li>'
                )
                $(".news-list-ul").children(":last").get(0).scrollIntoView(false)
            })
            //查找url参数
            function getQueryString(name) {
                let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                let r = window.location.search.substr(1).match(reg);
                if (r != null) {
                    return decodeURIComponent(r[2]);
                };
                return null;
            }
            //判断是否是看群时转过来的
            function isFromRoom(){
                var roomName = getQueryString("roomName")
                //若是群聊那边转过来,则roomName是群昵称
                if (roomName == null){
                    //不是从群那边转过来
                } else {
                    //从群那边转过来
                    $('#friends-list').prepend('<div class="list-box"><img class="chat-head" src="" alt="头像">' +
                        '<div class="chat-rig">' +
                        '<p class="title">' + roomName + '</p>' +
                        '<p class="text">群聊天记录</p>' +
                        '</div>' +
                        '</div>'
                    )
                }
            }
            isFromRoom()

        }
    </script>
</head>
<body>
<div class="main">

<%--    自添加标签--%>
    <div class="all">
        <dl class="list">
            <a href="AddFriends.jsp">添加朋友</a><br/>
            <a href="CreateRoom.jsp">发起群聊</a>
        </dl>
    </div>


    <div class="top">
        <div class="top-left">
            <div class="header"><a href="PersonPage.html"></a></div>
            <div class="search">
                <input type="text">
                <i class="icon-sear"></i>
            </div>
        </div>
        <div class="top-type">
            <a class="news icon-site"></a>
            <a href="FriendsList.html" class="friend icon-site" title="好友列表"></a>
            <a href="http://localhost:8080/pages/RoomList.jsp" class="file icon-site"></a>
            <a class="add icon-site" title="添加"></a>
        </div>
        <div class="top-right">
            <i class="ic-menu ic-same"></i>
            <i class="ic-shrink ic-same"></i>
            <i class="ic-boost ic-same"></i>
            <i class="ic-close ic-same"></i>
        </div>
    </div>
    <div class="box">
        <div class="chat-list" id="friends-list">
<%--            <div class="list-box">--%>
<%--                <img class="chat-head" src="" alt="">--%>
<%--                <div class="chat-rig">--%>
<%--                    <p class="title">用户昵称</p>-->--%>
<%--                    <p class="text">紧急！！！</p>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <div class="box-right" id="chat-div">
            <div class="recvfrom">
                <div class="nav-top">
                    <p id="nav-top-p"></p>
                </div>
                <div class="news-top">
                    <ul class="news-list-ul">
<%--                        <li class="other">--%>
<%--                            <div class="avatar"><img src="" alt=""></div>--%>
<%--                            <div class="msg">--%>
<%--                                <p class="msg-name">宋温暖</p>--%>
<%--                                <p class="msg-text">请接下这个活 <emoji class="pizza"></emoji></p>--%>
<%--                                <time>20:18</time>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li class="self">--%>
<%--                            <div class="avatar"><img src="" alt=""></div>--%>
<%--                            <div class="msg">--%>
<%--                                <p class="msg-name">安安安</p>--%>
<%--                                <p class="msg-text">请接下这个下这个活请接下接下这个活请接下接下这个活请接下下这个活请接下这个活<emoji class="pizza"></emoji></p>--%>
<%--                                <time>20:18</time>--%>
<%--                            </div>--%>
<%--                        </li>--%>
                    </ul>
                </div>
            </div>
            <div class="sendto">
                <div class="but-text" id="summernote">
                </div>
                <button id="send-button" class="button">发送</button>
            </div>
    </div>
</div>

</body>
</html>