class RandomizedSet {
    ArrayList<Integer> list;
    public RandomizedSet() {
        list = new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        if(list.contains(val)){
            return false;
        }
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!list.contains(val)){
            return false;
        }
        list.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        Random ran = new Random();
        return list.get(ran.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */