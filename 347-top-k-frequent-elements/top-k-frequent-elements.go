
import (
	"container/heap"
)


type Item struct {
	k int
	v int
}

type Heap []Item

func (h Heap) Less(i, j int) bool {
	return h[i].v > h[j].v
}

func (h Heap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h Heap) Len() int {
	return len(h)
}

func (h *Heap) Push(v interface{}) {
	*h = append(*h, v.(Item))
}

func (h *Heap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func topKFrequent(nums []int, k int) []int {
	m := map[int]int{}

	for _, num := range nums {
		if _, ok := m[num]; ok {
			m[num]++
		} else {
			m[num] = 1
		}
	}

	h := &Heap{}
	heap.Init(h)

	for k, v := range m {
		heap.Push(h, Item{
			k: k,
			v: v,
		})
	}

	res := []int{}

	for i := 0; i < k; i++ {
		t := heap.Pop(h)
		res = append(res, t.(Item).k)
	}

	return res

}
