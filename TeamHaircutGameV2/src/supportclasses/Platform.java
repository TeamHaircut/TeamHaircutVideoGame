package supportclasses;

public class Platform {
	public static int count;
	
	private float x;
	private float y;
	private int col;
	private int row;
	private String res;
	
	public Platform(float x, float y, int col, int row, String res) {
		count++;
		this.x = x;
		this.y = y;
		this.col = col;
		this.row = row;
		this.res = res;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

}
