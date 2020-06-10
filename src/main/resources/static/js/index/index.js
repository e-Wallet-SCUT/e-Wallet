$(function () {
    // $(document).ready(function(){
    //     $.ajax({
    //         url: "/info",
    //         type: "GET",
    //         data: {},
    //         success: function (result) {
    //             if (result!=null){
    //                 var userInfo = "<li><a href=\"\" class=\"scroll\">"+result+"</a><ul><li><a href='/logout'>logout</a></li></ul></li>"
    //                 $(".logibtn.gradient-btn").replaceWith(userInfo)
    //             }
    //
    //         }
    //     });
    // });

    $("#name").mousemove(function () {
        $("#userList").slideDown()
    })

    $("#name").mouseout(function () {
        $("#userList").slideUp();
    })

    $("#userList").mousemove(function () {
        $("#userList").slideDown()
    })

    $("#userList").mouseout(function () {
        $("#userList").slideUp();
    })



})