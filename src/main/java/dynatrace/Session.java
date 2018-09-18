package dynatrace;

public class Session implements AutoCloseable {
	
	private final Transaction transaction = new Transaction();

	@Override
	public void close() throws Exception {
	}

	public Object readTransaction(TransactionWork<Object> transactionWork) throws Exception {
		return transactionWork.work(transaction);
	}

	public Object writeTransaction(TransactionWork<Object> transactionWork) throws Exception {
		return transactionWork.work(transaction);
	}

}
