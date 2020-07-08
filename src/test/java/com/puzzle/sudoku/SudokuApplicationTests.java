package com.puzzle.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SudokuApplicationTests {

	@Autowired
	SudokuChecker sudokuChecker;

	// Testing the isRowValid() with valid solution
	@Test
	public void testValidRow() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(1, sudokuChecker.isRowValid(0, input));
	}

	// Testing the isRowValid() with repeated row element
	@Test
	public void testRepeatedRowElement() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 9, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(0, sudokuChecker.isRowValid(3, input));
	}

	// Testing the isRowValid() with an invalid row element
	@Test
	public void testInvalidRow() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 0 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(0, sudokuChecker.isRowValid(6, input));
	}

	// Testing the isColumnValid() with valid solution
	@Test
	public void testValidColumn() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(1, sudokuChecker.isColumnValid(0, input));
	}

	// Testing the the isColumnValid() with repeated column element
	@Test
	public void testRepeatedColumnElement() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 3, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(0, sudokuChecker.isColumnValid(3, input));
	}

	// Testing the isColumnValid() with an invalid column element
	@Test
	public void testInvalidColumn() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 0, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 0 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(0, sudokuChecker.isColumnValid(6, input));
	}

	// Testing the isSubgridValid() with valid solution
	@Test
	public void testValidSubgrid() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(1, sudokuChecker.isSubgridValid(input));
	}

	// Testing the isSubgridValid() with repeated elements
	@Test
	public void testRepeatedSubgrid() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 8, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(0, sudokuChecker.isSubgridValid(input));
	}

	// Testing the isSubgridValid() with invalid elements
	@Test
	public void testInvalidSubgrid() {
		int[][] input = { { 0, 0, 2, 7, 5, 3, 6, 4, 9 }, { 0, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertEquals(-1, sudokuChecker.isSubgridValid(input));
	}

	// Testing the isValidSudoko() with valid solution
	@Test
	public void testValidSolution() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertTrue(sudokuChecker.isValidSudoko(input));
	}

	// Testing the isValidSudoko() with duplicate row data
	@Test
	public void testDuplicateRows() {
		int[][] input = { { 8, 1, 2, 2, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertFalse(sudokuChecker.isValidSudoko(input));
	}

	// Testing the isValidSudoko() with duplicate column data
	@Test
	public void testDuplicateColumns() {
		int[][] input = { { 8, 1, 2, 2, 5, 3, 6, 4, 9 }, { 8, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertFalse(sudokuChecker.isValidSudoko(input));
	}

	// Testing the isValidSudoko() with invalid
	@Test
	public void testInvalidInput() {
		int[][] input = { { 0, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 3, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertFalse(sudokuChecker.isValidSudoko(input));
	}

	// Testing the isValidSudoko() with Repeated numbers
	@Test
	public void testRepeatedInput() {
		int[][] input = { { 8, 1, 2, 7, 5, 3, 6, 4, 9 }, { 9, 4, 3, 6, 8, 2, 1, 7, 5 }, { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
				{ 1, 5, 4, 2, 7, 7, 8, 9, 6 }, { 3, 6, 9, 8, 4, 5, 7, 2, 1 }, { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
				{ 5, 2, 1, 9, 7, 4, 3, 6, 8 }, { 4, 3, 8, 5, 2, 6, 9, 1, 7 }, { 7, 9, 6, 3, 1, 8, 4, 5, 2 } };
		assertFalse(sudokuChecker.isValidSudoko(input));
	}

	// Testing matrixTranspose() 
	@Test
	public void testmatrixTranspose() {
		int[][] input = { { 8, 1},{2, 4}};
		int[][] transpose = sudokuChecker.matrixTranspose().apply(input);
		assertEquals(input[0][1], transpose[1][0]);
	}

}
