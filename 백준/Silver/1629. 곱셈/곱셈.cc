// 0 <= A, B, C <= 2,147,483,647

#include<iostream>

using namespace std;

typedef long long ll;

ll fast_exponentiation_modular(ll base, ll exponent, ll divisor) {
	long long m = base % divisor;
	
	if(exponent <= 2) return exponent == 1 ? m : (m * m) % divisor;
	
	ll res = fast_exponentiation_modular(base, exponent / 2, divisor);
	res = (res * res) % divisor;
	if(exponent % 2 == 1) res = (res * m) % divisor;
	
	return res;
}

int main() {
	ll a, b, c;
	cin >> a >> b >> c;
	
	ll res = 0;
	
	res = fast_exponentiation_modular(a, b, c);
	
	cout << res;
	
	return 0;
}