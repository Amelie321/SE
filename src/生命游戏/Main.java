package ÉúÃüÓÎÏ·;

//Dead->Dead:condition 0 
//LIve->Live:condition 1
//Live->Dead:condition 2
//Dead->Live:condition 3
public class Main {
	public int LiveCount(int[][] board,int row,int col ) {
		int count=0;
		int rowlen=board.length;
		int collen=board[0].length;
		for(int i=row-1;i<=row+1;i++) {
			for(int j=col-1;j<=col+1;j++) {
				if(row < 0||row>=rowlen||col < 0||col>=collen||(i==row && j==col)) {
					continue;
				}
				if(board[i][j]==1||board[i][j]==2)
					count++;
			}
		}
		return count;
	}
	
	public void GameofLive(int[][] board) {
		int rowlen=board.length;
		int collen=board[0].length;
		if(board==null||rowlen==0||collen==0) {
			return;
		}
		for(int i=0;i<rowlen;i++) {
			for(int j=0;j<collen;j++) {
				int count= LiveCount(board,i,j);
				 if(board[i][j]==0 && count ==3){
	                    board[i][j]=3;
	                }else if(board[i][j] == 1 && (count < 2 || count > 3)){
	                    board[i][j]=2;
	                }
			}
		}
		for(int i=0;i<rowlen;i++) {
			for(int j=0;j<collen;j++) {
				board[i][j] = board[i][j] % 2;
			}
		}
	}
	
}
