#include<iostream>
#include<stdio.h>
#include<math.h>

using namespace std;

int
main(int argn, char *argv[])
{
    int t;  // times
    int m, n;  // dimensions
    cin >> t;
    double a = sqrt(2)-1;
    for (int i = 1; i <= t; i++) {
        cin >> m >> n;

        printf("Scenario #%d:\n", i);
        if ((m&1) && (n&1))  // odd number
            printf("%.2f\n", m*n+a);
        else
            printf("%.2f\n", (double)m*n);
        printf("\n");
    }

    return 0;
}
