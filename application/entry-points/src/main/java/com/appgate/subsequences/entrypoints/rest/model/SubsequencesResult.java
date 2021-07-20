package com.appgate.subsequences.entrypoints.rest.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@ToString
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class SubsequencesResult {

	private String baseString;
	private String target;
	private Integer subsequencesCount;
	private Long executionTimeInMillis;

}
