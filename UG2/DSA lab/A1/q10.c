#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LEN 1000

int min(int a, int b, int c) {
    if (a <= b && a <= c) return a;
    if (b <= a && b <= c) return b;
    return c;
}

// Function to calculate the Edit Distance between two strings
int edit_distance(char *str1, char *str2) {
    int len1 = strlen(str1);
    int len2 = strlen(str2);

    // Create a table to store the edit distances between all substrings
    int dp[MAX_LEN + 1][MAX_LEN + 1];

    // Fill the table
    for (int i = 0; i <= len1; i++) {
        for (int j = 0; j <= len2; j++) {
            // If the first string is empty, insert all characters of the second string
            if (i == 0) {
                dp[i][j] = j;
            }
            // If the second string is empty, delete all characters of the first string
            else if (j == 0) {
                dp[i][j] = i;
            }
            // If the last characters are the same, ignore the last character
            else if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            }
            // If the last characters are different, consider all possibilities and find the minimum
            else {
                dp[i][j] = 1 + min(dp[i - 1][j],       // Deletion
                                   dp[i][j - 1],       // Insertion
                                   dp[i - 1][j - 1]);  // Substitution
            }
        }
    }
    return dp[len1][len2];
}

int main() {
    char str1[MAX_LEN + 1], str2[MAX_LEN + 1];
    printf("Enter the first string (capital letters only): ");
    scanf("%s", str1);
    printf("Enter the second string (capital letters only): ");
    scanf("%s", str2);

    int distance = edit_distance(str1, str2);

    printf("The Edit Distance between '%s' and '%s' is: %d\n", str1, str2, distance);

    return 0;
}
