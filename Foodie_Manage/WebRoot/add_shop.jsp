<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/public.css">
        <link rel="stylesheet" type="text/css" href="css/register.css">
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
                text-align: center;
            }

            #body  table{
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
            #body  table input{
                border-style: none;
                background-color: gainsboro;
                text-align: center;
            }
            #body table .text{
                width: 300px;
                font-family: "微软雅黑";
                font-weight: bolder;
            }
            #body  table .content{
                width: 200px;
            }
            #body  .input{
                width: 50%;
                margin: 0 auto;
                margin-top: 20px;
            }
            #body  input[type="submit"]{
                width: 100px;
                height: 30px;
            }
        </style>
    </head>
    <body>
    <div id="body">
             <h2>添加商家</h2>
            <div class="psw">
                 <form action="ShopServlet?type=add" method="post" onsubmit="return validateSignUp()">
                    <table>
                        <tr>
                            <td class="text">商家名：</td>
                            <td class="content"><input type="text" name="shopname" placeholder="商家名" maxlength="30"/></td>
                        </tr>
                        <tr>
                            <td class="text">地址：</td>
                            <td class="content"><input type="text" name="address" placeholder="地址" /></td>
                        </tr>
                        <tr>
                            <td class="text">电话：</td>
                            <td class="content"> <input type="text" name="tel" placeholder="电话" id="tel"/></td>
                        </tr>
                        <tr>
                            <td class="text">商家介绍：</td>
                            <td class="content"> <input type="text" name="content" placeholder="请输入商家介绍"  /></td>
                        </tr>
                    </table>
                    <div class="input"><input type="submit" value="添加" name="submit"/></div>
                </form>

            </div>
        </div>
    </body>
</html>