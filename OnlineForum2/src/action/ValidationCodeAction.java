package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationCodeAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	private PageContext pageContext;

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	
	private String codeChars = "%#23456789abcdefghkmnpqrstuvwxyzABCDEFGHKLMNPQRSTUVWXYZ";
	
	private Color getRandomColor(int minColor, int maxColor){
		
		Random random = new Random();
		if(minColor>255) minColor=255;
		if(maxColor>255) maxColor=255;
		int red = minColor+random.nextInt(maxColor-minColor);
		int green = minColor+random.nextInt(maxColor-minColor);
		int blue = minColor+random.nextInt(maxColor-minColor);
		return new Color(red,green,blue);
	}
	
	public String execute() throws Exception
	{
		int CharsLength = codeChars.length();
		response.setHeader("ragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires",0);
		
		int width=90;
		int height = 20;
		
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();// �������������ֵ�graphics����
		g.setColor(getRandomColor(180,250));//������������ɫ
		g.fillRect(0, 0, width, height); 
		
		g.setFont(new Font("Times New Roman", Font.ITALIC, height)); //���ó�ʼ���壬���д������
		g.setColor(getRandomColor(120,180));//�������������ɫ
		StringBuilder validationCode = new StringBuilder();
		
		String[] fontNames = { "Times New Roman", "Book antiqua",  "Arial" };
		Random random = new Random();
		for(int i=0;i<random.nextInt(3)+3;i++)
		{
			g.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC, height));
			char codeChar = codeChars.charAt(random.nextInt(CharsLength));
			validationCode.append(codeChar);
			g.setColor(getRandomColor(10,100));
			g.drawString(String.valueOf(codeChar), 16*i+random.nextInt(7), height-random.nextInt(6));
		}
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5*60);
		session.setAttribute("validation_code", validationCode.toString());
		g.dispose();
		response.reset();
		try {
			OutputStream os = response.getOutputStream();
			ImageIO.write(image, "JPEG", os);
			os.flush();
			os.close();
			//	os=null;
			//	response.flushBuffer(); 
		//	out.clear();
		//	out = pageContext.pushBody();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
