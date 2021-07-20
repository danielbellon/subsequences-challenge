package com.appgate.subsequences.core.domain.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@Getter
@ToString
@RequiredArgsConstructor
public class CalculateSubsequencesCommand {

	private final String base;
	private final String target;

	public boolean isValid() {

		return !isInvalidTarget() && !areInvalidStrings();
	}

	private boolean areInvalidStrings() {

		return isBlank(base) && isBlank(target);
	}

	private boolean isInvalidTarget() {

		return target.length() > base.length();
	}

}
