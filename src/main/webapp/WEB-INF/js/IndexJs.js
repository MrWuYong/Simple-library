$(function () {
   $("#topics li").click(getPostList);
   
   function getPostList() {
      var href =$(this).attr("value");
      $.get(href,postList);
   }
   function postList(data){
       var list = data.list;
       alert("成功");
       alert(list);
       console.dir(list);
       console.info(list);
   }
});