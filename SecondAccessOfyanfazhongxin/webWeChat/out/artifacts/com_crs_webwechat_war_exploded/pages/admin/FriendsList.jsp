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
      width: 850px;
      height: 900px;
      margin-top: 50px;
      margin-left: 400px;
    }

    .list-box{
      height: 100px;
      width: 250px;
      display: inline-block;
      margin-top: 100px;
    }
    .friend-box {
      height: 100px;
      width: 250px;
      display: inline-block;
      cursor: pointer;
    }

    .friend-box.select {
      background-color: #dbdbdb;
    }

    .friend-box:hover {
      background-color: #dbdbdb;
    }

    .friend-box img.chat-head {
      height: 50px;
      width: 50px;
      border-radius: 50%;
      border: 1px solid #f4f4f4;
      margin: 15px 10px;
    }

    .friend-box .chat-rig {
      float: right;
      height: 50px;
      width: 178px;
      margin: 15px 0;
    }

    .friend-box .chat-rig .title {
      font-weight: 600;
      font-size: 17px;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }

    .friend-box .chat-rig .text {
      font-size: 12px;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
      color: #6C6C6C;
    }

    .add-button{
      float: left;
    }
    .dropdown{
      border: solid 1px #c7c6c6;
      float: right;
      position: relative;
      display: none;
    }
    .dropdown div{
      margin-top: 3px;
      cursor: pointer;
    }
    .show{
      display: block;
    }
  </style>

  <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
    window.onload = function () {
      //点击展示下拉菜单
      $('.search-result').on('click', '.friend-box', function (){
        // alert("点中了")
        $(this).next().toggleClass('show')
      })
      //点击发送消息，跳转到聊天界面
      $('.search-result').on('click', '.send_room-news', function (){
        var roomName = $(this).parent().parent().find('.title').text()
        var url = "http://localhost:8080/pages/admin/HomeTest.jsp?roomName="+roomName
        window.location.href = url
      })
      //点击拉黑好友
      $('.de-friend').on('click', function () {
        alert('开始执行拉黑')
        //将拉黑操作指令传输到后台
        $.ajax({
          url: "http://localhost:8080/FriendsServlet",
          type: "post",
          data: {"action": "deFriend", "friendNickname": $(this).parent().parent().find('.title').text()},
          dataType: "text",
          success: function () {
            alert("传输成功")
          },
          error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
            console.log(errorThrown);
          }
        });
      })
        //点击删除好友
        $('.delete-friend').on('click', function (){
          alert('开始执行删除')
          //将拉黑操作指令传输到后台
          $.ajax({
            url: "http://localhost:8080/FriendsServlet",
            type: "post",
            data: {"action":"deleteFriend","friendNickname":$(this).parent().parent().find('.title').text()},
            dataType: "text",
            success: function(){
              alert("传输成功")
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
              console.log(XMLHttpRequest.status);
              console.log(XMLHttpRequest.readyState);
              console.log(textStatus);
              console.log(errorThrown);
            }
          });
        //将这个好友卡片移出该界面
        $(this).parent().parent().remove()
      })

      //在用户列表中加载出我搜索的用户
      $("#users-search-button").on('click', function (){
        $(".search-result").empty()
        $.ajax({
          url: "http://localhost:8080/UserDetailsServlet",
          dataType: 'text',
          type: 'post',
          data: {"action":"userDetailsSearch","searchInfo":$("#searchInfo").val()},
          success: function (data) {
            showSearchResult(data);
          },
          error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
            console.log(errorThrown);
          }
        })

      })

      function showSearchResult(data) {
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
      //初始化好友列表
      function initFriendList(){
        $.ajax({
          url: "http://localhost:8080/FriendsServlet",
          dataType: 'text',
          type: 'post',
          data: {"action":"showAllFriends"},
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
      }
      function showAllFriends(data){
        var FriendsListJson = JSON.parse(data);
        for (var i in FriendsListJson) {
          // alert(allFriendsListJson[i].nickname)
          var addUsers = '<div class="list-box">' +
                            '<div class="friend-box">' +
                              '<img class="chat-head" src="" alt="">' +
                                '<div class="chat-rig">' +
                                  '<p class="title">' + FriendsListJson[i].nickname + '</p>' +
                                  '<p class="text">' + '个性签名' + '</p>' +
                                '</div>' +
                            '</div>' +
                            '<div class="dropdown">' +
                              '<div class="send_room-news">发送消息</div>' +
                              '<div class="de-friend">拉黑好友</div>' +
                              '<div class="delete-friend">删除好友</div>' +
                              '<div>举报好友</div>' +
                            '</div>' +
                          '</div>';
          $(addUsers).appendTo(".search-result");
        }
      }
      initFriendList()

    }
  </script>

</head>
<body>
<div class="search-top">
  <input type="text" name="searchInfo" placeholder="请输入待查询用户昵称" id="searchInfo">
  <button id="users-search-button">搜索</button>
</div>
<div class="search-result">
<!--  <div class="list-box">-->
<!--    <div class="friend-box">-->
<!--      <img class="chat-head" src="" alt="">-->
<!--      <div class="chat-rig">-->
<!--        <p class="title">哈哈哈</p>-->
<!--        <p class="text">紧急！！！</p>-->
<!--      </div>-->
<!--    </div>-->
<!--    <div class="dropdown">-->
<!--      <div>发送消息</div>-->
<!--      <div class="de-friend">拉黑好友</div>-->
<!--      <div class="delete-friend">删除好友</div>-->
<!--      <div>举报好友</div>-->
<!--    </div>-->
<!--  </div>-->
</div>
</div>
</body>
</html>