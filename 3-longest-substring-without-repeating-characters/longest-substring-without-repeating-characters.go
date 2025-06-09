func lengthOfLongestSubstring(s string) int {
    mp := map[rune]int{}
    l := 0
    res := 0

    runes := []rune(s)
    n := len(runes)

    for r := 0 ; r < n ; r++ {
        if _, ok := mp[runes[r]]; ok {
            l = max(l , mp[runes[r]] + 1)
        }

        mp[runes[r]] = r
        res = max(res , r-l+1)
    }

    return res
}