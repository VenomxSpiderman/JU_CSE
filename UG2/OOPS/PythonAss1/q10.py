import time

def geometric_progression(a, q):
    start_time = time.time()
    
    current = a
    loop_start_time = time.time()
    
    while current <= 100000:
        yield current
        current *= q
    
    loop_time = time.time() - loop_start_time
    total_time = time.time() - start_time
    
    print(f"Time within loop: {loop_time:.6f} seconds")
    print(f"Total time: {total_time:.6f} seconds")
    return

a = int(input("Enter the first term: "))
q = float(input("Enter the common ratio: "))

for term in geometric_progression(a, q):
    print(term)