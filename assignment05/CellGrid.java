package assignment05;

public class CellGrid
{
	private boolean[][] cells;
	private int maxRows;
	private int maxCols;
	public CellGrid(int mRows, int mCols)
	{
		maxRows = mRows;
		maxCols = mCols;
		cells = new boolean[mRows][mCols];
		for(int i = 0; i < mRows; i++)
			for(int j = 0; j < mCols; j++)
				cells[i][j] = false;
	}

	public boolean[][] getCells() {
		return cells;
	}

	public void randomStart()
	{
		java.util.Random random = new java.util.Random();
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = random.nextBoolean();		
	}
	public void applyUpdate()
	{
		int[][] tray = new int[maxRows][maxCols];
		for(int i = 0; i < maxRows; i++){
			for(int j = 0; j < maxCols; j++){
				if(i>0){
					if(cells[i-1][j] == true) tray[i][j]++;
				}
				if(j>0){
					if(cells[i][j-1]==true) tray[i][j]++;
				}
				if(i>0 && j>0){
					if(cells[i-1][j-1]==true) tray[i][j]++;
				}
				if(i<maxRows-1){
					if(cells[i+1][j]==true) tray[i][j]++;
				}
				if(j<maxCols-1){
					if(cells[i][j+1]==true) tray[i][j]++;
				}
				if(i<maxRows-1 && j<maxCols-1){
					if(cells[i+1][j+1]==true) tray[i][j]++;
				}
				if(i>0 && j<maxCols-1){
					if(cells[i-1][j+1]==true) tray[i][j]++;
				}
				if(i<maxRows-1 && j>0){
					if(cells[i+1][j-1]==true) tray[i][j]++;
				}
			}
		}
		for(int x = 0; x< maxRows; x++){
			for(int y = 0; y<maxCols; y++){
				if(cells[x][y] == false && tray[x][y] == 3) cells[x][y] = true;
				if(cells[x][y] == true && tray[x][y] >3) cells[x][y] = false;
				if(cells[x][y] == true && tray[x][y] < 2) cells[x][y] = false;
			}
		}
	}

	public void gosperStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[5][1] = true;
		cells[5][2] = true;
		cells[6][1] = true;
		cells[6][2] = true;
		cells[1][25] = true;
		cells[2][23] = true;
		cells[2][25] = true;
		cells[3][13] = true;
		cells[3][14] = true;
		cells[3][21] = true;
		cells[3][22] = true;
		cells[3][35] = true;
		cells[3][36] = true;
		cells[4][12] = true;
		cells[4][16] = true;
		cells[4][21] = true;
		cells[4][22] = true;
		cells[4][35] = true;
		cells[4][36] = true;
		cells[5][11] = true;
		cells[5][17] = true;
		cells[5][21] = true;
		cells[5][22] = true;
		cells[6][11] = true;
		cells[6][15] = true;
		cells[6][17] = true;
		cells[6][18] = true;
		cells[6][23] = true;
		cells[6][25] = true;
		cells[7][11] = true;
		cells[7][17] = true;
		cells[7][25] = true;
		cells[8][12] = true;
		cells[8][16] = true;
		cells[9][13] = true;
		cells[9][14] = true;		
	}

	public void gliderStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[1][3] = true;
		cells[2][4] = true;
		cells[3][2] = true;
		cells[3][3] = true;
		cells[3][4] = true;
	}
}