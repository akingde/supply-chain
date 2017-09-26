package com.bs.rest.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommonController extends BaseController{

	@RequestMapping(value = "/")
	public String index() {
		StringBuffer sb = new StringBuffer();
		sb.append("Welcome use bubi app restful APi<br/>")
		.append("RESTful API URL:<a href='http://localhost:8081/swagger-ui.html' target='_blank'>http://localhost:8081/swagger-ui.html</a>");
		return sb.toString();
	}
}
