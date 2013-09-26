#include<iostream>
#include<stdio.h>

using namespace std;

int step;
bool chess[6][6], found = false;

// left, up, origin, down, right
int r[5] = {-1, 0, 0, 0, 1};
int c[5] = {0, 1, 0, -1, 0};

void build()
{
    char ch;
    for (int i = 1; i <= 4; i++) {
        for (int j = 1; j <= 4; j++) {
            cin >> ch;
            if (ch == 'b') chess[i][j] = true;
        }
    }

//    for (int i = 1; i <= 4; i++) {
//        for (int j = 1; j <= 4; j++) {
//            cout << chess[i][j] << "";
//        }
//        cout << endl;
//    }
}

bool isOk()
{
    for (int i = 1; i <= 4; i++) {
        for (int j = 1; j <= 4; j++)
            if (chess[i][j] != chess[1][1])
                return false;
    }
    return true;
}

void flip(int row, int col)
{
    for (int i = 0; i < 5; i++) {
        int rr = row + r[i];
        int cc = col + c[i];
        chess[rr][cc] = !chess[rr][cc];
    }
}

void dfs(int r, int c, int dep)
{
    if (dep == step) { // done
        found = isOk();
        return;
    }
    if (r > 4 || found) return;

    flip(r, c);
    if (c < 4) dfs(r, c+1, dep+1);
    else dfs(r+1, 1, dep+1);

    flip(r, c);
    if (c < 4) dfs(r, c+1, dep);
    else dfs(r+1, 1, dep);
}

int
main(int argn, char *argv[])
{
    build();

    for (step = 0; step < 16; step++) {
        dfs(1, 1, 0);
        if (found) break;
    }

    if (found) cout << step << endl;
    else cout << "Impossible" << endl;

    return 0;
}
