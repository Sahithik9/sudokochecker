package com.puzzle.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class SudokuChecker {

	private static final Logger LOGGER = LoggerFactory.getLogger(SudokuChecker.class);

	/**
	 * Checks whether a given row is valid or not.
	 *
	 * @param row  row number.
	 * @param grid sudoku validation input.
	 * @return 0 if the row contains repeated values or an invalid value(values less
	 *         than 1 or greater than 9), 1 if the row is valid.
	 */
	public int isRowValid(int row, int[][] grid) {
		int temp[] = grid[row];
		return Arrays.stream(temp).distinct().toArray().length != 9
				|| Arrays.stream(temp).anyMatch(value -> value < 1 || value > 9) ? 0 : 1;
	}

	/** Transposes the given matrix*/
	public UnaryOperator<int[][]> matrixTranspose() {
		return grid -> {
			return IntStream.range(0, grid[0].length)
					.mapToObj(row -> IntStream.range(0, grid.length).map(c -> grid[c][row]).toArray())
					.toArray(int[][]::new);
		};
	}

	/**
	 * Checks whether a given column is valid or not.
	 *
	 * @param row  row number.
	 * @param grid sudoku validation input.
	 * @return 0 if the row contains repeated values or an invalid value(values less
	 *         than 1 or greater than 9), 1 if the row is valid.
	 */
	public int isColumnValid(int col, int[][] grid) {
		int[][] transpose = matrixTranspose().apply(grid);
		return isRowValid(col, transpose);
	}

	/**
	 * Checks whether all the sub-grids are valid or not.
	 *
	 * @param grid sudoku validation input.
	 * @return -1 if the sub-grids contains an invalid value(values less than 1 or
	 *         greater than 9), 0 if the sub-grid contains repeated values, 1 if the
	 *         sub-grid is valid.
	 */
	public int isSubgridValid(int[][] grid) {
		for (int row = 0; row < 9; row = row + 3) {
			for (int col = 0; col < 9; col = col + 3) {
				Set<Integer> s = new HashSet<Integer>();
				for (int r = row; r < row + 3; r++) {
					for (int c = col; c < col + 3; c++) {
						
						if (grid[r][c] < 1 || grid[r][c] > 9) {
							LOGGER.info("Invalid subgrid in Sudoku");
							return -1;
						} else if (s.add(grid[r][c]) == false) {
							LOGGER.info("Repeated values in Sudoku");
							return 0;
						}
						
						
					}
				}
			}
		}
		return 1;
	}

	/** Checks whether filled out grid is valid or not. */
	public boolean isValidSudoko(int[][] grid) {
		for (int i = 0; i < 9; i++) {
			if (isRowValid(i, grid) < 1 || isColumnValid(i, grid) < 1) {
				LOGGER.info("Invalid row/column in Sudoku");
				return false;
				}
		}
		return isSubgridValid(grid) < 1 ? false : true;
	}
}