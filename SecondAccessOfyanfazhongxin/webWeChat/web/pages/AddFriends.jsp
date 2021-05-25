<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        .search-top{
            margin-top: 50px;
            margin-left: 600px;
        }

        .search-result{
            width: 800px;
            height: 900px;
            margin-top: 50px;
            margin-left: 400px;
        }

        .list-box {
            height: 100px;
            width: 250px;
            display: inline-block;
            margin-top: 20px;
        }

        .list-box.select {
            background-color: #dbdbdb;
        }

        .list-box:hover {
            background-color: #dbdbdb;
        }

        .list-box img.chat-head {
            height: 50px;
            width: 50px;
            border-radius: 50%;
            border: 1px solid #f4f4f4;
            margin: 15px 10px;
        }

        .list-box .chat-rig {
            float: right;
            height: 50px;
            width: 178px;
            margin: 15px 0;
        }

        .list-box .chat-rig .title {
            font-weight: 600;
            font-size: 17px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

        .list-box .chat-rig .text {
            font-size: 12px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            color: #6C6C6C;
        }

        .add-button{
            float: left;
        }
    </style>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        window.onload = function () {
            //在用户列表中加载出我搜索的用户
            $("#users-search-button").on('click', function (){
                $(".search-result").empty()
                $.ajax({
                    url: "http://localhost:8080/UserDetailsServlet",
                    dataType: 'text',
                    type: 'post',
                    data: {"action":"userDetailsSearch","searchInfo":$("#searchInfo").val()},
                    success: function (data) {
                        showAllFriends(data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                })

            })

            function showAllFriends(data) {
                var usersListJson = JSON.parse(data);
                for (var i in usersListJson) {
                    // alert(allFriendsListJson[i].nickname)
                    var addUsers = '<div class="list-box">' +
                        '<img class="chat-head" src="" alt="">' +
                        '<div class="chat-rig">' +
                    '<p class="title">' + usersListJson[i].nickname + '</p>' +
                    '<p class="text">紧急！！！</p>' +
                    '</div>' +
                    '<button class="add-button">添加</button>' +
                    '</div>';
                    $(addUsers).appendTo(".search-result");
                }
            }

            $(".search-result").on('click', '.add-button', function (){
                $(this).attr('disabled', true)
                $(this).css('background-color', '#d9e0e8')
                $(this).text('已发送')
                var friendRequest = {}
                friendRequest.id = null
                friendRequest.senderName = "${sessionScope.userNickname}"
                friendRequest.receiverName = $(this).parent().find('.title').text()
                friendRequest.state = 0

                $.ajax({
                    url: "http://localhost:8080/FriendRequestServlet",
                    dataType: 'text',
                    type: 'post',
                    data: {"action":"saveFriendRequest","friendRequest":JSON.stringify(friendRequest)},
                    success: function () {
                        alert("请求发送成功")
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                })

            })
        }
    </script>

</head>
<body>
    <div class="search-top">
        <input type="text" name="searchInfo" placeholder="请输入待查询用户昵称" id="searchInfo">
        <button id="users-search-button">搜索</button>
    </div>
    <div class="search-result">
<%--        <div class="list-box">--%>
<%--            <img class="chat-head" src="" alt="">--%>
<%--            <div class="chat-rig">--%>
<%--                <p class="title">哈哈哈</p>--%>
<%--                <p class="text">紧急！！！</p>--%>
<%--            </div>--%>
<%--            <button class="add-button">添加</button>--%>
<%--        </div>--%>
    </div>
</div>
</body>
</html>