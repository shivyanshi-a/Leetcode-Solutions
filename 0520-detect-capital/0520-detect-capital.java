class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;

        boolean firstUpper = Character.isUpperCase(word.charAt(0));
        boolean secondUpper = Character.isUpperCase(word.charAt(1));

        if(!firstUpper && secondUpper) return false;

        for(int i = 2; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i)) != secondUpper){
                return false;
            }
        }
        return true;
    }
}
