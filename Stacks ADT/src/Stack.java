import java.util.EmptyStackException;

public interface Stack<T> {
	public void push(T elem);
	public boolean isEmpty();
	public int size();
	public T pop() throws EmptyStackException;
	public T top() throws EmptyStackException;
}
