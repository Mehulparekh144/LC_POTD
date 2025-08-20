"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head

        m = {}

        curr = head

        while curr:
            m[curr] = Node(curr.val)
            curr = curr.next
        
        curr = head
        while curr:
            copy = m[curr]
            copy.next = m.get(curr.next)   # use .get() to handle None
            copy.random = m.get(curr.random)
            curr = curr.next
        
        return m[head]
        