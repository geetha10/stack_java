// You will need to import the Random library from java.util
import java.util.Random;

public class PuzzleJava{

    public int[] getTenRolls(){
        int[] resultArray = new int[10];

        for(int i=0;i<10;i++){
            Random rand=new Random();
            resultArray[i]=;
        }

        return resultArray;
    }

    public char getRandomLetter(){
        Character[] alphabet = {
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	    };
        Random rand=new Random();
        int index = rand.nextInt(25);
        return alphabet[index];
    }

    public String generatePassword(){
        String password="";
        for(int i=1;i<=8;i++){
            password += getRandomLetter();
        }
        return password;
    }

    public String getNewPasswordSet(int length){
        String password="";
        for(int i=1;i<=length;i++){
            password += getRandomLetter();
        }
        return password;
    }
    
    public static void shuffeArray(Object[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length/2; i++) {
			Object temp = arr[i];
			int randomIdx = r.nextInt(arr.length - i) + i;
			arr[i] = arr[randomIdx];
			arr[randomIdx] = temp;
		}
	}
}