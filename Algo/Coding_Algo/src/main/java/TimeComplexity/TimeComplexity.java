package TimeComplexity;

/*
---------------------------------------------------------------------------------------------------------------------
Unsorted Array :

    Insert: O(1) //Add the elements on the last

    Search: O(n) // Need to compare each element

    Find min: O(n) // Need to compare each element

    Delete Min: O(n) + O(n) = 2(O(n) = O(n) // Find the element O(n) + After deletion of the element agan fill the empty place that will be O(n)

----------------------------------------------------------------------------------------------------------------------
Sorted Array : In Ascending order (example)

     Insert: (logn) + O(n);  // log n for searching the element + order of n for making the place.

     Search: O(n) // Worst case last element will be n.

     Find Min: O(1) // In ascending order first element will be minimum

     Delete min: : O(n) // In asc ending order, First element will be minimum but you need to move all elements.

----------------------------------------------------------------------------------------------------------------------

Unsorted Linked List:

    Insert : O(1) // Insert the elements in the begining. Change the head pointer.

    Search : O(n) // Linear search

    Find Min : O(n) // Find minimum need n comparison from head node to last end.

    Delete Min: O(n)

----------------------------------------------------------------------------------------------------------------------
Min Heap :

    Insert : O(logn)

    Find Min : O(1)

    Delete Min :O(logn)


----------------------------------------------------------------------------------------------------------------------

*/