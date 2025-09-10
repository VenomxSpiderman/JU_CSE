import heapq

def find_n_largest(coll, n):
    return heapq.nlargest(n, coll)

def find_n_smallest(coll, n):
    return heapq.nsmallest(n, coll)

if __name__ == '__main__':
    numbers = [12, 45, 1, 67, 89, 23, 4, 56, 90, 2,3,4,5,6,77,888,999,111,222,333]
    n_largest = 5
    largest_items = find_n_largest(numbers, n_largest)
    print(f"Largest {n_largest} items: {largest_items}")

    n_smallest = 5
    smallest_items = find_n_smallest(numbers, n_smallest)
    print(f"Smallest {n_smallest} items: {smallest_items}")