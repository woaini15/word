<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath }/layuicms/layui/css/layui.css"
		type="text/css"></link>
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layuicms/css/index.css"
	type="text/css"></link>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-2.1.1.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/layuicms/layui/layui.js" charset="UTF-8"></script>	
		
	<script type="text/javascript" src="${pageContext.request.contextPath }/layuicms/js/index.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layuicms/js/cache.js"></script>

</head>
<body onload="updLoad()">
	<br/>
	<div class="layui-container">
		<input type="hidden" name="class_id" id="class_id" >
		<div class="layui-row layui-col-space1">
			
				<div class="layui-form">
					<div class="layui-form-item">
							<label class="layui-form-label"><span style="color:red">*</span>用户名称</label>
							<div class="layui-input-inline">
									<input type="text" id="user_name" name="user_name" required
									lay-verify="required"  autocomplete="off"
									class="layui-input">
							</div>
					</div>
					
					<div class="layui-form-item">
							<label class="layui-form-label"><span style="color:red">*</span>用户密码</label>
							<div class="layui-input-inline">
									<input type="password" id="user_password" name="user_password" required
									lay-verify="required"  autocomplete="off"
									class="layui-input">
							</div>
					</div>
					
					<div class="layui-form-item">
							<label class="layui-form-label">性别</label>
							<div class="layui-input-block" id="IsPurchased">
							      <input type="radio" id="sex" name="sex" value="男" title="男" >
							      <input type="radio" id="sex" name="sex" value="女" title="女" checked>
						    </div>
					</div>
					
					
					<!--<div class="layui-form-item">
							<label class="layui-form-label"><span style="color:red">*</span>电子邮箱</label>
							  <div class="layui-input-inline">
									<input type="text" name="birthday" id="birthday" lay-verify="date"
								placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
							</div>
							
					</div>-->
					
					<div class="layui-form-item">
							<label class="layui-form-label"><span style="color:red">*</span>电子邮箱</label>
							<div class="layui-input-inline">
									<input type="text" id="birthday" name="birthday" required
									lay-verify="required"  autocomplete="off"
									class="layui-input">
							</div>
					</div>
					
					<div class="layui-form-item">
							<label class="layui-form-label"><span style="color:red">*</span>联系电话</label>
							<div class="layui-input-inline">
								<input type="text" id="phone" name="phone" required
									lay-verify="required"  autocomplete="off"
									class="layui-input">
							</div>
					</div>
									  	
				  	<div class="layui-form-item">
							<label class="layui-form-label"><span style="color:red">*</span>所属院系</label>
							<div class="layui-input-inline">
									<input type="text" id="address" name="address" required
									lay-verify="required"  autocomplete="off"
									class="layui-input">
							</div>
					</div>
  
  					<div class="layui-form-item">
							<label class="layui-form-label">用户类别</label>
							<div class="layui-input-block" id="IsPurchased2">
							      <input type="radio" name="user_category" value="管理员" title="管理员" >
							      <input type="radio" name="user_category" value="老师" title="老师">
							      <input type="radio" name="user_category" value="学生" title="学生">
						    </div>
					</div>
					
					
					<div class="layui-form-item" style="float: right;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-sm layui-icon" id="btnSave">&#x1005;保存</button>
	
							<button id="btnCancel"
								class="layui-btn layui-btn-sm layui-icon layui-bg-red ">&#x1006;取消</button>
							
						</div>
					</div>
				</div>
			</div>
		
	</div>
	<script>
		layui.use(['form','laydate'],function(){
		  var form = layui.form,
		      $=layui.$,
		      laydate = layui.laydate;
			  //执行一个laydate实例
		      laydate.render({
		    	  elem: '#birthday'
		      });
		});
	</script>
	
	<script type="text/javascript">
		//点击修改时获取父页面的id值
		$("document").ready(function(){
			$("#btnCancel").click(function(){
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	            parent.layer.close(index);//关闭弹出的子页面窗口
			});
		});
	</script>
	<script type="text/javascript">
		//点击修改时获取父页面的id值
		$("document").ready(function(){
			$("#class_id").val(parent.$('#class_id').val());
		});
	</script>

	<script type="text/javascript">
		function Verification(){
			var user_name=$("#user_name").val();
			var user_password=$("#user_password").val();
			var birthday=$("#birthday").val();
			var phone=$("#phone").val();
			var address=$("#address").val();
			if(user_name=="" || user_name==null){
				layer.msg('用户姓名不允许为空', {icon: 2,time: 1000});
				return false;
			}
			if(user_password=="" || user_password==null){
				layer.msg('用户密码不允许为空', {icon: 2,time: 1000});
				return false;
			}
			if(birthday=="" || birthday==null){
				layer.msg('出生年月不允许为空', {icon: 2,time: 1000});
				return false;
			}
			if(phone=="" || phone==null){
				layer.msg('联系电话不允许为空', {icon: 2,time: 1000});
				return false;
			}
			if(address=="" || address==null){
				layer.msg('地址不允许为空', {icon: 2,time: 1000});
				return false;
			}
			return true;
		}
		$("document").ready(function(){
			$("#btnSave").click(function(){
				//如果标识为0则为添加，不为0则为修改
				var class_id=$("#class_id").val();
				if(Verification()==true){
					if(class_id=="0"){
						$.ajax({
							type:"post",
							url:"<%=basePath %>um/addInformation2",
							data:{
								user_name:$("#user_name").val(),
								user_password:$("#user_password").val(),
								sex: $("#sex").val(),
								birthday:$("#birthday").val(),
								phone:$("#phone").val(),
								address:$("#address").val(),
								user_category:$("[name='user_category']").val(),
								user_flag:$("#user_flag").val()
							},
							dataType:"json",
							success:function(reqData){
								if(reqData>0){
									layer.msg('操作成功', {icon: 1,time: 1000},function(){
										parent.location.reload();
									});
								}else {
		                            layer.msg('操作失败', {icon: 2,time: 1000});
		                        }
							},
							error:function(){
								layer.msg('ajax执行错误！', {icon: 2,time: 1000});
							}
						});
					}else{
						 $.ajax({
							type:"post",
							url:"<%=basePath %>um/updInformation",
							data:{
								user_id:class_id,
								user_name:$("#user_name").val(),
								user_password:$("#user_password").val(),
								sex:$("#sex").val(),
								birthday:$("#birthday").val(),
								phone:$("#phone").val(),
								address:$("#address").val(),
								user_category:$("#user_category").val(),
								user_flag:$("#user_flag").val()
							},
							dataType:"json",
							success:function(reqData){
								if(reqData>0){
									layer.msg('操作成功', {icon: 1,time: 1000},function(){
										parent.location.reload();
									});
								}else {
		                            layer.msg('操作失败', {icon: 2,time: 1000});
		                        }
							},
							error:function(){
								layer.msg('ajax执行错误！', {icon: 2,time: 1000});
							}
						});
					}
				}
			});
		});
	</script>
	
	<script type="text/javascript">
	//页面打开时，首先验证rcved_pl_id标识是否为0，如果不为0，则根据标识
	//查询出对应的数据并把他赋值到对应的标签
		function updLoad(){
			var class_id=$("#class_id").val();
			if(class_id!=0){
				$.ajax({
					type:"post",
					url:"<%=basePath %>um/findByIdInformation",
					data:{
						ida:class_id
					},
					dataType:"json",
					success:function(reqData){
						if(reqData.sex=='女'){
							document.getElementsByName("sex")[1].checked=true;
						}else{
							document.getElementsByName("sex")[0].checked=true;
						}
						$("#user_name").val(reqData.user_name),
						$("#user_password").val(reqData.user_password),
						//$("input[name='sex'][value='男']").attr("checked", reqData.sex =='男' ? true : false);
	                    //$("input[name='sex'][value='女']").attr("checked", reqData.sex == '女' ? true : false);
						$("#birthday").val(reqData.birthday),
						$("#phone").val(reqData.phone),
						$("#address").val(reqData.address),
						//$("input[name=user_category][value='管理员']").attr("checked", reqData.user_category =='管理员' ? true : false);
	                    //$("input[name=user_category][value='老师']").attr("checked", reqData.user_category == '老师' ? true : false);
	                    $("input[name='user_category'][value='"+reqData.user_category+"']").attr("checked", "true");
	                    $("#user_flag").val(reqData.user_flag)
	                    form.render(); //更新全部
					},
					error:function(){
						layer.msg('ajax执行错误！', {icon: 2,time: 1000});
					}
				});
			}
		}
	</script>
</body>
</html>