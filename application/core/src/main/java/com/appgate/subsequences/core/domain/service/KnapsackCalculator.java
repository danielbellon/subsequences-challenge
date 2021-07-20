package com.appgate.subsequences.core.domain.service;

import com.appgate.subsequences.core.domain.model.KnapsackAlgorithm;
import lombok.Data;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since
 */
@Data
public class KnapsackCalculator implements SubsequenceCalculator {

	@Override
	public int getSubsequences(final String base, final String target) {

		return new KnapsackAlgorithm(base, target).getCount();
	}

}
