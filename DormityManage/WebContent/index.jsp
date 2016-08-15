<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>宿舍管理系统</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <style>
    .get {
      background: #1E5B94;
      color: #fff;
      text-align: center;
      padding: 100px 0;
    }

    .get-title {
      font-size: 200%;
      border: 2px solid #fff;
      padding: 20px;
      display: inline-block;
    }

    .get-btn {
      background: #fff;
    }

    .detail {
      background: #fff;
    }

    .detail-h2 {
      text-align: center;
      font-size: 150%;
      margin: 40px 0;
    }

    .detail-h3 {
      color: #1f8dd6;
    }

    .detail-p {
      color: #7f8c8d;
    }

    .detail-mb {
      margin-bottom: 30px;
    }

    .hope {
      background: #0bb59b;
      padding: 50px 0;
    }

    .hope-img {
      text-align: center;
    }

    .hope-hr {
      border-color: #149C88;
    }

    .hope-title {
      font-size: 140%;
    }

    .about {
      background: #fff;
      padding: 40px 0;
      color: #7f8c8d;
    }

    .about-color {
      color: #34495e;
    }

    .about-title {
      font-size: 180%;
      padding: 30px 0 50px 0;
      text-align: center;
    }

    .footer p {
      color: #7f8c8d;
      margin: 0;
      padding: 15px 0;
      text-align: center;
      background: #2d3e50;
    }
  </style>
</head>
<body>
<header class="am-topbar am-topbar-fixed-top">
  <div class="am-container">
    <h1 class="am-topbar-brand">
      <a href="#">宿舍管理系统</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-secondary am-show-sm-only"
            data-am-collapse="{target: '#collapse-head'}"><span class="am-sr-only">导航切换</span> <span
        class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="collapse-head">
      <ul class="am-nav am-nav-pills am-topbar-nav">
        <li class="am-active"><a href="#">首页</a></li>
       
      </ul>

      <div class="am-topbar-right">
       <a href="login.jsp"> <button class="am-btn am-btn-primary am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</button></a>
      </div>
    </div>
  </div>
</header>

<div class="get" >
  <div class="am-g">
    <div class="am-u-lg-12">
      <h1 class="get-title">宿舍管理系统</h1>

      <p>
        期待你的参与，共同打造一个属于我们的大家庭
      </p>

      <p>
    
      </p>
    </div>
  </div>
</div>

<div class="detail">
  <div class="am-g am-container">
    <div class="am-u-lg-12">
      <h2 class="detail-h2">我们期待和你一起去实现一个温馨的大家庭!</h2>

      <div class="am-g">
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">

          <h3 class="detail-h3">
            <i class="am-icon-mobile am-icon-sm"></i>
           为服务而生
          </h3>

          <p class="detail-p">
           提供卫生，环境，安全保障，设施维护，业余文化建设，生理、心理卫生的疏导和教育，以及提供其他生活服务，实行目标化管理，精细化管理，人性化管理的后勤外包服务。 </p>
        </div>
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-cogs am-icon-sm"></i>
            组织清楚，分工明确
          </h3>

          <p class="detail-p">
           我们提供服务给学生，既是服务提供者，也是服务监管者。</p>
        </div>
       
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-send-o am-icon-sm"></i>
            方便，高效率
          </h3>

          <p class="detail-p">
           	宿舍的管理和服务是持续性的，实现了目标化管理。管理更有针对性，目标明确，责任更明确，并且能够项目考核，满意度考核，管理效果比较明显。</p>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="hope">
  <div class="am-g am-container">
    <div class="am-u-lg-4 am-u-md-6 am-u-sm-12 hope-img">
      <img src="assets/i/examples/landing.png" alt="" data-am-scrollspy="{animation:'slide-left', repeat: false}">
      <hr class="am-article-divider am-show-sm-only hope-hr">
    </div>
    <div class="am-u-lg-8 am-u-md-6 am-u-sm-12">
      <h2 class="hope-title">同我们一起打造大家的“家”</h2>

      <p>
        在匆匆四年中，我们不愿成为这里的过客，拥抱长理文化，发挥我们的力量，参与到我们的大家庭中来。
      </p>
    </div>
  </div>
</div>



<footer class="footer">
  <p>© 2016 <a href="http://www.yunshipei.com" target="_blank">长沙理工大学计算机与通信工程学院</a>. by the Sofe Team.</p>
</footer>



<script src="assets/js/jquery.min.js"></script>

<script src="assets/js/amazeui.min.js"></script>
</body>
</html>
