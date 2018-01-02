<%@page import="com.qst.foodie.bean.Shop"%>
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
		<%
		Shop shop = (Shop)request.getAttribute("shop");
    	%>
        <div id="body">
            <h2>修改商家信息</h2>
            <div class="person">
                <form action="ShopServlet?type=update&shop_id=<%=shop.getShop_id() %>" method="post" name="form">
                    <table>
                        <tr>
                            <td class="text">商家ID：</td>
                            <td class="content"><%=shop.getShop_id() %></td>
                        </tr>
                        <tr>
                            <td class="text">商家名：</td>
                            <td class="content"><input type="text" name="shop_name" value="<%=shop.getShop_name() %>"/></td>
                        </tr>
                        <tr>
                            <td class="text">地址：</td>
                            <td class="content"><input type="text" name="address" value="<%=shop.getShop_address() %>"/></td>
                        </tr>
                        <tr>
                            <td class="text">电话：</td>
                            <td class="content"><input type="text" name="tel" value="<%=shop.getShop_tel() %>"/></td>
                        </tr>
                                                <tr>
                            <td class="text">介绍：</td>
                            <td class="content"><input type="text" name="content" value="<%=shop.getShop_content() %>"/></td>
                        </tr>
                                                <tr>
                            <td class="text">收益：</td>
                            <td class="content"><input type="number" name="revenue" value="<%=shop.getRevenue() %>"/></td>
                        </tr>
                    </table>
                    <div class="input"><input type="submit" name="reset" value="修改商家信息"/></div>
                </form>
            </div>
        </div>

    </body>
</html>