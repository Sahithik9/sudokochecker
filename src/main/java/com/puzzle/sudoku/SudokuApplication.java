package com.puzzle.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudokuApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SudokuApplication.class);

	static SudokuChecker sudokuValidation = new SudokuChecker();

	private static Scanner input;

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(SudokuApplication.class, args);

		try {
			if (args.length < 1) {
				LOGGER.info("Input required!");
				return;
			}
			final HashMap<String, String> cmdlineargs = new HashMap<String, String>();

			String[] parameter = null;
			parameter = args[0].split("=");
			if (parameter.length == 2) {
				cmdlineargs.put(parameter[0], parameter[1]);
			}

			input = new Scanner(new FileReader(new File(cmdlineargs.get("inputFilePath"))));
			int iRows = 9, iCols = 9;
			int[][] intArr = new int[iRows][iCols];
			for (int i = 0; i < iRows; i++) {
				for (int j = 0; j < iCols; j++) {
					try {
					intArr[i][j] = input.nextInt();
					}catch(Exception e) {
						LOGGER.info("Invalid Sudoku input. Please check the input.txt file.");
						return;
					}
				}
			}
			input.close();
			if (sudokuValidation.isValidSudoko(intArr)) {
				LOGGER.info("Sudoku Grid is Valid");
			} else {
				LOGGER.info("Sudoku Grid is InValid");
			}

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			throw new FileNotFoundException();
		}
	}

}
