class Solution {
    private static final int THRESHOLD = 1000;

    private static class Transaction implements Comparable<Transaction>{
        private String name;
        private int time;
        private int amount;
        private String city;
        private String transaction;

        public Transaction(String transaction) {
            this.transaction = transaction;
            parseTransaction();
        }

        @Override
        public int compareTo(Transaction other) {
            int cmp = name.compareTo(other.name);
            return cmp != 0 ? cmp : Integer.compare(time, other.time);
        }

        private void parseTransaction() {
            String[] parts = transaction.split(",");
            name = parts[0];
            amount = Integer.valueOf(parts[2]);
            time = Integer.valueOf(parts[1]);
            city = parts[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<Transaction> trans = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        for (String transaction : transactions) {
            Transaction currTrans = new Transaction(transaction);
            if (exceedThreshold(currTrans.amount)) {
                ans.add(transaction);
            } else {
                tran.add(currTrans);
            }
        }

        Arrays.sort(trans);

        int lo = 0;
        while (lo < trans.size()) {
            String name = trans.get(lo).name;
            int hi = lo + 1;
            while (hi < trans.size() && trans.get(hi).name.equals(name)) {
                hi++;
            }
            
            lo = hi;
        }

        return ans;
    }

    private static boolean exceedThreshold(int amount) {
        return amount > THRESHOLD;
    }
}