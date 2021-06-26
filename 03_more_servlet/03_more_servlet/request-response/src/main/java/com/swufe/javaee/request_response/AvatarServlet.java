package com.swufe.javaee.request_response;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.GitHubAvatar;
import com.talanlabs.avatargenerator.layers.backgrounds.ColorPaintBackgroundLayer;

@WebServlet(name = "avatarServlet", value = "/avatar-servlet")
public class AvatarServlet extends HttpServlet {
	private String message;

	public void init() {
		message = "success";
		System.out.println("init() will be called only once");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Avatar avatar = GitHubAvatar.newAvatarBuilder().layers(new ColorPaintBackgroundLayer(Color.WHITE)).build();

		BufferedImage bi = avatar.create(123456L);
		response.setContentType("text/html");
		ImageIO.write(avatar.create(123456L), "JPEG", new File("d:/1.jpeg"));

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
	}

	public void destroy() {
	}
}