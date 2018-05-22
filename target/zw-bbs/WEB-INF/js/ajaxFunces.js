$(function() {
    pwdHide();


    $("#oldPwd").blur(function () {
        var hid = $("#id").val().trim();
        var password = $(this).val().trim();
        $.post("checkPwd", {"password": password, "id": hid}, rollback);

        function rollback(data) {

            if (data==1){
                pwdShow();
                $("#checkInfo").addClass("checkFalse").text("验证成功");
            }
            if (data==0){
                pwdHide();
                $("#checkInfo").addClass("checkFalse").text("验证失败");
            }
        }
    });
    function pwdHide() {
        $("#rePassword").parent().hide();
        $("#password").parent().hide();
    }
    function pwdShow() {
        $("#rePassword").parent().show();
        $("#password").parent().show();
    }
});