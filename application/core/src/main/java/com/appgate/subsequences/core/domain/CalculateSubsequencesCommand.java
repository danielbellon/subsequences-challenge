package com.appgate.subsequences.core.domain;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@Getter
@ToString
public class CalculateSubsequencesCommand {

	// -----------------------------------------------------------------------------------------------------------------
	// Command Structure
	// -----------------------------------------------------------------------------------------------------------------

	private final String originalString;
	private final String subsequenceToLookFor;

	// -----------------------------------------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------------------------------------

	public CalculateSubsequencesCommand(final String originalString, final String subsequenceToLookFor) {

		validateCommand(originalString, subsequenceToLookFor);
		this.originalString = originalString;
		this.subsequenceToLookFor = subsequenceToLookFor;
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Business Rules
	// -----------------------------------------------------------------------------------------------------------------

	private void validateCommand(final String originalString, final String subsequenceToLookFor) {

		validateStringsEmptiness(originalString, subsequenceToLookFor);
		validateStringsLength(originalString, subsequenceToLookFor);
	}

	private void validateStringsEmptiness(final String originalString, final String subsequenceToLookFor) {

		if (StringUtils.isBlank(originalString) || StringUtils.isBlank(subsequenceToLookFor)) {
			throw new InvalidCommandException("");
		}
	}

	private void validateStringsLength(final String originalString, final String subsequenceToLookFor) {

		if (subsequenceToLookFor.length() > originalString.length()) {
			throw new InvalidCommandException("");
		}
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Business Exceptions
	// -----------------------------------------------------------------------------------------------------------------

	public static class InvalidCommandException extends RuntimeException {

		public InvalidCommandException(String message) {

			super(message);
		}
	}
}
