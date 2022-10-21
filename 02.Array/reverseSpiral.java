/*

    Input: R = 3, C = 3
    a = {{9, 8, 7},
        {6, 5, 4},
        {3, 2, 1}}
    Output: 5 6 3 2 1 4 7 8 9
 
*/
class reverseSpiral{
    
    public int[] reverse_Spiral(int r, int c, int[][] a){
        int[] ans = new int[r*c];
        
        int minR = 0;
        int maxR = r-1;
        int minC = 0;
        int maxC = c-1;
        
        int idx = ans.length-1;
        int count = 0;
        int total = r * c;
        
        while(count < total){
            for(int i=minC ; i<=maxC && count < total ; i++){
                ans[idx] = a[minR][i];
                idx--;
                count++;
            }
            minR++;
            
            for(int i=minR ; i<=maxR && count < total; i++){
                ans[idx] = a[i][maxC];
                count++;
                idx--;
            }
            maxC--;
            
            for(int i=maxC ; i>=minC && count < total; i--){
                ans[idx] = a[maxR][i];
                count++;
                idx--;
            }
            maxR--;
            
            for(int i=maxR ; i>=minR && count < total; i--){
                ans[idx] = a[i][minC];
                count++;
                idx--;
            }
            minC++;
        }
        
        return ans;
    }
}
