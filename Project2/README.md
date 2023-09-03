# Dijsktra's Algorithm

This is an implementation of Dijskra's Algorithm, where the time complexity of linked-list and matrix representations will be compared.

The theoretical time complexity of the operation is denoted below:

| Linked List       | Matrix       |
|-------------------|--------------|
| $O(\|E\|lg\|V\|)$ | $O(\|V\|^2)$ |

<br>

In the following sections, we define that for a undirected, connected graph with $|V|$ vertices, it is sparse if $|E|$ close to the minimum to remain connected (i.e. $|V-1|$), and dense if $|E|$ close to fully-connected (i.e. $\frac{|V| \cdot (|V| - 1)}{2}$).

In the test below, $|V|$ is fixed at 8000. Then the max $|E|$ is ~3.2e7. It can be observed that as $|E| \rightarrow \frac{|V| \cdot (|V| - 1)}{2}$, the runtime of linked list representation increases, while the matrix runtime grows slowly.
<br><br>
![cmp](https://github.com/edward62740/SC2001-Project/blob/main/Project2/doc/8000.png)

It can be observed that a matrix representation is more suitable for dense graphs. These findings are consistent with the implementation of these representations; for each iteration of the Dijkstra's algorithm, at most $|V-1|$ neighbors exist to be checked in a linked-list implementation, while it is always $|V-1|$ for matrix. Hence, it follows that as the average number of neighbours of a linked-list implementation grows to the maximum, the overhead from traversing the linked-list will exceed that of $|V-1|$ array accesses.