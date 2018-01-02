<%@page import="com.qst.foodie.dao.MenuDAO"%>
<%@page import="com.qst.foodie.dao.MenuTopDAO"%>
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
        </style>
    </head>
    <body>
        <div id="body">
            <div id="body_top">
                <h2>推荐菜品</h2>
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
               <%
                MenuTopDAO dao = new MenuTopDAO();
                MenuDAO dao1 = new MenuDAO();
                ShopDAO dao2 = new ShopDAO();
                List<Integer> mlist = (List<Integer>)dao.getTopMenuList();
                for(int i : mlist){
                	Menu menu = dao1.getMenu(i);
                	int shop_id = menu.getShop_id();
                	Shop shop = dao2.selectShopById(shop_id);
                 %>
                <tr>
                    <td><%=shop.getShop_name() %></td>
                    <td><%=menu.getMenu_id() %></td>
                    <td><%=menu.getMenu_name() %></td>
                    <td><%=menu.getMenu_content() %></td>
                    <td><%=menu.getMenu_price() %></td>
                    <td><%=menu.getMenu_image() %></td>
                    <td><a href="RemoveMenuTopServlet?menu_id=<%=menu.getMenu_id() %>">删除</a></td>
                </tr>
                <%} %>
                </table>
                
            </div>
            <div id="body_bottom">
                <h2>全部菜品</h2>
                    <%
				    	List<Shop> list = dao2.getShopList();
				     %>
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
                <tr id="xs">
                <td><%=shop.getShop_name() %></td>
                <td><%=menu.getMenu_id() %></td>
                <td><%=menu.getMenu_name() %></td>
                <td><%=menu.getMenu_content() %></td>
                <td><%=menu.getMenu_price()%></td>
                <td><%=menu.getMenu_image()%></td>
                <td><a href="AddMenuTopServlet?menu_id=<%=menu.getMenu_id() %>" onclick="javascript:this.style.display='none'">推荐</a></td>
                </tr>
                <%}}} %>
            </table>
            </div>
        </div>
    </body>
</html>