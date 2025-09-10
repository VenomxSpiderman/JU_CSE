#include <stdio.h>
int main() {
    int n;

    printf("Enter the size of the array(positive value only and >1): ");
    scanf("%d", &n);
    int arr[n];
    int i=0,j=n-1,n1;
    printf("Enter the elements of the array:\n");
    for (int i1 = 0; i1 < n; i1++) {
        scanf("%d",&n1);
        if(n1<0) arr[i++]=n1;
        else arr[j--]=n1;
    }
    j=n-1;
    while(i<j)
    {
        n1=arr[i];
        arr[i]=arr[j];
        arr[j]=n1;
        i++;
        j--;
    }
    printf("The elements of the Array are:\n");
    for (i = 0; i < n-1; i++)
        printf("%d,",arr[i]);
    printf("%d\n",arr[i]);


    return 0;
}