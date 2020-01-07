package com.java.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class SttDeveloper
    implements Runnable
{
    CountDownLatch latch;

    String strDevName;

    public SttDeveloper ( CountDownLatch latch, String strDevName )
    {
        super();
        this.latch = latch;
        this.strDevName = strDevName;
    }

    public void run ()
    {
        System.out.println( strDevName + " Developer started execution => " + Thread.currentThread().getName() );

        try
        {
            Thread.sleep( 3000 );
            System.out.println( strDevName + " Developer finished execution => " + Thread.currentThread().getName() );
            System.out.println( "Latch count: " + latch.getCount() );
        }
        catch ( Exception e )
        {
            System.err.println( "Dev error" + e );
        }
        finally
        {
            latch.countDown();
        }
        
        

    }

}
