package com.cgi.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.sp.domain.Employee;

@EnableFeignClients // easy alternative of resttemplate
@EnableAspectJAutoProxy
@EnableDiscoveryClient
@SpringBootApplication
public class SpMongoApplication {
	
	@FeignClient("MS-HR-MYSQL")
	public interface SPClient {
		@RequestMapping(value = "/employees", method = RequestMethod.GET)
		public Iterable<Employee> getEmpsFromSPMS();
	}
	
	@Autowired
	public SPClient spc;

	public static void main(String[] args) {
		SpringApplication.run(SpMongoApplication.class, args);
	}
	
	

}
