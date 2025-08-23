class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        q = deque()
        q.append((beginWord, 1))
        vis = set()
        words = set(wordList)

        while q:
            word, n = q.popleft()

            if word == endWord:
                return n
            
            word_arr = list(word)

            for i,letter in enumerate(word_arr):
                for c in range(ord('a') , ord('z') + 1):
                    word_arr[i] = chr(c)

                    new_word = "".join(word_arr)
                    if new_word in words and new_word not in vis:
                        vis.add(new_word)
                        q.append((new_word, n + 1))
                
                word_arr[i] = letter

        return 0
        