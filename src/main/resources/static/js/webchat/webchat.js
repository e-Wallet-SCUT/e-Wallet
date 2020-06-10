$(function () {
    //获取用户名
    $.ajax({
        url: "/info",
        type: "GET",
        data: {},
        success: function (username) {
            var webSocket;
            if ("WebSocket" in window)
            {
                webSocket = new WebSocket("ws://"+window.location.host+"/webchat/"+username);

                //连通之后的回调事件
                webSocket.onopen = function()
                {
                    //webSocket.send( username+"已经上线了");
                    $("#message").val($("#message").val()+"Hello!"+"\n");
                };

                //接收后台服务端的消息
                webSocket.onmessage = function (evt)
                {
                    var received_msg = evt.data;
                    var obj = JSON.parse(received_msg);
                    //1代表上线 2代表下线 3代表在线名单 4代表普通消息
                    if(obj.messageType==1){
                        //把名称放入到selection当中供选择
                        var onlineName = obj.username;
                        var option = "<option>"+onlineName+"</option>";
                        $("#onLineUser").append(option);
                        $("#message").val($("#message").val()+onlineName+"已上线"+"\n");
                    }
                    else if(obj.messageType==2){
                        $("#onLineUser").empty();
                        var onlineName = obj.onlineUsers;
                        var offlineName = obj.username;
                        var option = "<option>"+"--所有--"+"</option>";
                        for(var i=0;i<onlineName.length;i++){
                            if(!(onlineName[i]==username)){
                                option+="<option>"+onlineName[i]+"</option>"
                            }
                        }
                        $("#onLineUser").append(option);
                        $("#message").val($("#message").val()+offlineName+"已下线"+"\n");

                    }
                    else if(obj.messageType==3){
                        var onlineName = obj.onlineUsers;
                        var option = null;
                        for(var i=0;i<onlineName.length;i++){
                            if(!(onlineName[i]==username)){
                                option+="<option>"+onlineName[i]+"</option>"
                            }
                        }
                        $("#onLineUser").append(option);
                        $("#message").val($("#message").val()+"当前在线人数为"+onlineName.length+"\n");
                    }
                    else{
                        $("#message").val($("#message").val()+obj.fromusername+"对"+obj.tousername+"说："+obj.textMessage+"\n")
                    }
                };

                //连接关闭的回调事件
                webSocket.onclose = function()
                {
                    window.location.replace("/");
                    alert("Bye！")
                };
            }
            else{
                // 浏览器不支持 WebSocket
                alert("您的浏览器不支持 WebSocket!");
            }

            $("#close").click(function () {
                webSocket.close();
            })

            $("#send").click(function () {
                var selectText = $("#onLineUser").find("option:selected").text();
                if(selectText=="所有人"){
                    selectText = "All";
                }
                else{
                    $("#message").val($("#message").val()+username+"对"+selectText+"说："+ $("#text").val()+"\n")
                }
                var message = {
                    "message":$("#text").val(),
                    "username":username,
                    "to":selectText
                };
                webSocket.send(JSON.stringify(message));
                $("#text").val("");
            })
        }
    });
})