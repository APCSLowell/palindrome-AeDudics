import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
    String fine = noSpaces(word);
    String fine1 = onlyLetters(fine);
    String fine2 = fine1.toLowerCase();
    if(reverse(fine2).equals(fine2)){
    return true;
  }else{
    return false;
  }
}
  
public String reverse(String str)
{
    String sNew = new String();
    for(int i = str.length()-1; i >= 0; i--){
      sNew += str.substring(i,i+1);
  }
    return sNew;
}

public String noSpaces(String sWord){
 String result = new String();
  for(int i = 0; i < sWord.length(); i++)
     if(!sWord.substring(i,i+1).equals(" "))
       result=result + sWord.substring(i,i+1);
  return result;
}

public String onlyLetters(String sString){
  String thing = "";
  for(int i = 0; i < sString.length(); i++){
    if(Character.isLetter(sString.charAt(i))){
      thing += sString.charAt(i);
    }
  }
  return thing;
}
