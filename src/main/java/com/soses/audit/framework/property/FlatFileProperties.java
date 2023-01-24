package com.soses.audit.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:/properties/${hris_env}/flatfile.properties")
@Component
public class FlatFileProperties {

	@Value("${customer.store.base.path}")
    protected String customerStorePath;

	public String getCustomerStorePath() {
		return customerStorePath;
	}
}
