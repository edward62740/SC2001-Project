# Dijsktra's Algorithm

This is an implementation of Dijskra's Algorithm, where the time complexity of linked-list and matrix representations will be compared.

The theoretical time complexity of the operation is denoted below:

| Linked List       | Matrix       |
|-------------------|--------------|
| $O(\|E\|lg\|V\|)$ | $O(\|V\|^2)$ |

<br>

The matrix representation is preferable for dense graphs, where $|E|$ is close to $\frac{|V| \cdot (|V| - 1)}{2}$. Hence, the choice of matrix representations is a trade-off between space and time complexity. 
