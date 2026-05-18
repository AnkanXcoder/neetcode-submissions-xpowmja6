class Solution {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int maxLen = 0;

        boolean[] visited = new boolean[256];

        while (right < s.length()) {

            while (visited[s.charAt(right)]) {
                visited[s.charAt(left)] = false;
                left++;
            }

            visited[s.charAt(right)] = true;

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}