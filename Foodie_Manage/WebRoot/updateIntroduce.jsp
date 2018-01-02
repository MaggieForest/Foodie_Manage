<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            #body {
                width: 75%;
                height: 300px;
                margin: 0 auto;
                margin-top: 50px;
                margin-bottom: 120px;
            }
            #body h2{
                margin-left: 242px;
            }
            #body .div{
                width: 60%;
                margin: 0 auto;
                margin-top: 30px;

            }
            #body .div span{
                font-weight: bolder;
            }
            #body #div{
                margin-left: 200px;
            }
            #body #div #text{
                width: 250px;
                height: 100px;
            }
            #body .div input[type="submit"]{
                display: block;
                width: 50px;
                height: 30px;
                margin-left: 80px;
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
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
    </body>
</html>