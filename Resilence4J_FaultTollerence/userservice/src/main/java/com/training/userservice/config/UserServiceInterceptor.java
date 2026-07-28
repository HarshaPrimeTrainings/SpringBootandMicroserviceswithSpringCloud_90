package com.training.userservice.config;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class UserServiceInterceptor implements ClientHttpRequestInterceptor{

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		System.out.println("========== Interceptor Triggered ===========");
		request.getHeaders().add("service_name", "userservice");
		return execution.execute(request, body);
	}

}
