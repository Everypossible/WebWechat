<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PC聊天</title>
    <base href="http://localhost:8080/pages/">

<!--    <link rel="stylesheet" href="Home.css" type="text/css">-->
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

            height: 800px;
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
            /*background-image: url("../img/header.jpg");*/
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

            background-image: url("../pages/img/icon/search.png");
            background-size: 100% 100%;
            height: 28px;
            width: 28px;
            position: absolute;
            margin-top: 3px;
            margin-left: -104px;

        }

        .main .top .top-type {
            height: 100%;
            width: 200px;
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
            background-image: url("../pages/img/icon/news.png");

        }

        .main .top .top-type .friend {
            background-image: url("../pages/img/icon/friend.png");

        }

        .main .top .top-type .file {
            background-image: url("../pages/img/icon/file.png");

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

            background-image: url("../pages/img/icon/menu.png");
        }

        .main .top .top-right .ic-menu:hover {
            /*background-image: url("img/icon/menu (1).png");*/
        }

        .main .top .top-right .ic-shrink {
            background-image: url("../pages/img/icon/shrink.png");
        }

        .main .top .top-right .ic-shrink:hover {
            /*background-image: url("img/icon/shrink (1).png");*/
        }

        .main .top .top-right .ic-boost {
            background-image: url("../pages/img/icon/boost.png");
        }

        .main .top .top-right .ic-boost:hover {
            /*background-image: url("img/icon/boost (1).png")*/
        }

        .main .top .top-right .ic-close {
            background-image: url("../pages/img/icon/close.png");
        }

        .main .top .top-right .ic-close:hover {
            /*background-image: url("img/icon/close (1).png");*/
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
            height: 100%;
            background-color: #f4f4f4;
        }

        .main .box .chat-list .list-box {
            height: 80px;
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
            overflow: hidden;

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
            background-color: #6C6C6C;
            border-radius: 5px;
            padding: 8px;
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
            position: absolute;
            left: 40px;

        }

        .main .box .box-right .recvfrom .news-top ul li.self .avatar {
            position: absolute;
            right: 0;
            top: 0;
        }

        .main .box .box-right .recvfrom .news-top ul li.self .msg {
            position: absolute;
            right: 38px;
        }

        .main .box .box-right .sendto {
            width: 752px;
            height: 180px;
        }

        .main .box .box-right .sendto .but-nav {
            height: 40px;
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

        .main .box .box-right .sendto .but-nav ul li.font {
            background-image: url("../pages/img/icon/font.png");
        }

        .main .box .box-right .sendto .but-nav ul li.face {
            background-image: url("../pages/img/icon/face.png");
        }

        .main .box .box-right .sendto .but-nav ul li.cut {
            background-image: url("../pages/img/icon/cut.png");
        }

        .main .box .box-right .sendto .but-nav ul li.page {
            background-image: url("../pages/img/icon/page.png");
        }

        .main .box .box-right .sendto .but-nav ul li.old {
            background-image: url("../pages/img/icon/old.png");
        }

        .main .box .box-right .sendto .but-text textarea {
            border: none;
            font-size: 22px;
            margin-left: 20px;
            width: 732px;
            height: 100px;
        }

        .main .box .box-right .sendto .but-text .button {
            float: right;
            padding: 5px 25px;
            background-color: #3bb4f2;
            margin-right: 20px;
        }

    </style>
</head>
<body>
<div class="main">
    <div class="top">
        <div class="top-left">
            <div class="header"></div>
            <div class="search">
                <input type="text">
                <i class="icon-sear"></i>
            </div>
        </div>
        <div class="top-type">
            <a href="#" class="news icon-site"></a>
            <a href="#" class="friend icon-site"></a>
            <a href="#" class="file icon-site"></a>
        </div>
        <div class="top-right">
            <i class="ic-menu ic-same"></i>
            <i class="ic-shrink ic-same"></i>
            <i class="ic-boost ic-same"></i>
            <i class="ic-close ic-same"></i>
        </div>
    </div>
    <div class="box">
        <div class="chat-list">
            <div class="list-box">
                <img class="chat-head" src="../static/img/img-header2.jpg" alt="">
                <div class="chat-rig">
                    <p class="title">${sessionScope.user.username}</p>
                    <p class="text">紧急！！！</p>
                </div>
            </div>
            <div class="list-box select"><img class="chat-head" src="../static/img/img-header.jpeg" alt="">
                <div class="chat-rig"><p class="title">宋温暖</p>
                    <p class="text">在？</p></div>
            </div>
            <div class="list-box"><img class="chat-head" src="../static/img/img-header2.jpg" alt="">
                <div class="chat-rig"><p class="title">安安安</p>
                    <p class="text">你好，我这里有个任务帮我做一下</p></div>
            </div>
            <div class="list-box">
                <img class="chat-head" src="../static/img/img-header2.jpg" alt="">
                <div class="chat-rig">
                    <p class="title">公众号</p>
                    <p class="text">紧急！！！</p>
                </div>
            </div>
            <div class="list-box"><img class="chat-head" src="../static/img/img-header.jpeg" alt="">
                <div class="chat-rig"><p class="title">宋温暖</p>
                    <p class="text">在？</p></div>
            </div>
            <div class="list-box"><img class="chat-head" src="../static/img/img-header2.jpg" alt="">
                <div class="chat-rig"><p class="title">安安安</p>
                    <p class="text">你好，我这里有个任务帮我做一下</p></div>
            </div>
            <div class="list-box">
                <img class="chat-head" src="../static/img/img-header2.jpg" alt="">
                <div class="chat-rig">
                    <p class="title">公众号</p>
                    <p class="text">紧急！！！</p>
                </div>
            </div>
            <div class="list-box"><img class="chat-head" src="../static/img/img-header.jpeg" alt="">
                <div class="chat-rig"><p class="title">宋温暖</p>
                    <p class="text">在？</p></div>
            </div>
            <div class="list-box"><img class="chat-head" src="../static/img/img-header2.jpg" alt="">
                <div class="chat-rig"><p class="title">安安安</p>
                    <p class="text">你好，我这里有个任务帮我做一下</p></div>
            </div>
        </div>
        <div class="box-right">
            <div class="recvfrom">
                <div class="nav-top">
                    <p>公众号</p>
                </div>
                <div class="news-top">
                    <ul>
                        <li class="other">
                            <div class="avatar"><img src="../static/img/img-header2.jpg" alt=""></div>
                            <div class="msg">
                                <p class="msg-name">宋温暖</p>
                                <p class="msg-text">请接下这个活 <emoji class="pizza"></emoji></p>
                                <time>20:18</time>
                            </div>
                        </li>
                        <li class="self">
                            <div class="avatar"><img src="../static/img/img-header2.jpg" alt=""></div>
                            <div class="msg">
                                <p class="msg-name">安安安</p>
                                <p class="msg-text">请接下这个下这个活请接下接下这个活请接下接下这个活请接下下这个活请接下这个活<emoji class="pizza"></emoji></p>
                                <time>20:18</time>
                            </div>
                        </li>
                        <li class="other">
                            <div class="avatar"><img src="../static/img/img-header2.jpg" alt=""></div>
                            <div class="msg">
                                <p class="msg-name">Name</p>
                                <p class="msg-text">请接下这个活 <emoji class="pizza"></emoji></p>
                                <time>20:18</time>
                            </div>
                        </li>
                        <li class="self">
                            <div class="avatar"><img src="../static/img/img-header2.jpg" alt=""></div>
                            <div class="msg">
                                <p class="msg-name">Name</p>
                                <p class="msg-text">请接下这个活 <emoji class="pizza"></emoji></p>
                                <time>20:18</time>
                            </div>
                        </li>
                        <li class="other">
                            <div class="avatar"><img src="../static/img/img-header2.jpg" alt=""></div>
                            <div class="msg">
                                <p class="msg-name">Name</p>
                                <p class="msg-text">请接下这个活 <emoji class="pizza"></emoji></p>
                                <time>20:18</time>
                            </div>
                        </li>
                        <li class="other">
                            <div class="avatar"><img src="../static/img/img-header2.jpg" alt=""></div>
                            <div class="msg">
                                <p class="msg-name">Name</p>
                                <p class="msg-text">请接下这个活 <emoji class="pizza"></emoji></p>
                                <time>20:18</time>
                            </div>
                        </li>
                        <li class="other">
                            <div class="avatar"><img src="../static/img/img-header2.jpg" alt=""></div>
                            <div class="msg">
                                <p class="msg-name">Name</p>
                                <p class="msg-text">请接下这个活 <emoji class="pizza"></emoji></p>
                                <time>20:18</time>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="sendto">
                <div class="but-nav">
                    <ul>
                        <li class="font"></li>
                        <li class="face"></li>
                        <li class="cut"></li>
                        <li class="page"></li>
                        <li class="old"></li>
                    </ul>
                </div>
                <div class="but-text">
                    <textarea name="" id="" cols="110" rows="6"></textarea>
                    <a href="#" class="button">发送</a>
                </div>
            </div>
        </div>

    </div>


</div>

</body>
</html>