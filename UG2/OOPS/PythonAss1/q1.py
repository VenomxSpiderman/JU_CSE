import math

def prime_generator():
    
    primes = [2]
    
    yield 2

    num_to_test = 3

    while True:
        is_prime = True
        sqrt_num_to_test = math.isqrt(num_to_test)

        for p in primes:
            if p > sqrt_num_to_test:
                break
            if num_to_test % p == 0:
                is_prime = False
                break

        if is_prime:
            primes.append(num_to_test)
            yield num_to_test

        num_to_test += 2


if __name__ == "__main__":
    gen = prime_generator()
    for _ in range(20):
        print(next(gen))