import java.util.*;
import java.text.*;
public class player {
	private int rowPosition;
	private int colPosition;
	private boolean hasGold;
	private boolean hasArrow;

	public player(int rowSize) {
		colPosition = 0;
		rowPosition = rowSize;
		hasGold = false;
		hasArrow = true;
	}
	public void move(char direction) {
		//Make the main method check for validity of the moves not here.
		if (direction == 'u' || direction == 'U') {
			rowPosition = rowPosition - 1;
		}
		if (direction == 'd' || direction == 'D') {
			rowPosition = rowPosition + 1;
		}
		if (direction == 'l' || direction == 'L') {
			colPosition = colPosition - 1;
		}
		if (direction == 'r' || direction == 'R') {
			colPosition = colPosition + 1;
		}
	}
	public void shoot() {
		hasArrow = false;
	}
	public boolean checkArrow() {
		return hasArrow;
	}
	public boolean checkGold() {
		return hasGold;
	}
	public void gold() {
		hasGold = true;
		//I think this is wrong as of 11/8 2:00 PM
	}
	public int rowPositionGet() {
		return rowPosition;
	}
	public int colPositionGet() {
		return colPosition;
	}

}
