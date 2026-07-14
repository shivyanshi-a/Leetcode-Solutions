class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();

        for (String word : words) {

            if (word.length() == 0)
                continue;

            set.remove(word);

            if (canForm(word, set, new HashMap<>())) {
                ans.add(word);
            }

            set.add(word);
        }

        return ans;
    }

    private boolean canForm(String word,
                            HashSet<String> set,
                            HashMap<String, Boolean> memo) {

        if (memo.containsKey(word))
            return memo.get(word);

        for (int i = 1; i < word.length(); i++) {

            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (set.contains(prefix)) {

                if (set.contains(suffix) || canForm(suffix, set, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }

        memo.put(word, false);
        return false;
    }
}