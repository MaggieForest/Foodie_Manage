<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>信息管理--管理员</title>
        <link type="text/css" href="css/public.css" rel="stylesheet"/>
        <link type="text/css" href="css/index.css" rel="stylesheet"/>
        <style>
            #body{
                margin-bottom: 500px;
            }
            #body #body_left{
                width: 20%;
                float: left;
                margin-top: 20px;
                background-color: gainsboro;
                padding-top: 40px;
                padding-bottom: 40px;
            }
            #body_left table{
                width: 80%;
                margin: 0 auto;
            }
            #body #body_left table tr{
                width: 80%;
                height: 40px;
                background-color: aliceblue;
            }
            #body #body_left table .title{
                text-align: left;
                padding-left: 5px;
                /*margin-top: 15px;*/
            }
            #body #body_left table a{
                text-decoration: none;
                color: black;
            }
            #body #body_left table .content{
                text-align: center;
                font-size: 12px;
            }

            #body #body_right{
                width: 78%;
                float: right;
                margin-top: 20px;
            }
            #body #body_right #iframe{
                width: 100%;
                height: 550px;
                /*border-style: none;*/
            }
        </style>
    </head>
    <body>
        <div id="head">
            <!-- logo-->
            <div id="head_left">
                <a href="index.jsp"><img src="images/2.png"/></a>
            </div>
             <div id="head_top">
                    <c:choose>
	                	<c:when test="${user.user_name!=null}">
	                		<a href="UserLogoutServlet"><span>【退出】</span></a>
	                		<span>欢迎您：<c:out value="${user.user_name}"></c:out></span>
	                	</c:when>
	                	<c:otherwise>
	                		<a href="register.jsp"><span>【注册】</span></a>
	                    	<a href="register.jsp"><span>【登录】</span></a>
	                	</c:otherwise>
                	</c:choose>
                </div>
           
            <!-- nav-->
            <div id="head_right">
                <ul>
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="shopping.jsp">我的购物车</a></li>
                    <li><a href="MemberServlet">会员管理中心</a></li>
                    <li><a href="order_search.jsp">订单查询</a></li>
                    <li><a href="about.jsp">关于我们</a></li>
                </ul>
            </div>
        </div>

        <div id="body">
            <div id="body_left">
                <table>
                    <tr><th class="title">账号管理</th></tr>
                    <tr><td class="content"><a href="person.jsp" target="frame">修改个人信息</a></td></tr>
                    <tr><td class="content"><a href="psw.jsp" target="frame">修改密码</a></td></tr>
                    <tr><th class="title">商家管理</th></tr>
                    <tr><td class="content"><a href="select_shop.jsp" target="frame">商家查询</a></td></tr>
                    <tr><td class="content"><a href="add_shop.jsp" target="frame">添加商家</a></td></tr>
                    <tr><th class="title">菜品管理</th></tr>
                    <tr><td class="content"><a href="select_food.jsp" target="frame">查询菜单</a></td></tr>
                    <tr><td class="content"><a href="add_food.jsp" target="frame">添加菜品</a></td></tr>
                    <tr><td class="content"><a href="recom_food.jsp" target="frame">推荐菜品</a></td></tr>
                    <!--<tr><th class="title">留言管理</th></tr>-->
                    <!--<tr><td class="content"><a href="#" target="frame">查看留言</a></td></tr>-->
                    <!--<tr><td class="content"><a href="#" target="frame">删除留言</a></td></tr>-->
                    <tr><th class="title">商家信息</th></tr>
                    <tr><td class="content"><a href="updateIntroduce.jsp" target="frame">修改介绍</a></td></tr>
                </table>
            </div>
            <div id="body_right">
                <iframe name="frame" id="iframe" src="person.jsp"></iframe>
            </div>
        </div>

        <!-- foot-->
        <div id="footer">
            <span>© 2018 ❤ MYZD</span>
        </div>
    </body>
</html>