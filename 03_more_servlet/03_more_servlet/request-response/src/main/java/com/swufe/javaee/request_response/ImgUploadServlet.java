package com.swufe.javaee.request_response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "imgServlet", value = "/img-servlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ImgUploadServlet extends HttpServlet {
	private String message;

	public void init() {
		message = "Hello World!";
		System.out.println("init() will be called only once");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {// TODO
																														// Auto-generated
																														// method
																														// stub
		final Part filePart = request.getPart("filename");
		String fileName = getFileName(filePart);
		OutputStream out = new FileOutputStream(
				"d:/" + fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length()));
		InputStream filecontent = filePart.getInputStream();
		int read;
		final byte[] bytes = new byte[1024];
		while ((read = filecontent.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		response.getOutputStream().write("upload success".getBytes());
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public void destroy() {
	}
}