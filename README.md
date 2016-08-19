# Java-Challenges
A collection of completed Java challenges with a range of difficulties.

Challenges are scored by execution speed and memory usage; you might notice I've done some very unorthodox stuff to boost performance in a couple places. Naming conventions are all over the place as they are just enough for me to keep track of what's going on. I didn't originally intend for this code to be public.

Good example would be my substitute for Integer.parseInt(..)

```java
public static int parseInt( final String s )
{
    int num  = 0;
    int sign = -1;
    final int len  = s.length( );
    final char ch  = s.charAt( 0 );
    if ( ch == '-' )
        sign = 1;
    else
        num = '0' - ch;
    int i = 1;
    while ( i < len )
        num = num*10 + '0' - s.charAt( i++ );
    return sign * num;
} 
```
At the time I was completing these challenges this was more efficient than the built in method. I no longer remember why or who credit for this hack originally belongs to. 
