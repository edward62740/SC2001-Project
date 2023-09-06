# Hybrid Sort

This is an implementation of the hybrid sort. The algorithm will recursively divide the input array into subarrays of size S. The sorted subarrays are then merged. The pseudocode is as follows:

```
HybridSort(A, start, end)
{
    if(start >= end) return
    if((end-start) <= THRESHOLD)
        InsertionSort(A, start, end)
    else
        mid = floor((start+end) / 2)
        HybridSort(A, start, mid)
        HybridSort(A, mid+1, end)
        merge(A, start, end)
}
```

## Time Complexity
The theoretical time complexity is:
| Best                      | Avg                       | Worst                     |
|---------------------------|---------------------------|---------------------------|
| $O(n+nlog(\frac{n}{S}))$ | $O(nS+nlog(\frac{n}{S}))$ | $O(nS+nlog(\frac{n}{S}))$ |


where $S \in [1, n]$, and represents the point at which the recursion stops and insertion sort is used. The following testing will determine the optimum value of S for improved runtime over Merge Sort, for this particular case.
<br><br>
The time complexity is derived as follows. <br>

Suppose we have $n$ elements. Then the algorithm will recursively divide $n$ elements into sublists of size $\frac{n}{S}$. 

For the merge sort segment, with the recurrence relation $T(n) = 2T(\frac{n}{2}) + O(n)$. Then the height of the recursion tree is approx. $h = log(\frac{n}{S})$   ($2^h=\frac{n}{S}$), and the copying of elements is $O(n)$, then the complexity of the merge sort segment is given by $O(nlog(\frac{n}{S}))$.<br>
Next, we have insertion sort which has $O(n)$ in the best, $O(n^2)$ in avg and worst cases. It follows that for $\frac{n}{S}$ lists of length $S$, the time complexity of the insertion sort segment is $O(S) *\frac{n}{S} = O(n)$ and $O(S^2) *\frac{n}{S} = O(nS)$ for best, avg/worst cases respectively.
<br><br>


All the testing used a variable sized array between 500 to 12.5M, where each element $x \in [0, 1000] \cap Z$

<br><br>
The graph below shows the key comparisons made for a variable sized array, for S fixed at 64.
<br><br>
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/keycmp.png)

<br><br>
The graph below shows the key comparisons made for a variable S, and fixed input size 1M.
<br><br>
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/svscmp.png)
<br><br>
However, the optimum value of S cannot be determined by the key comparisons alone. When the recursion overhead exceeds the higher time complexity of insertion sort, we can observe that the runtime reflects this factor.
<br><br>
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/Svsruntime.png)
<br><br>
## Comparison with Merge Sort

The performance of HybridSort is shown below (with S=64), for input size 10M. It can be shown that there is noticable improvement over the standard Merge Sort algorithm (approx. 1.2x faster, for input size of 10M). <br><br>
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/runtime.png)
<br><br>
It is evident that for all S > 1, there are more key comparisons than S = 1. Indeed, the number of key comparisons for this particular test case is ~1.37x more for the HybridSort, over the MergeSort. Hence, the improved runtime of the HybridSort could be attributed to factors such as the recursion overhead, cache locality etc.


<br><br>
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project1/doc/cmpsort.png)