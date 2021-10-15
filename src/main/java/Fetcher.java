public interface Fetcher<input, output>{
    /**
     * Given a task return some meaningful result
     * @param task is the action you want to process
     * @return is the thing you want
     */
    public output fetch(input task);
}
