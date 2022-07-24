using namespace std;
#include<bits/stdc++.h>

const int maxn = 221;

string operator + (string a , string b) {
    while (a.length() < b.length()) a = "0" + a ;
    while (a.length() > b.length()) b = "0" + b ;
    string c = "" ;
    int m = 0 , t ;
    for (int i = a.length() - 1 ; i >= 0 ; i--) {
        t = a[i] + b[i] - 2 * '0' + m ;
        c = char(t % 10 + '0') + c ;
        m = t / 10 ;
    }
    return m == 0 ? c : char(m + '0') + c ;
}
string operator * (string a , int b) {
    if (b == 0) return "0" ;
    if (b == 1) return a ;
    string c = a * (b / 2) ;
    if (b % 2) return c + c + a ;
    return c + c ;
}

bool Cmp(string a , string b) {
    while (a.length() < b.length()) a = "0" + a ;
    while (a.length() > b.length()) b = "0" + b ;
    return a < b ;
}

int N , M ;
string C[maxn][maxn] = { "1" } ;
string X , Y = "0" ;


int main() {
    cin >> N >> M ;
    for (int i = 1 ; i <= N ; i++)
        for (int j = 1 ; j <= i ; j++)
            C[i][j] = C[i - 1][j] * j + C[i - 1][j - 1] ;
    X = C[N][M] ;
    for (int j = 2 ; j <= N ; j++)
        Y = max(Y , C[N][j] , Cmp) ;
    cout << X << '\n' << Y ;

    return 0 ;
}
