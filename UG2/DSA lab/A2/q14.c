#include <stdio.h>
#include <string.h>
#define MAX_DIGITS 100
void add(char num1[], char num2[], char result[]) {
    int carry = 0, sum, i;
    int len1 = strlen(num1);
    int len2 = strlen(num2);
    int maxLen = len1 > len2 ? len1 : len2;

    for (i = 0; i < maxLen || carry; i++) {
        int digit1 = i < len1 ? num1[len1 - 1 - i] - '0' : 0;
        int digit2 = i < len2 ? num2[len2 - 1 - i] - '0' : 0;
        sum = digit1 + digit2 + carry;
        result[i] = (sum % 10) + '0';
        carry = sum / 10;
    }
    result[i] = '\0';
    strrev(result);
}

void subtract(char num1[], char num2[], char result[]) {
    int borrow = 0, diff, i;
    int len1 = strlen(num1);
    int len2 = strlen(num2);

    for (i = 0; i < len1; i++) {
        int digit1 = num1[len1 - 1 - i] - '0';
        int digit2 = i < len2 ? num2[len2 - 1 - i] - '0' : 0;
        diff = digit1 - digit2 - borrow;
        if (diff < 0) {
            diff += 10;
            borrow = 1;
        } else {
            borrow = 0;
        }
        result[i] = diff + '0';
    }
    result[i] = '\0';
    strrev(result);
}

void multiply(char num1[], char num2[], char result[]) {
    int len1 = strlen(num1);
    int len2 = strlen(num2);
    int temp[MAX_DIGITS] = {0};

    for (int i = len1 - 1; i >= 0; i--) {
        for (int j = len2 - 1; j >= 0; j--) {
            temp[i + j + 1] += (num1[i] - '0') * (num2[j] - '0');
        }
    }

    for (int i = len1 + len2 - 1; i > 0; i--) {
        if (temp[i] >= 10) {
            temp[i - 1] += temp[i] / 10;
            temp[i] %= 10;
        }
    }

    int index = 0;
    for (int i = 0; i < len1 + len2; i++) {
        if (index == 0 && temp[i] == 0) continue;
        result[index++] = temp[i] + '0';
    }
    result[index] = '\0';
}

int main() {
    char num1[MAX_DIGITS], num2[MAX_DIGITS], result[MAX_DIGITS * 2];
    printf("Enter first number: ");
    scanf("%s", num1);
    printf("Enter second number: ");
    scanf("%s", num2);

    add(num1, num2, result);
    printf("Sum: %s\n", result);

    subtract(num1, num2, result);
    printf("Difference: %s\n", result);

    multiply(num1, num2, result);
    printf("Product: %s\n", result);

    return 0;
}