package org.example.test_1Z0816.ch03.o10;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * 兩個特務頭子約定在某時某地交換身份
 */
public class ExchangerTest {
    public static void main(String[] args) {

        Random random = new Random();

        Exchanger<Agent> agentExchanger = new Exchanger<>();

        Runnable runnable = () -> {
            Agent agent = new Agent(Thread.currentThread().getName(), random.nextInt(30));
            Agent newAgent;
            try {
                newAgent = agentExchanger.exchange(agent);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("交換前：" + agent + " -> 交換後：" + newAgent);
        };

        for(int i = 0; i < 2; i++) {
            new Thread(runnable, "特工" + i).start();
        }
    }
}
