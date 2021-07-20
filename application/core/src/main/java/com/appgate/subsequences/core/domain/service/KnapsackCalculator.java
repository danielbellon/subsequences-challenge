package com.appgate.subsequences.core.domain.service;

import com.appgate.subsequences.core.domain.model.KnapsackAlgorithm;
import lombok.Data;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@Data
public class KnapsackCalculator implements SubsequenceCalculator {

	@Override
	public int getSubsequences(final String base, final String target) {

		return new KnapsackAlgorithm(base, target).getCount();
	}

}
