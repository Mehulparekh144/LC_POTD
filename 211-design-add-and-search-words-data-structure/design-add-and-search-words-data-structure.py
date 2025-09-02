class TrieNode:

    def __init__(self):
        self.children = {}
        self.isEnd = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()
                

    def addWord(self, word: str) -> None:
        curr = self.root
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            
            curr = curr.children[ch]
        
        curr.isEnd = True

    def search(self, word: str) -> bool:

        def solve(node, idx):
            if idx == len(word):
                return node.isEnd
            
            c = word[idx]

            if c == '.':
                for child in node.children:
                    if solve(node.children[child], idx+1):
                        return True
            
                return False
            else:
                if c not in node.children:
                    return False
                return solve(node.children[c] , idx + 1)
        
        curr = self.root
        return solve(curr, 0)
                



        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)