package com.helloqiaodan.firstweb;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.*;
import com.sun.image.codec.*;

/**
 * Servlet implementation class IdentityServlet
 */
@WebServlet("/IdentityServlet")
public class IdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
public static final char[] CHARS = {'2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z'};
	public static Random random = new Random();//随机数字
	public static String getRandomString(){
		//获取6位随机的数字
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i<6;i++){
			//每次取一个随机的数字
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	public static Color getRandomColor(){
		//获取随机的颜色
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
		
	}
	public static Color getReverseColor(Color c){
		//返回某颜色相反的颜色
		return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
	}
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("image/jpeg");
		String randomStr = getRandomString();
		request.getSession(true).setAttribute("randomString", randomStr);
		int width = 100;
		int height = 30;
		Color color = getRandomColor();
		Color reverseColor = getReverseColor(color);
		BufferedImage imageBuffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		Graphics2D g = imageBuffer.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverseColor);
		g.drawString(randomStr, 18, 20);
		for(int i = 0,n = random.nextInt(100);i<n;i++){
			//随机画噪点，最多画100个噪点
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(imageBuffer);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//访问路径：
	//http://localhost:8080/01-firstWeb/servlet/IdentityServlet

}
