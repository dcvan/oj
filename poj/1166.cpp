#include<iostream>
#include<stdio.h>

using namespace std;

/* 
 *  * linear method
 *   
 *    assume A + Mx = 0, then x = M^{-1} * -A
 */

const int M[9][9] = {   // inverted matrix
    {3,2,3,2,2,1,3,1,0},
    {3,3,3,3,3,3,2,0,2},
    {3,2,3,1,2,2,0,1,3},
    {3,3,2,3,3,0,3,3,2},
    {3,2,3,2,1,2,3,2,3},
    {2,3,3,0,3,3,2,3,3},
    {3,1,0,2,2,1,3,2,3},
    {2,0,2,3,3,3,3,3,3},
    {0,1,3,1,2,2,3,2,3},
};

int
main(int argn, char *argv[])
{
    int clocks[9], moves[9] = {0};    
    for (int i = 0; i < 9; i++) {
        scanf("%d", clocks+i);
        clocks[i] = (4 - clocks[i])%4;
    }
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            moves[i] += M[i][j]*clocks[j];
        }
    }
    for (int i = 0, j = 0; i < 9; i++) {
        moves[i] %= 4;
        if (moves[i]) {
            printf("%s%d", j ? " " : "", i+1);
            while (--moves[i])
                printf(" %d", i+1);
            j = 1;
        }
    }
    printf("\n");
    return 0;
}
