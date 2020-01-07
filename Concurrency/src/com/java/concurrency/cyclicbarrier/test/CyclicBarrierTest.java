package com.java.concurrency.cyclicbarrier.test;

import java.util.concurrent.CyclicBarrier;

import com.java.concurrency.cyclicbarrier.CyclicBarrierFinishJob;
import com.java.concurrency.cyclicbarrier.Passenger;

public class CyclicBarrierTest
{
    public static void main ( String[] args )
    {
        System.out.println( Thread.currentThread().getName() + " Started" );
        CyclicBarrier barrier = new CyclicBarrier( 3, new CyclicBarrierFinishJob() );
        Passenger p1 = new Passenger( 1000, barrier, "Passanger:=A" );
        Passenger p2 = new Passenger( 2000, barrier, "Passanger:=B" );
        Passenger p3 = new Passenger( 3000, barrier, "Passanger:=C" );
        p1.start();
        p2.start();
        p3.start();
        
        Passenger p4 = new Passenger( 4000, barrier, "Passanger:=D" );
        Passenger p5 = new Passenger( 5000, barrier, "Passanger:=E" );
        Passenger p6 = new Passenger( 6000, barrier, "Passanger:=F" );
        p4.start();
        p5.start();
        p6.start();

        System.out.println( Thread.currentThread().getName() + " Stopped" );

    }

    // @Test
    // public void test()
    // {
    //
    // }
}
