<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ognl</title>
</head>
<body>
<h2>在struts标签中不能使用el表达式</h2>
##使用El表达式获得普通值<br>
${request.request_data }<br/>
${session.session_data }<br/>
${application.application_data }<br/>
<hr/>
##使用ognl获得普通值<br>
<s:property value="#request.request_data"/><br/>
<s:property value="#session.session_data"/><br/>
<s:property value="#application.application_data"/><br/>
<hr/>
##使用ognl获得根值<br>
<s:property value="text"/><br/>
<s:property value="name"/><br/>
<s:property value="user.name"/><br/>
<s:property value="user1.name"/><br/>
<s:property value="user2.name"/><br/>

 <hr/>一、ognl.构建 list集合 <br/>
    <s:iterator var="str" value="{'a','b'}">
    	<s:property value="#str"/>
    </s:iterator>
    
    <hr/>一、ognl.构建 map集合<br/>
     <s:iterator var="en" value="#{'cn':'China','usa':'America'}">
     	<s:property value="#en.key"/>
     	<s:property value="#en.value"/>  <br/>
     </s:iterator>
 <hr/>测试struts迭代标签 <br/>
	    <br/>一、. list迭代</br>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    	</tr>
  		<s:iterator var="user" value="#request.list" status="st">
  			<tr class=<s:property value="#st.even?'even':'odd'"/> >
  				<td><s:property value="#user.id"/></td>
  				<td><s:property value="#user.name"/></td>
  			</tr>
  		</s:iterator>
  	</table>
  	
  	 <br/>二、迭代map</br>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    	</tr>
  		<s:iterator var="en" value="#request.map" status="st">
  			<tr>
  				<td><s:property value="#en.key"/></td>
  				<td><s:property value="#en.value.name"/></td>
  			</tr>
  		</s:iterator>
  	</table>

</body>
</html>