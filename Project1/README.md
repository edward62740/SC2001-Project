# Hybrid Sort

This is an implementation of the hybrid sort. The algorithm will recursively divide the input array into subarrays of size S. The sorted subarrays are then merged. The pseudocode is as follows:

```
HybridSort(A, start, end)
{
    if(start >= end) return
    if((end-start) > THRESHOLD)
        InsertionSort(A, start, end)
    else
        mid = (start+end) / 2
        HybridSort(A, start, mid)
        HybridSort(A, mid+1, end)
        merge(A, start, end)
}
```

All the following testing used a variable sized array between 500 to 12.5M, and each element $x \in [0, 1000] \cap Z$

The graph below shows the key comparisons made for a variable sized array A, for S fixed at 64.
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/keycmp.png)



The graph below shows the key comparisons made for a variable S, and input size 1M.
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/Screenshot%202023-09-01%20175351.png)

The performance of HybridSort is shown below (with S=64), for input size 10M. It can be shown that there is noticable improvement over the standard Merge Sort algorithm.
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/runtime.png)
