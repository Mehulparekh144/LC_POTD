import "sort"

func groupAnagrams(strs []string) [][]string {
    m := map[string][]string{};

    for _ , str := range strs {
        sorted := sortString(str);

        arr , ok := m[sorted];
        if ok {
            m[sorted] = append(arr , str);
        } else {
            m[sorted] = []string{str};
        }
    }

    res := [][]string{};
    for _, v := range m {
        res = append(res , v);
    }

    return res;
}

func sortString(str string) string {
    b := []byte(str);
    sort.Slice(b , func(i , j int) bool {
        return b[i] < b[j]
    });
    return string(b);
}