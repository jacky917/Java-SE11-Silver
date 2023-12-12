package org.example.test_1Z0816.ch03.q16;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在Java中，列表（容器）是一種常用的資料結構，用於儲存元素的有序集合。 Java提供了多種清單實現，每種都有其特定用途和特點。
 * 以下是Java中常見的幾種清單類型及其線程安全版本的詳細介紹：
 * 1. ArrayList
 *    特點：基於動態數組實現，提供了快速的隨機存取能力。 當數組容量不足時，會自動擴容。
 *    線程安全：ArrayList 本身不是線程安全的。 線程安全版本可以透過Collections.synchronizedList(new ArrayList<>())建立。
 * 2. LinkedList
 *    特點：基於雙向鍊錶實現，適合頻繁的插入、刪除操作。
 *    線程安全：LinkedList 也不是線程安全的。 可以使用Collections.synchronizedList(new LinkedList<>())來獲得線程安全版本。
 * 3. Vector
 *    特點：類似於 ArrayList，但它是線程安全的，因為它的大多數方法都進行了同步處理。
 *    線程安全：Vector 本身就是線程安全的，但由於其同步操作通常效率不高，現在較少使用。
 * 4. Stack
 *    特點：Stack 繼承自 Vector，實作了後進先出（LIFO）的堆疊結構。
 *    線程安全：由於繼承自 Vector，Stack 也是線程安全的。
 * 5. CopyOnWriteArrayList
 *    特點：是一種線程安全的 ArrayList 變體，使用寫入時複製技術實作。 適用於讀多寫少的併發場景。
 *    線程安全：CopyOnWriteArrayList 本身就是線程安全的。
 * 6. Collections.synchronizedList
 *    用途：Collections.synchronizedList 方法可以將任何列表包裝為線程安全的列表。
 *    特點：為清單的所有操作提供了同步包裝，但在迭代時可能需要額外的同步。
 * 7. ConcurrentLinkedQueue (線程安全)
 *    描述：ConcurrentLinkedQueue 是一個基於鏈表的線程安全隊列，它實現了 Queue 接口。
 *    特點：適用於高並發情況，實現了無鎖的隊列操作，通過使用原子操作來保證線程安全。
 * 8. BlockingQueue 的實現 (線程安全)
 *    描述：BlockingQueue 是一個接口，提供了阻塞的插入和取出操作。它有多個線程安全的實現，如 ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue 等。
 *    特點：這些隊列在多線程環境中用於生產者-消費者場景，提供了同步的插入和取出操作。
 * 9. ConcurrentSkipListSet 和 ConcurrentSkipListMap (線程安全)
 *    描述：這兩個類是基於跳表實現的，分別提供了線程安全的集合和映射。
 *    特點：這些結構支持全範圍、並發的讀寫訪問，並且在多線程環境中保持高性能。
 * 注意事項
 *    在選擇清單類型時，應考慮資料結構的特性以及應用場景（如頻繁的隨機存取、插入刪除操作等）。
 *    對於多執行緒環境，如果選擇非執行緒安全的清單實現，應確保適當的外部同步，或使用執行緒安全的變體。
 *    使用線程安全的清單時，雖然提供了基本的同步機制，但在某些情況下（如迭代時），可能還需要額外的同步措施。
 */
public class ThreadSafeArray {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 迭代時可以安全地修改列表
        for (Integer item : list) {
            System.out.println(item);
            list.remove(0); // 不會拋出 ConcurrentModificationException
        }


        // 在Java中，Vector 類別本身是執行緒安全的，這意味著其單一操作（如新增、刪除或檢索元素）是同步的。
        // 然而，即使Vector是線程安全的，它仍然可能在迭代過程中拋出ConcurrentModificationException。
        // 這種異常通常發生在對Vector進行迭代時，如果另一個執行緒同時修改了Vector的結構（即新增或刪除元素），就可能會出現這個例外。

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number == 1) {
                vector.remove(number); // 這裡直接修改 vector，可能會導致 ConcurrentModificationException
            }
        }
    }
}
