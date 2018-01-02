<%@page import="com.qst.foodie.dao.ShopDAO"%>
<%@page import="com.qst.foodie.bean.Shop"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            #body{
                width: 75%;
                margin: 0 auto;
                margin-top: 30px;
            }
            #body h2{
                /*margin-left: 242px;*/
                /*margin: 0 auto;*/
                text-align: center;
            }
            #body table{
                width: 60%;
                margin: 0 auto;
            }
            #body table tr th{
                width: 100px;
                height: 30px;
                background-color: #808080;
            }
            #body table tr td{
                width: 100px;
                height: 30px;
                text-align: center;
                font-size: 15px;
                background-color: #dcdcdc;
            }


            #body .div{
                width: 60%;
                /*margin-left: 20px;*/
                margin: 0 auto;
                margin-top: 30px;

            }
            #body .div span{
                font-weight: bolder;
            }
            #body .div input[type="text"]{
                width: 150px;
                height: 30px;
            }

            #body .div input[type="submit"]{
                width: 50px;
                height: 30px;
                margin-left: 20px;
            }
        </style>
    </head>
    <body>
    <%
    	ShopDAO dao = new ShopDAO();
    	List<Shop> list = (List<Shop>)dao.getShopList();
     %>
        <div id="body">
            <h2>商家查询</h2>
            <table>
                <tr>
                    <th>商家ID</th>
                    <th>商家名</th>
                    <th>地址</th>
                    <th>电话</th>
                    <th>介绍</th>
                    <th>收益</th>
                    <th>操作</th>
                </tr>
                                <%if(list!=null){ 
                for(Shop shop : list){
                %>
                <tr>
                <td><%=shop.getShop_id() %></td>
                <td><%=shop.getShop_name() %></td>
                <td><%=shop.getShop_address() %></td>
                <td><%=shop.getShop_tel() %></td>
                <td><%=shop.getShop_content() %></td>
                <td><%=shop.getRevenue() %></td>
                <td><a href="ShopServlet?type=updateSelect&shop_id=<%=shop.getShop_id() %>">修改</a>&nbsp<a href="ShopServlet?type=delete&shop_id=<%=shop.getShop_id() %>" onclick="return confirm('确定要删除吗？')">删除</a></td>
                </tr>
                <%}} %>
            </table>
            
        </div>

    </body>
</html>