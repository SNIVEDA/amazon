package com.niit.frontshop.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "E:\\sudha\\eclipse workspace\\frontshop\\src\\main\\webapp\\assets\\images";
	private static String REAL_PATH = "";

	private static final Logger logger = LoggerFactory.logger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// get real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		// check if directories exist
		if (!new File(ABS_PATH).exists()) {
			// create directories
			new File(ABS_PATH).mkdirs();
		}

		if (!new File(REAL_PATH).exists()) {
			// create directories
			new File(REAL_PATH).mkdirs();
		}

		try {
			// server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IOException ex) {

		}
	}
}
