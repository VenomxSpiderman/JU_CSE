#include <stdio.h>
#include <limits.h>
long long fibonacci_iterative(int n);
long long fibonacci_recursive(int n);
int main()
{
    int n;
    printf("Enter a positive integer n: ");
    scanf("%d", &n);

    if (n < 0)
    {
        printf("Fibonacci is not defined for negative numbers.\n");
        return 1;
    }

    unsigned long long fib_iter = fibonacci_iterative(n);
    unsigned long long fib_rec = fibonacci_recursive(n);
    if (fib_iter == -1)
        printf("Overflows");
    else
        printf("Iterative Fibonacci of %d: %llu\n", n, fib_iter);
    if (fib_rec == -1)
        printf("Overflows");
    else
        printf("Iterative Fibonacci of %d: %llu\n", n, fib_rec);

    return 0;
}
long long fibonacci_iterative(int n)
{
    long long a = 0, b = 1, c;
    for (int i = 2; i <= n; i++)
    {
        if (a > LLONG_MAX || b > LLONG_MAX)
            return -1;
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

long long fibonacci_recursive(int n)
{
    if (n <= 1)
        return n;
    long long a = fibonacci_recursive(n - 1);
    long long b = fibonacci_recursive(n - 2);
    if (a > LLONG_MAX || b > LLONG_MAX)
        return -1;
    return a + b;
}
