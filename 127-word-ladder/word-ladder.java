class Pair {
    String word;
    int length;

    public Pair(String word, int length) {
        this.word = word;
        this.length = length;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int length = p.length;

            if (Objects.equals(word , endWord))
                return length;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder newWord = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    newWord.setCharAt(i, ch);

                    if (set.contains(newWord.toString())) {
                        q.offer(new Pair(newWord.toString(), length + 1));
                        set.remove(newWord.toString());
                    }
                }
            }
        }

        return 0;
    }
}