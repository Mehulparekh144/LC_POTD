import "sort"

func threeSum(nums []int) [][]int {
	n := len(nums)

	res := [][]int{}

	sort.Ints(nums)

	for i := range nums {

		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		j := i + 1
		k := n - 1

		for j < k {

			sum := nums[i] + nums[j] + nums[k]

			if sum > 0 {
				k--
			} else if sum < 0 {
				j++
			} else {
				res = append(res, []int{nums[i], nums[j], nums[k]})
				j++
				k--

				for j < k && nums[j] == nums[j-1] {
					j++
				}

				for j < k && nums[k] == nums[k+1] {
					k--
				}
			}
		}
	}

	return res
}