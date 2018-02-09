package com.opencodez.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencodez.service.InfoServiceImpl;
import com.opencodez.service.interceptors.AppInboundInterceptor;
import com.opencodez.service.interceptors.AppOutboundInterceptor;

@Configuration
public class CXFConfig {

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }
	
    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {    
    	SpringBus springBus = new SpringBus();
       	springBus.getInInterceptors().add(new AppInboundInterceptor());
    	springBus.getOutInterceptors().add(new AppOutboundInterceptor());
    	return springBus;
    }	
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new InfoServiceImpl());
        endpoint.getFeatures().add(new LoggingFeature());
        endpoint.publish("/InfoService");
        return endpoint;
    }
}
