#include <stdio.h>

int isPerfectNumber(int num) {
    int sum = 0;
    for (int i = 1; i <= num / 2; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }
    return sum == num;
}

void convertToASCII(int num) {
    char result[20];
    int index = 0;
    
    while (num > 0) {
        int digit = num % 10;
        char asciiChar = digit + 97;
        result[index++] = asciiChar;
        num /= 10;
    }
    result[index] = '\0';
    
    for (int i = 0; i < index / 2; i++) {
        char temp = result[i];
        result[i] = result[index - i - 1];
        result[index - i - 1] = temp;
    }
    
    printf("Equivalent character sequence: %s\n", result);
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);
    
    if (isPerfectNumber(num)) {
        printf("%d is a perfect number.\n", num);
        convertToASCII(num);
    } else {
        printf("%d is not a perfect number.\n", num);
    }
    
    return 0;
}