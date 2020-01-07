package com.java.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class SttTester
    implements Runnable
{

    String strTesterName;

    public SttTester ( String strTesterName )
    {
        super();
        this.strTesterName = strTesterName;
    }

    public void run ()
    {
        System.out.println( strTesterName + " Developer started execution => " + Thread.currentThread().getName() );

        try
        {
            Thread.sleep( 2000 );
        }
        catch ( Exception e )
        {
            System.err.println( "Dev error" + e );
        }

        System.out.println( strTesterName + " Developer finished execution => " + Thread.currentThread().getName() );

    }

}
