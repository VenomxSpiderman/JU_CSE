import cProfile
import pstats
import time
import itertools
import math

def find_pythagorean_triples(limit):
    return [(a, b, c) for a, b, c in itertools.combinations(range(1, limit + 1), 3) if a**2 + b**2 == c**2]

def optimized_find_pythagorean_triples(limit):
    return [(a, b, c) for a in range(1, limit) for b in range(a, limit) if (c := math.isqrt(a**2 + b**2)) <= limit and a**2 + b**2 == c**2]

if __name__ == "__main__":
    limit = 1000

    print("Profiling brute force approach:")
    profiler = cProfile.Profile()
    profiler.enable()
    find_pythagorean_triples(limit)
    profiler.disable()
    stats = pstats.Stats(profiler)
    stats.strip_dirs()
    stats.sort_stats("time")
    stats.print_stats()

    print("\nProfiling optimized approach:")
    profiler = cProfile.Profile()
    profiler.enable()
    optimized_find_pythagorean_triples(limit)
    profiler.disable()
    stats = pstats.Stats(profiler)
    stats.strip_dirs()
    stats.sort_stats("time")
    stats.print_stats()
