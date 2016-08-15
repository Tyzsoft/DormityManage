<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <script src="assets/js/app.js"></script>
  <script type="text/javascript">
  $('#your-slider').flexslider({
	  playAfterPaused: 8000,
	  before: function(slider) {
	    if (slider._pausedTimer) {
	      window.clearTimeout(slider._pausedTimer);
	      slider._pausedTimer = null;
	    }
	  },
	  after: function(slider) {
	    var pauseTime = slider.vars.playAfterPaused;
	    if (pauseTime && !isNaN(pauseTime) && !slider.playing) {
	      if (!slider.manualPause && !slider.manualPlay && !slider.stopped) {
	        slider._pausedTimer = window.setTimeout(function() {
	          slider.play();
	        }, pauseTime);
	      }
	    }
	  }
	  // 设置其他参数
	});
  
  </script>
</head>
<body style="height: 500px;">
<div class="am-slider am-slider-default" data-am-flexslider="{playAfterPaused: 8000}" id="your-slider" style="height: 500px;">
  <ul class="am-slides" style="height: 500px;">
    <li style="height: 500px;"><img src="image/1.png" /></li>
    <li style="height: 500px;"><img src="image/2.png" /></li>
    <li style="height: 500px;"><img src="image/3.png" /></li>
    <li style="height: 500px;"><img src="image/4.png" /></li>
    <li style="height: 500px;"><img src="image/5.png" /></li>
    <li style="height: 500px;"><img src="image/6.png" /></li>
    <li style="height: 500px;"><img src="image/7.png" /></li>
  </ul>
</div>
</body>
</html>