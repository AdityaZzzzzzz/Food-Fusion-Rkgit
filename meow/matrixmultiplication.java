//2 d Matrix multiplication
public class matrixmultiplication {
    public static void main(String[] args) {
        int ar1[][]= {{1,2},
                     {3,4}};
        int ar2[][]= {{1,2},
                     {3,4}};

            int ar3  [][]= new int[3][3]; 
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        ar3[i][j]+= ar1[i][k] * ar2[k][j];
                        
                    }
                    
                }
                
            }      
        System.out.println("Resultant Matrix:");
       for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(ar3[i][j]+" ");
                    
                }
                System.out.println();
            }  

    }  
}
