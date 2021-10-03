class Solution {
    private static final int DIVISOR = 1_000_000_007;
    private TreeMap<Integer, Integer> buyOrders;
    private TreeMap<Integer, Integer> sellOrders;
    private static final int BUY = 0;
    private static final int SELL = 1;
    private static final int PRICE_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;
    private static final int TYPE_IDNEX = 2;

    public int getNumberOfBacklogOrders(int[][] orders) {
        buyOrders = new TreeMap<>(Collections.reverseOrder());
        sellOrders = new TreeMap<>(); 
        
        for (int[] order : orders) {
            updateOrder(order, buyOrders, sellOrders);
        }

        long size = 0;
        size = (size + getValSum(buyOrders)) % DIVISOR;
        size = (size + getValSum(sellOrders)) % DIVISOR;
        return (int)size;
    }

    private static long getValSum(TreeMap<Integer, Integer> map) {
        long size = 0;
        for (var val : map.values()) {
            size = (size + val) % DIVISOR;
        }
        return size;
    }

    private static void updateOrder(int[] order, 
                                    TreeMap<Integer, Integer> buy, 
                                    TreeMap<Integer, Integer> sell) {
        if (order[TYPE_IDNEX] == BUY) {
            while (order[AMOUNT_INDEX] > 0 && !sell.isEmpty()) {
                var entry = sell.firstEntry();
                int key = entry.getKey();
                int val = entry.getValue();
                if (order[PRICE_INDEX] < key) {
                    break;
                } else {
                    int min = Math.min(order[AMOUNT_INDEX], val);
                    order[AMOUNT_INDEX] -= min;
                    val -= min;
                    if (val == 0) {
                        sell.remove(key);
                    } else {
                        sell.put(key, val);
                    }
                }
            }
            if (order[AMOUNT_INDEX] > 0) {
                int val = buy.getOrDefault(order[PRICE_INDEX], 0) + order[AMOUNT_INDEX];
                buy.put(order[PRICE_INDEX], val);
            }
        } else {
            while (order[AMOUNT_INDEX] > 0 && !buy.isEmpty()) {
                var entry = buy.firstEntry();
                int key = entry.getKey();
                int val = entry.getValue();
                if (order[PRICE_INDEX] > key) {
                    break;
                } else {
                    int min = Math.min(order[AMOUNT_INDEX], val);
                    order[AMOUNT_INDEX] -= min;
                    val -= min;
                    if (val == 0) {
                        buy.remove(key);
                    } else {
                        buy.put(key, val);
                    }
                }
            }
            if (order[AMOUNT_INDEX] > 0) {
                int val = sell.getOrDefault(order[PRICE_INDEX], 0) + order[AMOUNT_INDEX];
                sell.put(order[PRICE_INDEX], val);
            }
        }
    }

}