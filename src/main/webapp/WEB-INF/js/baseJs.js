$(function () {
    $("form").submit(function (e) {
        var values = $("input");
        for(var i=0;i<values.length-1;i++){
            var value = values.eq(i).val();
            if(value == null || value== ""){
                $(this).next().html("不可为空！");
                return false;
            }
        }
    });
});