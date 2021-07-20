package com.appgate.subsequences.entrypoints.rest.controller;

import com.appgate.subsequences.core.domain.command.CalculateSubsequencesCommand;
import com.appgate.subsequences.core.usecases.CalculateSubsequencesUseCase;
import com.appgate.subsequences.entrypoints.rest.model.SubsequencesResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that exposes the {@link CalculateSubsequencesUseCase} logic
 *
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/subsequence")
public class SubsequencesController {

	/**
	 * Use case with the business logic behind the subsequences count calculation
	 */
	private final CalculateSubsequencesUseCase useCase;

	/**
	 * Receives a base and a target string in order to call the {@link CalculateSubsequencesUseCase}
	 * in order to know how many subsequences from the base string are equals to the target string
	 *
	 * @param base   {@link String} in which the subsequences will be looked in
	 * @param target {@link String} that represent the desired subsequence
	 * @return a {@link ResponseEntity} with the {@link SubsequencesResult} in its body
	 */
	@GetMapping("/count")
	public ResponseEntity<SubsequencesResult> getCount(
			@RequestParam(value = "string") final String base,
			@RequestParam(value = "target") final String target) {

		log.info("Receiving subsequence count request: [Base String: {}, Target: {}]", base, target);

		var stopWatch = new StopWatch();
		stopWatch.start();
		var count = useCase.execute(new CalculateSubsequencesCommand(base, target));
		stopWatch.stop();

		var result = SubsequencesResult
				.builder()
				.withSubsequencesCount(count)
				.withBaseString(base)
				.withTarget(target)
				.withExecutionTimeInMillis(stopWatch.getTotalTimeMillis())
				.build();

		log.info("Subsequences calculation completed: [Result: {}]", result);

		return ResponseEntity.ok(result);
	}
}
