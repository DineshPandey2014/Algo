package Graph;

/**
 * https://www.youtube.com/watch?v=dis_c84ejhQ
 * https://www.youtube.com/watch?v=eL-KzMXSXXI&t=308s
 *
 * 1) For graph to be having topological sorting. Graph must be DAG
 *    Directed and Acyclic Graph ( No Cycle) means No (A-->B--->C-->A)
 *  It's a linear ordering of vertices such that for every directed edge uv for vertex u to v (u--->v)
 *  u comes before vertex v in the ordering
 *
 *  2) Every DAG Should have atleast one Topological Sorting ordering.
 *  Asingle graph can have more then one topologocal sorting.
 *
 *
 *  Step : To find topological Sorting.
 *  1. First find in degree for every vertex.
 *  2. First choose the vertex whose indegree is zeror.
 *
 *
 *
 *
 *                                /--> 2 ------->3
 *                              /      |      -->
 *                             1       |    /
 *                             \       <   /
 *                              \-->---4  / -------->5
 *
 *      TWO TOPOLOGICAL SORTING IS POSSIBLE
 *      1) 1,2,4,3,5
 *      2) 1,2,4,5,3
 *
 *  Reason  For  Graph Not Having Topoilogical Sorting For Cyclis graph : Because for cyclic graph we have indgree is 1 not 0.
 *
 *  3. By defination all rooted trees have a topological ordering since they do not contain
 *     any cycles.
 *
 *  ## Programitically How To Find Topological Sorting ##
 *
 *  1. Pick an unvisited node.
 *  2. Begnining with a selected node, do a Depth First Search (DFS) exploring only unvisited nodes
 *  3. On the recursive callback of the DFS add the current node to the topological ordering in the
 *     reverse order.
 *
 *
 *
 */
public class Topological_Sorting {


}
