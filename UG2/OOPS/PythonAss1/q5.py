def fibonacci_generator():
    a, b = 0, 1
    yield a
    yield b
    while True:
        a, b = b, a + b
        yield b

gen = fibonacci_generator()

print("First 7 Fibonacci numbers:")
for _ in range(7):
    print(next(gen))

def is_perfect_square(n):
    if n < 0:
        return False
    sqrt_n = int(n**0.5)
    return sqrt_n * sqrt_n == n

def check_fibonacci(num):
    if num < 0:
        return False
    return is_perfect_square(5*num*num + 4) or is_perfect_square(5*num*num - 4)

user_number = int(input("\nEnter a number to check if it's Fibonacci: "))
if check_fibonacci(user_number):
    print(f"{user_number} is a Fibonacci number")
else:
    print(f"{user_number} is not a Fibonacci number") 