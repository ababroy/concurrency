package com.java.concurrency.countdownlatch.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.java.concurrency.countdownlatch.SttDeveloper;
import com.java.concurrency.countdownlatch.SttTester;

public class CountDownLatchTest
{
    // public static void main ( String[] args )
    // {
    // CountDownLatch latch = new CountDownLatch( 2 );
    //
    // SttDeveloper coreDev = new SttDeveloper( latch, "Shail" );
    // SttDeveloper guiDev = new SttDeveloper( latch, "Abhijit" );
    //
    // Thread t1 = new Thread( coreDev );
    // Thread t2 = new Thread( guiDev );
    //
    // t1.start();
    // t2.start();
    //
    // try
    // {
    // latch.await();
    // }
    // catch ( InterruptedException e )
    // {
    // e.printStackTrace();
    // }
    // System.out.println( "Tester got notified to execute" );
    // SttTester tester = new SttTester( "Pritam" );
    // Thread t3 = new Thread( tester );
    // t3.start();
    //
    // System.out.println( "Main thread: " + Thread.currentThread().getName() + " get closed " );
    // }

    @Test
    public void test ()
    {
        CountDownLatch latch = new CountDownLatch( 2 );

        SttDeveloper coreDev = new SttDeveloper( latch, "Shail" );
        SttDeveloper guiDev = new SttDeveloper( latch, "Abhijit" );

        Thread t1 = new Thread( coreDev );
        Thread t2 = new Thread( guiDev );

        t1.start();
        t2.start();

        try
        {
            latch.await();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        System.out.println( "Tester got notified to execute" );
        SttTester tester = new SttTester( "Pritam" );
        Thread t3 = new Thread( tester );
        t3.start();
        try
        {
            Thread.currentThread().join();
        }
        catch ( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( "Main thread: " + Thread.currentThread().getName() + " get closed " );
    }

}
