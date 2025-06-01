func twoSum(numbers []int, target int) []int {
    i, j := 0 , len(numbers) - 1;

    for i <= j {
        a := numbers[i];
        b := numbers[j];

        if a+b > target {
            j--;
        } else if a+b < target {
            i++;
        } else {
            return []int{i+1 , j+1};
        }
    }

    return []int{};
    
}