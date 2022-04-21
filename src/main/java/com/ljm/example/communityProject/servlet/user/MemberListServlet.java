package com.ljm.example.communityProject.servlet.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.example.mysqlutil.MysqlUtil;
import com.sbs.example.mysqlutil.SecSql;

@WebServlet("/usr/member/list")
public class MemberListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MysqlUtil.setDBInfo("121.172.92.53", "limjeongmin", "cleanertje0905", "myProject");
		
		List<Map<String, Object>> memberMapList = MysqlUtil.selectRows(new SecSql().append("SELECT * FROM member ORDER BY id DESC"));
		MysqlUtil.closeConnection();
		
		request.setAttribute("memberMapList", memberMapList);
		// jsp 파일에서 잘 출력할수있게 다 준비. 
		request.getRequestDispatcher("/jsp/usr/member/list.jsp").forward(request, response);
	}

}
