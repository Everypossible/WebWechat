<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        body{
            background-color: rgba(75,216,254,.1);
        }
        /*容器样式*/
        .title-top{
            margin-left: 700px;
            margin-top: 25px;
        }
        .friend-list{
            width: 255px;
            height: 700px;
            margin-left: 200px;
            margin-top: 30px;
            border: #222222 2px solid;
            overflow: auto;

        }
        .member-list{
            width: 780px;
            height: 700px;
            border: #222222 2px solid;
            position: relative;
            top: -704px;
            left: 457px;
            overflow: auto;
            /*消除本元素原来占的位置*/
            margin-bottom: -650px;
        }
        .create-div{
            position: relative;
            top: -40px;
            left: 950px;
            width: 300px;
            height: 30px;
            /*border: #222222 2px solid;*/
        }

        /*每个好友的样式*/
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
        /*小细节的样式*/
        .member-list-title{
            margin-left: 10px;
            margin-top: 5px;
        }
        .add-button{
            float: left;
        }
        .room-name-input{
            font-size: 20px;
            width: 200px;
        }
        .create-button{
            color: white;
            background-color: rgb(58,146,217);
        }

    </style>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        window.onload = function (){
            //在好友列表中加载出我的所有好友
            $.ajax({
                url: "http://localhost:8080/FriendsServlet",
                dataType: 'text',
                type: 'post',
                // data: "action=msgSendToMySQL" & "msg="+JSON.stringify(msg),
                data: "action=showAllFriends",
                // contentType: 'application/json;charset=utf-8',
                success: function (data){
                    showAllFriends(data);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                    console.log(errorThrown);
                }
            })
            function showAllFriends(data) {
                var allFriendsListJson = JSON.parse(data);
                for (var i in allFriendsListJson){
                    // alert(allFriendsListJson[i].nickname)
                    var addFriends = '<div class="list-box"><img class="chat-head" src="" alt="头像">' +
                        '<div class="chat-rig">' +
                        '<p class="title">' + allFriendsListJson[i].nickname + '</p>' +
                        '<p class="text">个性签名</p>' +
                        '</div>' +
                        '<button class="add-button">加入该群</button>'
                        '</div>';
                    $(addFriends).appendTo(".friend-list");
                    // console.log($(addFriends))
                }
                // alert(allFriendsListJson);
            }

            // 将好友添加进群员列表
            $("body").on('click', ".add-button", function (){
                if ($(this).text() == "加入该群"){
                    $(this).text("取消加入")
                    $(this).parent().appendTo($(".member-list"))
                } else {
                    $(this).text("加入该群")
                    $(this).parent().prependTo($(".friend-list"))
                }
            })

            //获取群成员列表的所有成员的用户名
            $(".create-button").on('click', function (){
                if ($(".member-list").children().length == 1) {
                    alert("群成员不能为空")
                } else if ($(".room-name-input").val() == ""){
                    alert("群名称不能为空")
                } else {
                    //将群名称和群成员发送到后台
                    var members = new Array()
                    $(".member-list .title").each(function (){
                        members.push($(this).text())
                    })
                    // alert(members[0])
                    $.ajax({
                        url: "http://localhost:8080/RoomServlet",
                        // dataType: 'json',
                        type: 'post',
                        // data: "action=msgSendToMySQL" & "msg="+JSON.stringify(msg),
                        data: {"members":JSON.stringify(members), "action":"createRoom", "roomNickname":$(".room-name-input").val()},
                        // contentType: 'application/json;charset=utf-8',
                        success: function (){
                            alert("创建成功")
                            history.go(0)
                        },
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                            console.log(XMLHttpRequest.status);
                            console.log(XMLHttpRequest.readyState);
                            console.log(textStatus);
                        }

                    })

                }
            })
        }
    </script>
</head>
<body>
<div>
  <div>
      <div class="title-top">创建群聊</div>

      <div class="friend-list">
<%--          <div class="list-box">--%>
<%--              <img class="chat-head" src="" alt="">--%>
<%--              <div class="chat-rig">--%>
<%--                  <p class="title">测试</p>--%>
<%--                  <p class="text">紧急！！！</p>--%>
<%--              </div>--%>
<%--              <button class="add-button">加入该群</button>--%>
<%--          </div>--%>
      </div>

      <div class="member-list">
          <div class="member-list-title">已加入群聊：</div>

              <div class="list-box">
                  <img class="chat-head" src="" alt="">
                  <div class="chat-rig">
                      <p class="title">${sessionScope.userNickname}</p>
                      <p class="text">个性签名</p>
                  </div>
                  <button disabled="disabled" class="add-button">已加入</button>
             </div>
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--              <button class="add-button">加入该群</button>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--              <button class="add-button">加入该群</button>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--              <button class="add-button">加入该群</button>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
<!--          <div class="list-box">-->
<!--              <img class="chat-head" src="" alt="">-->
<!--              <div class="chat-rig">-->
<!--                  <p class="title">哈哈哈</p>-->
<!--                  <p class="text">紧急！！！</p>-->
<!--              </div>-->
<!--          </div>-->
      </div>
      <div class="create-div">
          <input type="text" class="room-name-input">
          <button class="create-button">创建群聊</button>
      </div>
  </div>
</div>
</body>
</html>