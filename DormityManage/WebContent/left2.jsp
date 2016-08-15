<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>宿舍管理系统</title>
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/amazeui.min.js"></script>
  <script src="assets/js/app.js"></script>
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
   <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>
<body>
	 <ul class="am-list admin-sidebar-list">
        <li><a href="admin-index.jsp" target="mainFrame"><span class="am-icon-home"></span> 首页</a></li>
        <li><a href="stu_findAll?page=1" target="mainFrame"><span class="am-icon-table" >学生管理</span> </a></li>
        <li><a href="dor_findAll?page=1" target="mainFrame"><span class="am-icon-sign-out" ></span> 寝室管理</a></li>
        <li><a href="lack_findAll?page=1" target="mainFrame"><span class="am-icon-sign-out" ></span> 缺勤管理</a></li>
      </ul>
	<div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>时光静好，与君语；细水流年，与君同。—— 管理员</p>
        </div>
      </div>
</body>
</html>