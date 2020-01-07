package com.java.concurrency.cyclicbarrier;

public class CyclicBarrierFinishJob
    implements Runnable
{

    @Override
    public void run ()
    {
        System.out.println( " All 3 threads are done and came to THE barrier event." );
    }

}
