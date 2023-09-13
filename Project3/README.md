# DP

Problem statement: Given some knapsack with capacity $C$ and $n$ non-divisible objects with their corresponding weight $w_{i}$ and profit $p_{i}$, for $i \in [0, n-1] \cap \mathbb{Z}$, find the maximum profit, denoted by $P(C)$.

The recursive definition for $P(C)$ is:

$Base: P(0) = 0$ <br>
$P(C) = max(P(C), P(C - w_{i}) + p_{i})$


Subproblem graph:
##### todo


The pseudocode for the bottom-up approach used to solve this problem is as follows:
```
Knapsack-DP(W, P, C)
{
    int A[][] = new int[W.length+1][C+1]
    for i in W.length+1:
        for j in C+1:
            if j<W[i-1]:
                A[i][j] = A[i-1][j]
            else:
                A[i][j] = max(A[i-1][j], A[i-1][j-W[i-1]] + P[i-1])

    return A[W.length][C]
}
```
