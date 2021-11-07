package Job.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(new SolutionMainTwo().method(array));
    }
}
class SolutionMainTwo{
    public int method(int[] array){
        Arrays.sort(array);
        int num = 1;
        int cur = 0;
        int left = 0;int right = 0;
        while (right<array.length){

        }
        return 1;
    }
}
/*
#include<algorithm>
#include<iostream>
#include<cstring>
#include<cmath>
using namespace std;
const int MaxN = 10005;
const long long Mod = 1000000007;
#define ll long long
using namespace std;
int n;
ll ans,A[MaxN];
int S[MaxN],X,D[MaxN];
#define inv(x) quick_pow(x,Mod-2)
ll quick_pow(ll x,ll y){
    ll temp = 1;
    while(y){
        if(y&1) temp = temp*x%Mod;
        x = x*x%Mod;
        y = y/2;
    }
    return temp;
}
ll C(ll m,ll n){
    ll temp = A[(int)m];
    temp = temp*inv(A[(int)m-n])%Mod;
    temp = temp*inv(A[(int)n])%Mod;
    return temp;
}
int main(){
    A[0] = 1;
    for(int i = 1;i<MaxN;i++)
        A[i] = A[i-1]*i%Mod;
    int temp , flag = 1;
    cin>>n;
    for(int i =1;i<=n;i++){
        cin>>temp;
        ++S[temp];
        X = max(X,temp);
    }
    if(S[0] !=1)
        flag = 0;
    for(int i=1;i<=X;i++){
        if(S[i] == 0)
            flag = 0;
        if(S[i]>S[i-1] << 1)
            flag = 0;
    }
    if(flag == 0){
        cout<<0<<endl;
        return 0;
    }
    ans = 1;
    for(int i =1;i<=X;i++)
        ans = C(S[i-1]*2,S[i])*ans%Mod;
    cout<<ans<<endl;
    return 0;
}
 */
