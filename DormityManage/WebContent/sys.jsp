<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
  	
  $(function() {
	  $('#doc-prompt-toggle').on('click', function() {
	    $('#my-prompt').modal({
	      relatedTarget: this,
	      onConfirm: function(e) {
	       		var phone = document.getElementById("phone").value;
	       		var name = $("#name").val();
	       		var card = $("#card").val();
	       		var address = $("#address").val();
	       		var pwd = $("#pwd").val();
	       		var re1 = /^1\d{10}$/;//电话号码
	       		var re2 = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;//身份证
	       		var flag = true;
	       		
	       		if(name==""){
	       			flag = false;
	       			$("#name").attr('placeholder','名字不能为空');
	       		}
	       		if(pwd == ""){
	       			flag = false;
	       			$("#pwd").attr('placeholder','密码不能为空');
	       		}
	       		if(address == ""){
	       			flag = false;
	       			$("#address").attr('placeholder','地址不能为空');
	       		}
	       		if(card == ""){
	       			flag = false;
	       			$("#card").attr('placeholder','身份证号码不能为空');
	       		}
	       		if(phone == ""){
	       			flag = false; 
	       			$("#phone").attr('placeholder','电话号码不能为空');
	       		}
	       		
	       		if(re1.test(phone)){
	       			flag = false;
	       			$("#phone").attr('placeholder','电话号码格式错误');
	       		}
	       		
	       		if(re2.test(card)){
	       			flag = false;
	       			$("#card").attr('placeholder','身份证号格式错误');
	       		}
	       		if(flag){
	       			alert("ok");
	       		}
	       		
	       		
	      },
	      onCancel: function(e) {
	      }
	    });
	  });
	  
	
	});
  
	


  function del(id){
	 
		 $('#my-confirm').modal({
		        relatedTarget: this,
		        onConfirm: function(options) {
		        	$('#sid').attr('value',id); 

		          $("#deleteform").submit();
		        },
		        onCancel: function() {
		        
		        }
		      });

  }
	  
  </script>
  
</head>
<body>
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"></strong> 宿舍管理员管理</div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
          <div class="am-btn-group am-btn-group-xs">
            <a href="sys_findProvince"><button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button></a>
           
          </div>
        </div>
      </div>
      <div class="am-u-sm-12 am-u-md-3">
       
      </div>
      <div class="am-u-sm-12 am-u-md-3">
      <form action="sys_find">
        <div class="am-input-group am-input-group-sm">
          <input type="text" name="name" class="am-form-field">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="submit">搜索</button>
          </span>
        </div>
        </form>
      </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-id">ID</th>
                <th class="table-title">用户名</th>
                <th class="table-type">性别</th>
                <th class="table-author am-hide-sm-only">电话</th>
                <th class="table-date am-hide-sm-only">身份证号</th>
                <th class="table-set">地址</th>
                <th class="table-set">寝室楼</th>
                <th class="table-set">操作</th>
              </tr>
          </thead>
          <tbody>
          <s:iterator var="p" value="pageBean.list"> 
          	<tr>
          		<td>
          		<span>
					<s:property value="#p.sid"/>
				</span>
          		</td>
          		<td>
          		<span>
					<s:property value="#p.name"/>
				</span>
				</td>
          		<td>
          		<span>
					<s:property value="#p.gender"/>
				</span>
          		</td>
          		<td>
          		<span>
					<s:property value="#p.telephone"/>
				</span>
          		</td>
          		<td>
          		<span>
					<s:property value="#p.card"/>
				</span>
          		</td>
          		<td>
          		<span>
					<s:property value="#p.address"/>
				</span>
          		</td>
          		<td>
          		<span>
					<s:property value="#p.building.name"/>
				</span>
          		</td>
          		 <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                  <a href="sys_edit?sid=<s:property value="#p.sid" />">
                   <span class="am-icon-pencil-square-o">编辑</span></a>
                    </div>
                   <div class="am-btn-group am-btn-group-xs">
                    <a href="#" onclick="del(<s:property value="#p.sid" />)">
                   <span class="am-icon-pencil-square-o" >删除</span></a>
                   
                  </div>
                </div>
               
              </td>
              
          		
          	</tr>
         </s:iterator>
          </tbody>
        </table>
          <div class="am-cf">
  <span>第 <s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/> 页</span>
<div class="am-fr">
    <ul class="am-pagination">
  
      <s:if test="pageBean.page!=1">
      		<li>
				<a href="sys_index?page=<s:property value="pageBean.page-1"/>" >«</a>
			</li>
      </s:if>
      <s:else>
      		 <li class="am-disabled">
      		 <a href="sys_index?page=1" >«</a>
      		 </li>
      </s:else>
      
     <s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page == #i">
					<li class="am-active">
					<a href="sys_index?page=<s:property value="#i"/>">
					<s:property value="#i"/></a>
					</li>
				</s:if>
				<s:else>
					<li >
					<a href="sys_index?page=<s:property value="#i"/>">
					<s:property value="#i"/></a>
					</li>
				</s:else>
	</s:iterator>
	<s:if test="pageBean.page != pageBean.totalPage">	
		<li>
		<a  href="sys_index?page=<s:property value="pageBean.page+1"/>">»</a>
		</li>		
	</s:if>
	<s:else>
		<li class="am-disabled">
		<a  href="sys_index?page=<s:property value="pageBean.totalPage"/>">»</a>
		</li>
	</s:else>
    </ul>
  </div>
         </div>
        </form>
      </div>

    </div>
    
    
   

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
   <form action="sys_delete" id="deleteform">
   <input type="hidden" name="sid" id="sid">
    <div class="am-modal-bd">
      你，确定要删除这条记录吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
    </form>
  </div>
</div>





</body>
</html>