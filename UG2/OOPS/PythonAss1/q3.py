from itertools import compress, islice

def even_numbers():
    num = 2
    while True:
        yield num
        num += 2

def odd_numbers():
    num = 1
    while True:
        yield num
        num += 2


even_iter = even_numbers()
odd_iter = odd_numbers()

print("Even numbers:")
for x in islice(even_iter, 10):
    print(x)

print("\nOdd numbers:")
for x in islice(odd_iter, 10):
    print(x)
    

numbers = list(range(1, 21))
even_selector = [n % 2 == 0 for n in numbers]
odd_selector = [not x for x in even_selector]

even_numbers_compressed = compress(numbers, even_selector)
odd_numbers_compressed = compress(numbers, odd_selector)

print("\nEven numbers:")
for _ in range(10): 
    print(next(even_numbers_compressed))

print("\nOdd numbers:")
for _ in range(10): 
    print(next(odd_numbers_compressed))