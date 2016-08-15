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
  
	function change(id) {
		 $("#sid").attr('value',id);
		  var sid = $("#sid").val(); 
		 
		  $('#my-prompt').modal({
		      relatedTarget: this,
		      onConfirm: function(e) {
		    	
		    	 $("#dorform").submit();
		      },
		      onCancel: function(e) {
		       
		      }
		    });
	}


	 function del(id){
		 $("#ssid").attr('value',id);
		 var td = $("#ssid").val();
		
		 $('#my-confirm').modal({
		        relatedTarget: this,
		        onConfirm: function(options) {
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"></strong> 学生管理</div>
    </div>

    <div class="am-g">
      
      <div class="am-g">
      <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
          <div class="am-btn-group am-btn-group-xs">
            <a href="stu_add"><button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span>入住</button></a>
           
          </div>
        </div>
      </div>
      
      <div class="am-u-sm-12 am-u-md-3">
       
      </div>
   
   
    <form action="stu_find?page=1" method="post">
    <div class="am-u-sm-12 am-u-md-3">
        <div class="am-form-group">
          <select data-am-selected="{btnSize: '5'}" size="3" name="dor">
          			<option value="1">请选择</option>
         		<s:iterator var="b" value="allList" id="b">
      				<option value="<s:property value="b"/>">
      					<s:property value="b"/>
      				</option>
      			</s:iterator>
          </select>
        </div>
      </div>
      <div class="am-u-sm-12 am-u-md-3">
        <div class="am-input-group am-input-group-sm">
          <input type="text" class="am-form-field" name="name" placeholder="输入姓名">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="submit">搜索</button>
          </span>
        </div>
      </div>
    </form>
   
         
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main" id="mytable">
            <thead>
              <tr>
              
                <th class="table-id">ID</th>
                <th class="table-title">姓名</th>
                <th class="table-type">学号</th>
                <th class="table-type">状态</th>
                <th class="table-type">电话</th>
                <th class="table-type">身份证号</th>
                <th class="table-type">辅导员</th>
                <th class="table-type">年级</th>
                <th class="table-type">专业</th>
                <th class="table-type">宿舍号</th>
                <th class="table-type">宿舍楼</th>
                <th class="table-type">操作</th>
              </tr>
          </thead>
          <tbody>
          <s:iterator var="p" value="pageBean.list"> 
          	<tr style="height: 45px;">
          	 
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
          		<span >
					<s:property value="#p.xh"/>
				</span>
				</td>
          		<td>
          		<span >
					<s:property value="#p.state"/>
				</span>
				</td>
				<td>
          		<span >
					<s:property value="#p.telephone"/>
				</span>
				</td>
				<td>
          		<span >
					<s:property value="#p.card"/>
				</span>
				</td>
				<td>
          		<span >
					<s:property value="#p.teacher"/>
				</span>
				</td>
				<td>
          		<span >
					<s:property value="#p.grader"/>
				</span>
				</td>
				<td>
          		<span >
					<s:property value="#p.profession"/>
				</span>
				</td>
				<td>
          		<span >
					<s:property value="#p.dormity.num"/>
				</span>
				</td>
				<td>
          		<span >
					<s:property value="#p.dormity.building.name"/>
				</span>
				</td>
				 <td>
                <div class="am-btn-toolbar" id="doc-prompt-toggle">
                  <div class="am-btn-group am-btn-group-xs" >
                  <a href="#" onclick="change(<s:property value="#p.sid"/>)">
                   <span class="am-icon-pencil-square-o">换寝</span></a>
                </div>
                <div class="am-btn-group am-btn-group-xs">
                   
                     <a href="#" onclick="del(<s:property value="#p.sid" />)">
                   <span class="am-icon-pencil-square-o" >退宿</span></a>
                   
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
				<a href="stu_findAll?page=<s:property value="pageBean.page-1"/>" >«</a>
			</li>
      </s:if>
      <s:else>
      		 <li class="am-disabled">
      		 <a href="stu_findAll?page=1" >«</a>
      		 </li>
      </s:else>
      
     <s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page == #i">
					<li class="am-active">
					<a href="stu_findAll?page=<s:property value="#i"/>">
					<s:property value="#i"/></a>
					</li>
				</s:if>
				<s:else>
					<li >
					<a href="stu_findAll?page=<s:property value="#i"/>">
					<s:property value="#i"/></a>
					</li>
				</s:else>
	</s:iterator>
	<s:if test="pageBean.page != pageBean.totalPage">	
		<li>
		<a  href="stu_findAll?page=<s:property value="pageBean.page+1"/>">»</a>
		</li>		
	</s:if>
	<s:else>
		<li class="am-disabled">
		<a  href="stu_findAll?page=<s:property value="pageBean.totalPage"/>">»</a>
		</li>
	</s:else>
    </ul>
  </div>
         </div>
        </form>
      </div>

    </div>
    
    
   <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">选择寝室</div>
     <form action="stu_changeDor" method="post" id="dorform">
 	<input type="hidden" name="sid" id="sid">
    <div class="am-modal-bd">
       <select id="doc-select-1" style="width:455px;" name="dor">
      			<s:iterator var="b" value="dbList" id="b">
      				<option value="<s:property value="b"/>">
      					<s:property value="b"/>
      				</option>
      			</s:iterator>
      		</select>
    </div>
    <div class="am-modal-footer">
    
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>提交</span>
      
    </div>
    </form>
  </div>
</div>


<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
   <form action="stu_delete" id="deleteform" method="post">
   
    <div class="am-modal-bd">
    <input type="hidden" name="sid" id="ssid">
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