<%@page import="com.qst.foodie.dao.ShopDAO"%>
<%@page import="com.qst.foodie.bean.Shop"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            #body table .title{
                font-weight: bolder;
                width: 100px;
                height: 40px;
                text-align: center;
                line-height: 40px;
            }
            #body table .content{
                width: 200px;
                height: 40px;
            }
            #body input[type="file"]{
                /*width: 200px;*/
                /*background-color: orange;*/
            }
            #body input[type="text"]{
                height: 25px;
            }
            #body table textarea{
                width: 200px;
            }
            #body input[type="submit"]{
                width: 100px;
                height: 30px;
                /*margin: 0 auto;*/
                margin-top: 30px;
                /*text-align: center;*/
                margin-left: 290px;
            }
        </style>
    </head>
    <body>
        <div id="body">
            <h2>添加菜品</h2>
    <%
    	ShopDAO dao = new ShopDAO();
    	List<Shop> list = (List<Shop>)dao.getShopList();
     %>
            <form method="post" action="AddMenuServlet" enctype="multipart/form-data">
                <table>
                       <tr>
                        <td class="title">
                            <span>商家：</span>
                        </td>
                        <td class="content">
                            <select name="shop_name" >     
  								<option value="0">-请选择-</option> 
  							<%if(list!=null){ 
               					 for(Shop shop : list){
               					 %>
                                <option><%= shop.getShop_name()%></option>
                           <%}} %>
   							</select>  
                        </td>
                    </tr>
                    <tr>
                        <td class="title">
                            <span>菜名：</span>
                        </td>
                        <td class="content">
                            <input type="text" name="menu_name"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="title">
                            <span>单价：</span>
                        </td>
                        <td class="content">
                            <input type="text" name="menu_price"/><span>元/份</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="title">
                            <span>菜品描述：</span>
                        </td>
                        <td class="content">
                            <textarea name="menu_content"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="title">
                            <span>图片：</span>
                        </td>
                        <td class="content">
                            <input type="file" name="filename"/>
                            <br>
                            <span>仅支持.jpg或.png格式</span>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="添加"/>
            </form>

        </div>
    </body>
</html>