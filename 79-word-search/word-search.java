class Solution {
    int[] row_dif={0,-1,0,1};
    int[] col_dif={-1,0,1,0};
    boolean is_exist=false;
    public void rec(char[][] B,String word,int R,int C,int row,int col,int wind,int WLEN){
        if(wind==WLEN){
            is_exist=true;
            return;
        }
        char temp=B[row][col];
        B[row][col]='?';
        for(int i=0;i<4;i++){
            int trow=row-row_dif[i];
            int tcol=col-col_dif[i];
            if(trow<0 || trow>=R || tcol<0 || tcol>=C)continue;
            
            if(B[trow][tcol]==word.charAt(wind)){
                rec(B,word,R,C,trow,tcol,wind+1,WLEN);
            }
            

        }
        B[row][col]=temp;
    }
    public boolean exist(char[][] board, String word) {
        int R=board.length,C=board[0].length,WLEN=word.length();
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]==word.charAt(0)){
                    rec(board,word,R,C,row,col,1,WLEN);
                    if(is_exist){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}