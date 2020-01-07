package com.java.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Passenger
    extends Thread
{

    private int duration;

    private CyclicBarrier barrier;

    public Passenger ( int duration, CyclicBarrier barrier, String pname )
    {
        super( pname );
        this.duration = duration;
        this.barrier = barrier;
    }

    @Override
    public void run ()
    {
        try
        {
            Thread.sleep( duration );
            System.out.println( Thread.currentThread().getName() + " is waiting " + ( barrier.getParties() - barrier.getNumberWaiting() - 1 )
                + " other threads to reach the common barrier point. " );

            barrier.await();

        }
        catch ( InterruptedException | BrokenBarrierException e )
        {
            e.printStackTrace();
        }
        System.out.println( "As "+ barrier.getParties()+" reached the common barrier point and " +Thread.currentThread().getName()+" as released" );
    }

    // private CyclicBarrier barrier;
    //
    // private int duration;
    //
    // public Passanger ( String passangerName, CyclicBarrier barrier, int duration )
    // {
    // super( passangerName);
    // this.barrier = barrier;
    // this.duration = duration;
    // }
    //
    // @Override
    // public void run ()
    // {
    //
    // try
    // {
    // Thread.sleep( duration );
    // System.out.println( "Passenger is arrived: " + Thread.currentThread().getName() );
    // if ( barrier.await() == 0 )
    // {
    // System.out.println( " All 3 passangers are entered into the CAB." );
    // }
    // }
    // catch ( InterruptedException | BrokenBarrierException e )
    // {
    // e.printStackTrace();
    // }
    //
    // }
}
