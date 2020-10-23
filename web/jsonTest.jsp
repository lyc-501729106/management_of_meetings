<%--
  Created by IntelliJ IDEA.
  User: 译辰哥哥
  Date: 2020/10/14
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    <script type="text/javascript" src="./js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        function testName() {
            alert("testName")
            $.get("JudeServ", { uname: $("#uname").val()  },
                //以下方法的data即为servlet的返回值，我们现在希望 servlet的返回值为一个 json格式的数据
                //数据内容为：boolean类型的 flag ,字符串类型的result
                function(data){
                    if(data.flag){
                        $("#showname").html(data.result)  ;
                    }else{
                        alert("sdd");
                        $("#showname").html(data.result)  ;
                    }

                } , "json"); //保持传递过来的为一个json数据

        }
        function loadXMLDoc() {
            //var no = document.getElementById("phoneno") ;
            $.ajax({
                type : "POST",
                url : "JudeServ",
                data : "phoneno=" + $("#phoneno").val(),
                success : function(msg) {
                    //alert(msg) ;
                    $("#show").html(msg) ;
                    // document.getElementById("show").innerHTML = msg ;
                }
            });
        }
    </script>
</head>
<body>
<form>
    <input id="uname" value="tom">
    <input type="button" value="按钮" onclick="testName()"><span id="showname">这里显示内容</span>
</form>

</body>
</html>
