package com.appgate.subsequences.core.domain.model;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since 1.0.0
 */
public class KnapsackAlgorithm {

	final String base;
	final String target;
	final int[][] matrix;

	public KnapsackAlgorithm(final String base, final String target) {

		this.base = base;
		this.target = target;
		this.matrix = new int[target.length() + 1][base.length() + 1];
	}

	public int getCount() {

		fillFirstRow();
		fillFirstColumn();
		fillMatrix();
		return matrix[target.length()][base.length()];
	}

	private void fillMatrix() {

		for (var targetIndex = 1; targetIndex <= target.length(); targetIndex++) {
			for (var baseIndex = 1; baseIndex <= base.length(); baseIndex++) {

				matrix[targetIndex][baseIndex] =
						doLastCharactersMatch(targetIndex, baseIndex) ?
						getSequencesWithoutLastChar(targetIndex, baseIndex) :
						getLastBaseValue(targetIndex, baseIndex);
			}
		}
	}

	private int getLastBaseValue(int targetIndex, int baseIndex) {

		return matrix[targetIndex][baseIndex - 1];
	}

	private int getSequencesWithoutLastChar(int targetIndex, int baseIndex) {

		return matrix[targetIndex][baseIndex - 1] + matrix[targetIndex - 1][baseIndex - 1];
	}

	private boolean doLastCharactersMatch(int targetIndex, int baseIndex) {

		return target.charAt(targetIndex - 1) == base.charAt(baseIndex - 1);
	}

	private void fillFirstRow() {

		for (var j = 0; j <= base.length(); j++) {
			matrix[0][j] = 1;
		}
	}

	private void fillFirstColumn() {

		for (var i = 1; i <= target.length(); i++) {
			matrix[i][0] = 0;
		}
	}
}
