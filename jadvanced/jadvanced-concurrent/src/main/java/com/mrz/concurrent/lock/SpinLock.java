package com.mrz.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SpinLock implements Lock {
    /**
     *  use thread itself as  synchronization state
     *  ʹ��Owner Thread��Ϊͬ��״̬����ʹ��һ���򵥵�boolean flag����Я��������Ϣ
     */
    private AtomicReference<Thread> owner = new AtomicReference<Thread>();
    /**
     * reentrant count of a thread, no need to be volatile
     */
    private int count = 0;
	public void lock() {
	      Thread t = Thread.currentThread();
	        // if re-enter, increment the count.
	        if (t == owner.get()) {
	            ++count;
	            return;
	        }
	        //spin
	        while (owner.compareAndSet(null, t)) {
	        }		
	}
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}
	public void unlock() {
        Thread t = Thread.currentThread();
        //only the owner could do unlock;
        if (t == owner.get()) {
            if (count > 0) {
                // reentrant count not zero, just decrease the counter.
                --count;
            } else {
                // compareAndSet is not need here, already checked
                owner.set(null);
            }
        }		
	}
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
