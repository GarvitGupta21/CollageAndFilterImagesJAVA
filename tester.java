int solution(int[] a) {
    int count=0;
    if(a.length==1){
        if(a[0]==0)count++;
        return count;
    }

   // else if((0+a[1])/2 == a[0]) count++;
    else if((a[1])/2 == a[0]) count++;



    for(int i=2; i<a.length; i++){
        if(i== a.length-1){
            int sum=0+a[i-1];
            if(sum/2== a[i]) count++;
        }
        else{
        int sum= a[i-1]+a[i+1];
        if (sum/2 == a[i]) count++;
        }
    }
    // if((0+a[a.length-2])/2 == a[a.length-1]) count++;
    return count;
}