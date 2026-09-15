class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, "", letters, ans);
        return ans;
    }

    void backtrack(String digits, int index, String list, String[] letters, List<String> ans) {
        if (index == digits.length()) {
            ans.add(list);
            return;
        }
        String s = letters[digits.charAt(index) - '0'];
        for (char c : s.toCharArray()) {
            backtrack(digits, index + 1, list + c, letters, ans);
        }
    }
}