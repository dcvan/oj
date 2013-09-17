#include<iostream>
#include<stdio.h>
#include<string.h>

using namespace std;

int text2code(char c)
{
    if (c == '_') return 0;
    else if (c == '.') return 27;
    else return c-'a'+1;
}

char code2text(int i)
{
    if (i == 0) return '_';
    else if (i == 27) return '.';
    else return 'a'+i-1;
}

int
main(int argn, char *argv[])
{
    int k, n;
    char ciphertext[100];
    char plaintext[100];

    while (cin >> k) {
        if (k == 0) break;

        cin >> ciphertext;
        n = strlen(ciphertext);

        // untwist
        for (int i = 0; i < n; i++) {
            int c = text2code(ciphertext[i]);
            int v = (c + i) % 28;
            plaintext[k*i % n] = code2text(v);
        }
        plaintext[n] = '\0';

        cout << plaintext << "\n";
    }
    return 0;
}
