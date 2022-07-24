/*#include <bits/stdc++.h>

using namespace std;

int main()
{
    string name[]={"Phuc","Nga","Anh"};
    string name2[]={"Bao","love"};
    string Fname, space=" ";
    int n=sizeof(name)/sizeof(string);
    int m=sizeof(name2)/sizeof(string);
    for(int i=0;i<n-1;i++)
    {
        for(int j=1;j<n;j++)
            if(name[i]>name[j])
        {
            swap(name[i],name[j]);
        }
    }
    for(int i=0;i<n;i++)
    {
        Fname+=name[i]+space;
    }
    for(int i=m-1;i>=0;i--)
    {
        Fname+=name2[i]+space;
    }
    cout<<Fname<<endl;
    cout<<sizeof(name2)<<endl<<sizeof(string);
    return 0;
}*/




/*#include <bits/stdc++.h>

using namespace std;

int main()
{
    char s[]="Bao dep trai";
    string name= "xyz";
    cout<<name<<endl;
    name=s;
    cout<<name.length()<<" : "<<name<<endl;
    return 0;
}*/






/*#include <bits/stdc++.h>
#include <string>
using namespace std;

int main()
{
    string handsome;
    string name="Bao dep trai";
    getline(cin,handsome);
    //handsome.insert(4,name);
    handsome.erase(4,9);cout<<handsome;
    //cout<<handsome.substr(4,8);
}*/







/*#include <bits/stdc++.h>
#include <string>
using namespace std;

int main()
{
    string str1="green apple";
    string str2="red apple";
    string t="c";
    if(str1.compare(str2))cout<<"Forever ";
    if(str1.compare(6,5,str2,4,5)==0)cout<<"Love Bao";
    cout<<endl;
    if(str1.find(t,0)!=0)cout<<"Nga";
    return 0;
}*/










#include <bits/stdc++.h>
#include <string>
using namespace std;

int main()
{
    string choosing;
    getline(cin,choosing);
    choosing.replace(0,2,"Minh");
    cout<<choosing;
}

























































































