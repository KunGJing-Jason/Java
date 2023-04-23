#include <stdio.h>
#include <math.h>

int main(){
    double x;                       

    scanf("%lf" , &x);                      

    if(x < 0)                       
        printf("0\n");
    else         
        printf("%f" , sqrt(x));

    return 0;
}