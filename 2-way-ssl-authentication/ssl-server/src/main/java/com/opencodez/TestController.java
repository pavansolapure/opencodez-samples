/**
 * 
 */
package com.opencodez;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavan
 *
 */
@RestController
public class TestController {
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!! You are seeing this only because I TRUST YOU!!!";
	}
}
