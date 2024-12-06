

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h')); // 1
        System.out.println(countChar(hello, 'l')); // 2
        System.out.println(countChar(hello, 'z')); // 0
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("c", "space"));
        System.out.println(remove("committee","meet"));
                //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
     int count=0;
     for (int i = 0 ; i<str.length();i++){
       if (str.charAt(i) == ch){
        count++;
       }
     }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns false
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str2, String str1) { // finished subsetOf
        if (str2.length() == 0){
            return true;
        }
        if (str2.length() > str1.length()){
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) { // if the first letter of str2 is in str1
                int j = 0;
                str1=remove(str1, "" + str1.charAt(j));
                str2=remove(str2, "" + str2.charAt(j));
                while (j < str2.length()  && str1.charAt(i+j) == str2.charAt(j)) { // checks if the rest of the letters are the same
                    j++;
                }
                if (j == str2.length() || str2.length()==1 ) { // if all the letters are the same
                    return true;
                }
            }
        }
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
     String newStr = "";
     if (str.length() == 1 ) return str;
     if (str.length() == 0 ) return newStr;
     for (int i=0 ; i<str.length()-1;i++){
        newStr=newStr + str.charAt(i);
        newStr=newStr + " ";
     }
     newStr=newStr + str.charAt(str.length()-1);
     return newStr;
    }
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String word ="";
    for ( int i = 0 ; i<n; i++){
    char temp = (char) (Math.random() * 26 + 97);
    word = word + temp;
    }
        return word;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("committee","meet") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
    String temp = str1;
        for (int i=0; i<str2.length();i++){
        int index = temp.indexOf(str2.charAt(i));
        if (index == -1) return temp;
        temp = temp.substring(0, index ) + temp.substring(index+1 , temp.length());
         }
    return temp;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
