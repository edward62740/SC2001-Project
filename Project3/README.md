# DP

Problem statement: Given some knapsack with capacity $C$ and $n$ non-divisible objects with their corresponding weight $w_{i}$ and profit $p_{i}$, for $i \in [0, n-1] \cap \mathbb{Z}$, find the maximum profit, denoted by $P(C)$.

The recursive definition for $P(C)$ is:

$Base: P(0) = 0$ <br>
$P(C) = max(P(C), P(C - w_{i}) + p_{i})$


Topologically sorted DAG of subproblems for P(14):<br>
![dp](https://github.com/edward62740/SC2001-Project/blob/main/Project3/doc/dp.jpg)
<br><br>
The pseudocode for the bottom-up approach used to solve this problem is as follows:
```
Knapsack-DP(w[0..n-1], p[0..n-1], C)
{
    ARRAY A[n+1][C+1] = 0
    FOR i in [1..n+1]:
        FOR j in [1..C+1]:
            IF j<w[i-1]:
                A[i][j] = A[i-1][j]
            ELSE:
                A[i][j] = max(A[i-1][j], A[i-1][j-w[i-1]] + p[i-1])

    RETURN A[w.length][C]
}
```

Based on this algorithm, fixing $P(14)$ and $p=[7,6,9]$, the results with $w=[4,6,8]$ and $w=[5,6,8]$ respectively produce the same result $P(14) = 16$, as required.<br>
The figure below displays the contents of the arrays after running.

![run](https://github.com/edward62740/SC2001-Project/blob/main/Project3/doc/run.png)
