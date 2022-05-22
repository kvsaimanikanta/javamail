package com.springmvc.lc.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.springmvc.lc" })
@PropertySources({ @PropertySource("classpath:email.properties") })
public class LcApplicationConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	Logger logger = Logger.getLogger(LcApplicationConfig.class.getName());

	// creating view resolver
	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// formatter
	@Override
	public void addFormatters(FormatterRegistry registry) {

		registry.addFormatter(new PhoneNumberFormatter());
	}

	// Loading messages from the property file
	@Bean(name = "messageSource")
	MessageSource messageSource() {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("Messages");

		return messageSource;
	}

	@Bean(name = "validator")
	LocalValidatorFactoryBean validator() {

		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());

		return bean;
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return validator();
	}

	// to send gmail 
	@Bean
	public JavaMailSender getJavaMailSender() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();

		/*
		 * with out using the properties file
		 * javaMailSenderImpl.setHost("smtp.gmail.com"); // this is the default host for
		 * the gmail javaMailSenderImpl.setUsername("knani58259");
		 * javaMailSenderImpl.setPassword("sai58259"); 
		 * javaMailSenderImpl.setPort(587); // this the default port for the gmail
		 */
		
		logger.info(">>>>>>>>>>>>>>>>> Inside the javaMailSenderImpl method");

		// By using the properties file
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.userName"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(getIntProperty("mail.port"));

		javaMailSenderImpl.setJavaMailProperties(getMailProperties());

		return javaMailSenderImpl;

	}

	int getIntProperty(String key) {

		String property = env.getProperty(key);

		return Integer.parseInt(property);
	}

	private Properties getMailProperties() {

		// Default properties for the email sender
		Properties properties = new Properties();
//		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		return properties;
	}

}
