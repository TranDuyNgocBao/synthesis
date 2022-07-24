//dùng 1 cái map M, với M[x] đánh dấu vị trí nhỏ nhất mà
//tổng 2 số có giá trị là x, rồi với mỗi số a[i],
//m duyệt xem có số a[j] với j >i nào mà M[a[i]-a[j]] > j thì cộng vào kết quả

/*freopen("SODEP.INP","r",stdin);
    freopen("SODEP.OUT","w",stdout);
    ios::sync_with_stdio(0); cin.tie(0);
    long int n,dem=0;
    cin>>n;
    if(n<=3){cout<<"0"; return 0;}
    long long a[n+1],b[n+1];
    for(int i=1;i<=n;i++)
    {
        cin>>a[i];
        b[i]=a[i];
    }
    sort(b+1,b+n+1);
    for(int i=n; i>=4 ; i--)
    {
        if((b[i]==b[i-1])&&(i!=4))continue;
        int t;
        t=0;

        for(int j=n; j>=3; j--)
        {
            for(int u=j-1; u>=2; u--)
            {

                for(int k=u-1; k>=1; k--)
                {
                    if(b[i]==a[j]+a[u]+a[k])
                    {
                        t=1;
                        dem++;
                        break;
                    }
                }if(t==1)break;

            }if(t==1)break;
        }
    }
    cout<<dem;*/
