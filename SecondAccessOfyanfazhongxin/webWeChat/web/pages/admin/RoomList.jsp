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
      //展示和我有关的所有的群
      function showAllRooms(data) {
        var roomsListJson = JSON.parse(data);
        for (var i in roomsListJson) {
          var addUsers = '<div class="list-box">' +
                            '<div class="friend-box">' +
                            '<img class="chat-head" src="" alt="">' +
                            '<div class="chat-rig">' +
                              '<p class="title">' + roomsListJson[i] + '</p>' +
                             ' <p class="text">' + "聊天记录" + '</p>' +
                            '</div>' +
                              '</div>' +
                            '<div class="dropdown">' +
                              '<div class="send_room-news">发送群聊</div>' +
                              '<div class="delete-friend">退出该群</div>' +
                              '<div>举报该群</div>' +
                            '</div>' +
                          '</div>'
          $(addUsers).appendTo(".search-result");
        }
      }
      //跳转到聊天界面
      $('.search-result').on('click', '.send_room-news', function (){
        var roomName = $(this).parent().parent().find('.title').text()
        var url = "http://localhost:8080/pages/admin/HomeTest.jsp?roomName="+roomName
        window.location.href = url
      })

      //初始化我的所有群聊
      function initMyRoom(){
        $.ajax({
          url: "http://localhost:8080/RoomServlet",
          dataType: 'text',
          async: false,
          type: 'post',
          data: {"action":"queryMyJoinRoomByUserNickname", "userNickname":"${sessionScope.userNickname}"},
          success: function (data) {
            showAllRooms(data);
          },
          error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
            console.log(errorThrown);
          }
        })
      }
      initMyRoom()

    }
  </script>

</head>
<body>
<div class="search-top">
  <input type="text" name="searchInfo" placeholder="请输入待查询用户昵称" id="searchInfo">
  <button id="users-search-button">搜索</button>
</div>
<div class="search-result">
<%--  <div class="list-box">--%>
<%--    <div class="friend-box">--%>
<%--      <img class="chat-head" src="" alt="">--%>
<%--      <div class="chat-rig">--%>
<%--        <p class="title">哈哈哈</p>--%>
<%--        <p class="text">紧急！！！</p>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--    <div class="dropdown">--%>
<%--      <div>发送群聊</div>--%>
<%--      <div class="de-friend">拉黑好友</div>--%>
<%--      <div class="delete-friend">删除好友</div>--%>
<%--      <div>举报好友</div>--%>
<%--    </div>--%>
<%--  </div>--%>
</div>
</div>
</body>
</html>