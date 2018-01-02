<%@page import="com.qst.foodie.dao.MenuDAO"%>
<%@page import="com.qst.foodie.dao.MenuTopDAO"%>
<%@page import="com.qst.foodie.dao.ShopDAO"%>
<%@page import="com.qst.foodie.bean.Shop"%>
<%@page import="com.qst.foodie.bean.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            #body {
                width: 75%;
                height: 300px;
                height: 500px;
                /*background-color: aqua;*/
                /*float: right;*/
                margin: 0 auto;
                margin-top: 50px;
                margin-bottom: 120px;
                /*border-left: 3px solid gray;*/
                /*border-top: 3px solid gray;*/
                /*border-bottom: 3px solid gray;*/
            }
            #body h2{
                text-align: center;
            }

            #body   table{
                margin: 0 auto;
                margin-top: 30px;
            }
            #body  table tr{
                /*width: 400px;*/
                height: 50px;
                background-color: gainsboro;
                line-height: 50px;
                text-align: center;
            }
            #body   table input{
                border-style: none;
                background-color: gainsboro;
                text-align: center;
            }
            #body  table .text{
                width: 300px;
                font-family: "微软雅黑";
                font-weight: bolder;
            }
            #body  table .content{
                width: 200px;
            }
            #body .input{
                width: 50%;
                margin: 0 auto;
                margin-top: 20px;
            }
            #body input[type="submit"]{
                width: 100px;
                height: 30px;
            }
        </style>
    </head>
    <body>
	    <div id="body">
	       <div class="person">
	       <%
	       Menu menu = (Menu)request.getAttribute("menu");
	       int shop_id = menu.getShop_id();
	       ShopDAO dao = new ShopDAO();
           Shop shop = dao.selectShopById(shop_id);
	        %>
                <form action="#" method="post" name="form">
                    <table>
                        <tr>
                            <td class="text">商家名：</td>
                            <td class="content"><%=shop.getShop_name() %></td>
                        </tr>
                        <tr>
                            <td class="text">菜单ID：</td>
                            <td class="content"><%=menu.getMenu_id() %></td>
                        </tr>
                        <tr>
                            <td class="text">菜名：</td>
                            <td class="content"><input type="text" name="menu_name" value="<%=menu.getMenu_name() %>"/></td>
                        </tr>
                        <tr>
                            <td class="text">介绍：</td>
                            <td class="content"><input type="text" name="menu_content" value="<%=menu.getMenu_content() %>"/></td>
                        </tr>
                                                <tr>
                            <td class="text">价格：</td>
                            <td class="content"><input type="number" name="menu_price" value="<%=menu.getMenu_price() %>"/></td>
                        </tr>
                                                <tr>
                            <td class="text">图片：</td>
                            <td class="content"><%=menu.getMenu_image() %></td>
                        </tr>
                    </table>
                    <div class="input"><input type="submit" name="reset" value="修改菜单信息"/></div>
                </form>
    </body>
</html>