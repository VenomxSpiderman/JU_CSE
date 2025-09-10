import heapq

class PriorityQueue:
    def __init__(self):
        self._queue = []
        self._index = 0

    def push(self, item, priority):

        heapq.heappush(self._queue, (-priority, self._index, item))
        self._index += 1

    def pop(self):
        return heapq.heappop(self._queue)[-1]

    def is_empty(self):
        return len(self._queue) == 0

# Example usage:
if __name__ == "__main__":
    pq = PriorityQueue()
    pq.push("task1", 10)
    pq.push("task2", 15)
    pq.push("task3", 31)

    while not pq.is_empty():
        print(pq.pop())