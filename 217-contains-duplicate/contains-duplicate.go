func containsDuplicate(nums []int) bool {
    m := map[int]int{};

    for _ , num := range nums {
        x , ok := m[num];
        if !ok {
            m[num] = x;
        } else {
            return true;
        }
    }

    return false;
}