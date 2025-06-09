import "fmt"

func trap(height []int) int {
    n := len(height);

    left := make([]int , n);
    right := make([]int, n);

    left[0] = height[0]
    right[n-1] = height[n-1]
 
    for i := 1 ; i < n ; i++ {
        left[i] = max(height[i] , left[i-1]);
    }

    for i := n-2 ; i >= 0 ; i-- {
        right[i] = max(height[i] , right[i+1]);
    }

    total := 0;
    for i , h := range(height) {
        total += min(left[i] , right[i]) - h;
    }

    return total;
}