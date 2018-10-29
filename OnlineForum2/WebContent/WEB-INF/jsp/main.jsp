<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>论坛主界面</title>
		<script type="text/javascript" src="javascript/common.js">
</script>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<form action="main.action" method="post">
			<input type="text" name="select" style="width: 200px" />
			&nbsp;
			<input type="submit" value="按主题查询" />
		</form>

		<p />
		<div style="width: 800px; text-align: center">
			<table width="800px" border="0" cellspacing="0" cellpadding="0"
				class="bt">
				<tr style="height: 23px; font: bold" bgcolor="#DDDDDD">
					<td>
						主题
					</td>
					<td width="12%">
						发贴人
					</td>
					<td width="8%">
						浏览
					</td>
					<td width="8%">
						回复
					</td>
					<td width="15%">
						最新回应
					</td>
				</tr>

				<s:iterator var="element" value="userInfo.topics">
					<tr style="height: 23px">
						<td>
							<a
								href="view_topic.action?path=<s:property value='#element.topicPath'/>&user=<s:property value='#element.user.name'/>">
								<s:property value='#element.topic' /> </a>
						</td>
						<td>
							<s:property value='#element.user.name' />
						</td>
						<td>
							<s:property value='#element.viewCount' />
						</td>
						<td>
							<s:property value='#element.replyCount' />
						</td>
						<td>
							<s:property value='#element.lastReplyTimeInterval' />
							&nbsp;
							<s:property value='#element.lastReplyUser.name' />
						</td>
					</tr>
				</s:iterator>
			</table>
			<p />
			<p />
			<div class="pages">
				<s:if test="userInfo.totalPage > 1">
					<b>页: </b>
					<c:forEach var="i" begin="1" end="${userInfo.totalPage}">
						<c:choose>
							<c:when test="${param.page == null and i == 1}">
								<span class="page_on">${i}</span>
							</c:when>

					 		<c:when test="${param.page == i}"> 
					 			<span class="page_on">${i}</span> 
							</c:when> 

							<c:otherwise>
								<a href='main.action?page=${i}&select=${param.select}'
									class='blue'>${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

				</s:if>
			</div>
			<form action="new_topic_page.action" method="post">
				<input type="submit" value="我要发贴" />
			</form>
		</div>
	</body>

</html>
