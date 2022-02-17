public class TestPuzzle{
    public static void main(String[] args){
        PuzzleJava puzzleApp= new PuzzleJava();
        
        System.out.println("******* getTenRolls *******");
        int[] tenRolls=puzzleApp.getTenRolls(); 
        for(int i=0;i<10;i++){
            System.out.println(tenRolls[i]);
        }

        System.out.println("******* getRandomLetter *******");
        System.out.println(puzzleApp.getRandomLetter());

        System.out.println("******* generatePassword *******");
        System.out.println(puzzleApp.generatePassword());
        

        System.out.println("******* getNewPasswordSet *******");
        System.out.println(puzzleApp.getNewPasswordSet(40));

    }
}