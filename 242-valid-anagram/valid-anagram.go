func isAnagram(s string, t string) bool {
    f1 := [26]int{}
    f2 := [26]int{}

    for _ , r := range s {
        f1[r-'a']++;
    }

    for _ , r := range t {
        f2[r-'a']++;
    }

    return f1 == f2;
}