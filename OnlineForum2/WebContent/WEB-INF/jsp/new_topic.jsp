<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %> 
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

<script type="text/javascript">
	//初始化文本编辑器
	CKEDITOR.replace('content_text');
</script>
<script type="text/javascript">
function check(){
	
	var title=document.getElementById("title");
	if(title.value=="")
		{
		alert("请输入标题");
		title.focus();
		return;
		}
	var content= CKEDITOR.instances.content_text.getData();
	if(content=="")
		{
	alert("请输入内容");
		content.focus();
		return;
		}
	document.postTopic.submit();
}
</script>
</head>
<body>

	<a href=""> 返回</a>
	<form name="postTopic" action="post_topic.action" method="post" >
		标题： <input type="text" name="title" id="title" style="width: 720px" />
		<p />
		
		<textarea name="content" id="content_text" class="ckeditor"></textarea>
	<input type="button" onclick="check()"  value="提交" />
	
	</form>
<!--  	<ckeidtor:replace replace="content_text" basePath="ckeditor/" /> -->
	<p />
	
	<script type="text/javascript">
	function check1(){
		var title= document.getElementById("title");
		if(title==null||title=="")
			{
				alert("请输入标题！");
				title.focus();
                return false;
			}
		var content= document.getElementById("content_text");
		if(content==null||content=="")
			{
				alert("请输入内容！");
				content_text.focus();
                return false;
			}
		
		
	}
		

		/*		
		  function new_topic()
		  {
		try
		{ 
		var title = document.getElementById("title");
		
		if(title.value.replace(/(^\s*)/g, "") == "")
		{
		   alert("请输入标题!");
		   title.focus();
		   return;
		}          
		
		   postTopic.submit();

		}
		catch(e)
		{
		   alert(e);
		}
		}
		  
		 */
	</script>
</body>
</html>