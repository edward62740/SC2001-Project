# DP

Problem statement: Given some knapsack with capacity $C$ and $n$ non-divisible objects with their corresponding weight $w_{i}$ and profit $p_{i}$, for $i \in [0, n-1] \cap \mathbb{Z}$, find the maximum profit, denoted by $P(C)$.

The recursive definition for $P(C)$ is:

$Base: P(0) = 0$ <br>
$P(C) = max(P(C), P(C - w_{i}) + p_{i})$


Subproblem graph:<br>
![dp](https://github.com/edward62740/SC2001-Project/blob/main/Project3/doc/dp.jpg)
<br><br>
The pseudocode for the bottom-up approach used to solve this problem is as follows:
```
Knapsack-DP(W[0..n-1], P[0..n-1], C)
{
    ARRAY A[n+1][C+1]
    FOR i in [1..n+1]:
        FOR j in [1..C+1]:
            IF j<W[i-1]:
                A[i][j] = A[i-1][j]
            ELSE:
                A[i][j] = max(A[i-1][j], A[i-1][j-W[i-1]] + P[i-1])

    RETURN A[W.length][C]
}
```

Based on this algorithm, fixing $P(14)$ and $P=[7,6,9]$, the results with $W=[4,6,8]$ and $W=[5,6,8]$ respectively produce the same result $P(14) = 16$, as required.<br>
The figure below displays the contents of the arrays after running.

![run](https://github.com/edward62740/SC2001-Project/blob/main/Project3/doc/run.png)
