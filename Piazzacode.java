public class Piazzacode {


    int rr=tileDimension*collageDimension;
    int cc=tileDimension*collageDimension;
    
    for( int i=0;i< collageDimension;i++)
    {
        for(int j=0;j<collageDimension;j++)
        {
            for(int r=tileDimension*i;r<tileDimension*(i+1);r++)
            {                     
                for(int c= tileDimension*j;c<tileDimension*(j+1);c++)
                { 
                    int m=0;
                    while(m<cc)
                    {
                    int n=0;
                    while(n<rr)
                    {
                    Color color = original.get(m,n);//(tileDimension*j),(tileDimension*i));//, c-(tileDimension*j));
                    collage.set(r,c,color);                        
                   n++;
                    }
                    m++;
                    }}}}

    
}
