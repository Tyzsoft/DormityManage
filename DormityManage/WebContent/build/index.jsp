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
	 
	
	});
  
	
   function show(name,introd){
	   	  $("#name_thead").empty();
		  $("#details_thead").empty();
		  $("#name_thead").append("<tr><td>"+name+"</td></tr>");
		  $("#details_thead").append("<tr><td>"+introd+"</td></tr>");
		   
		  $('#doc-modal-1').modal({
		      target: this,
		      closeViaDimmer: 0, 
		      width: 400, 
		      height: 500
		    });
   }


  
  </script>
  
</head>
<body>
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"></strong> 宿舍楼管理</div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
          <div class="am-btn-group am-btn-group-xs">
            <a href="build_add"><button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button></a>
           
          </div>
        </div>
      </div>
      <div class="am-u-sm-12 am-u-md-3">
       
      </div>
   

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main" id="mytable">
            <thead>
              <tr>
                <th class="table-id">ID</th>
                <th class="table-title">名字</th>
                <th class="table-type">介绍</th>
                <th class="table-set">操作</th>
              </tr>
          </thead>
          <tbody>
          <s:iterator var="p" value="pageBean.list"> 
          
          	<tr style="height: 45px;overflow: hidden;">
          		<td>
          		<span>
					<s:property value="#p.bid"/>
				</span>
				
          		</td>
          		<td >
          		<a href="#" onclick="show('<s:property value="#p.name"/>','<s:property value="#p.introduction"/>')">
          		<span>
					<s:property value="#p.name"/>
				</span>
				</a>
				</td>
          		<td style="width: 520px;height:45px;overflow: height: 45px;">
          		<div style="height: 45px;overflow: hidden;"> 
          		<span>
					<s:property value="#p.introduction"/>
				</span>
				 	</div>
				</td>
          		 <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                  <a href="build_edit?bid=<s:property value="#p.bid"/>">
                   <span class="am-icon-pencil-square-o">编辑</span></a>
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
				<a href="build_findAll?page=<s:property value="pageBean.page-1"/>" >«</a>
			</li>
      </s:if>
      <s:else>
      		 <li class="am-disabled">
      		 <a href="build_findAll?page=1" >«</a>
      		 </li>
      </s:else>
      
     <s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page == #i">
					<li class="am-active">
					<a href="build_findAll?page=<s:property value="#i"/>">
					<s:property value="#i"/></a>
					</li>
				</s:if>
				<s:else>
					<li >
					<a href="build_findAll?page=<s:property value="#i"/>">
					<s:property value="#i"/></a>
					</li>
				</s:else>
	</s:iterator>
	<s:if test="pageBean.page != pageBean.totalPage">	
		<li>
		<a  href="build_findAll?page=<s:property value="pageBean.page+1"/>">»</a>
		</li>		
	</s:if>
	<s:else>
		<li class="am-disabled">
		<a  href="build_findAll?page=<s:property value="pageBean.totalPage"/>">»</a>
		</li>
	</s:else>
    </ul>
  </div>
         </div>
        </form>
      </div>

    </div>
    
    
   <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">
	 	<table class="am-table am-table-bordered am-table-radius am-table-striped" id="name_thead">
                   
      	</table>
		 <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd">
       <table class="am-table am-table-bordered am-table-radius am-table-striped">
                    <thead id="details_thead">
                    </thead>
      </table>
    </div>
  </div>
</div>







</body>
</html>