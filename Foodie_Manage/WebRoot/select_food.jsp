<%@page import="com.qst.foodie.dao.ShopDAO"%>
<%@page import="com.qst.foodie.bean.Shop"%>
<%@page import="com.qst.foodie.bean.Menu"%>
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
    	List<Shop> list = dao.getShopList();
     %>
        <div id="body">
            <h2>菜单查询</h2>
            <table>
                <tr>
                    <th>商家名</th>
                    <th>菜单ID</th>
                    <th>菜名</th>
                    <th>介绍</th>
                    <th>价格</th>
                    <th>图片</th>
                    <th>操作</th>
                </tr>
              <%if(list!=null){ 
                for(Shop shop : list){
                List<Menu> mList = shop.getMenuList();
                for(Menu menu : mList){
              %>
                <tr>
                <td><%=shop.getShop_name() %></td>
                <td><%=menu.getMenu_id() %></td>
                <td><%=menu.getMenu_name() %></td>
                <td><%=menu.getMenu_content() %></td>
                <td><%=menu.getMenu_price()%></td>
                <td><%=menu.getMenu_image()%></td>
                <td><a href="MenuServlet?type=updateSelect&menu_id=<%=menu.getMenu_id() %>">修改</a>&nbsp<a href="MenuServlet?type=delete&menu_id=<%=menu.getMenu_id() %>" onclick="return confirm('确定要删除吗？')">删除</a></td>
                </tr>
                <%}}} %>
            </table>
            
        </div>

    </body>
</html>