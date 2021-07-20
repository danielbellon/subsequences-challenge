package com.appgate.subsequences.core.usecases;

import com.appgate.subsequences.core.domain.command.CalculateSubsequencesCommand;
import com.appgate.subsequences.core.domain.service.SubsequenceCalculator;
import lombok.RequiredArgsConstructor;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class CalculateSubsequencesUseCase {

	private final SubsequenceCalculator calculator;

	public int execute(CalculateSubsequencesCommand command) {

		return command.isValid() ?
			   calculator.getSubsequences(command.getBase(), command.getTarget()) :
			   0;
	}
}
