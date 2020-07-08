# Sudoku Checker:
* Checks whether a filled out grid is a valid solution. <br /> 
	- Each row must contain the digits 1-9 without repetition. <br /> 
	- Each column must contain the digits 1-9 without repetition. <br /> 
	- Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition. <br /> 
* Sample input should be passed from a text file. e.g: input.txt <br />
* Input : 
				<code> 8 1 2 7 5 3 6 4 9 </code>
                                <code> 9 4 3 6 8 2 1 7 5 </code>
				<code> 6 7 5 4 9 1 2 8 3 </code>
				<code> 1 5 4 2 3 7 8 9 6 </code>
				<code> 3 6 9 8 4 5 7 2 1 </code>
				<code> 2 8 7 1 6 9 5 3 4 </code>
				<code> 5 2 1 9 7 4 3 6 8 </code>
				<code> 4 3 8 5 2 6 9 1 7 </code>
				<code> 7 9 6 3 1 8 4 5 2 </code>

* Output : <code>  Sudoku Grid is Valid </code>
* Returns log message as
	"Sudoku Grid is Valid" or "Sudoku Grid is InValid"

