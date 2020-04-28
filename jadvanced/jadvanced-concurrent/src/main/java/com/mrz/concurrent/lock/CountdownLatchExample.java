package com.mrz.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��������һ�����߶���̵߳ȴ�����̡߳�
 * ά����һ�������� cnt��ÿ�ε��� countDown() �������ü�������ֵ�� 1������ 0 ��ʱ����Щ��Ϊ���� await() �������ڵȴ����߳̾ͻᱻ���ѡ�
 * @author Administrator
 *
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
                
            });
        }
        System.out.println("end");
        executorService.shutdown();
    }
}