package com.incloud.tgestiona.b2b.audit;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Value("${user.b2b}")
	private String UserName;

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(UserName);
	}
}
