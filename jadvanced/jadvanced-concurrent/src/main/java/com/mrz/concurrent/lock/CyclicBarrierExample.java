package com.mrz.concurrent.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * �������ƶ���̻߳���ȴ���ֻ�е�����̶߳�����ʱ����Щ�̲߳Ż����ִ�С�
 * �� CountdownLatch ���ƣ�����ͨ��ά����������ʵ�ֵġ�
 * �߳�ִ�� await() ����֮���������� 1�������еȴ���ֱ��������Ϊ 0�����е��� await() �������ڵȴ����̲߳��ܼ���ִ�С�
 * CyclicBarrier ���������캯�������� parties ָʾ�������ĳ�ʼֵ��barrierAction �������̶߳��������ϵ�ʱ���ִ��һ�Ρ�
 * @author Administrator
 *
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("before..");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.print("after..");
            });
        }
        executorService.shutdown();
    }
}
