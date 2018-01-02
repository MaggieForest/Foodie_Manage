<%@page import="com.qst.foodie.dao.ShopDAO"%>
<%@page import="com.qst.foodie.bean.Shop"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>网上订餐系统--首页</title>
        <link type="text/css" href="css/public.css" rel="stylesheet"/>
        <link type="text/css" href="css/index.css" rel="stylesheet"/>
    </head>
    <body>
    	<jsp:useBean id="user" scope="session" class="com.qst.foodie.bean.User"></jsp:useBean>
    	<jsp:useBean id="menuBean" scope="page" class="com.qst.foodie.bean.Menu"></jsp:useBean>
    	<%	
    	ShopDAO dao = new ShopDAO();
    	List<Shop> list = (List<Shop>)dao.getShopList();
    	%>
    
        <div id="whole">
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
	                    <li><a href="order_search.jsp">订单查询</a></li>
	                    <li><a href="MemberServlet">管理中心</a></li>
	                    <li><a href="about.jsp">关于我们</a></li>
                    </ul>
                </div>
            </div>
<!-- content-->
            <div id="body">
                <div id="body_left">
				<!-- search-->
                    <div id="search">
                        <input type="text" id="research"/>
                        <img src="images/search.png" width="30px"/>
                    </div>
                    <!-- shoplist-->
                    <div id="introduce">
                        <h2>附近商家</h2>
                        <ul>
                        <%
                        if(list!=null){
                        for(Shop shop : list){
                        %>
                       <li><h3><a href="#"> <%=shop.getShop_name() %></a></h3>
                        <%
                        }
                        }
                         %>
                         </ul>
                    </div>
                </div>
                <div id="body_right">
                    <!-- 菜品-->
                    <div id="main">
                        <!-- 每日推荐-->
                        <div class="food">
                            <h2>每日推荐</h2>
                            <ul class="text">
                            
                            </ul>
                        </div>
                        <!-- 全部菜品-->
                        <div class="food">
                            <h2 id="title">全部菜品</h2>
                            <ul class="text">
                            
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- foot-->
            <div id="footer">
                <span>© 2018 ❤ MYZD</span>
            </div>
        </div>
    </body>
</html>