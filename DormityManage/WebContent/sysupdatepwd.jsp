<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>宿舍管理系统</title>
  <meta name="description" content="这是一个form页面">
  <meta name="keywords" content="form">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
  
  <script type="text/javascript">
  function checkPwd() {
	var oldPwd = document.getElementById("oldPwd").value;
	var newPwd = document.getElementById("newPwd").value;
	var rePwd = document.getElementById("rePwd").value;
	if(oldPwd == ""){
		  alert("密码不能为空");
	  
	}
	 if(newPwd == ""){
		 alert("密码不能为空");
	  }
	 if(rePwd == ""){
		 alert("密码不能为空");
	  }
	 
	if(rePwd != newPwd){
		alert("输入两次密码不同;");
		return false;
	}else{
		document.getElementById("update").submit();
	}

	
  } 
  
  function checkOld(){
	    var oldPwd = document.getElementById("oldPwd").value;
		if(oldPwd == ""){
			  document.getElementById("old").innerHTML="密码不能为空";
		  
		}
  }
  function  checkNew() {
	  var newPwd = document.getElementById("newPwd").value;
	 
	  if(newPwd == ""){
		  document.getElementById("new").innerHTML="密码不能为空";
	  }
	}
  function  checkRe() {
	 
	  var rePwd = document.getElementById("rePwd").value;
	  if(rePwd == ""){
		  document.getElementById("re").innerHTML="密码不能为空";
	  }
	}
  </script>
  
</head>
<body>

<!-- content start -->
<div class="admin-content">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改密码</strong> / <small>Update Password</small></div>
  </div>

  <div class="am-tabs am-margin" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li class="am-active"><a href="#tab1">修改密码</a></li>
    
    </ul>

     
        <form id="update" class="am-form"  action="sys_updatePwd" method="post">
        <s:actionerror/>
        <div class="am-g am-margin-top" >
            <div class="am-u-sm-4 am-u-md-2 am-text-right" style="margin-left: -60px">
           	   原来密码:
            </div>
            <div class="am-u-sm-8 am-u-md-4" style="margin-right: 500px">
              <input type="password" class="am-input-sm" name="oldPwd" id="oldPwd" onchange="checkOld()">
            </div>
            <div><span id="old" style="margin-left: -500px"></span></div>
         </div>
          <div class="am-g am-margin-top" >
            <div class="am-u-sm-4 am-u-md-2 am-text-right" style="margin-left: -77px">
           	  新密码:
            </div>
            <div class="am-u-sm-8 am-u-md-4" style="margin-left: 15px">
              <input type="password" class="am-input-sm" name="newPwd" id="newPwd" onchange="checkNew()">
            </div>
           	<div><span id="new" ></span></div>
         </div>
         <div class="am-g am-margin-top" >
            <div class="am-u-sm-4 am-u-md-2 am-text-right" style="margin-left: -55px">
           	  确认密码：
            </div>
            <div class="am-u-sm-8 am-u-md-4" style="margin-right: 500px">
              <input type="password" class="am-input-sm" name="rePwd" id="rePwd" onchange="checkRe()">
            </div>
  			<div><span id="re" style="margin-left: -500px"></span></div>
         </div>
        </form>
     
    </div>
  </div>

  <div class="am-margin">
    <button type="button" class="am-btn am-btn-primary am-btn-xs" onclick="checkPwd()">提交保存</button>
    <a href="welcome.jsp"><button type="button" class="am-btn am-btn-primary am-btn-xs" >放弃保存</button></a>
  </div>
</div>
<!-- content end -->

</div>



<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
