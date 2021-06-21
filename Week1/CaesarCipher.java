package Week1;

public class CaesarCipher {
    public static String encrypt(String input,int key){
        key %= 26;
        StringBuilder upperCase = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuilder lowerCase = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        String shiftedUpper = upperCase.substring(key,26) +  upperCase.substring(0,key);
        String shiftedLower = shiftedUpper.toLowerCase();
        char[] inputArray = input.toCharArray();
        int n=input.length();
        for(int i=0;i<n;i++){
            if(inputArray[i] >= 97 && inputArray[i] <= 122){
                int index = (int)inputArray[i] - 97;
                inputArray[i] = shiftedLower.charAt(index);
            }
            else if(inputArray[i] >= 65 && inputArray[i] <= 90){
                int index = (int)inputArray[i]-65;
                inputArray[i] = shiftedUpper.charAt(index);
            }
        }
        return new String(inputArray);
    }

    public static String encryptTwoKeys(String input,int key1,int key2){
        StringBuilder upperCase = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuilder lowerCase = new StringBuilder("abcdefghijklmnopqrstuvwxyz");

        key1 %= 26;
        key2 %= 26;
        String shiftedUpper1 = upperCase.substring(key1,26) + upperCase.substring(0,key1);
        String shiftedLower1 = shiftedUpper1.toLowerCase();
        String shiftedUpper2 = upperCase.substring(key2,26) + upperCase.substring(0,key2);
        String shiftedLower2 = shiftedUpper2.toLowerCase();
        char[] inputArray = input.toCharArray();
        int n = input.length();
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                if (inputArray[i] >= 97 && inputArray[i] <= 122) {
                    int index = (int) inputArray[i] - 97;
                    inputArray[i] = shiftedLower1.charAt(index);
                } else if (inputArray[i] >= 65 && inputArray[i] <= 90) {
                    int index = (int) inputArray[i] - 65;
                    inputArray[i] = shiftedUpper1.charAt(index);
                }
            }
            else{
                if (inputArray[i] >= 97 && inputArray[i] <= 122) {
                    int index = (int) inputArray[i] - 97;
                    inputArray[i] = shiftedLower2.charAt(index);
                } else if (inputArray[i] >= 65 && inputArray[i] <= 90) {
                    int index = (int) inputArray[i] - 65;
                    inputArray[i] = shiftedUpper2.charAt(index);
                }
            }
        }
        String result = new String(inputArray);
        return result;
    }

    public static void main(String[] args){
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encrypt("First Legion", 23));
        System.out.println(encrypt("First Legion", 17));
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
        System.out.println(encryptTwoKeys("First Legion",23,17));
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
    }
}
