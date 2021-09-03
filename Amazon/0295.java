class MedianFinder {
    // min-heap store the larger half of the data
    private PriorityQueue<Integer> larger;
    // max-heap store the smaller half of the data
    private PriorityQueue<Integer> smaller;

    /** initialize your data structure here. */
    public MedianFinder() {
        larger = new PriorityQueue<>();
        smaller = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (smaller.size() == 0) {  smaller.offer(num); }
        else if (smaller.size() == larger.size()) {
            if (num <= larger.peek()) {
                smaller.offer(num);
            } else {
                smaller.offer(larger.poll());
                larger.offer(num);
            }
        } else {
            if (smaller.peek() <= num) {
                larger.offer(num);
            } else {
                larger.offer(smaller.poll());
                smaller.offer(num);
            }
        }
    }
    
    public double findMedian() {
        double median = smaller.peek();
        if ((smaller.size() + larger.size()) % 2 == 0) {
            median = (median + larger.peek()) / 2;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */