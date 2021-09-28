class SeatManager {
    private PriorityQueue<Integer> unreserved;

    public SeatManager(int n) {
        unreserved = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            unreserved.offer(i);
        }
    }
    
    public int reserve() {
        return unreserved.poll(); 
    }
    
    public void unreserve(int seatNumber) {
        unreserved.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */