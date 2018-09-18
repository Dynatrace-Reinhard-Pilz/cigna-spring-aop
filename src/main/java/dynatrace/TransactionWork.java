package dynatrace;

@FunctionalInterface
public interface TransactionWork<T> {

	T work(Transaction transaction);
	
}
