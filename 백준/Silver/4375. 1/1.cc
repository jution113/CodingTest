// n (n % 2 != 0 && n % 5 != 0
// n (1 <= n <= 10000)
// n (모든 자릿수가 1로만 구성)

#include<iostream>
#include<string>

using namespace std;

typedef long long ll;

int base = 10;
string res = "";

ll modular_multi(ll pre_pow_m, int divisor) {
	return (pre_pow_m * (base % divisor)) % divisor;
}

int main() {
	int divisor = 0;
	
	while(cin >> divisor) {
		ll sum_m = 1 % divisor;
		ll pow_m = 1 % divisor;
		ll digit = 1;
		
		while(sum_m != 0) {
			pow_m = modular_multi(pow_m, divisor);
			sum_m = (sum_m + pow_m) % divisor;
			digit++;
		}
		
		res += to_string(digit) + "\n";
	}
	
	cout << res;
	
	return 0;
} 