package com.appgate.subsequences.entrypoints;

import com.appgate.subsequences.core.domain.command.CalculateSubsequencesCommand;
import com.appgate.subsequences.core.usecases.CalculateSubsequencesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/subsequence")
public class SubsequencesController {

	private final CalculateSubsequencesUseCase useCase;

	@GetMapping("/count")
	public ResponseEntity<Integer> getCount(final String base, final String target) {

		return ResponseEntity.ok(useCase.execute(new CalculateSubsequencesCommand(base, target)));
	}
}
