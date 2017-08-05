package com.GKquiz;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class gkquizinitilaizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class<?>[]{rootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new  Class<?>[]{webConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[]{"/"};
	}

}
