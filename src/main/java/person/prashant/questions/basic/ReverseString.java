package person.prashant.questions.basic;

public class ReverseString {

    private static String reverse(String input){
        if(input != null && input.length() > 1){
            char[] inputChars = input.toCharArray();
            char[] outputChars = new char[input.length()];
            for(int i = 0; i < input.length(); i++){
                outputChars[i] = inputChars[input.length()-1-i];
            }

            return new String(outputChars);
            //return new StringBuilder(input).reverse().toString();
        }
        return input;
    }

    private static void compareOrFail(String a, String b){
        if(a != null && !a.equals(b)){
            throw new RuntimeException(String.format("strings [%s] and [%s] are not equal", a, b));
        }
    }

    public static void main(String[] args) {
        compareOrFail(reverse(null),null);
        compareOrFail(reverse(""),"");
        compareOrFail(reverse("aaa"),"aaa");
        compareOrFail(reverse("ab"),"ba");
        compareOrFail(reverse("abc"),"cba");

    }
}
