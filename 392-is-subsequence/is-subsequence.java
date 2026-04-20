class Solution {
    public boolean isSubsequence(String s, String t) {
        int n= s.length();
        int m= t.length();

        int a[][]= new int [n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    a[i][j]=1+a[i-1][j-1];
                }else{
                    a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
                }
            }
        }
        return ((a[n][m]==n?true:false));
    }
}