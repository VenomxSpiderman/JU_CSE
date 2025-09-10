#include <limits.h>
#include <stdio.h>
long long factorial_iterative(int n) {
unsigned long long result = 1;
  for (int i = 2; i <= n; i++) {
    result *= i;
    if (result > ULLONG_MAX)
      return -1;
  }
  return result;
}
long long factorial_recursive(int n) {
  if (n == 1)
    return 1;
  unsigned long long temp = factorial_recursive(n - 1);
  if (temp > ULLONG_MAX)
    return -1;
  return n * temp;
}
int main() {
  int n;
  printf("Enter a number: ");
  scanf("%d", &n);

  if (n < 0) {
    printf("Factorial is not defined for negative numbers.\n");
    return 1;
  }

  printf(factorial_iterative(n)<=-1?"Overflows\n":"%lld",factorial_iterative(n));
  printf(factorial_recursive(n)<=-1?"Overflows\n":"%lld",factorial_recursive(n));

  return 0;
}
