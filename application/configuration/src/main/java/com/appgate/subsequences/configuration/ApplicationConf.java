package com.appgate.subsequences.configuration;

import com.appgate.subsequences.core.domain.service.KnapsackCalculator;
import com.appgate.subsequences.core.domain.service.SubsequenceCalculator;
import com.appgate.subsequences.core.usecases.CalculateSubsequencesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.appgate.subsequences.entrypoints")
public class ApplicationConf {

	@Bean public SubsequenceCalculator subsequenceCalculator() {

		return new KnapsackCalculator();
	}

	@Bean public CalculateSubsequencesUseCase calculateSubsequencesUseCase(SubsequenceCalculator calculator) {

		return new CalculateSubsequencesUseCase(calculator);
	}
}
