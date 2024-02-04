package com.APIgateway.service;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class NettyWebServerFactorySslCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
	@Override
	public void customize(NettyReactiveWebServerFactory serverFactory) {
		Ssl ssl = new Ssl();
		ssl.setEnabled(true);
		ssl.setKeyStore("classpath:sample.jks");
		ssl.setKeyAlias("netty");
		ssl.setKeyPassword("pass");
		ssl.setKeyStorePassword("pass");
	}
}
