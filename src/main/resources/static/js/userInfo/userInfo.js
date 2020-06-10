$(function () {
    $("#update").click(function () {
        var input = $("input")
        for(var i = 2;i<input.length;i++){
            input[i].removeAttribute("disabled")
        }
        input[input.length-1].type = "date"
        // $("input").removeAttr("disabled")
        $("#update").hide()
        $("#save").show()
        $("#cancel").show()
    })
    $("#cancel").click(function () {
        window.location.href = "/userInfo"
    })
    $("#save").click(function(){
        var data = {}
        var input = $("input")
        for(var i = 2;i<input.length;i++){
            if (input[i].value == ""){
               data[input[i].id] = input[i].placeholder
            }
            else{
                data[input[i].id] = input[i].value
            }
        }
        $.ajax({
            url:"/updateUserInfo",
            type:"GET",
            data: data,
            success: function (result) {
                alert("修改成功")
                window.location.href = "/userInfo"
            }
        })
    })
    $("#back").click(function () {
        window.location.href = "/"
    })

})