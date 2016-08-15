<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>宿舍管理系统</title>
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/amazeui.min.js"></script>
  
  <script type="text/javascript">
   $(function() {
		 
		  $('#form1').submit(function() {
			  var phone = document.getElementById("telephone").value;
	       		var name = $("#name").val();
	       		var card = $("#card").val();
	       		var xh = $("#xh").val();
	       		var teacher = $("#teacher").val();
	       		var grader = $("#grader").val();
	       		var profession = $("#profession").val();
	       		var re1 = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;//电话号码
	       		var re2 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;//身份证
	       		var flag = true;
	       		
	       		if(name==""){
	       			flag = false;
	       			$("#name").attr('placeholder','名字不能为空').css("border","1px solid red");
	       			return false;
	       			
	       		}
	       		
	       		if(card == ""){
	       			flag = false;
	       			$("#card").attr('placeholder','身份证号码不能为空').css("border","1px solid red");
	       			return false;
	       		}
	       		if(phone == ""){
	       			flag = false; 
	       			$("#telephone").attr('placeholder','电话号码不能为空').css("border","1px solid red");
	       			return false;	
	       		}
	       		if(!re1.test(phone)){
	       			flag = false; 
	       			$("#telephone").attr('placeholder','电话号码格式错误').css("border","1px solid red");
	       			return false;
	       		}
	       		if(!re2.test(card)){
	       			flag = false; 
	       			$("#card").attr('placeholder','身份证号码不合法').css("border","1px solid red");
	       			return false;
	       		}
	       	
		  });
		  
	});
	  

  </script>
</head>
<body>

<div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">宿舍楼添加</strong></div>
    </div>

    <hr/>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="am-g">
              <div class="am-u-md-4">
                <img class="am-img-circle am-img-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/200/h/200/q/80" alt=""/>
              </div>
              <div class="am-u-md-8">
              
                <form class="am-form">
                  <div class="am-form-group">
                    <p>情在同甘共苦中传达</p>
                    <p>俭在节水节电中歌颂</p>
                    <p>洁在一角一落中展现</p>
                    <p>悦在欢声笑语中流漏</p>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="user-info">
             <p>微笑是寝室的吸引力，</p> 
             <P>文明是寝室的原动力。</P>
             <P>寝室文明有风采，共建和谐好家园。</P>
            </div>
            <div class="user-info">
             	<a>
             	<p>海乃百川，有容乃大；</p>
             	<p>我们屋虽不大，却窗明几净；</p>
             	<p>人虽不同，却其乐融融。</p>
             	</a>
            </div>
          </div>
        </div>

      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
      
        <form class="am-form am-form-horizontal" id="form1" name="form1" action="stu_addstu" method="post">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">姓名</label>
            <div class="am-u-sm-9">
              <input type="text" id="name"  name="name" placeholder="输入你的姓名 ">
            </div>
          </div>

         <div class="am-g am-margin-top-sm" style="margin-left: 2px;">
             <label for="user-name" class="am-u-sm-3 am-form-label">
             	学号</label>
            <div class="am-u-sm-8 am-u-md-4 am-u-end" style="width:492px;">
             <input type="text" id="xh"  name="xh" placeholder="输入学号 ">
            </div>
          </div>
          <div class="am-g am-margin-top-sm" style="margin-left: 2px;">
             <label for="user-name" class="am-u-sm-3 am-form-label">
             	电话</label>
            <div class="am-u-sm-8 am-u-md-4 am-u-end" style="width:492px;">
              <input type="text" id="telephone"  name="telephone" placeholder="输入电话号码 ">
            </div>
          </div>
          <div class="am-g am-margin-top-sm" style="margin-left: 2px;">
             <label for="user-name" class="am-u-sm-3 am-form-label">
             	身份证号</label>
            <div class="am-u-sm-8 am-u-md-4 am-u-end" style="width:492px;">
              <input type="text" id="card"  name="card" placeholder="输入身份证号 ">
            </div>
          </div>
          
          <div class="am-g am-margin-top-sm" style="margin-left: 2px;">
             <label for="user-name" class="am-u-sm-3 am-form-label">
             	辅导员</label>
            <div class="am-u-sm-8 am-u-md-4 am-u-end" style="width:492px;">
              <input type="text" id="teacher"  name="teacher" placeholder="输入辅导员名字 ">
            </div>
          </div>
          <div class="am-g am-margin-top-sm" style="margin-left: 2px;">
             <label for="user-name" class="am-u-sm-3 am-form-label">
             	年级</label>
            <div class="am-u-sm-8 am-u-md-4 am-u-end" style="width:492px;">
              <input type="text" id="grader"  name="grader" placeholder="输入年级 ">
            </div>
          </div>
          <div class="am-g am-margin-top-sm" style="margin-left: 2px;">
             <label for="user-name" class="am-u-sm-3 am-form-label">
             	专业</label>
            <div class="am-u-sm-8 am-u-md-4 am-u-end" style="width:492px;">
              <input type="text" id="profession"  name="profession" placeholder="输入专业 ">
            </div>
          </div>
          <div class="am-g am-margin-top-sm" style="margin-left: 2px;">
             <label for="user-name" class="am-u-sm-3 am-form-label">
             	宿舍</label>
            
             <select id="doc-select-1" style="margin-left: 190px;width:455px;" name="dor">
      			<s:iterator var="b" value="dbList" id="b">
      				<option value="<s:property value="b"/>">
      					<s:property value="b"/>
      				</option>
      			</s:iterator>
      		</select>
      
      		<span class="am-form-caret"></span>
            
          </div>
           
           
          
          <div class="am-form-group" style="margin-top: 20px;">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <input type="submit" id="submit" class="am-btn am-btn-primary" value="提交"></input>
              <input type="reset" class="am-btn am-btn-primary" style="margin-left: 100px;"></input>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>