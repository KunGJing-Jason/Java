#include<iostream>
#include<math.h>

using namespace std;

int main(){
    double x;                       

    cin >> x;                       

    if(x < 0)                       
        cout << 0 << endl;
    else
        cout << sqrt(x) << endl;
        
    return 0;
}