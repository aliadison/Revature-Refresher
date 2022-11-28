class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ; i<9;i++){
            String nums = "";
            for(int k = 0; k<9;k++){
                char c = board[i][k];
                if(c == '.') continue;
                else if(nums.indexOf(c) == -1){
                    nums += c;
                }else return false;
            }
        }
        for(int i = 0 ; i<9;i++){
            String nums = "";
            for(int k = 0; k<9;k++){
                char c = board[k][i];
                if(c == '.') continue;
                else if(nums.indexOf(c) == -1){
                    nums += c;
                }else return false;
            }
        }
        return true;
    }
}
