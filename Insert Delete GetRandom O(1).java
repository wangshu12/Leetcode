// If we just use Arraylist, insert would take O(1), but remove would take O(n) in worst case because the arraylist need to shift the numbers.
// Unless that the element that we remove is at the end of the arraylist, that would take O(1).
// So, actually we can find the index of the element that we want to remove, and we replace it with the last element of the arraylist.
// In this case, we need to remember position or index of each element in the arraylist.
// So we can build a hashmap, key is the number, and the associated value is the index of the number in the arraylist.
class RandomizedSet {
    List<Integer> numbers;
    HashMap<Integer, Integer> pos_map;
    java.util.Random ran;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numbers = new ArrayList<>();
        pos_map = new HashMap<>();
        ran = new java.util.Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(pos_map.containsKey(val)) return false;
        pos_map.put(val, numbers.size());
        numbers.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!pos_map.containsKey(val)) return false;
        int index = pos_map.get(val);
        if(index != numbers.size() - 1){
            int num = numbers.get(numbers.size() - 1);
            numbers.set(index, num);
            pos_map.put(num, index);
        }
        numbers.remove(numbers.size() - 1);
        pos_map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return numbers.get(ran.nextInt(numbers.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */