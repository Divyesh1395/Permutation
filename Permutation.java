/**
 *This program print all unique combinations of a given string.
 *
 * @author DIVYESH
 */
import java.util.*;

class Permutation {
   public static LinkedHashSet<String> stringPermutation(LinkedHashSet<String> set, char strArray[], char auxArray[], int index){
        for(int i=0; i<strArray.length; i++){
        char m[]; 
        
        //Recurse until we left with two characters.
            if(strArray.length > 2){
                auxArray[index++] = strArray[i];
                
                //Initialize array m with n-1 characters of strArray.
                m = new char[(strArray.length-1)];
                int y = 0;
                for(int z=0; z<strArray.length; z++){
                    if(z != i) m[y++] = strArray[z];
                }
                stringPermutation(set, m, auxArray, index);
                index--;
            }
            
        //Swap the last two remaining characters and print all permutations  .
            else{
                String s = "";
                for(int k=0; k<auxArray.length; k++){
                    s += auxArray[k];
                }
                for(int k=0; k<2; k++){
                    s += strArray[k];
                }
                set.add(s);
                char temp = strArray[1];
                strArray[1] = strArray[0];
                strArray[0] = temp;
            }
            
        }
        return set;
    }

    public static void main(String[] args){

	LinkedHashSet<String> set = new LinkedHashSet<String>();
	Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String");
	String str = scan.nextLine();
        char auxArray[] = new char[str.length()-2];
        char strArray[] = str.toCharArray();
	int c = 0;
        set = stringPermutation(set, strArray, auxArray, c);
	System.out.println("All unique combinations :\n");
        for(String x : set)
            System.out.println(x);
    }
}