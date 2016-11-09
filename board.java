import java.util.*;
import java.text.*;
public class board {
	private cell[][] cellArray;
	private player player1;
	int colSize;
	int rowSize;
	boolean wumpusExists;
	int rowPosition;
	int colPosition;

	public board () {
		Random rand = new Random();
		wumpusExists = true;
		boolean gold = false;
		boolean pit = false;
		boolean wumpus = false;
		boolean cave = false;
		int goldInt = 0;
		int pitInt = 0;
		int wumpusInt = 0;
		if (gold == false) {
			goldInt = rand.nextInt(10) + 1;
			if (goldInt == 3) {
				gold = true;
			}
		}
		pitInt = rand.nextInt(10) + 1;
		if (pitInt == 1) {
			pit = true;
		}
		if (wumpus == false && gold == false) {
			wumpusInt = rand.nextInt(10) + 1;
			if (wumpusInt == 7) {
				wumpus = true;
			}
		}
		rowSize = rand.nextInt(6) + 4;
		colSize = rand.nextInt(6) + 4;
		cellArray = new cell[rowSize][colSize];
		player1 = new player(rowSize);
		rowPosition = player1.rowPositionGet();
		colPosition = player1.colPositionGet();
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (i == rowSize - 1 && j == 0) {
					cave = true;
				}
				cellArray[i][j] = new cell(gold, wumpus, cave, pit);
			}
		}//end of double for loop
	}//constructor closing tag
	public boolean goldAround() {
		boolean goldIsNear = false;
		boolean check = false;
		if (rowPosition > 1) {//Checks the cell aboce current position
			check = cellArray[rowPosition - 1][colPosition].checkGold();
			if (check == true) {
				goldIsNear = true;
				return goldIsNear;
			}
		}
		if (colPosition > 1) {//Checks the cell to the left of the current position
			check = cellArray[rowPosition][colPosition - 1].checkGold();
			if (check == true) {
				goldIsNear = true;
				return goldIsNear;
			}
		}
		if (rowPosition < rowSize) {
			check = cellArray[rowPosition + 1][colPosition].checkGold();
			if (check == true) {
				goldIsNear = true;
				return goldIsNear;
			}
		}
		if (colPosition < colSize) {
			check = cellArray[rowPosition][colPosition + 1].checkGold();
			if (check == true) {
				goldIsNear = true;
				return goldIsNear;
			}
		}
		return goldIsNear;
	}
	public boolean pitAround(int rowPosition, int colPosition) {
		boolean pitIsNear = false;
		boolean check = false;
		if (rowPosition > 1) {//Checks the cell aboce current position
			check = cellArray[rowPosition - 1][colPosition].checkPit();
			if (check == true) {
				pitIsNear = true;
				return pitIsNear;
			}
		}
		if (colPosition > 1) {//Checks the cell to the left of the current position
			check = cellArray[rowPosition][colPosition - 1].checkPit();
			if (check == true) {
				pitIsNear = true;
				return pitIsNear;
			}
		}
		if (rowPosition < rowSize) {
			check = cellArray[rowPosition + 1][colPosition].checkPit();
			if (check == true) {
				pitIsNear = true;
				return pitIsNear;
			}
		}
		if (colPosition < colSize) {
			check = cellArray[rowPosition][colPosition + 1].checkPit();
			if (check == true) {
				pitIsNear = true;
				return pitIsNear;
			}
		}
		return pitIsNear;
	}
	public boolean wumpusAround(int rowPosition, int colPosition) {
		boolean wumpusIsNear = false;
		boolean check = false;
		if (rowPosition > 1) {//Checks the cell aboce current position
			check = cellArray[rowPosition - 1][colPosition].checkWumpus();
			if (check == true) {
				wumpusIsNear = true;
				return wumpusIsNear;
			}
		}
		if (colPosition > 1) {//Checks the cell to the left of the current position
			check = cellArray[rowPosition][colPosition - 1].checkWumpus();
			if (check == true) {
				wumpusIsNear = true;
				return wumpusIsNear;
			}
		}
		if (rowPosition < rowSize) {
			check = cellArray[rowPosition + 1][colPosition].checkWumpus();
			if (check == true) {
				wumpusIsNear = true;
				return wumpusIsNear;
			}
		}
		if (colPosition < colSize) {
			check = cellArray[rowPosition][colPosition + 1].checkWumpus();
			if (check == true) {
				wumpusIsNear = true;
				return wumpusIsNear;
			}
		}
		return wumpusIsNear;
	}
	public boolean move(char direction) {
		boolean validMove = false;
		if ((direction == 'u' || direction == 'U') && rowPosition > 1) {
			rowPosition = rowPosition - 1;
			validMove = true;
			player1.move(direction);
			return validMove;
			//Need to put something here that changes player object
			//which I've yet to create
		}
		else if ((direction == 'u' || direction == 'U') && rowPosition <= 1) {
			validMove = false;
			return validMove;
		}
		if ((direction == 'd' || direction == 'D') && rowPosition < rowSize) {
			rowPosition = rowPosition + 1;
			validMove = true;
			player1.move(direction);
			return validMove;
			//Once again I need to finish this shit out
		}
		else if ((direction == 'd' || direction == 'D') && rowPosition >= rowSize) {
			validMove = false;
			return validMove;
		}
		if ((direction == 'l' || direction == 'L') && colPosition > 1) {
			colPosition = colPosition - 1;
			validMove = true;
			player1.move(direction);
			return validMove;
			//Finish this shit
		}
		else if ((direction == 'l' || direction == 'L') && colPosition <= 1) {
			validMove = false;
			return validMove;
		}
		if ((direction == 'r' || direction == 'R') && colPosition < colSize) {
			colPosition = colPosition + 1;
			validMove = true;
			player1.move(direction);
			return validMove;
			//Finish
		}
		else if ((direction == 'r' || direction == 'R') && colPosition >= colSize) {
			validMove = false;
			return validMove;
		}
		return validMove;
	}
	public boolean shootArrow(char direction) {
		boolean hasArrow = player1.checkArrow();
		boolean wumpusKilled = false;
		if (hasArrow == true) {
			if ((direction == 'u' || direction == 'U') && rowPosition > 1) {
				for (int i = rowPosition; i > 1; i--) {
					boolean wumpus = cellArray[i][colPosition].checkWumpus();
					if (wumpus == true) {
						player1.shoot();//COPY THIS TO ALL OF THESE
						wumpusExists = false;
						wumpusKilled = true;
						cellArray[i][colPosition].removeWumpus();//HAVE TO COPY THIS TO ALL OF THESE STATEMENTS
						return wumpusKilled;
					}
					else {
						wumpusKilled = false;
						return wumpusKilled;
					}
				}
			}
			else if ((direction == 'u' || direction == 'U') && rowPosition <= 1) {
				wumpusKilled = false;
				return wumpusKilled;
			}
			if ((direction == 'd' || direction == 'D') && rowPosition < rowSize) {
				for (int i = rowPosition; i < rowSize; i++) {
					boolean wumpus = cellArray[i][colPosition].checkWumpus();
					if (wumpus == true) {
						player1.shoot();//COPY THIS TO ALL OF THESE
						wumpusExists = false;
						wumpusKilled = true;
						cellArray[i][colPosition].removeWumpus();//HAVE TO COPY THIS TO ALL OF THESE STATEMENTS
						return wumpusKilled;
					}
					else {
						wumpusKilled = false;
						return wumpusKilled;
					}
				}
			}
			else if ((direction == 'd' || direction == 'D') && rowPosition < rowSize) {
				wumpusKilled = false;
				return wumpusKilled;
			}
			if ((direction == 'l' || direction == 'L') && colPosition > 1) {
				for (int i = colPosition; i > 1; i--) {
					boolean wumpus = cellArray[rowPosition][i].checkWumpus();
					if (wumpus == true) {
						player1.shoot();//COPY THIS TO ALL OF THESE
						wumpusExists = false;
						wumpusKilled = true;
						cellArray[rowPosition][i].removeWumpus();//HAVE TO COPY THIS TO ALL OF THESE STATEMENTS
						return wumpusKilled;
					}
					else {
						wumpusKilled = false;
						return wumpusKilled;
					}
				}
			}
			else if ((direction == 'l' || direction == 'L') && colPosition > 1) {
				wumpusKilled = false;
				return wumpusKilled;
			}
			if ((direction == 'r' || direction == 'R') && colPosition < colSize) {
				for (int i = colPosition; i < colSize; i++) {
					boolean wumpus = cellArray[rowPosition][i].checkWumpus();
					if (wumpus == true) {
						player1.shoot();//COPY THIS TO ALL OF THESE
						wumpusExists = false;
						wumpusKilled = true;
						cellArray[rowPosition][i].removeWumpus();//HAVE TO COPY THIS TO ALL OF THESE STATEMENTS
						return wumpusKilled;
					}
					else {
						wumpusKilled = false;
						return wumpusKilled;
					}
				}
			}
			else if ((direction == 'r' || direction == 'R') && colPosition < colSize) {
				wumpusKilled = false;
				return wumpusKilled;
			}
		}
		else {
			wumpusKilled = false;
			return wumpusKilled;
		}
		return wumpusKilled;
	}
	public boolean climbOut() {
		return true;
	}
	public boolean getGold() {
		return true;
	}
	public int getRowSize() {
		return rowSize;
	}
	public int getColSize() {
		return colSize;
	}
	public boolean checkForArrow() {
		boolean hasArrow = player1.checkArrow();
		return hasArrow;
	}
	public boolean atCave() {
		boolean atTheCave = cellArray[rowPosition][colPosition].checkCave();
		return atTheCave;
	}
	public boolean atGold() {
		boolean atTheGold = cellArray[rowPosition][colPosition].checkGold();
		return atTheGold;
	}
	public void updatePosition() {
		rowPosition = player1.rowPositionGet();
		colPosition = player1.colPositionGet();
	}
}//class closing tag
