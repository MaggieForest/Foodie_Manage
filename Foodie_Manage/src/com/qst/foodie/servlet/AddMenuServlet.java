package com.qst.foodie.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.qst.foodie.bean.Menu;
import com.qst.foodie.dao.MenuDAO;
import com.qst.foodie.dao.ShopDAO;
@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig servletConfig;
	
    public AddMenuServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			//新建一个SmartUpload对象
			SmartUpload su = new SmartUpload();
			//上传初始化
			su.initialize(servletConfig, request, response);
			//限制每个上传文件的最大长度
			su.setMaxFileSize(1000000);
			//限制总上传数据的长度
			su.setTotalMaxFileSize(200000);
			//设定允许上传的文件（通过扩展名限制），仅允许jpg，png文件
			su.setAllowedFilesList("jpg,png");
			//设定禁止上传的文件（通过扩展名限制），禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件
			su.setDeniedFilesList("exe,bat,jsp,htm,html");
			//上传文件
			su.upload();
			//获取上传的文件操作
			Files files = su.getFiles();
			//获取单个文件
			File singleFile = files.getFile(0);
			//获取上传文件的扩展名
			String fileType = singleFile.getFileExt();
			//设置上传文件的扩展名
			String[] type = {"JPG","jpg"};
			// 判断上传文件的类型是否正确
			int place = java.util.Arrays.binarySearch(type, fileType);
			//判断文件扩展名是否正确
			if (place != -1){
				//判断该文件是否被选择
				if (!singleFile.isMissing()){
					String picSize = String.valueOf(singleFile.getSize());					
					//以系统时间作为上传文件名称，设置上传完整路径
					String fileName = String.valueOf(System.currentTimeMillis());
					String filedir = "images/" + fileName + "." + singleFile.getFileExt();
					String smalldir = "samllImages/" + fileName + "." + singleFile.getFileExt();				
					//执行上传操作
					singleFile.saveAs(filedir, File.SAVEAS_VIRTUAL);
					System.out.println("上传至： " + filedir);
					ShopDAO dao1 = new ShopDAO();
					MenuDAO dao = new MenuDAO();
					int shop_id = dao1.searchByShopname(su.getRequest().getParameter("shop_name"));
					String menu_name = su.getRequest().getParameter("menu_name");
					float menu_price = Float.parseFloat(su.getRequest().getParameter("menu_price"));
					String menu_content = su.getRequest().getParameter("menu_content");
					Menu menu = new Menu();
					menu.setMenu_name(menu_name);
					menu.setMenu_content(menu_content);
					menu.setMenu_price(menu_price);
					menu.setMenu_image(fileName);
					dao.save(menu, shop_id);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().println("<script LANGUAGE='javascript'> alert('添加成功！');location.replace(document.referrer);</script>");
	}
 
	}


