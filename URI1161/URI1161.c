#include <stdio.h>
#include <stdlib.h>

long long int fatorial(long a){
    long long fatorialValor = 1;
    while (a>1){
        fatorialValor = fatorialValor*a;
        a--;
    }
    return fatorialValor;
}


int main() {

     long long int vet[21];
     int M, N;
     int it = 0;

    while(it<21){
        vet[it] = fatorial(it);
        it++;
    }

    while(scanf("%d %d", &M, &N)!=EOF){
        printf("%lli\n", vet[M]+vet[N]);
    }

return 0;
}

